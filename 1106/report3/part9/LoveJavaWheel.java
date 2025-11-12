package report_20251106_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoveJavaWheel extends JFrame {
    private JLabel label;
    private int fontSize = 30; // 초기 폰트 크기

    public LoveJavaWheel() {
        setTitle("Love Java 폰트 크기 조절");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLayout(new FlowLayout());

        label = new JLabel("Love Java");
        label.setFont(new Font("Serif", Font.PLAIN, fontSize));
        add(label);

        // 마우스 휠 리스너 등록
        label.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int rotation = e.getWheelRotation();

                if (rotation < 0) { // 위로 굴림 → 크기 감소
                    if (fontSize > 5) {
                        fontSize -= 5;
                    }
                } else { // 아래로 굴림 → 크기 증가
                    fontSize += 5;
                }

                label.setFont(new Font("Serif", Font.PLAIN, fontSize));
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoveJavaWheel();
    }
}
