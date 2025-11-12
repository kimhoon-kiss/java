package report_20251106_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HoverLabel extends JFrame {

    public HoverLabel() {
        setTitle("JLabel 마우스 이벤트 예제");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel label = new JLabel("사랑해 자바");
        label.setFont(new Font("맑은 고딕", Font.BOLD, 30));
        label.setForeground(Color.BLUE);

        // 마우스 리스너 등록
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                label.setText("Love Java");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setText("사랑해 자바");
            }
        });

        add(label);

        setVisible(true);
    }

    public static void main(String[] args) {
        new HoverLabel();
    }
}
