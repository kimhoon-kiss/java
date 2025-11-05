package kimhn_report4_20251105;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calendar calendar = Calendar.getInstance();

        while (true) {
            System.out.print("년도 입력(-1이면 종료)>>");
            int year = scanner.nextInt();

            if (year == -1)
                break;

            for (int month = 0; month < 12; month++) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, 1);

                // 1일의 요일 (1: 일요일, 2: 월요일, ..., 7: 토요일)
                int startDay = calendar.get(Calendar.DAY_OF_WEEK);

                // 해당 달의 마지막 날짜
                int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

                System.out.println();
                System.out.println(year + "년 " + (month + 1) + "월");
                System.out.println("일월화수목금토");

                // 1일 전까지 공백 출력
                for (int i = 1; i < startDay; i++) {
                    System.out.print("   ");
                }

                // 날짜 출력
                for (int day = 1; day <= lastDay; day++) {
                    System.out.printf("%2d ", day);
                    if ((day + startDay - 1) % 7 == 0)
                        System.out.println();
                }
                System.out.println("\n");
            }
        }

        scanner.close();
    }
}
