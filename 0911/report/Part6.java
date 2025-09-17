package kimhoon;

import java.util.Scanner;
public class Part6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 나이 입력
        System.out.print("나이를 입력하세요>>> ");
        int age = sc.nextInt();

        // 나이 검증
        if (age <= 0) {
            System.out.println("나이는 양수로만 입력하세요.");
            sc.close();
            return; // 프로그램 종료
        }

        // 빨간 초 (10살)
        int red = age / 10;   // 10으로 나눈 몫
        int remainder = age % 10; // 나머지

        // 파란 초 (5살)
        int blue = remainder / 5;
        remainder = remainder % 5;

        // 노란 초 (1살)
        int yellow = remainder; // 남은 값은 그대로 노란 초 개수

        // 총 개수
        int total = red + blue + yellow;

        // 결과 출력
        System.out.println("빨간 초 " + red + "개, 파란 초 " + blue + "개, 노란 초 " + yellow + "개. 총 " + total + "개가 필요합니다");

        sc.close();
    }
}
