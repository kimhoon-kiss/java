package report_20251106_2;

import javax.swing.*;
import java.awt.*;

public class GridLayoutColorEx extends JFrame {
    public GridLayoutColorEx() {
        // 프레임 제목
        setTitle("GridLayout Color Practice");
        
        // 닫기 버튼(X) 누르면 종료
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // GridLayout: 1행 10열
        setLayout(new GridLayout(1, 10));
        
        // 10개의 색을 담은 배열
        Color[] color = {
            Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
            Color.CYAN, Color.BLUE, Color.MAGENTA, Color.PINK,
            Color.GRAY, Color.LIGHT_GRAY
        };
        
        // 버튼 10개 생성 후 각각 배경색 지정
        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton("" + (i + 1));
            btn.setBackground(color[i]); // 색상 설정
            add(btn);
        }
        
        // 프레임 크기
        setSize(600, 100);
        
        // 화면 표시
        setVisible(true);
    }

    public static void main(String[] args) {
        new GridLayoutColorEx(); // 실행
    }
}
