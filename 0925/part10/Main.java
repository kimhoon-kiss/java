package kimhoon_report2_20250925;
import java.util.Scanner;

class DayDiary {
    private String memo;

    public DayDiary() {
        this.memo = null;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getMemo() {
        return memo;
    }
}

class MonthDiary {
    private int year;
    private int month;
    private DayDiary[] days; // 30일치 메모 배열
    private final int DAYS_IN_MONTH = 30;
    private Scanner scanner;

    public MonthDiary(int year, int month) {
        this.year = year;
        this.month = month;
        this.days = new DayDiary[DAYS_IN_MONTH];
        for (int i = 0; i < DAYS_IN_MONTH; i++) {
            days[i] = new DayDiary();
        }
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.printf("*****%d년 %d월 다이어리*****%n", year, month);
        while (true) {
            System.out.print("기록:1, 보기:2, 종료:3>> ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1":
                    write();
                    break;
                case "2":
                    show();
                    break;
                case "3":
                    System.out.println("프로그램을 종료합니다");
                    return;
                default:
                    // 잘못된 입력 시 아무 출력 없이 다시 메뉴로
                    break;
            }
        }
    }

    private void write() {
        System.out.print("날짜(1~30)와 텍스트(빈칸없이 4글자 이하)>> ");
        String line = scanner.nextLine().trim();
        String[] parts = line.split(" ");

        if (parts.length != 2) {
            // 입력 형태가 잘못되면 아무 메시지 없이 돌아감
            return;
        }

        int day;
        try {
            day = Integer.parseInt(parts[0]);
        } catch (NumberFormatException e) {
            return;
        }

        if (day < 1 || day > DAYS_IN_MONTH) {
            return;
        }

        String memo = parts[1];
        if (memo.length() > 4 || memo.contains(" ")) {
            return;
        }

        days[day - 1].setMemo(memo);
    }

    private void show() {
        final int DAYS_PER_WEEK = 7;
        for (int i = 0; i < DAYS_IN_MONTH; i++) {
            String memo = days[i].getMemo();
            if (memo == null) {
                System.out.print("...     \t");
            } else {
                System.out.print(memo + "     \t");
            }
            if ((i + 1) % DAYS_PER_WEEK == 0) {
                System.out.println();
            }
        }
        if (DAYS_IN_MONTH % DAYS_PER_WEEK != 0) {
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MonthDiary monthDiary = new MonthDiary(2024, 10);
        monthDiary.run();
    }
}