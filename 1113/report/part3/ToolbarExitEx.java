package kimhoon_report_20251115;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToolbarExitEx extends JFrame {

    public ToolbarExitEx() {
        setTitle("Toolbar Exit Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // ---- 툴바 생성 ----
        JToolBar toolBar = new JToolBar();

        // 종료 버튼 생성
        JButton btnExit = new JButton("종료");

        // 종료 버튼 이벤트 처리
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exitProgram(); // 종료 처리 함수 호출
            }
        });

        // 툴바에 버튼 추가
        toolBar.add(btnExit);

        // 프레임에 툴바 부착
        add(toolBar, BorderLayout.NORTH);

        setVisible(true);
    }

    // 종료 처리 함수
    private void exitProgram() {
        int result = JOptionPane.showConfirmDialog(
                this,
                "정말 종료하시겠습니까?",
                "종료 확인",
                JOptionPane.YES_NO_OPTION
        );

        if (result == JOptionPane.YES_OPTION) {
            System.exit(0);  // YES 선택 시 종료
        }
        // NO 선택 시 아무 행동 없음
    }

    public static void main(String[] args) {
        new ToolbarExitEx();
    }
}
