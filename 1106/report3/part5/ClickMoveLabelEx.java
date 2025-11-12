package report_20251106_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ClickMoveLabelEx extends JFrame {
    private JLabel label;
    private Random rand = new Random();

    public ClickMoveLabelEx() {
        setTitle("클릭하면 움직이는 C");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // 배치관리자 제거

        // JLabel 생성
        label = new JLabel("C");
        label.setFont(new Font("Gulim", Font.BOLD, 40));
        label.setSize(50, 50); // JLabel 크기 지정
        label.setLocation(100, 100); // 초기 위치 설정
        add(label);

        // 클릭 이벤트 리스너
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 프레임 크기 내에서 무작위 좌표 계산
                int frameWidth = getWidth();
                int frameHeight = getHeight();

                int labelWidth = label.getWidth();
                int labelHeight = label.getHeight();

                // JLabel이 프레임 내부에서 벗어나지 않도록 조정
                int x = rand.nextInt(Math.max(1, frameWidth - labelWidth - 20));
                int y = rand.nextInt(Math.max(1, frameHeight - labelHeight - 40));

                label.setLocation(x, y);
            }
        });

        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ClickMoveLabelEx();
    }
}
