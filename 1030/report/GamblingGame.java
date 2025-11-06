package kimhn_report4_20251105;

import java.util.*;

class Player {
    String name;
    Random rand = new Random();

    Player(String name) {
        this.name = name;
    }

    // 한 번 플레이하는 함수 (Enter 입력 기다리고 결과 리턴)
    boolean play(Scanner sc) {
        System.out.print("[" + name + "]: <Enter>");
        sc.nextLine(); // 엔터 입력 대기

        int n1 = rand.nextInt(3) + 1;
        int n2 = rand.nextInt(3) + 1;
        int n3 = rand.nextInt(3) + 1;

        System.out.println(n1 + " " + n2 + " " + n3);

        if (n1 == n2 && n2 == n3) {
            System.out.println(name + "님이 이겼습니다!");
            return true;
        } else {
            System.out.println("아쉽군요!");
            return false;
        }
    }
}

public class GamblingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("갬블링 게임에 참여할 선수 숫자>>");
        int n = sc.nextInt();
        sc.nextLine(); // 개행 제거

        Player[] players = new Player[n];
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + "번째 선수 이름>>");
            String name = sc.nextLine();
            players[i] = new Player(name);
        }

        boolean winner = false;

        while (!winner) {
            for (int i = 0; i < n; i++) {
                if (players[i].play(sc)) {
                    winner = true;
                    break;
                }
            }
        }

        sc.close();
    }
}
