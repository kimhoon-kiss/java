package report_20251106_2;

import javax.swing.*;
import java.awt.*;

public class GridLayoutEx extends JFrame {
    public GridLayoutEx() {
        // 프레임 제목
        setTitle("GridLayout Practice");
        
        // 닫기 버튼(X)을 누르면 프로그램 종료
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // GridLayout: 1행 10열, 간격 없음
        setLayout(new GridLayout(1, 10));
        
        // 버튼 10개 생성 및 추가
        for (int i = 1; i <= 10; i++) {
            add(new JButton("" + i));
        }
        
        // 프레임 크기 설정
        setSize(600, 100);
        
        // 화면 표시
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new GridLayoutEx(); // 실행
    }
}
