package kimhoon_report_20251115;

import javax.swing.*;
import java.awt.*;

public class MenuBarEx extends JFrame {

    public MenuBarEx() {
        setTitle("MenuBar Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // 메뉴바 생성
        JMenuBar menuBar = new JMenuBar();

        // 4개의 상위 메뉴
        JMenu menuFile = new JMenu("파일");
        JMenu menuEdit = new JMenu("편집");
        JMenu menuView = new JMenu("보기");
        JMenu menuInput = new JMenu("입력");

        // 보기 메뉴의 메뉴 아이템 2개
        JMenuItem itemZoom = new JMenuItem("화면확대");
        JMenuItem itemOutline = new JMenuItem("쪽윤곽");

        // 보기 메뉴에 아이템 추가
        menuView.add(itemZoom);
        menuView.add(itemOutline);

        // 메뉴바에 4개 메뉴 추가
        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuView);
        menuBar.add(menuInput);

        // 프레임에 메뉴바 설정
        setJMenuBar(menuBar);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuBarEx();
    }
}
