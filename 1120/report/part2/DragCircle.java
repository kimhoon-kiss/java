package kimhoon_report_20251120;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class DragCircle extends JPanel {

    private BufferedImage bgImg;   // 배경 이미지
    private int circleX = 100;     // 원의 중심 X좌표
    private int circleY = 100;     // 원의 중심 Y좌표
    private final int R = 20;      // 반지름 = 20픽셀

    public DragCircle() {

        // 배경 이미지 읽기 (문제 1에서 사용한 이미지 파일명 넣기)
        try {
            bgImg = ImageIO.read(new File("background.jpg")); 
        } catch (Exception e) {
            System.out.println("이미지 불러오기 실패");
        }

        // 마우스 드래그 이벤트 등록
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                circleX = e.getX();  // 드래그한 위치로 원 중심 이동
                circleY = e.getY();
                repaint();           // 화면 다시 그리기
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 1. 배경 이미지 그리기
        if (bgImg != null) {
            g.drawImage(bgImg, 0, 0, getWidth(), getHeight(), null);
        }

        // 2. 초록색 원 그리기
        g.setColor(Color.GREEN);
        g.fillOval(circleX - R, circleY - R, R * 2, R * 2);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("드래그 가능한 원");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        DragCircle panel = new DragCircle();
        frame.add(panel);

        frame.setVisible(true);
    }
}
