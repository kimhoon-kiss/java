package kimhoon_report_20251115;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CoffeeMachine extends JFrame {

    private final int MAX = 10;

    // ProgressBar (세로, 크기 조정)
    private JProgressBar cupBar, coffeeBar, waterBar, sugarBar, creamBar;

    public CoffeeMachine() {
        setTitle("Coffee Machine");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout());

        // ===== NORTH =====
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());

        JLabel title = new JLabel("Welcome, Hot Coffee!!", SwingConstants.CENTER);
        title.setFont(new Font("고딕", Font.BOLD, 24));
        northPanel.add(title, BorderLayout.NORTH);

        // 보라색 가로줄
        JPanel purpleLine = new JPanel();
        purpleLine.setBackground(new Color(128, 0, 128)); // 보라색
        purpleLine.setPreferredSize(new Dimension(0, 5)); // 높이 5픽셀
        northPanel.add(purpleLine, BorderLayout.SOUTH);

        add(northPanel, BorderLayout.NORTH);

        // ===== CENTER (ProgressBar 영역) =====
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); // 세로 ProgressBar 가로 정렬

        cupBar = createVerticalBar();
        coffeeBar = createVerticalBar();
        waterBar = createVerticalBar();
        sugarBar = createVerticalBar();
        creamBar = createVerticalBar();

        // 라벨 + ProgressBar 묶기
        centerPanel.add(createResourcePanel("Cup", cupBar));
        centerPanel.add(createResourcePanel("Coffee", coffeeBar));
        centerPanel.add(createResourcePanel("Water", waterBar));
        centerPanel.add(createResourcePanel("Sugar", sugarBar));
        centerPanel.add(createResourcePanel("Cream", creamBar));

        add(centerPanel, BorderLayout.CENTER);

        // ===== SOUTH (버튼 영역) =====
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1, 4, 10, 10));

        JButton blackBtn = new JButton("Black Coffee");
        JButton sugarBtn = new JButton("Sugar Coffee");
        JButton dabangBtn = new JButton("Dabang Coffee");
        JButton resetBtn = new JButton("Reset");

        southPanel.add(blackBtn);
        southPanel.add(sugarBtn);
        southPanel.add(dabangBtn);
        southPanel.add(resetBtn);

        add(southPanel, BorderLayout.SOUTH);

        // 버튼 이벤트 등록
        blackBtn.addActionListener(e -> makeCoffee("BLACK"));
        sugarBtn.addActionListener(e -> makeCoffee("SUGAR"));
        dabangBtn.addActionListener(e -> makeCoffee("DABANG"));
        resetBtn.addActionListener(e -> reset());

        setVisible(true);
    }

    // 세로 ProgressBar 생성 + 크기 조정 + 숫자 제거
    private JProgressBar createVerticalBar() {
        JProgressBar bar = new JProgressBar(JProgressBar.VERTICAL, 0, MAX);
        bar.setValue(MAX);
        bar.setStringPainted(false); // 숫자 표시 제거
        bar.setPreferredSize(new Dimension(50, 150)); // 가로 50, 세로 150
        return bar;
    }

    // ProgressBar + 라벨 묶기
    private JPanel createResourcePanel(String name, JProgressBar bar) {
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        JLabel label = new JLabel(name, SwingConstants.CENTER);
        p.add(label, BorderLayout.NORTH);
        p.add(bar, BorderLayout.CENTER);
        return p;
    }

    // Reset 기능
    private void reset() {
        cupBar.setValue(MAX);
        coffeeBar.setValue(MAX);
        waterBar.setValue(MAX);
        sugarBar.setValue(MAX);
        creamBar.setValue(MAX);

        JOptionPane.showMessageDialog(this, "재료가 모두 보충되었습니다!");
    }

    // 커피 만들기
    private void makeCoffee(String type) {

        // 필요한 자원 체크
        if (!hasEnough(type)) {
            JOptionPane.showMessageDialog(this,
                    "부족한 것이 있습니다. 채워주세요.",
                    "경고",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 자원 차감
        cupBar.setValue(cupBar.getValue() - 1);
        coffeeBar.setValue(coffeeBar.getValue() - 1);
        waterBar.setValue(waterBar.getValue() - 1);

        if (type.equals("SUGAR") || type.equals("DABANG"))
            sugarBar.setValue(sugarBar.getValue() - 1);

        if (type.equals("DABANG"))
            creamBar.setValue(creamBar.getValue() - 1);

        // 커피 이미지 출력 + 메시지
        ImageIcon icon = new ImageIcon("./coffee.jpg");  // 이미지 경로
        JOptionPane.showMessageDialog(this,
                "뜨거워요, 즐거운 하루~",
                "커피 완성!",
                JOptionPane.INFORMATION_MESSAGE,
                icon);
    }

    // 재료 충분한지 체크
    private boolean hasEnough(String type) {
        if (cupBar.getValue() < 1 || coffeeBar.getValue() < 1 || waterBar.getValue() < 1)
            return false;

        if (type.equals("SUGAR") || type.equals("DABANG"))
            if (sugarBar.getValue() < 1) return false;

        if (type.equals("DABANG"))
            if (creamBar.getValue() < 1) return false;

        return true;
    }

    public static void main(String[] args) {
        new CoffeeMachine();
    }
}
