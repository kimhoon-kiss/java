package report_20251106_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DragColorChangeEx extends JFrame {

    private Container contentPane;
    private boolean dragging = false; // 드래그 중 여부 표시

    public DragColorChangeEx() {
        setTitle("드래깅 동안 배경색 변경 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = getContentPane();
        contentPane.setBackground(Color.GREEN);
        contentPane.setLayout(null);

        // 마우스 이벤트 리스너 등록
        contentPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                dragging = true;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                dragging = false;
                contentPane.setBackground(Color.GREEN); // 드래그 끝나면 초록색 복귀
            }
        });

        contentPane.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (dragging)
                    contentPane.setBackground(Color.YELLOW); // 드래그 중 노란색
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                // 마우스가 움직이지만 드래깅 중이 아니면 초록색 유지
                if (!dragging)
                    contentPane.setBackground(Color.GREEN);
            }
        });

        setSize(400, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DragColorChangeEx();
    }
}
