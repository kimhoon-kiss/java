package report_20251106_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RandomNumberColorGUI extends JFrame {
    private JLabel[] numberLabels = new JLabel[10]; // CENTER 숫자 0~9
    private JPanel centerPanel;
    private Random rand = new Random();

    public RandomNumberColorGUI() {
        setTitle("랜덤 숫자 & 색상 GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        // 🟦 WEST 영역 - 색상 버튼 10개 + Clear
        JPanel westPanel = new JPanel(new GridLayout(11, 1, 5, 5));
        JButton[] buttons = new JButton[11];
        Color[] colors = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
                           Color.CYAN, Color.BLUE, Color.MAGENTA, Color.PINK,
                           Color.LIGHT_GRAY, Color.GRAY };

        // 색상 버튼
        for (int i = 0; i < 10; i++) {
            buttons[i] = new JButton();
            buttons[i].setBackground(colors[i]);
            buttons[i].setOpaque(true);
            buttons[i].setBorderPainted(false);
            westPanel.add(buttons[i]);

            final Color cColor = colors[i];
            buttons[i].addActionListener(e -> changeNumberColor(cColor));
        }

        // Clear 버튼
        buttons[10] = new JButton("Clear");
        westPanel.add(buttons[10]);
        buttons[10].addActionListener(e -> resetNumberColor());

        c.add(westPanel, BorderLayout.WEST);

        // 🟨 CENTER 영역 - null 레이아웃으로 자유 배치
        centerPanel = new JPanel(null);
        centerPanel.setBackground(Color.WHITE);
        c.add(centerPanel, BorderLayout.CENTER);

        // 숫자 JLabel 0~9 생성
        for (int i = 0; i < 10; i++) {
            numberLabels[i] = new JLabel(String.valueOf(i), SwingConstants.CENTER);
            numberLabels[i].setFont(new Font("Gulim", Font.BOLD, 24));
            numberLabels[i].setOpaque(false);
            // 무작위 위치
            setRandomPosition(numberLabels[i]);
            // 클릭 시 무작위 재배치
            numberLabels[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    setRandomPosition((JLabel) e.getSource());
                    centerPanel.repaint();
                }
            });
            centerPanel.add(numberLabels[i]);
        }

        setSize(600, 500);
        setVisible(true);
    }

    // 숫자 글자색 변경
    private void changeNumberColor(Color color) {
        for (JLabel lbl : numberLabels) {
            lbl.setForeground(color);
        }
    }

    // 글자색 초기화
    private void resetNumberColor() {
        for (JLabel lbl : numberLabels) {
            lbl.setForeground(Color.BLACK);
        }
    }

    // 랜덤 위치 지정 (50~200 범위)
    private void setRandomPosition(JLabel lbl) {
        int width = 50;
        int height = 50;
        int x = 50 + rand.nextInt(151); // 50~200
        int y = 50 + rand.nextInt(151);
        lbl.setBounds(x, y, width, height);
    }

    public static void main(String[] args) {
        new RandomNumberColorGUI();
    }
}
