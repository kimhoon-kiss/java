package kimhoon_report3_20251002;
import java.util.Scanner;
import java.util.Random;

public class MGPApp {
    public static void main(String[] args) {
        new Game().run();
    }
}

abstract class Player {
    protected String bet[] = { "묵", "찌", "빠" }; // 가위, 바위, 보
    protected String name;
    protected String lastBet = null;

    protected Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getBet() {
        return lastBet;
    }

    abstract public String next(); // 다음 낼 것 반환
}

class Human extends Player {
    private Scanner scanner = new Scanner(System.in);

    public Human(String name) {
        super(name);
    }

    @Override
    public String next() {
        while (true) {
            System.out.print(name + ">> 묵, 찌, 빠 중 하나를 입력하세요: ");
            String input = scanner.nextLine().trim();
            for (String b : bet) {
                if (b.equals(input)) {
                    lastBet = input;
                    return input;
                }
            }
            System.out.println("잘못된 입력입니다. 묵, 찌, 빠 중에서 다시 입력하세요.");
        }
    }
}

class Computer extends Player {
    private Random random = new Random();

    public Computer(String name) {
        super(name);
    }

    @Override
    public String next() {
        int idx = random.nextInt(bet.length);
        lastBet = bet[idx];
        System.out.println(name + ">> 결정하였습니다: " + lastBet);
        return lastBet;
    }
}

class Game {
    private Player human;
    private Player ai;
    private Player owner; // 현재 오너

    public Game() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("사람 이름 입력 >> ");
        String humanName = scanner.nextLine().trim();

        System.out.print("컴퓨터 이름 입력 >> ");
        String aiName = scanner.nextLine().trim();

        human = new Human(humanName);
        ai = new Computer(aiName);

        System.out.println("2명의 선수를 생성 완료하였습니다.");
        owner = human;  // 사람이 먼저 오너가 됨
        System.out.println(owner.getName() + "가 먼저 오너가 되어 시작합니다.");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n오너는 " + owner.getName() + " 입니다.");

            // 오너가 낸 수
            String ownerChoice = owner.next();

            // 상대가 낸 수
            Player other = (owner == human) ? ai : human;
            String otherChoice = other.next();

            System.out.println(owner.getName() + " : " + ownerChoice + ", " + other.getName() + " : " + otherChoice);

            // 두 사람이 낸 수가 같은 경우
            if (ownerChoice.equals(otherChoice)) {
                System.out.println(owner.getName() + "가 이겼습니다.");
                System.out.println("게임을 종료합니다.");
                break;
            }

            // 이긴 사람이 오너가 됨
            if (isFirstWin(ownerChoice, otherChoice)) {
                System.out.println("오너는 계속 " + owner.getName() + "입니다.");
            } else {
                owner = other;
                System.out.println("오너가 " + owner.getName() + "로 변경되었습니다.");
            }
        }
    }

    // 가위바위보 승리 판단 (첫 번째가 이겼으면 true)
    private boolean isFirstWin(String first, String second) {
        return (first.equals("묵") && second.equals("빠")) ||
               (first.equals("찌") && second.equals("묵")) ||
               (first.equals("빠") && second.equals("찌"));
    }
}