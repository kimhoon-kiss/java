package kimhoon_report_20251115;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.File;

public class MouseAudioControlEx extends JFrame {

    private Clip clip;           // 오디오 재생용 Clip
    private long pausePosition = 0;  // 일시정지 시 위치 저장

    public MouseAudioControlEx() {
        setTitle("마우스 오디오 제어 예제");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 오디오 로드 & 자동 재생
        loadAndPlayAudio("music.wav");   // 같은 폴더에 music.wav 넣기

        Container c = getContentPane();
        c.setBackground(Color.LIGHT_GRAY);

        // 마우스 리스너 등록
        c.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                resumeAudio();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                pauseAudio();
            }
        });

        setVisible(true);
    }

    // 오디오 로드 및 재생
    private void loadAndPlayAudio(String filename) {
        try {
            File audioFile = new File(filename);
            AudioInputStream ais = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();   // 자동 재생
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "오디오 로드 실패!");
        }
    }

    // 오디오 일시 중지
    private void pauseAudio() {
        if (clip != null && clip.isRunning()) {
            pausePosition = clip.getMicrosecondPosition(); // 현재 재생 위치 저장
            clip.stop();
        }
    }

    // 오디오 재개
    private void resumeAudio() {
        if (clip != null && !clip.isRunning()) {
            clip.setMicrosecondPosition(pausePosition); // 저장된 위치에서 다시 시작
            clip.start();
        }
    }

    public static void main(String[] args) {
        new MouseAudioControlEx();
    }
}
