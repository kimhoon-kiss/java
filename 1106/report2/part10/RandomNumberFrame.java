package report_20251106_2;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RandomNumberFrame extends JFrame {
    public RandomNumberFrame() {
        setTitle("랜덤 숫자 출력 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new BorderLayout());

        // === WEST 영역: 컬러 버튼 10개 배치 ===
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(10, 1, 0, 0)); // 공백 없이 붙이기

        Color[] colors = {
            Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN,
            Color.BLUE, Color.MAGENTA, Color.PINK, Color.LIGHT_GRAY, Color.GRAY
        };

        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton(""); // 텍스트 제거
            btn.setBackground(colors[i]);  // 색상 지정
            btn.setOpaque(true);
            btn.setBorderPainted(false);   // 테두리 제거
            westPanel.add(btn);
        }
        add(westPanel, BorderLayout.WEST);

        // === CENTER 영역: 랜덤 숫자 라벨 배치 ===
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(null);
        centerPanel.setBackground(Color.WHITE);

        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            int num = rand.nextInt(10); // 0~9
            JLabel label = new JLabel(String.valueOf(num));
            label.setFont(new Font("맑은 고딕", Font.BOLD, 18));
            int x = rand.nextInt(151) + 50;  // 50~200
            int y = rand.nextInt(151) + 50;  // 50~200
            label.setBounds(x, y, 30, 30);
            centerPanel.add(label);
        }

        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new RandomNumberFrame();
    }
}
