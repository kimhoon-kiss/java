package kimhoon_report1;

import java.util.Scanner;
import java.util.Random;

public class Openchallenge3{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Random r = new Random();

        String yesOrNo;  // 게임 반복 여부


        do {
            int hiddenNumber = r.nextInt(100); // 0~99 랜덤 숫자
            int low = 0;     // 최소 범위
            int high = 99;   // 최대 범위
            int count = 0; // 시도 횟수

            System.out.println("수를 결정하였습니다. 맞추어 보세요");
            System.out.println(low + "-" + high);

            // 한 게임 반복
            while (true) {
            	count++;
                System.out.print(count + ">> ");
                int guess = scn.nextInt();

                if (guess < hiddenNumber) {
                    System.out.println("더 높게");
                    low = guess;
                } else if (guess > hiddenNumber) {
                    System.out.println("더 낮게");
                    high = guess;
                } else {
                    System.out.println("맞았습니다");
                    break;
                }

                // 현재 범위 표시
                System.out.println(low + "-" + high);
            }

            // 게임 반복 여부 확인
            System.out.print("다시하시겠습니까(y/n)>> ");
            yesOrNo = scn.next();

        } while (!yesOrNo.equalsIgnoreCase("n")); // n 입력 시 종료

        scn.close();
    }
}
