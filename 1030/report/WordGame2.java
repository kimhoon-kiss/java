package kimhn_report4_20251105;

import java.util.*;

public class WordGame2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String[] words = {"happy", "morning", "package", "together", "lovely", "sunny", "extract", "nation", "cookie", "connect"};

        System.out.println("10초 안에 단어를 맞추세요!!");

        while (true) {
            String answer = words[rand.nextInt(words.length)];
            String quiz = shuffleWord(answer, rand);

            System.out.println(quiz);

            long start = System.currentTimeMillis();  // 시작 시간

            System.out.print(">>");
            String input = sc.nextLine();

            long end = System.currentTimeMillis();    // 종료 시간
            double elapsed = (end - start) / 1000.0;  // 경과 시간 (초 단위)

            if (input.equals("그만")) break;

            if (elapsed > 10.0) {
                System.out.printf("실패!!! 10초 초과, %.3f초 경과%n", elapsed);
            } else if (input.equals(answer)) {
                System.out.printf("성공!!! %.3f초 경과%n", elapsed);
            } else {
                System.out.printf("실패!!! %s 입니다. %.3f초 경과%n", answer, elapsed);
            }
        }

        sc.close();
    }

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
