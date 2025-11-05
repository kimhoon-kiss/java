package kimhn_report4_20251105;

import java.util.*;

public class WordPuzzle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        while (true) {
            System.out.print("단어>> ");
            String word = sc.nextLine();

            if (word.equals("그만"))
                break;

            char[][] board = new char[5][5];

            // 1. 방향 정하기 (0=가로, 1=세로, 2=대각선)
            int direction = rand.nextInt(3);

            // 2. 시작 위치 정하기
            int row = 0, col = 0;
            if (direction == 0) { // 가로
                row = rand.nextInt(5);
                col = rand.nextInt(6 - word.length());
            } else if (direction == 1) { // 세로
                row = rand.nextInt(6 - word.length());
                col = rand.nextInt(5);
            } else { // 대각선
                row = rand.nextInt(6 - word.length());
                col = rand.nextInt(6 - word.length());
            }

            // 3. 단어 삽입
            for (int i = 0; i < word.length(); i++) {
                if (direction == 0)
                    board[row][col + i] = word.charAt(i);
                else if (direction == 1)
                    board[row + i][col] = word.charAt(i);
                else
                    board[row + i][col + i] = word.charAt(i);
            }

            // 4. 나머지 칸을 랜덤 알파벳으로 채움
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (board[i][j] == '\0') { // 비어있는 칸이면
                        board[i][j] = (char) ('a' + rand.nextInt(26));
                    }
                }
            }

            // 5. 출력
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
        }

        sc.close();
    }
}
