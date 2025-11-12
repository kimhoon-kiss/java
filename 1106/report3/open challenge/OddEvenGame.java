package report_20251106_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class OddEvenGame extends JFrame {

    private JLabel numberLabel;   // 중앙 표시
    private JLabel messageLabel;  // 아래 메시지 표시
    private JButton oddButton, evenButton, confirmButton, resetButton;
    private int randomNumber = 0; // 랜덤 숫자 저장
    private String selected = ""; // 선택한 홀/짝 저장

    public OddEvenGame() {
        setTitle("홀짝 맞추기 게임");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        // === 중앙 표시 라벨 ===
        numberLabel = new JLabel("?", SwingConstants.CENTER);
        numberLabel.setOpaque(true);
        numberLabel.setBackground(new Color(128, 0, 128)); // 보라색
        numberLabel.setForeground(Color.WHITE);
        numberLabel.setFont(new Font("맑은 고딕", Font.BOLD, 40));
        numberLabel.setBounds(100, 30, 100, 60);
        panel.add(numberLabel);

        // === 중앙 아래 메시지 라벨 ===
        messageLabel = new JLabel("무엇일까요?", SwingConstants.CENTER);
        messageLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
        messageLabel.setBounds(100, 90, 100, 20);
        panel.add(messageLabel);

        // === 버튼 생성 ===
        oddButton = new JButton("홀");
        oddButton.setBounds(40, 140, 60, 40);
        panel.add(oddButton);

        evenButton = new JButton("짝");
        evenButton.setBounds(100, 140, 60, 40);
        panel.add(evenButton);

        confirmButton = new JButton("확인");
        confirmButton.setBounds(160, 140, 60, 40);
        panel.add(confirmButton);

        resetButton = new JButton("다시");
        resetButton.setBounds(220, 140, 60, 40);
        panel.add(resetButton);

        // === 버튼 이벤트 처리 ===
        oddButton.addActionListener(e -> selected = "홀");
        evenButton.addActionListener(e -> selected = "짝");

        confirmButton.addActionListener(e -> {
            if (selected.isEmpty()) {
                JOptionPane.showMessageDialog(this, "홀이나 짝 먼저 선택하세요!", "경고", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (randomNumber == 0) {
                JOptionPane.showMessageDialog(this, "게임을 시작하려면 '다시' 버튼을 눌러주세요!", "경고", JOptionPane.WARNING_MESSAGE);
                return;
            }

            boolean isOdd = (randomNumber % 2 != 0);
            if (isOdd && selected.equals("홀")) {
                messageLabel.setText("홀 맞았어요!");
            } else if (!isOdd && selected.equals("짝")) {
                messageLabel.setText("짝 맞았어요!");
            } else if (isOdd && selected.equals("짝")) {
                messageLabel.setText("홀 아쉽군요!");
            } else if (!isOdd && selected.equals("홀")) {
                messageLabel.setText("짝 아쉽군요!");
            }

            selected = ""; // 선택 초기화
            numberLabel.setText(String.valueOf(randomNumber)); // 숫자 표시
        });

        resetButton.addActionListener(e -> {
            Random rand = new Random();
            randomNumber = rand.nextInt(10) + 1; // 1~10
            numberLabel.setText("?");
            messageLabel.setText("무엇일까요?");
            selected = "";
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new OddEvenGame();
    }
}
