package kimhoon_report_20251120;

import javax.swing.*;
import java.awt.*;

// JLabel 상속 - 배경색이 항상 파란색인 커스텀 라벨
class BlueLabel extends JLabel {
    public BlueLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
        setOpaque(true);
        setForeground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(Color.BLUE);
    }
}

// JFrame 확장 - 실제 GUI 실행용
public class BlueLabelDemo extends JFrame {
    public BlueLabelDemo() {
        setTitle("BlueLabel 데모");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        BlueLabel label1 = new BlueLabel("hello", JLabel.CENTER);
        label1.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
        label1.setBackground(Color.RED);
        label1.setPreferredSize(new Dimension(80, 30));
        add(label1);

        BlueLabel label2 = new BlueLabel("Big Hello", JLabel.CENTER);
        label2.setFont(new Font("맑은 고딕", Font.ITALIC, 50));
        label2.setBackground(Color.GREEN);
        label2.setPreferredSize(new Dimension(250, 70));
        add(label2);

        JLabel normalLabel = new JLabel("Normal Label");
        normalLabel.setOpaque(true);
        normalLabel.setBackground(Color.ORANGE);
        normalLabel.setPreferredSize(new Dimension(100, 30));
        add(normalLabel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BlueLabelDemo());
    }
}