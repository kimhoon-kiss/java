package report_20251106;

import java.util.*;

public class MinValueVector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector<Integer> v = new Vector<>();

        System.out.print("정수 입력(-1이면 입력 끝)>>");

        while (true) {
            int n = sc.nextInt();
            if (n == -1)  // -1 입력 시 종료
                break;
            v.add(n);
        }

        if (v.isEmpty()) {
            System.out.println("입력된 정수가 없습니다.");
            return;
        }

        int min = v.get(0);
        for (int i = 1; i < v.size(); i++) {
            if (v.get(i) < min)
                min = v.get(i);
        }

        System.out.println("제일 작은 수는 " + min);
        sc.close();
    }
}
