package kimhoon_report_20251120;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DragImagePanel extends JPanel {

    private Image img;          // 이미지 객체
    private int imgX = 100;     // 이미지 시작 X 위치
    private int imgY = 100;     // 이미지 시작 Y 위치
    private int mouseX, mouseY; // 마우스를 누른 시점의 상대좌표 저장

    public DragImagePanel() {

        // 이미지 로딩
        img = Toolkit.getDefaultToolkit().getImage("apple.jpg");

        // 이미지 드래그 기능
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                // 마우스를 누른 위치가 이미지 영역 안에 있을 때만 드래그 시작
                int w = img.getWidth(DragImagePanel.this);
                int h = img.getHeight(DragImagePanel.this);

                if (e.getX() >= imgX && e.getX() <= imgX + w &&
                    e.getY() >= imgY && e.getY() <= imgY + h) {

                    mouseX = e.getX() - imgX;
                    mouseY = e.getY() - imgY;
                }
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                imgX = e.getX() - mouseX;
                imgY = e.getY() - mouseY;

                repaint(); // 화면 갱신
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 이미지 그리기
        g.drawImage(img, imgX, imgY, this);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("그래픽 이미지 드래그");
        DragImagePanel panel = new DragImagePanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.add(panel);
        frame.setVisible(true);
    }
}
