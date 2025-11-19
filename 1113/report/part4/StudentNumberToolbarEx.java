package kimhoon_report_20251115;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentNumberToolbarEx extends JFrame {

    public StudentNumberToolbarEx() {
        setTitle("학번 입력 툴바 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        // ---- 툴바 생성 ----
        JToolBar toolBar = new JToolBar();

        // 라벨
        JLabel label = new JLabel("학번: ");

        // 텍스트필드 생성
        JTextField tf = new JTextField(15);

        // KeyListener 추가
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char ch = e.getKeyChar();

                // 입력된 문자가 숫자가 아니면
                if (!Character.isDigit(ch)) {
                    e.consume(); // 입력 무효화
                    JOptionPane.showMessageDialog(
                            StudentNumberToolbarEx.this,
                            "숫자가 아닌 키입니다. 숫자를 입력하세요.",
                            "입력 오류",
                            JOptionPane.WARNING_MESSAGE
                    );
                }
            }
        });

        // 툴바에 컴포넌트 추가
        toolBar.add(label);
        toolBar.add(tf);

        add(toolBar, BorderLayout.NORTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentNumberToolbarEx();
    }
}
