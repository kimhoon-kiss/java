package kimhn_report4_20251105;

class Student {
    private String name;
    private int id;

    // 생성자
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // toString() 재정의
    @Override
    public String toString() {
        return "학번이 " + id + "인 " + name;
    }

    // equals() 재정의
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student other = (Student) obj;
        // 이름과 id가 모두 같을 때 같은 학생으로 판단
        return this.name.equals(other.name) && this.id == other.id;
    }
}

public class StudentApp {
    public static void main(String[] args) {
        Student a = new Student("황기태", 23); // id가 23인 황기태 학생
        Student b = new Student("황기태", 77); // id가 77인 황기태 학생

        System.out.println(a);

        if (a.equals(b))
            System.out.println("같은 학생입니다.");
        else
            System.out.println("다른 학생입니다.");
    }
}
