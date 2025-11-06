package kimhn_report4_20251105;

import java.util.Scanner;

public class GradeAverageSplit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("여러 과목의 학점을 빈 칸으로 분리 입력>>");
            String line = scanner.nextLine();

            if (line.equalsIgnoreCase("그만"))
                break;

            String[] grades = line.split(""); // 한 글자씩 분리
            double sum = 0;
            int count = 0;
            boolean error = false;

            for (String g : grades) {
                g = g.toUpperCase(); // 대소문자 구분 안 함
                int score = 0;

                switch (g) {
                    case "A": score = 100; break;
                    case "B": score = 90; break;
                    case "C": score = 80; break;
                    case "D": score = 70; break;
                    case "F": score = 0; break;
                    default:
                        System.out.println("입력 오류: " + g);
                        error = true;
                }

                if (error) break;
                sum += score;
                count++;
            }

            if (!error && count > 0)
                System.out.println("평균은 " + (sum / count));
        }

        scanner.close();
    }
}
