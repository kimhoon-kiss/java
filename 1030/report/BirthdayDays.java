package kimhn_report4_20251105;

import java.util.Calendar;
import java.util.Scanner;

public class BirthdayDays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calendar today = Calendar.getInstance();

        System.out.printf("오늘은 %d년 %d월 %d일%n",
                today.get(Calendar.YEAR),
                today.get(Calendar.MONTH) + 1,
                today.get(Calendar.DAY_OF_MONTH));

        while (true) {
            System.out.print("생일 입력(년 월 일)>>");
            String line = scanner.nextLine().trim();

            if (line.equals("그만"))
                break;

            // 입력값 파싱
            String[] parts = line.split("\\s+");
            if (parts.length != 3) {
                System.out.println("입력 형식이 잘못되었습니다. 예: 2000 1 15");
                continue;
            }

            int y = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            int d = Integer.parseInt(parts[2]);

            Calendar birth = Calendar.getInstance();
            birth.set(y, m - 1, d, 0, 0, 0);
            birth.set(Calendar.MILLISECOND, 0);

            // 오늘 날짜와 비교
            long diffMillis = today.getTimeInMillis() - birth.getTimeInMillis();
            long days = diffMillis / (1000 * 60 * 60 * 24);

            if (days > 0) {
                System.out.printf("오늘까지 %d일 살아왔습니다.%n", days);
            } else if (days == 0) {
                System.out.println("오늘이 생일입니다!");
            } else {
                System.out.printf("%d일 더 살아야 생일이 됩니다.%n", Math.abs(days));
            }
        }

        scanner.close();
    }
}
