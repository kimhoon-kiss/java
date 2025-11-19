package kimhoon_report_20251115;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.*;

public class AudioMenuEx extends JFrame {

    private Clip clip = null;   // 현재 재생 중인 오디오

    public AudioMenuEx() {
        setTitle("오디오 재생 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createMenu();   // 메뉴 생성

        setSize(400, 200);
        setVisible(true);
    }

    // 메뉴 생성 메서드
    private void createMenu() {
        JMenuBar mb = new JMenuBar();
        JMenu audioMenu = new JMenu("오디오");

        JMenuItem playItem = new JMenuItem("연주");
        JMenuItem stopItem = new JMenuItem("종료");

        // 연주 선택 → 파일 선택 후 재생
        playItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playAudio();
            }
        });

        // 종료 선택 → 재생 중지
        stopItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopAudio();
            }
        });

        audioMenu.add(playItem);
        audioMenu.add(stopItem);
        mb.add(audioMenu);
        setJMenuBar(mb);
    }

    // 오디오 재생 처리
    private void playAudio() {
        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(this);

        if (result != JFileChooser.APPROVE_OPTION)
            return;

        File audioFile = chooser.getSelectedFile();

        try {
            // 기존 클립 재생 중이면 정지
            if (clip != null && clip.isOpen()) {
                clip.stop();
                clip.close();
            }

            AudioInputStream ais = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();  // 재생 시작

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "오디오 파일을 재생할 수 없습니다.",
                    "오류",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // 오디오 정지 처리
    private void stopAudio() {
        if (clip != null && clip.isOpen()) {
            clip.stop();
            clip.close();
        }
    }

    public static void main(String[] args) {
        new AudioMenuEx();
    }
}
