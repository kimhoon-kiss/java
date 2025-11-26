package kimhoon_report_20251120;
import javax.swing.*;
import java.awt.*;

public class GridPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        int cols = 10;
        int rows = 10;

        int cellWidth = width / cols;
        int cellHeight = height / rows;

        g.setColor(Color.BLACK);

        // 수직선
        for (int i = 0; i <= cols; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, height);
        }

        // 수평선
        for (int i = 0; i <= rows; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("10x10 격자 그리기");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GridPanel());
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}