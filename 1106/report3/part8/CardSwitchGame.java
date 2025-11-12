package report_20251106_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CardSwitchGame extends JFrame {
    private JLabel[] cards = new JLabel[12];
    private JLabel firstSelected = null; // 첫 번째 선택된 카드
    private JLabel secondSelected = null; // 두 번째 선택된 카드

    public CardSwitchGame() {
        setTitle("카드 스위치 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLayout(new GridLayout(3, 4, 10, 10)); // 3행 4열로 카드 배치

        // 카드 생성 및 초기 설정
        for (int i = 0; i < cards.length; i++) {
            cards[i] = new JLabel(Integer.toString(i + 1), SwingConstants.CENTER);
            cards[i].setOpaque(true);
            cards[i].setBackground(Color.YELLOW);
            cards[i].setFont(new Font("맑은 고딕", Font.BOLD, 24));
            cards[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

            // 카드 클릭 리스너 등록
            cards[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    handleCardClick((JLabel) e.getSource());
                }
            });

            add(cards[i]);
        }

        setVisible(true);
    }

    // 카드 클릭 처리 로직
    private void handleCardClick(JLabel clickedCard) {
        // 첫 번째 선택
        if (firstSelected == null) {
            firstSelected = clickedCard;
            firstSelected.setBackground(new Color(180, 130, 255)); // 보라색 계열로 표시
            return;
        }

        // 두 번째 선택 (같은 카드를 두 번 누르면 무시)
        if (clickedCard == firstSelected) return;

        secondSelected = clickedCard;
        secondSelected.setBackground(new Color(180, 130, 255));

        // 숫자 교환
        String temp = firstSelected.getText();
        firstSelected.setText(secondSelected.getText());
        secondSelected.setText(temp);

        // 색상 원래대로 복원
        firstSelected.setBackground(Color.YELLOW);
        secondSelected.setBackground(Color.YELLOW);

        // 선택 초기화
        firstSelected = null;
        secondSelected = null;
    }

    public static void main(String[] args) {
        new CardSwitchGame();
    }
}
