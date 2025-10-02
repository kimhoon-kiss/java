package kimhoon_report2_20250925;
import java.util.Scanner;

public class Grade {
    private String name;
    private int java;
    private int web;
    private int os;

    // 생성자: 이름과 세 과목 점수 받음
    public Grade(String name, int java, int web, int os) {
        this.name = name;
        this.java = java;
        this.web = web;
        this.os = os;
    }

    // 이름 반환 메서드
    public String getName() {
        return name;
    }

    // 평균 점수 계산 후 반환 메서드
    public int getAverage() {
        return (java + web + os) / 3;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("이름, 자바, 웹프로그래밍, 운영체제 순으로 점수 입력>>");
        String name = scanner.next();
        int java = scanner.nextInt();
        int web = scanner.nextInt();
        int os = scanner.nextInt();

        Grade st = new Grade(name, java, web, os);

        System.out.println(st.getName() + "의 평균은 " + st.getAverage());

        scanner.close();
    }
}