package report_20251106_2;

import javax.swing.*;   // 스윙 컴포넌트를 사용하기 위해
import java.awt.*;      // BorderLayout, Container 등을 사용하기 위해

public class BorderLayoutEx extends JFrame {
    public BorderLayoutEx() {
        // 프레임 제목 설정
        setTitle("BorderLayout Practice");
        
        // 닫기 버튼(X)을 눌렀을 때 프로그램 종료
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // BorderLayout 생성 (가로 간격 5픽셀, 세로 간격 7픽셀)
        setLayout(new BorderLayout(5, 7));
        
        // 각 위치에 버튼 추가
        add(new JButton("North"), BorderLayout.NORTH);
        add(new JButton("South"), BorderLayout.SOUTH);
        add(new JButton("East"), BorderLayout.EAST);
        add(new JButton("West"), BorderLayout.WEST);
        add(new JButton("Center"), BorderLayout.CENTER);
        
        // 프레임 크기 지정
        setSize(400, 200);
        
        // 화면에 표시
        setVisible(true);
    }

    public static void main(String[] args) {
        new BorderLayoutEx(); // 프레임 생성
    }
}
