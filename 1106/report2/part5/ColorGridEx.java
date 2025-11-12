package report_20251106_2;

import javax.swing.*;
import java.awt.*;

public class ColorGridEx extends JFrame {
    public ColorGridEx() {
        // 프레임 제목
        setTitle("Color Grid 4x4");
        
        // 닫기 버튼(X) 누르면 프로그램 종료
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // GridLayout: 4행 4열, 간격 0
        setLayout(new GridLayout(4, 4));
        
        // 사용할 색상 16개 배열
        Color[] colors = {
            Color.WHITE, Color.LIGHT_GRAY, Color.GRAY, Color.DARK_GRAY,
            Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
            Color.CYAN, Color.BLUE, Color.MAGENTA, Color.PINK,
            new Color(128, 0, 0), new Color(0, 128, 0),
            new Color(0, 0, 128), new Color(255, 200, 0)
        };
        
        // JLabel 16개 생성 후 각각 색상과 순서 표시
        for (int i = 0; i < 16; i++) {
            JLabel label = new JLabel(String.valueOf(i + 1));
            label.setOpaque(true);                // 배경색 보이게 설정
            label.setBackground(colors[i]);       // 색상 적용
            label.setFont(new Font("Arial", Font.BOLD, 20)); // 글꼴 크기
            label.setForeground(Color.BLACK);    // 글자 색
            label.setHorizontalAlignment(SwingConstants.LEFT); // 왼쪽 정렬
            label.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0)); // 왼쪽 여백
            add(label);                           // 프레임에 추가
        }
        
        // 프레임 크기 설정
        setSize(400, 400);
        
        // 프레임 보이기
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new ColorGridEx(); // 실행
    }
}
