package kimhoon_report2_20250925;

public class Memo {
    private String name;    // 작성자 이름
    private String time;    // 메모 시각
    private String content; // 메모 내용

    // 생성자
    public Memo(String name, String time, String content) {
        this.name = name;
        this.time = time;
        this.content = content;
    }

    // 작성자 이름 리턴
    public String getName() {
        return name;
    }

    // 다른 Memo 객체와 작성자 이름이 같으면 true 리턴
    public boolean isSameName(Memo other) {
        return this.name.equals(other.name);
    }

    // 메모 정보 출력
    public void show() {
        System.out.println(name + ", " + time + " " + content);
    }

    // 메모 내용 길이 리턴
    public int length() {
        return content.length();
    }

    // main 메서드: 예시 실행 코드
    public static void main(String[] args) {
        Memo a = new Memo("유승연", "10:10", "자바 과제 있음");
        Memo b = new Memo("박채원", "10:15", "시카고로 어학 연수가요!");
        Memo c = new Memo("김경미", "11:30", "사랑하는 사람이 생겼어요..");

        a.show();

        if (a.isSameName(b)) {
            System.out.println("동일한 사람입니다.");
        } else {
            System.out.println("다른 사람입니다.");
        }

        System.out.println(c.getName() + "가 작성한 메모의 길이는 " + c.length());
    }
}