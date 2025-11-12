package report_20251106;

import java.util.*;

class Student {
    private String name;
    private String major;
    private int id;
    private double grade;

    public Student(String name, String major, int id, double grade) {
        this.name = name;
        this.major = major;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public int getId() {
        return id;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return name + ", " + major + ", " + id + ", " + grade;
    }
}

public class StudentVectorExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Student> students = new Vector<>();

        System.out.println("4명 이름, 전공, 학번, 학점 입력");
        for (int i = 0; i < 4; i++) {
            System.out.print(">> ");
            String input = scanner.nextLine();
            String[] parts = input.split(",\\s*");
            String name = parts[0];
            String major = parts[1];
            int id = Integer.parseInt(parts[2]);
            double grade = Double.parseDouble(parts[3]);
            students.add(new Student(name, major, id, grade));
        }

        System.out.println("--------------------------------------------------------------");

        // 모든 학생 정보 출력
        for (Student s : students) {
            System.out.println("이름: " + s.getName());
        }
        System.out.println();
        for (Student s : students) {
            System.out.println("전공: " + s.getMajor());
        }
        System.out.println();
        for (Student s : students) {
            System.out.println("학번: " + s.getId());
            System.out.println("학점평균: " + s.getGrade());
        }

        System.out.println("--------------------------------------------------------------");

        // 장학생 선발
        System.out.print("장학생: ");
        for (Student s : students) {
            if (s.getGrade() >= 4.0) { // 예시엔 4.8이라 되어 있지만, 4.0으로 수정 가능
                System.out.print(s.getName() + " ");
            }
        }
        System.out.println();
        System.out.println("--------------------------------------------------------------");

        // 학생 검색
        while (true) {
            System.out.print("학생 이름 >> ");
            String name = scanner.nextLine();
            if (name.equals("그만"))
                break;

            boolean found = false;
            for (Student s : students) {
                if (s.getName().equals(name)) {
                    System.out.println(s);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println(name + " 학생이 없습니다.");
            }
        }

        scanner.close();
    }
}
