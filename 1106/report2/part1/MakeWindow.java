package report_20251106_2;

import javax.swing.*;   // 스윙 컴포넌트를 사용하기 위해
import java.awt.*;      // Color, Container 등을 사용하기 위해

public class MakeWindow extends JFrame {
    public MakeWindow() {
        // 프레임의 타이틀 설정
        setTitle("Make a Window using Swing");
        
        // 프레임의 기본 종료 동작 설정 (닫기 버튼 누르면 프로그램 종료)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 컨텐트팬 가져오기
        Container c = getContentPane();
        
        // 배경색을 노란색으로 설정
        c.setBackground(Color.YELLOW);
        
        // 프레임 크기 설정 (가로 400, 세로 150)
        setSize(400, 150);
        
        // 프레임을 화면에 표시
        setVisible(true);
    }
    
    public static void main(String[] args) {
        // 프레임 생성
        new MakeWindow();
    }
}
