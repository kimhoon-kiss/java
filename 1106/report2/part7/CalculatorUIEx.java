package report_20251106_2;

import javax.swing.*;
import java.awt.*;

public class CalculatorUIEx extends JFrame {
    public CalculatorUIEx() {
        setTitle("Swing Calculator UI");               
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setSize(300, 400);                             
        setLayout(new BorderLayout(5, 5));            // 전체 레이아웃

        /* ------------------------------
         * NORTH: 수식 입력 필드 + 레이블
         * ------------------------------ */
        JPanel northPanel = new JPanel(new BorderLayout(5, 5));
        JLabel formulaLabel = new JLabel("수식");
        formulaLabel.setPreferredSize(new Dimension(50, 30));
        JTextField inputField = new JTextField();
        northPanel.add(formulaLabel, BorderLayout.WEST);
        northPanel.add(inputField, BorderLayout.CENTER);
        add(northPanel, BorderLayout.NORTH);

        /* ------------------------------
         * CENTER: 숫자 및 연산자 버튼
         * ------------------------------ */
        JPanel centerPanel = new JPanel(new GridLayout(4, 4, 5, 5));

        String[] buttons = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "×",
            "0", "C", "=", "÷"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            centerPanel.add(btn);
        }

        add(centerPanel, BorderLayout.CENTER);

        /* ------------------------------
         * SOUTH: 노란색 가로줄 + 계산 결과
         * ------------------------------ */
        JPanel southPanel = new JPanel(new BorderLayout(5, 5));
        southPanel.setBackground(Color.YELLOW);
        southPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        southPanel.setPreferredSize(new Dimension(0, 50));

        JLabel resultLabel = new JLabel("계산결과 ");
        JTextField resultField = new JTextField(); // 흰색 결과창
        resultField.setEditable(false);
        resultField.setBackground(Color.WHITE);

        southPanel.add(resultLabel, BorderLayout.WEST);
        southPanel.add(resultField, BorderLayout.CENTER);

        add(southPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CalculatorUIEx();
    }
}
