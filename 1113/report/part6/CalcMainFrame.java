package kimhoon_report_20251115;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalcMainFrame extends JFrame {

    private JLabel resultLabel; // 결과 출력 라벨

    public CalcMainFrame() {
        setTitle("Calculate Dialog Example");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        // 결과 출력 라벨
        resultLabel = new JLabel("Result: ");
        resultLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));

        // Calculate 버튼
        JButton btnCalc = new JButton("Calculate");
        btnCalc.addActionListener(e -> {
            // 다이얼로그 생성 (this = 부모 프레임)
            CalcDialog dialog = new CalcDialog(this);
            dialog.setVisible(true);  // 모달 다이얼로그 띄우기
        });

        c.add(btnCalc);
        c.add(resultLabel);

        setVisible(true);
    }

    // 메인 프레임 라벨을 업데이트하는 함수
    public void setResult(int value) {
        resultLabel.setText("Result: " + value);
    }

    public static void main(String[] args) {
        new CalcMainFrame();
    }
}


// ----------------------- CalcDialog 클래스 정의 -----------------------

class CalcDialog extends JDialog {

    private JTextField tf1;
    private JTextField tf2;

    public CalcDialog(CalcMainFrame parent) {
        // 부모 프레임 전달 + 모달 true 설정
        super(parent, "Calculator", true);

        setSize(250, 200);
        setLayout(new FlowLayout());

        add(new JLabel("Number 1:"));
        tf1 = new JTextField(10);
        add(tf1);

        add(new JLabel("Number 2:"));
        tf2 = new JTextField(10);
        add(tf2);

        JButton btnAdd = new JButton("Add");
        add(btnAdd);

        // Add 버튼 이벤트 처리
        btnAdd.addActionListener(e -> {
            try {
                int n1 = Integer.parseInt(tf1.getText());
                int n2 = Integer.parseInt(tf2.getText());
                int sum = n1 + n2;

                // 메인 프레임에 결과 전달
                parent.setResult(sum);

                // 다이얼로그 닫기
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "정수를 입력하세요.");
            }
        });
    }
}
