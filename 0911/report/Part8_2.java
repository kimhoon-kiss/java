package kimhoon;

import java.util.Scanner;

public class Part8_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("연산 입력>>> ");
        double num1 = sc.nextDouble();   // 첫 번째 실수 입력
        String op = sc.next();           // 연산자 입력
        double num2 = sc.nextDouble();   // 두 번째 실수 입력

        double result;  // 결과 저장용 변수

        switch (op) {
            case "더하기":
                result = num1 + num2;
                System.out.printf("%.1f%s %.1f의 계산 결과는 %.1f%n", num1, op, num2, result);
                break;

            case "빼기":
                result = num1 - num2;
                System.out.printf("%.1f%s %.1f의 계산 결과는 %.1f%n", num1, op, num2, result);
                break;

            case "곱하기":
                result = num1 * num2;
                System.out.printf("%.1f%s %.1f의 계산 결과는 %.1f%n", num1, op, num2, result);
                break;

            case "나누기":
                if (num2 == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                } else {
                    result = num1 / num2;
                    System.out.printf("%.1f%s %.1f의 계산 결과는 %.1f%n", num1, op, num2, result);
                }
                break;

            default:
                System.out.println("사칙연산이 아닙니다.");
        }

        sc.close();
    }
}
