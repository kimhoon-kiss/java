package report_20251106;

import java.util.*;

public class SumPositives {
    private Vector<Integer> v = new Vector<Integer>(); // 멤버 변수

    // 정수 입력 (-1 대신 0이면 입력 종료)
    public void read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("0이 입력될 때까지 정수 입력>>");
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            v.add(n);
        }
    }

    // 벡터에 있는 음수들을 모두 0으로 변경
    public void changeToZero() {
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i) < 0)
                v.set(i, 0);
        }
    }

    // 벡터의 모든 원소 출력
    public void showAll() {
        for (int i = 0; i < v.size(); i++) {
            System.out.print(v.get(i) + " ");
        }
        System.out.println();
    }

    // 벡터의 양수들의 합 계산
    public int add() {
        int sum = 0;
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i) > 0)
                sum += v.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        SumPositives sp = new SumPositives();
        sp.read(); // 정수들을 입력받아 벡터 v에 저장
        sp.changeToZero(); // 벡터 v의 음수들을 모두 0으로 변경
        System.out.print("음수를 0으로 바꾸면 ");
        sp.showAll(); // 벡터의 모든 원소 출력
        System.out.println("양수들의 합은 " + sp.add()); // 양수들의 합 출력
    }
}
