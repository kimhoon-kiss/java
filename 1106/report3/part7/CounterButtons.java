package report_20251106_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CounterButtons extends JFrame {
    private JButton[] buttons = new JButton[5];

    public CounterButtons() {
        setTitle("버튼 클릭 카운터");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout()); // 간단하게 가로로 배치

        // 버튼 5개 생성 및 초기값 설정
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("0"); // 초기값 0
            buttons[i].setFont(new Font("맑은 고딕", Font.BOLD, 20));
            buttons[i].setPreferredSize(new Dimension(80, 50));

            // 버튼 클릭 시 숫자 증가하는 리스너 추가
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton b = (JButton) e.getSource();
                    int current = Integer.parseInt(b.getText()); // 현재 숫자 읽기
                    b.setText(Integer.toString(current + 1));   // 1 증가 후 갱신
                }
            });

            add(buttons[i]);
        }

        setSize(500, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CounterButtons();
    }
}
