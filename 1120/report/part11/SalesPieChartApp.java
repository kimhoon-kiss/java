package kimhoon_report_20251120;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class SalesPieChartApp extends JFrame {

    // 과일 이름 배열
    private final String[] FRUIT_NAMES = {"apple", "cherry", "strawberry", "prune"};
    // 판매량 입력을 위한 텍스트 필드
    private JTextField[] salesFields;
    // 파이 차트를 그릴 패널
    private PieChartPanel chartPanel;

    public SalesPieChartApp() {
        setTitle("과일 판매량 파이 차트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 메인 컨테이너 설정
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(10, 10)); // 여백 추가

        // --- 1. 입력 패널 설정 ---
        JPanel inputPanel = createInputPanel();
        contentPane.add(inputPanel, BorderLayout.NORTH);

        // --- 2. 차트 및 결과 표시 패널 설정 ---
        chartPanel = new PieChartPanel();
        // 차트 패널의 선호 크기 설정 (초기 크기 및 파이 차트의 비율을 위해)
        chartPanel.setPreferredSize(new Dimension(400, 300));
        contentPane.add(chartPanel, BorderLayout.CENTER);

        pack(); // 컴포넌트 크기에 맞게 프레임 크기 조절
        setLocationRelativeTo(null); // 화면 중앙 배치
        setVisible(true);
    }

    /**
     * 판매량 입력 필드와 라벨을 포함하는 입력 패널 생성 및 ActionListener 설정
     */
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(FRUIT_NAMES.length, 2, 5, 5)); // 4행 2열
        salesFields = new JTextField[FRUIT_NAMES.length];

        // Action 리스너: Enter 키 입력 시 데이터 처리 및 갱신
        ActionListener inputListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAndRedraw();
            }
        };

        for (int i = 0; i < FRUIT_NAMES.length; i++) {
            // 과일 이름 라벨
            panel.add(new JLabel(FRUIT_NAMES[i] + " 판매량: "));

            // 텍스트 필드
            salesFields[i] = new JTextField("0", 10); // 기본값 "0" 설정
            salesFields[i].addActionListener(inputListener); // Enter 키 이벤트 등록
            panel.add(salesFields[i]);

            // 초기 테스트 데이터 설정 (선택 사항, 테스트 시 주석 해제)
            // salesFields[i].setText(String.valueOf((i + 1) * 10));
        }
        return panel;
    }

    /**
     * 모든 입력 데이터를 읽어 백분율을 계산하고 파이 차트 패널을 갱신
     */
    private void calculateAndRedraw() {
        double totalSales = 0;
        double[] sales = new double[FRUIT_NAMES.length];

        // 1. 판매량 읽기 및 총합 계산
        for (int i = 0; i < FRUIT_NAMES.length; i++) {
            try {
                // 입력된 문자열을 숫자로 파싱
                sales[i] = Double.parseDouble(salesFields[i].getText().trim());
                if (sales[i] < 0) { // 음수 입력 방지
                    JOptionPane.showMessageDialog(this, FRUIT_NAMES[i] + " 판매량은 음수일 수 없습니다.", "입력 오류", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                totalSales += sales[i];
            } catch (NumberFormatException ex) {
                // 숫자가 아닌 입력은 0으로 간주하고 오류 메시지 출력
                sales[i] = 0; // 오류 발생해도 다른 항목 계산을 위해 0으로 설정
                JOptionPane.showMessageDialog(this, FRUIT_NAMES[i] + " 판매량이 유효하지 않습니다. 숫자를 입력하세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
                return; // 오류 발생 시 계산 중단
            }
        }

        // 2. 백분율 계산 및 차트 데이터 설정
        if (totalSales > 0) {
            Vector<Slice> data = new Vector<>();
            StringBuilder resultText = new StringBuilder("<html><b>과일별 판매량 비율</b><br>");

            for (int i = 0; i < FRUIT_NAMES.length; i++) {
                double percentage = (sales[i] / totalSales) * 100;
                resultText.append("<b>").append(FRUIT_NAMES[i]).append("</b>: ")
                          .append(String.format("%.1f", percentage)).append("% (").append((int)sales[i]).append("개)<br>");
                data.add(new Slice(FRUIT_NAMES[i], sales[i], percentage));
            }
            resultText.append("</html>");

            // 3. 차트 패널 갱신
            chartPanel.setData(data, resultText.toString());
        } else {
             // 총 판매량이 0이거나 음수인 경우
             chartPanel.setData(new Vector<>(), "<html>총 판매량이 0이거나 유효하지 않습니다. 판매량을 입력하세요.</html>");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SalesPieChartApp::new);
    }

    /**
     * 파이 차트의 각 조각(Slice) 정보를 저장하는 내부 클래스
     */
    class Slice { // private 대신 default 접근 지정자로 변경 (컴파일 오류 방지)
        String name;
        double value;
        double percentage;
        Color color;

        // 파이 차트 조각에 사용할 색상 (미리 정의)
        private final Color[] COLORS = {Color.RED, Color.ORANGE, Color.GREEN, Color.BLUE}; // 색상 조정

        public Slice(String name, double value, double percentage) {
            this.name = name;
            this.value = value;
            this.percentage = percentage;
            // 과일 이름 배열 순서에 따라 색상 할당
            int index = -1;
            for (int i = 0; i < FRUIT_NAMES.length; i++) {
                if (FRUIT_NAMES[i].equals(name)) {
                    index = i;
                    break;
                }
            }
            this.color = COLORS[index % COLORS.length]; // 인덱스 활용
        }
    }

    /**
     * 파이 차트와 백분율 텍스트를 그리는 패널
     */
    private class PieChartPanel extends JPanel {
        private Vector<Slice> data = new Vector<>();
        private String resultText = "<html>판매량을 입력하고 Enter를 누르세요.</html>";
        private JLabel resultLabel; // HTML 텍스트를 표시할 JLabel

        public PieChartPanel() {
            setLayout(new BorderLayout()); // 내부 레이아웃 설정
            setBackground(Color.WHITE); // 배경색 지정 (선택 사항)

            resultLabel = new JLabel(resultText);
            resultLabel.setHorizontalAlignment(JLabel.CENTER); // 텍스트 중앙 정렬
            resultLabel.setVerticalAlignment(JLabel.TOP); // 상단 정렬
            resultLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 여백 추가
            add(resultLabel, BorderLayout.EAST); // 차트 오른쪽에 텍스트 표시

            // 초기 파이 차트가 그려질 공간을 위해 컴포넌트 추가하지 않음
        }

        // 완성된 setData 메서드
        public void setData(Vector<Slice> data, String newResultText) {
            this.data = data;
            this.resultText = newResultText;
            resultLabel.setText(resultText); // JLabel의 텍스트 업데이트
            repaint(); // 파이 차트 다시 그리기
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // 안티앨리어싱 적용

            // 차트 영역 계산 (resultLabel이 차지하는 공간 제외)
            int chartWidth = getWidth() - (resultLabel.isVisible() ? resultLabel.getWidth() : 0);
            int chartHeight = getHeight();
            int diameter = Math.min(chartWidth, chartHeight) * 3 / 4; // 패널 크기의 3/4를 지름으로 사용
            int x = (chartWidth - diameter) / 2;
            int y = (chartHeight - diameter) / 2;

            if (data.isEmpty() || chartWidth <= 0 || chartHeight <= 0) {
                // 데이터가 없거나 패널 크기가 유효하지 않으면 파이 차트 그리지 않음
                return;
            }

            // 파이 차트 그리기
            double currentAngle = 0; // 시작 각도
            for (Slice slice : data) {
                int arcAngle = (int) Math.round(slice.percentage * 3.6); // 360도 기준 각도 계산
                g2d.setColor(slice.color);
                g2d.fillArc(x, y, diameter, diameter, (int) currentAngle, arcAngle);
                
                // 각 슬라이스 테두리 그리기 (선택 사항)
                g2d.setColor(Color.BLACK);
                g2d.drawArc(x, y, diameter, diameter, (int) currentAngle, arcAngle);

                currentAngle += arcAngle;
            }

            // 남은 각도 채우기 (정수 반올림 오차 보정)
            if (Math.round(currentAngle) < 360) {
                 g2d.setColor(data.lastElement().color); // 마지막 조각 색상으로 채움
                 g2d.fillArc(x, y, diameter, diameter, (int) currentAngle, 360 - (int) currentAngle);
            }
        }
    }
}