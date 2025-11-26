package kimhoon_report_20251120;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ClippingDemo extends JPanel implements KeyListener {

    private BufferedImage image;
    private int clipX = 0, clipY = 0;        // 클리핑 영역 시작 좌표
    private final int clipSize = 50;         // 클리핑 영역 크기

    public ClippingDemo() {
        try {
            // 이미지 파일경로를 실제 경로로 바꿔야 함
            image = ImageIO.read(new File("yourImage.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "이미지 로드 실패");
            System.exit(1);
        }
        setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();

        // 클리핑 영역 설정
        g2.setClip(clipX, clipY, clipSize, clipSize);

        // 이미지 그리기 (0,0 위치 기준)
        g2.drawImage(image, 0, 0, this);

        g2.dispose();

        // 클리핑 영역 시각적으로 표시하려면 아래 주석 해제
        /*
        Graphics2D g3 = (Graphics2D) g;
        g3.setColor(Color.RED);
        g3.drawRect(clipX, clipY, clipSize, clipSize);
        */
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_UP:
                clipY = Math.max(clipY - 10, 0);
                break;
            case KeyEvent.VK_DOWN:
                clipY = Math.min(clipY + 10, getHeight() - clipSize);
                break;
            case KeyEvent.VK_LEFT:
                clipX = Math.max(clipX - 10, 0);
                break;
            case KeyEvent.VK_RIGHT:
                clipX = Math.min(clipX + 10, getWidth() - clipSize);
                break;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // 사용 안 함
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // 사용 안 함
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("클리핑 이동 데모");
            ClippingDemo panel = new ClippingDemo();
            frame.add(panel);
            frame.pack();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            panel.requestFocusInWindow();  // 키 이벤트 받을 수 있게 포커스 요청
        });
    }
}