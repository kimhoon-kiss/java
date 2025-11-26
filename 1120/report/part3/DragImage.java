package kimhoon_report_20251120;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DragImage extends JFrame {

    private JLabel imgLabel;   // 이미지를 표시할 JLabel
    private int mouseX, mouseY; // 마우스를 눌렀을 때의 상대 위치 저장

    public DragImage() {
        setTitle("이미지 드래그");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(null);    // 위치를 자유롭게 설정하기 위해 null 레이아웃 사용

        // 이미지 아이콘 불러오기
        ImageIcon icon = new ImageIcon("apple.jpg");

        // JLabel에 이미지 넣기
        imgLabel = new JLabel(icon);
        imgLabel.setSize(icon.getIconWidth(), icon.getIconHeight());
        imgLabel.setLocation(100, 100); // 시작 위치

        // 마우스 눌렀을 때의 좌표 저장
        imgLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });

        // 마우스를 드래그하면 라벨 위치 이동
        imgLabel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int newX = imgLabel.getX() + e.getX() - mouseX;
                int newY = imgLabel.getY() + e.getY() - mouseY;

                imgLabel.setLocation(newX, newY);
            }
        });

        contentPane.add(imgLabel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DragImage();
    }
}
