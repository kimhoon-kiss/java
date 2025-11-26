package kimhoon_report_20251120;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class PolygonDrawerApp extends JFrame {

    public PolygonDrawerApp() {
        setTitle("마우스 클릭 다각형 그리기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 그래픽을 그릴 패널 생성
        DrawingPanel drawingPanel = new DrawingPanel();
        add(drawingPanel);

        setSize(600, 400); 
        setVisible(true);
    }

    /**
     * 마우스 이벤트를 처리하고 다각형을 그리는 패널 클래스
     */
    private class DrawingPanel extends JPanel {
        // 클릭된 점의 좌표를 저장할 리스트
        private List<Point> points = new ArrayList<>();
        // 점을 찍을 때 표시할 크기
        private final int DOT_SIZE = 8; 

        public DrawingPanel() {
            // MouseAdapter를 사용하여 클릭 이벤트만 간편하게 처리
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // 클릭된 위치의 좌표를 리스트에 추가
                    points.add(e.getPoint()); 
                    
                    // 패널을 다시 그려 업데이트된 선분과 점을 표시
                    repaint(); 
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // 시작 안내 메시지
            if (points.size() < 1) {
                g.drawString("화면을 클릭하여 점을 찍으세요. (점 3개 이상 시 폐다각형 완성)", 10, 20);
                return;
            }

            // --- 1. 점들을 연결하는 선분 및 점 그리기 ---
            g.setColor(Color.BLUE);
            Graphics2D g2d = (Graphics2D) g;
            // 선 굵기 설정
            g2d.setStroke(new BasicStroke(2)); 

            for (int i = 0; i < points.size(); i++) {
                Point current = points.get(i);
                
                // --- 1-1. 점 그리기 (클릭 위치 표시) ---
                // DOT_SIZE/2를 빼서 클릭 지점을 원의 중심으로 맞춤
                g.fillOval(current.x - DOT_SIZE / 2, current.y - DOT_SIZE / 2, DOT_SIZE, DOT_SIZE);
                
                // --- 1-2. 이전 점과 현재 점을 선분으로 연결 ---
                if (i > 0) {
                    Point prev = points.get(i - 1);
                    g.drawLine(prev.x, prev.y, current.x, current.y);
                }
            }

            // --- 2. 폐다각형(닫힌 다각형) 만들기 ---
            // 점이 3개 이상이면 첫 번째 점과 마지막 점을 연결
            if (points.size() >= 3) {
                Point first = points.get(0);
                Point last = points.get(points.size() - 1);
                
                // 폐다각형을 닫는 선분을 다른 색(예: 빨간색)으로 표시
                g.setColor(Color.RED); 
                g.drawLine(last.x, last.y, first.x, first.y);
            }
        }
    }

    public static void main(String[] args) {
        // 이벤트 디스패치 스레드에서 GUI 생성 및 실행
        SwingUtilities.invokeLater(PolygonDrawerApp::new);
    }
}