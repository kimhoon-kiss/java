package report_20251106_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RotateStringEx extends JFrame {
    private JLabel label;
    private String text = "Love Java";

    public RotateStringEx() {
        setTitle("문자열 왼쪽 회전 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // JLabel 생성
        label = new JLabel(text);
        label.setFont(new Font("Gulim", Font.BOLD, 30));
        add(label);

        // 키 리스너 추가
        label.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // 왼쪽 화살표 키를 누르면 문자열 회전
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    text = text.substring(1) + text.charAt(0);
                    label.setText(text);
                }
            }
        });

        // 포커스를 받을 수 있도록 설정
        label.setFocusable(true);
        label.requestFocus();

        setSize(300, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RotateStringEx();
    }
}
