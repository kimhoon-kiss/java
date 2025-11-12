package report_20251106_2;

import javax.swing.*;
import java.awt.*;

public class CardBackFrame extends JFrame {

    public CardBackFrame() {
        setTitle("16장의 카드의 뒷면에 숨겨진 이미지 찾기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(new BorderLayout());

        // === NORTH 영역 ===
        JPanel northPanel = new JPanel();
        northPanel.setBackground(new Color(255, 255, 200)); // 연한 노란색
        JLabel titleLabel = new JLabel("숨겨진 이미지 찾기");
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
        northPanel.add(titleLabel);
        add(northPanel, BorderLayout.NORTH);

        // === CENTER 영역 (4x4 Grid) ===
        JPanel centerPanel = new JPanel(new GridLayout(4, 4, 5, 5)); // 4행 4열, 여백 5px
        centerPanel.setBackground(Color.DARK_GRAY);

        for (int i = 0; i < 16; i++) {
            JLabel card = new JLabel(String.valueOf(i + 1), SwingConstants.LEFT); // 왼쪽 정렬
            card.setOpaque(true);
            card.setBackground(Color.GREEN); // 카드 뒷면 색상
            card.setFont(new Font("맑은 고딕", Font.BOLD, 20));
            card.setForeground(Color.BLACK); // 숫자 색상 검은색
            card.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5)); // 숫자와 카드 경계 여백
            centerPanel.add(card);
        }

        add(centerPanel, BorderLayout.CENTER);

        // === SOUTH 영역 ===
        JPanel southPanel = new JPanel();
        southPanel.setBackground(new Color(255, 255, 200)); // 연한 노란색
        JButton startButton = new JButton("실행 시작");
        southPanel.add(startButton);
        add(southPanel, BorderLayout.SOUTH);

        // === EAST & WEST 여백용 JLabel ===
        add(new JLabel(" "), BorderLayout.EAST);
        add(new JLabel(" "), BorderLayout.WEST);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CardBackFrame();
    }
}
