package kimhoon;

import java.util.Scanner;

public class Part7_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        System.out.print("월을 입력하세요(1~12)>>> ");
        int month = sc.nextInt();

        // 조건문
        if (month >= 3 && month <= 5) {
            System.out.println("따뜻한 봄");
        } else if (month >= 6 && month <= 8) {
            System.out.println("바다가 즐거운 여름");
        } else if (month >= 9 && month <= 11) {
            System.out.println("낙엽이 지는 아름다운 가을");
        } else if (month == 12 || month == 1 || month == 2) {
            System.out.println("눈 내리는 하얀 겨울");
        } else {
            System.out.println("1~12만 입력하세요");
        }

        sc.close();
    }
}
