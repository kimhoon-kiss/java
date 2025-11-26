package kimhoon_report_20251120;
import javax.swing.*;
import java.awt.*;

public class RhombusPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);

        int centerX = width / 2;
        int centerY = height / 2;

        int maxSize = Math.min(width, height) / 2;

        for (int i = 1; i <= 10; i++) {
            int halfWidth = i * maxSize / 10;
            int halfHeight = i * maxSize / 10;

            int[] xPoints = {
                centerX,
                centerX + halfWidth,
                centerX,
                centerX - halfWidth
            };

            int[] yPoints = {
                centerY - halfHeight,
                centerY,
                centerY + halfHeight,
                centerY
            };

            g2.drawPolygon(xPoints, yPoints, 4);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("마름모 10개 그리기");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new RhombusPanel());
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}