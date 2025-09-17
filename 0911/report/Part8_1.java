package kimhoon;

import java.util.Scanner;

public class Part8_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("연산 입력>>> ");
        double num1 = sc.nextDouble();   // 첫 번째 실수 입력
        String op = sc.next();           // 연산자 입력
        double num2 = sc.nextDouble();   // 두 번째 실수 입력

        double result;  // 결과 저장용 변수

        if (op.equals("더하기")) { // op가 "더하기"인지 검사
            result = num1 + num2;
            System.out.printf("%.1f%s %.1f의 계산 결과는 %.1f%n", num1, op, num2, result);

        } else if (op.equals("빼기")) { // op가 "빼기"인지 검사
            result = num1 - num2;
            System.out.printf("%.1f%s %.1f의 계산 결과는 %.1f%n", num1, op, num2, result);

        } else if (op.equals("곱하기")) { // op가 "곱하기"인지 검사
            result = num1 * num2;
            System.out.printf("%.1f%s %.1f의 계산 결과는 %.1f%n", num1, op, num2, result);

        } else if (op.equals("나누기")) { // op가 "나누기"인지 검사
            if (num2 == 0) {
                System.out.println("0으로 나눌 수 없습니다.");
            } else {
                result = num1 / num2;
                System.out.printf("%.1f%s %.1f의 계산 결과는 %.1f%n", num1, op, num2, result);
            }

        } else { // 지정된 4가지 연산자가 아닌 경우
            System.out.println("사칙연산이 아닙니다.");
        }

        sc.close();
    }
}
