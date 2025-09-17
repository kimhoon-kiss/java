package kimhoon;

import java.util.Scanner;

public class Part10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 기준 사각형의 두 점
        int baseX1 = 10, baseY1 = 10;
        int baseX2 = 200, baseY2 = 300;

        // 사용자 입력
        System.out.print("(x1, y1), (x2, y2)의 좌표 입력>>> ");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        // 입력한 두 점 중 작은 값과 큰 값으로 정리
        int minX = Math.min(x1, x2);
        int maxX = Math.max(x1, x2);
        int minY = Math.min(y1, y2);
        int maxY = Math.max(y1, y2);

        // 포함 판별
        if (minX >= baseX1 && minY >= baseY1 && maxX <= baseX2 && maxY <= baseY2) {
            System.out.printf("(%d,%d) (%d,%d) 사각형은 (%d,%d) (%d,%d) 사각형에 포함된다.%n",
                    x1, y1, x2, y2, baseX1, baseY1, baseX2, baseY2);
        } else {
            System.out.printf("(%d,%d) (%d,%d) 사각형은 (%d,%d) (%d,%d) 사각형에 포함되지 않는다.%n",
                    x1, y1, x2, y2, baseX1, baseY1, baseX2, baseY2);
        }

        sc.close();
    }
}
