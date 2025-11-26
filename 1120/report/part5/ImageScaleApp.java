package kimhoon_report_20251120;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ImageScaleApp extends JFrame {
    
    // 초기 이미지 파일 이름
    private static final String IMAGE_FILE = "apple.jpg";
    
    public ImageScaleApp() {
        setTitle("이미지 확대/축소 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 이미지 패널 생성
        ImagePanel imagePanel = new ImagePanel();
        add(imagePanel);
        
        // KeyListener를 등록하고 포커스를 받을 수 있도록 설정
        imagePanel.setFocusable(true);
        imagePanel.requestFocusInWindow(); // 윈도우가 보일 때 포커스를 요청
        
        setSize(500, 400); // 윈도우 크기 설정 (적절히 조정 가능)
        setVisible(true);
    }

    /**
     * 이미지를 그리고 키 이벤트에 따라 크기를 조절하는 패널 클래스
     */
    private class ImagePanel extends JPanel implements KeyListener {
        private Image image;
        private double scale = 1.0; // 현재 스케일링 비율
        private int originalWidth = -1; // 원본 이미지 너비
        private int originalHeight = -1; // 원본 이미지 높이
        
        // 이미지 초기 위치
        private final int IMAGE_X = 10;
        private final int IMAGE_Y = 10;

        public ImagePanel() {
            // 이미지 로드
            image = new ImageIcon(IMAGE_FILE).getImage();

            // ImageObserver를 사용하여 이미지 너비/높이 얻기
            // Image 로딩은 비동기적일 수 있으므로 getWidth/getHeight(this)를 사용
            // 값이 -1로 나오면 로딩 중이므로, 완전히 로드될 때까지 기다려야 할 수 있습니다.
            originalWidth = image.getWidth(this);
            originalHeight = image.getHeight(this);
            
            // KeyListener 등록
            addKeyListener(this);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            // Graphics2D 객체 사용을 위해 캐스팅
            Graphics2D g2 = (Graphics2D) g;

            // 이미지가 로드된 후 원본 크기를 얻음
            if (originalWidth == -1 || originalHeight == -1) {
                originalWidth = image.getWidth(this);
                originalHeight = image.getHeight(this);
            }
            
            // 로드가 완료되었고 크기가 유효할 때만 그리기
            if (originalWidth > 0 && originalHeight > 0) {
                
                // 현재 스케일이 적용된 너비와 높이 계산
                int currentWidth = (int) (originalWidth * scale);
                int currentHeight = (int) (originalHeight * scale);

                // 이미지를 지정된 위치와 크기로 그림 (스케일링 적용)
                g2.drawImage(
                    image, 
                    IMAGE_X, IMAGE_Y,            // 이미지 좌측 상단 위치
                    currentWidth, currentHeight,  // 이미지의 새로운 너비와 높이
                    this
                );
            } else {
                g2.drawString("이미지 파일 로드 중이거나 로드 실패: " + IMAGE_FILE, IMAGE_X, IMAGE_Y + 15);
            }
        }

        // --- KeyListener 구현 ---
        
        @Override
        public void keyTyped(KeyEvent e) {
            char keyChar = e.getKeyChar();
            
            // '+' 키 입력 시 (쉬프트와 '='이 함께 눌리는 경우도 처리)
            if (keyChar == '+') {
                scale *= 1.1; // 10% 확대
                repaint();     // 화면 다시 그리기 요청
                System.out.println("이미지 확대: 스케일 = " + String.format("%.2f", scale));
            } 
            // '-' 키 입력 시
            else if (keyChar == '-') {
                // 최소 스케일 제한 (예: 0.1 이하로는 축소되지 않도록)
                if (scale > 0.1) {
                    scale *= 0.9; // 10% 축소
                    repaint();     // 화면 다시 그리기 요청
                    System.out.println("이미지 축소: 스케일 = " + String.format("%.2f", scale));
                } else {
                    System.out.println("더 이상 축소할 수 없습니다.");
                }
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            // 이 문제에서는 keyTyped에서 처리하므로 비워둡니다.
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // 이 문제에서는 keyTyped에서 처리하므로 비워둡니다.
        }
    }

    public static void main(String[] args) {
        // 이벤트 디스패치 스레드에서 GUI 생성 및 실행
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImageScaleApp();
            }
        });
    }
}