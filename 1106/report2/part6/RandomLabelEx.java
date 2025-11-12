package report_20251106_2;

import javax.swing.*;
import java.awt.*;

public class RandomLabelEx extends JFrame {
    public RandomLabelEx() {
        // 프레임 제목
        setTitle("Random Color Labels");
        
        // 닫기 버튼(X) 누르면 종료
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 크기 설정
        setSize(300, 300);
        
        // 절대 위치 지정 모드 (레이아웃 사용 안 함)
        setLayout(null);
        
        // JLabel 20개 생성
        for (int i = 0; i < 20; i++) {
            JLabel label = new JLabel();
            label.setOpaque(true); // 배경색 표시
            
            // 랜덤 RGB 색상
            int r = (int)(Math.random() * 256);
            int g = (int)(Math.random() * 256);
            int b = (int)(Math.random() * 256);
            label.setBackground(new Color(r, g, b));
            
            // 랜덤 위치 (x: 10~250, y: 10~250)
            int x = (int)(Math.random() * 240) + 10;
            int y = (int)(Math.random() * 240) + 10;
            
            // JLabel 크기 10×10
            label.setSize(10, 10);
            label.setLocation(x, y);
            
            // 프레임에 추가
            add(label);
        }
        
        // 프레임 보이기
        setVisible(true);
    }

    public static void main(String[] args) {
        new RandomLabelEx();
    }
}
