package report_20251106_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class MovingBlocks extends JFrame {
    private JPanel panel;
    private Random rand = new Random();

    public MovingBlocks() {
        setTitle("라온의 블록 드래그 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        panel = new JPanel();
        panel.setLayout(null); // 자유 배치
        panel.setBackground(Color.WHITE);
        add(panel);

        // 키 입력 감지
        panel.setFocusable(true);
        panel.requestFocus();
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'm' || e.getKeyChar() == 'M') {
                    createBlock();
                }
            }
        });

        setVisible(true);
    }

    // 블록 생성 메서드
    private void createBlock() {
        JLabel block = new JLabel();
        block.setOpaque(true);
        block.setBackground(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        block.setBounds(100, 100, 80, 80);

        // 마우스로 드래그 가능하게 설정
        BlockDragListener listener = new BlockDragListener(block);
        block.addMouseListener(listener);
        block.addMouseMotionListener(listener);

        panel.add(block);
        panel.repaint();
        panel.requestFocus();
    }

    // 드래그 동작 리스너 내부 클래스
    private class BlockDragListener extends MouseAdapter {
        private JLabel target;
        private Point prevPt;

        public BlockDragListener(JLabel target) {
            this.target = target;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            prevPt = e.getPoint(); // 클릭 시작 지점 저장
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            int dx = e.getX() - prevPt.x;
            int dy = e.getY() - prevPt.y;

            Point current = target.getLocation();
            target.setLocation(current.x + dx, current.y + dy);
        }
    }

    public static void main(String[] args) {
        new MovingBlocks();
    }
}
