package kimhoon_report2_20250925;

import java.util.Scanner;
import java.util.Random;

class Player {
    private String name;
    private int totalScore;

    public Player(String name) {
        this.name = name;
        this.totalScore = 0;
    }

    public void addScore(int point) {
        totalScore += point;
    }

    public int getScore() {
        return totalScore;
    }

    public String getName() {
        return name;
    }
}

public class GuessGame {
    private Player[] players;
    private int[] guesses;
    private int hiddenAnswer;
    private Random rand;
    private Scanner sc;

    public GuessGame(int playerCount) {
        players = new Player[playerCount];
        guesses = new int[playerCount];
        rand = new Random();
        sc = new Scanner(System.in);
        hiddenAnswer = rand.nextInt(100) + 1; // 1~100 랜덤 숫자
    }

    public void inputPlayers() {
        System.out.println("게임에 참여하는 선수 수 >> " + players.length);
        for (int i = 0; i < players.length; i++) {
            System.out.print("선수 이름>> ");
            String name = sc.nextLine();
            players[i] = new Player(name);
        }
    }

    public void runGame() {
        System.out.println("*** 예측 게임을 시작합니다. ***");
        boolean continueGame = true;
        while (continueGame) {
            System.out.println("1~100사이의 숫자가 결정되었습니다. 선수들은 맞추어 보세요.");

            // 모든 플레이어 예측 입력
            for (int i = 0; i < players.length; i++) {
                System.out.print(players[i].getName() + ">> ");
                guesses[i] = Integer.parseInt(sc.nextLine());
            }

            int minDiff = 100;
            // 각 선수와 정답 차이 계산
            for (int i = 0; i < players.length; i++) {
                int diff = Math.abs(hiddenAnswer - guesses[i]);
                if (diff < minDiff) {
                    minDiff = diff;
                }
            }

            // 가장 가까운 선수에게 1점 부여
            System.out.print("정답>> " + hiddenAnswer + "\n");
            System.out.print("정답에 가장 가까운 선수는 ");
            for (int i = 0; i < players.length; i++) {
                int diff = Math.abs(hiddenAnswer - guesses[i]);
                if (diff == minDiff) {
                    players[i].addScore(1);
                    System.out.print(players[i].getName() + " ");
                }
            }
            System.out.println("입니다. 점수 1점 확보!");

            // 계속 여부 확인
            System.out.print("계속하려면 yes 입력>> ");
            String ans = sc.nextLine();
            if (!ans.equalsIgnoreCase("yes")) {
                continueGame = false;
            } else {
                // 새로운 정답 생성
                hiddenAnswer = rand.nextInt(100) + 1;
            }
        }

        // 최종 결과 출력
        System.out.println("\n최종 점수 결과:");
        for (Player p : players) {
            System.out.println(p.getName() + ": " + p.getScore() + "점 ");
        }

        // 최소 점수를 가진 승자 찾기
        int minScore = players[0].getScore();
        for (Player p : players) {
            if (p.getScore() < minScore) {
                minScore = p.getScore();
            }
        }
        System.out.print("최종 승자는 ");
        for (Player p : players) {
            if (p.getScore() == minScore) {
                System.out.print(p.getName() + " ");
            }
        }

        System.out.println("입니다!");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("게임에 참가하는 선수 수>> ");
        int count = Integer.parseInt(sc.nextLine());
        GuessGame game = new GuessGame(count);
        game.inputPlayers();
        game.runGame();
        sc.close();
    }
}