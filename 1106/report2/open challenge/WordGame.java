package report_20251106_2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class WordGame extends JFrame {
    private JPanel northPanel;
    private JPanel centerPanel;
    private JPanel southPanel;
    private JLabel titleLabel;
    private JButton newTextButton;
    private JTextField nameField;
    private JLabel nameLabel;

    // 원문 문장
    private final String text = "I can't help falling in love with you";
    private String[] words;
    private final Random rand = new Random();

    // CENTER 내 단어들을 관리할 배열
    private JLabel[] wordLabels;

    public WordGame() {
        super("Open Challenge 9");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // 화면 가운데

        // BorderLayout을 가진 contentPane 설정
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // NORTH 패널
        northPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titleLabel = new JLabel("단어 조합 게임! 순서대로 단어를 클릭하세요~~");
        newTextButton = new JButton("New Text");
        newTextButton.addActionListener(e -> placeWordsRandomly());
        northPanel.add(titleLabel);
        northPanel.add(newTextButton);
        cp.add(northPanel, BorderLayout.NORTH);

        // CENTER 패널: 절대 위치를 위해 null 레이아웃 사용
        centerPanel = new JPanel(null) {
            // 패널 최소크기 강제 (보이기를 더 안정적으로)
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(400, 220);
            }
        };
        centerPanel.setBackground(Color.WHITE);
        cp.add(centerPanel, BorderLayout.CENTER);

        // SOUTH 패널
        southPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        southPanel.setBackground(Color.YELLOW); // 사진의 예시처럼 노란색 영역
        nameLabel = new JLabel("이름");
        nameField = new JTextField(18);
        southPanel.add(nameLabel);
        southPanel.add(nameField);
        cp.add(southPanel, BorderLayout.SOUTH);

        // 단어 분리
        words = text.split(" ");
        createWordLabels();
        placeWordsRandomly(); // 초기 배치

        // 프레임 표시
        pack(); // preferred sizes 바탕으로 크기 조정 (우리는 이미 setSize 했으므로 pack 후 setSize 해도 무방)
        setSize(400, 300); // 요구사항 프레임 크기 고정
        setVisible(true);
    }

    // 단어 라벨들 생성 (한 번만)
    private void createWordLabels() {
        wordLabels = new JLabel[words.length];
        for (int i = 0; i < words.length; i++) {
            JLabel lbl = new JLabel(words[i]);
            lbl.setFont(lbl.getFont().deriveFont(Font.BOLD, 12f));
            lbl.setOpaque(false);
            // 마우스 클릭 시 회색으로 바꾸고 비활성화하는 간단한 동작 추가 (GUI 효과)
            lbl.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JLabel source = (JLabel) e.getSource();
                    source.setForeground(Color.GRAY);
                    source.setEnabled(false);
                    // 선택된 단어를 titleLabel 뒤에 붙여 표시 (디버그/시연용)
                    titleLabel.setText(titleLabel.getText() + " " + source.getText());
                }
            });
            wordLabels[i] = lbl;
            centerPanel.add(lbl);
        }
    }

    // 단어들을 랜덤 위치에 배치 (x:0~350, y:0~180 범위 준수)
    private void placeWordsRandomly() {
        // 먼저 모든 라벨을 활성화하고 컬러 초기화
        for (JLabel lbl : wordLabels) {
            lbl.setEnabled(true);
            lbl.setForeground(Color.BLACK);
        }
        // 초기 제목 복원(혹시 선택된 문구가 붙어있다면 리셋)
        titleLabel.setText("단어 조합 게임!!!..");

        for (JLabel lbl : wordLabels) {
            // 라벨 크기 계산을 위해 임시로 사이즈 지정 후 getPreferredSize 사용
            Dimension pref = lbl.getPreferredSize();
            int w = pref.width;
            int h = pref.height;

            // x 범위 0~350, y 범위 0~180 (문제조건)
            // 단, 라벨이 패널 밖으로 거의 벗어나지 않게 보정 (옵션)
            int maxX = 350;
            int maxY = 180;
            int x = rand.nextInt(Math.max(1, maxX + 1));
            int y = rand.nextInt(Math.max(1, maxY + 1));

            // 보정: 라벨의 우측/하단이 너무 밖으로 나가면 약간 조정 (보여주기용)
            if (x + w > 380) { // 프레임 가로(400) 여백 고려
                x = Math.max(0, 380 - w);
            }
            if (y + h > 220) { // CENTER 패널 높이 가늠
                y = Math.max(0, 220 - h);
            }

            lbl.setBounds(x, y, w, h);
            lbl.repaint();
        }
        centerPanel.revalidate();
        centerPanel.repaint();
    }

    public static void main(String[] args) {
        // Swing은 EDT에서 실행
        SwingUtilities.invokeLater(() -> new WordGame());
    }
}
