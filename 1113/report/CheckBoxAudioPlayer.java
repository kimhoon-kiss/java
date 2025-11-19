package kimhoon_report_20251115;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import javax.sound.sampled.*;

public class CheckBoxAudioPlayer extends JFrame {

    private JPanel listPanel;        // 체크박스 목록 패널
    private Clip clip;               // 현재 재생 중인 오디오
    private ArrayList<JCheckBox> checkList = new ArrayList<>();
    private boolean stopFlag = false; // 연주 중단 신호

    public CheckBoxAudioPlayer() {
        setTitle("체크박스 오디오 플레이어");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);

        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        JScrollPane scroll = new JScrollPane(listPanel);

        loadAudioFiles(); // audio 폴더 읽어 체크박스 생성

        JButton playBtn = new JButton("연주 시작");
        JButton stopBtn = new JButton("연주 끝");

        playBtn.addActionListener(e -> startPlay());
        stopBtn.addActionListener(e -> stopPlay());

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(playBtn);
        bottomPanel.add(stopBtn);

        add(scroll, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // audio 폴더의 wav 파일을 체크박스로 표시
    private void loadAudioFiles() {
        File dir = new File("audio");
        if (!dir.exists()) {
            JOptionPane.showMessageDialog(this, "audio 폴더가 없습니다.");
            return;
        }

        for (File f : dir.listFiles()) {
            if (f.getName().toLowerCase().endsWith(".wav")) {
                JCheckBox cb = new JCheckBox(f.getName());
                cb.setFont(new Font("", Font.PLAIN, 16));
                listPanel.add(cb);
                checkList.add(cb);
            }
        }
    }

    // 연주 시작
    private void startPlay() {
        stopFlag = false;

        // 체크된 파일 목록 수집
        ArrayList<File> selectedFiles = new ArrayList<>();
        for (JCheckBox cb : checkList) {
            if (cb.isSelected()) {
                File f = new File("audio/" + cb.getText());
                selectedFiles.add(f);
            }
        }

        if (selectedFiles.isEmpty()) {
            JOptionPane.showMessageDialog(this, "선택된 곡이 없습니다.");
            return;
        }

        // 별도 스레드에서 순차 재생
        new Thread(() -> playSequential(selectedFiles)).start();
    }

    // 순차 재생 로직
    private void playSequential(ArrayList<File> files) {
        for (File f : files) {
            if (stopFlag) return;

            // UI에서 현재 곡 표시 색 변경
            highlightCurrent(f.getName());

            playOneFile(f);  // 곡 하나 재생(끝날 때까지 블록)
        }

        SwingUtilities.invokeLater(() -> clearHighlight());
    }

    // 곡 하나 재생(끝날 때까지 대기)
    private void playOneFile(File file) {
        try {
            if (clip != null && clip.isOpen()) {
                clip.stop();
                clip.close();
            }

            AudioInputStream ais = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(ais);

            Object lock = new Object();

            // 곡 끝났는지 감지
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    synchronized (lock) {
                        lock.notify();
                    }
                }
            });

            clip.start();

            // 곡 끝날 때까지 기다림
            synchronized (lock) {
                lock.wait();
            }

            clip.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "오디오 재생 오류: " + file.getName());
        }
    }

    // 현재 재생 중인 곡 빨간색 표시
    private void highlightCurrent(String name) {
        SwingUtilities.invokeLater(() -> {
            for (JCheckBox cb : checkList) {
                if (cb.getText().equals(name)) {
                    cb.setForeground(Color.RED);
                } else {
                    cb.setForeground(Color.BLACK);
                }
            }
        });
    }

    // 모든 글자색 원래대로
    private void clearHighlight() {
        for (JCheckBox cb : checkList) {
            cb.setForeground(Color.BLACK);
        }
    }

    // 연주 끝
    private void stopPlay() {
        stopFlag = true;

        if (clip != null && clip.isOpen()) {
            clip.stop();
            clip.close();
        }

        clearHighlight();
    }

    public static void main(String[] args) {
        new CheckBoxAudioPlayer();
    }
}
