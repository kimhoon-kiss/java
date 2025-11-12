package report_20251106_2;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RandomStarFrame extends JFrame {

    public RandomStarFrame() {
        setTitle("랜덤한 별을 가진 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // === NORTH 영역 ===
        JPanel northPanel = new JPanel();
        northPanel.add(new JLabel("별 개수"));
        JTextField starField = new JTextField("15", 5);
        JButton makeStarButton = new JButton("별 만들기");
        northPanel.add(starField);
        northPanel.add(makeStarButton);
        add(northPanel, BorderLayout.NORTH);

        // === CENTER 영역 ===
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(null); // 배치관리자 제거
        centerPanel.setBackground(Color.white);

        Random rand = new Random();

        // 별 생성
        for (int i = 0; i < 15; i++) {
            JLabel star = new JLabel("*");
            star.setForeground(Color.red);
            int x = rand.nextInt(280); // 0~279
            int y = rand.nextInt(180); // 0~179
            star.setBounds(x, y, 20, 20);
            centerPanel.add(star);
        }

        // 왼쪽 위 Refresh 버튼
        JButton refreshButton = new JButton("Refresh");
        refreshButton.setBounds(10, 10, 90, 30); // x=10, y=10, width=90, height=30
        centerPanel.add(refreshButton);

        add(centerPanel, BorderLayout.CENTER);

        // === SOUTH 영역 ===
        JPanel southPanel = new JPanel();
        southPanel.setBackground(new Color(255, 255, 200)); // 연한 노란색 가로줄
        JButton exitButton = new JButton("Exit");
        southPanel.add(exitButton);
        add(southPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new RandomStarFrame();
    }
}
