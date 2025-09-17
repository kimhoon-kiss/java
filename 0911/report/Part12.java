package kimhoon;

import java.util.Scanner;

public class Part12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 사용자 입력
        System.out.print("자동차 상태 입력>> ");
        int status = scanner.nextInt(); // 예: 139

        // 비트 연산
        int temperature = status & 0b00111111; // 하위 6비트 -> 온도
        boolean aircon = (status & 0b01000000) != 0; // 비트6 -> 에어컨
        boolean running = (status & 0b10000000) != 0; // 비트7 -> 자동차 달림

        // 자동차 달리는 상태 / 정지 상태
        if (running) {
            System.out.print("자동차는 달리는 상태이고 ");
        } else {
            System.out.print("자동차는 정지 상태이고 ");
        }

        // 에어컨 상태
        if (aircon) {
            System.out.print("에어컨이 켜진 상태이고 ");
        } else {
            System.out.print("에어컨이 꺼진 상태이고 ");
        }

        // 온도 출력
        System.out.println("온도는 " + temperature + "도이다.");

        scanner.close();
    }
}
