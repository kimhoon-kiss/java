package kimhoon;

import java.util.Scanner;

public class Part9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사각형을 정의하는 두 점
        int x1 = 10, y1 = 10;       // 왼쪽 아래 점
        int x2 = 200, y2 = 300;     // 오른쪽 위 점

        // 사용자 입력
        System.out.print("점(x,y)의 좌표 입력>>> ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        // 판별
        if (x > x1 && x < x2 && y > y1 && y < y2) {
            // 내부
            System.out.printf("(%d,%d)는 사각형 안에 있습니다.%n", x, y);

        } else if ((x == x1 || x == x2) && (y >= y1 && y <= y2)
                || (y == y1 || y == y2) && (x >= x1 && x <= x2)) {
            // 경계선 위
            System.out.printf("(%d,%d)는 사각형 선 상에 있습니다.%n", x, y);

        } else {
            // 외부
            System.out.printf("(%d,%d)는 사각형 밖에 있습니다.%n", x, y);
        }

        sc.close();
    }
}
