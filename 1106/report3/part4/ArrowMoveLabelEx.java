package report_20251106_3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ArrowMoveLabelEx extends JFrame {
    private JLabel[] labels = new JLabel[15];
    private int index = 7; // 초기 선택 위치 (중앙 근처)
    private JPanel centerPanel;

    public ArrowMoveLabelEx() {
        setTitle("상하좌우 키로 이동");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        // 🟢 NORTH 영역 - 안내문
        JLabel msg = new JLabel("상하좌우 키로 블록을 이동시킬 수 있습니다", SwingConstants.CENTER);
        c.add(msg, BorderLayout.NORTH);

        // 🟣 CENTER 영역 - 격자 패널
        centerPanel = new JPanel(new GridLayout(3, 5, 1, 1));
        centerPanel.setBackground(Color.PINK);
        c.add(centerPanel, BorderLayout.CENTER);

        // 15개의 JLabel 생성 (흰색 배경, 테두리)
        for (int i = 0; i < 15; i++) {
            labels[i] = new JLabel();
            labels[i].setOpaque(true);
            labels[i].setBackground(Color.WHITE);
            centerPanel.add(labels[i]);
        }

        // 초기 선택된 칸을 파란색으로 표시
        labels[index].setBackground(Color.BLUE);

        // 키 이벤트 리스너 등록
        c.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                // 이전 칸은 흰색으로 되돌림
                labels[index].setBackground(Color.WHITE);

                switch (keyCode) {
                    case KeyEvent.VK_LEFT:
                        if (index % 5 != 0) index--; // 같은 행에서 왼쪽 이동
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (index % 5 != 4) index++; // 같은 행에서 오른쪽 이동
                        break;
                    case KeyEvent.VK_UP:
                        if (index >= 5) index -= 5; // 위 행으로 이동
                        break;
                    case KeyEvent.VK_DOWN:
                        if (index < 10) index += 5; // 아래 행으로 이동
                        break;
                }

                // 새 칸을 파란색으로 변경
                labels[index].setBackground(Color.BLUE);
            }
        });

        // 키 입력 받을 수 있도록 설정
        c.setFocusable(true);
        c.requestFocus();

        setSize(400, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ArrowMoveLabelEx();
    }
}
