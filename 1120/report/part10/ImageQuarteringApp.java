package kimhoon_report_20251120;

import javax.swing.*;
import java.awt.*;

public class ImageQuarteringApp extends JFrame {

    private static final String IMAGE_FILE = "apple.jpg"; // 사용할 이미지 파일명
    private static final int GAP = 10;                     // 이미지 조각 간의 간격 (10픽셀)

    public ImageQuarteringApp() {
        setTitle("이미지 4등분 배치");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImagePanel imagePanel = new ImagePanel();
        add(imagePanel);

        // 이미지 크기에 맞춰 프레임 크기 조정 (예시 크기)
        setSize(400, 400); 
        setVisible(true);
    }

    /**
     * 이미지를 로드하고 4등분하여 간격을 두고 배치하는 패널 클래스
     */
    private class ImagePanel extends JPanel {
        private Image image;
        private int imageWidth = -1;
        private int imageHeight = -1;

        public ImagePanel() {
            // 1. 이미지 로드
            image = new ImageIcon(IMAGE_FILE).getImage();

            // 이미지 로딩 상태를 확인하고 원본 크기를 얻음
            MediaTracker mt = new MediaTracker(this);
            mt.addImage(image, 0);
            try {
                mt.waitForID(0);
                imageWidth = image.getWidth(this);
                imageHeight = image.getHeight(this);
            } catch (InterruptedException e) {
                System.err.println("이미지 로딩 실패: " + e.getMessage());
                imageWidth = 0;
                imageHeight = 0;
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (imageWidth <= 0 || imageHeight <= 0) {
                g.drawString("이미지 파일 로드 실패 또는 파일 없음: " + IMAGE_FILE, 10, 20);
                return;
            }

            // 2. 패널 크기와 간격에 기반한 계산
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            // 각 이미지 조각이 차지할 너비와 높이 (패널 크기 - 총 간격) / 2
            // 총 간격: 왼쪽/오른쪽 여백 (10px) + 중앙 간격 (10px) = 30px
            int chunkWidth = (panelWidth - 3 * GAP) / 2;
            int chunkHeight = (panelHeight - 3 * GAP) / 2;
            
            // 각 조각의 원본 이미지 내 너비와 높이
            int srcChunkWidth = imageWidth / 2;
            int srcChunkHeight = imageHeight / 2;
            
            // 이미지 조각을 그리는 메서드 호출
            
            // -----------------------------------------------------------------------------------
            // drawImage(Image, destX1, destY1, destX2, destY2, srcX1, srcY1, srcX2, srcY2, ImageObserver)
            // -----------------------------------------------------------------------------------
            
            // A. 좌측 상단 조각 (Src: 0, 0 ~ srcChunkWidth, srcChunkHeight)
            drawQuarter(g, 
                GAP, GAP, 
                GAP + chunkWidth, GAP + chunkHeight, 
                0, 0, 
                srcChunkWidth, srcChunkHeight
            );

            // B. 우측 상단 조각 (Src: srcChunkWidth, 0 ~ imageWidth, srcChunkHeight)
            drawQuarter(g, 
                2 * GAP + chunkWidth, GAP, 
                2 * GAP + 2 * chunkWidth, GAP + chunkHeight, 
                srcChunkWidth, 0, 
                imageWidth, srcChunkHeight
            );

            // C. 좌측 하단 조각 (Src: 0, srcChunkHeight ~ srcChunkWidth, imageHeight)
            drawQuarter(g, 
                GAP, 2 * GAP + chunkHeight, 
                GAP + chunkWidth, 2 * GAP + 2 * chunkHeight, 
                0, srcChunkHeight, 
                srcChunkWidth, imageHeight
            );

            // D. 우측 하단 조각 (Src: srcChunkWidth, srcChunkHeight ~ imageWidth, imageHeight)
            drawQuarter(g, 
                2 * GAP + chunkWidth, 2 * GAP + chunkHeight, 
                2 * GAP + 2 * chunkWidth, 2 * GAP + 2 * chunkHeight, 
                srcChunkWidth, srcChunkHeight, 
                imageWidth, imageHeight
            );
        }
        
        /**
         * Graphics.drawImage의 오버로드 버전을 사용하여 이미지를 그립니다.
         * @param g 그래픽 컨텍스트
         * @param dx1 목적지(패널) 좌측 상단 X
         * @param dy1 목적지(패널) 좌측 상단 Y
         * @param dx2 목적지(패널) 우측 하단 X
         * @param dy2 목적지(패널) 우측 하단 Y
         * @param sx1 원본 이미지 좌측 상단 X
         * @param sy1 원본 이미지 좌측 상단 Y
         * @param sx2 원본 이미지 우측 하단 X
         * @param sy2 원본 이미지 우측 하단 Y
         */
        private void drawQuarter(Graphics g, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2) {
             g.drawImage(
                image, 
                dx1, dy1, dx2, dy2, // 패널에 그릴 영역 (Dest)
                sx1, sy1, sx2, sy2, // 원본 이미지에서 잘라낼 영역 (Src)
                this
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ImageQuarteringApp::new);
    }
}