package kimhoon_report_20251120;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

public class PersistentCirclesApp extends JFrame {

    public PersistentCirclesApp() {
        setTitle("마우스 드래그로 원 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 원을 그릴 패널 생성
        CircleDrawingPanel drawingPanel = new CircleDrawingPanel();
        add(drawingPanel);

        setSize(600, 400);
        setVisible(true);
    }

    /**
     * 원의 정보를 저장할 내부 클래스 (Color 추가하여 구분 용이하게 함)
     */
    private class Circle {
        public int x, y;     // 중심점 좌표
        public int radius;   // 반지름
        public Color color;  // 원의 색상

        public Circle(int x, int y, int radius, Color color) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.color = color;
        }
    }

    /**
     * 마우스 이벤트를 처리하고 원을 그리는 패널 클래스
     */
    private class CircleDrawingPanel extends JPanel implements MouseMotionListener {
        
        // 그려진 모든 Circle 객체를 저장할 Vector
        private Vector<Circle> circles = new Vector<>();
        
        // 현재 그리고 있는 원의 정보 (임시 저장)
        private Point startPoint = null; // 마우스 클릭 시작점 (원의 중심)
        private Circle currentCircle = null; // 현재 임시로 그릴 원
        
        // 그리기 색상
        private final Color DRAW_COLOR = Color.BLUE;

        public CircleDrawingPanel() {
            // 마우스 클릭 및 릴리스 이벤트 처리
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    // 마우스 클릭 지점을 원의 중심점으로 설정
                    startPoint = e.getPoint();
                    currentCircle = null; // 새 원 시작
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    // 마우스 릴리스 시, 현재 원을 최종 저장소(Vector)에 추가
                    if (currentCircle != null) {
                        circles.add(currentCircle);
                        currentCircle = null; // 임시 원 정보 초기화
                    }
                    startPoint = null;
                    
                    // 릴리스 후 최종적으로 화면 갱신
                    repaint(); 
                }
            });

            // 마우스 드래그 이벤트 처리
            addMouseMotionListener(this);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (startPoint == null) return;
            
            // 현재 마우스 위치 (드래그 끝점)
            Point endPoint = e.getPoint();
            
            // 중심점(startPoint)과 현재 마우스 위치(endPoint) 사이의 거리 계산
            // 이 거리가 원의 반지름이 됨
            int radius = (int) startPoint.distance(endPoint);
            
            // 임시 원 객체 생성 (아직 Vector에 저장되지는 않음)
            currentCircle = new Circle(
                startPoint.x, 
                startPoint.y, 
                radius, 
                DRAW_COLOR
            );
            
            // 마우스 드래그 중에도 실시간으로 원을 보여주기 위해 갱신 요청
            repaint(); 
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            // 필요 없음
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            
            // --- 1. Vector에 저장된 모든 원 그리기 (영구적으로 표시되는 원) ---
            for (Circle circle : circles) {
                g2d.setColor(circle.color);
                
                // 원을 그릴 위치와 크기 계산: (x, y)는 좌측 상단 모서리여야 함
                int diameter = circle.radius * 2;
                int x = circle.x - circle.radius; // 좌측 상단 x
                int y = circle.y - circle.radius; // 좌측 상단 y
                
                // 원의 윤곽선만 그리기
                g2d.drawOval(x, y, diameter, diameter); 
            }
            
            // --- 2. 현재 드래그 중인 임시 원 그리기 (마우스에 따라 움직이는 원) ---
            if (currentCircle != null) {
                g2d.setColor(Color.RED); // 임시 원은 다른 색으로 구분
                
                int diameter = currentCircle.radius * 2;
                int x = currentCircle.x - currentCircle.radius;
                int y = currentCircle.y - currentCircle.radius;

                g2d.drawOval(x, y, diameter, diameter);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PersistentCirclesApp::new);
    }
}