package kimhn_report4_20251105;

import java.util.*;

class Player {
    String name;
    int favorite; // 좋아하는 숫자
    int count;    // 맞춘 개수

    public Player(String name) {
        this.name = name;
    }

    public void setFavorite(int num) {
        this.favorite = num;
    }

    public void setCount(int c) {
        this.count = c;
    }
}

public class NumberExpectationGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("게임에 참여할 선수들 이름>>");
        String line = sc.nextLine();
        String[] names = line.split(" ");

        // 선수 생성
        ArrayList<Player> players = new ArrayList<>();
        for (String n : names) {
            Player p = new Player(n);
            System.out.print("[" + p.name + "] 정수 선택(1~10)>>");
            int fav = Integer.parseInt(sc.nextLine());
            p.setFavorite(fav);
            players.add(p);
        }

        ArrayList<Player> losers = new ArrayList<>(players);

        // 패자가 한 명이 될 때까지 반복
        while (losers.size() > 1) {
            System.out.print("Enter키 입력>>");
            sc.nextLine();

            // 15개의 랜덤 숫자 생성
            int[] nums = new int[15];
            for (int i = 0; i < 15; i++) {
                nums[i] = rand.nextInt(10) + 1;
                System.out.print(nums[i] + " ");
            }
            System.out.println();

            // 각 플레이어의 맞춘 개수 세기
            int min = Integer.MAX_VALUE;
            for (Player p : losers) {
                int count = 0;
                for (int n : nums) {
                    if (n == p.favorite) count++;
                }
                p.setCount(count);
                System.out.println("[" + p.name + "] 맞춘 개수: " + p.count);
                if (count < min) min = count;
            }

            // 최소값을 가진 패자들 찾기
            ArrayList<Player> nextLosers = new ArrayList<>();
            for (Player p : losers) {
                if (p.count == min) nextLosers.add(p);
            }

            losers = nextLosers;

            // 중간결과 출력
            if (losers.size() > 1) {
                System.out.print("현재 패자들 : ");
                for (Player p : losers) {
                    System.out.print(p.name + " ");
                }
                System.out.println("\n");
            }
        }

        // 최종 패자 출력
        System.out.println("최종 패자는 " + losers.get(0).name + "입니다.");
        sc.close();
    }
}
