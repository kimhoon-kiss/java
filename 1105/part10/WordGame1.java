package kimhn_report4_20251105;

import java.util.*;

public class WordGame1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String[] words = {"happy", "morning", "package", "together", "lovely", "sunny", "extract", "nation", "cookie", "connect"};

        System.out.println("10초 안에 단어를 맞추세요!!");

        while (true) {
            // 1. 랜덤 단어 선택
            String answer = words[rand.nextInt(words.length)];

            // 2. 단어를 섞기
            String quiz = shuffleWord(answer, rand);

            // 3. 문제 출력
            System.out.println(quiz);

            // 4. 사용자 입력
            System.out.print(">>");
            String input = sc.nextLine();

            if (input.equals("그만")) break;

            // 5. 정답 확인
            if (input.equals(answer))
                System.out.println("성공!!!");
            else
                System.out.println("실패!!! " + answer + " 입니다.");
        }

        sc.close();
    }

    // 단어를 섞는 함수
    static String shuffleWord(String word, Random rand) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < 20; i++) {
            int a = rand.nextInt(chars.length);
            int b = rand.nextInt(chars.length);
            char temp = chars[a];
            chars[a] = chars[b];
            chars[b] = temp;
        }
        return new String(chars);
    }
}
