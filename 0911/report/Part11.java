package kimhoon;

import java.util.Scanner;

public class Part11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사용자 입력
        System.out.print("냉장고 상태 입력>>> ");
        String input = sc.next(); // 예: "00001101"

        // 2진수 문자열 → 정수 변환
        int status = Integer.parseInt(input, 2);

        // 하위 4비트만 추출
        int lower4 = status & 0b1111;

        // 비트별 상태 확인
        int power = lower4 & 1;          // 비트0 (전원)
        int door = (lower4 >> 1) & 1;    // 비트1 (문)
        int lamp = (lower4 >> 2) & 1;    // 비트2 (전구)
        int temp = (lower4 >> 3) & 1;    // 비트3 (냉장고 온도)

        // 결과 출력
        System.out.print("전원 " + (power == 1 ? "켜져 있음. " : "꺼져 있음. "));
        System.out.print("문 " + (door == 1 ? "닫혀 있음. " : "열려 있음. "));
        System.out.print("전구 " + (lamp == 1 ? "정상 작동. " : "손상됨. "));
        System.out.println("냉장고 온도 " + (temp == 1 ? "3도 미만." : "3도 이상."));

        sc.close();
    }
}
