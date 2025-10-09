package kimhoon_report3_20251002;
//이 전체 코드를 복사하여 "ColorPointProblem.java" 파일로 저장하시면 됩니다.

//Point 클래스는 ColorPoint의 부모 클래스입니다.
class Point {
 private int x, y; // x, y 좌표 필드

 public Point(int x, int y) {
     this.x = x;
     this.y = y;
 }

 public int getX() { return x; }
 public int getY() { return y; }

 // protected로 선언하여 상속받은 클래스에서 접근 및 사용 가능하게 합니다.
 protected void move(int x, int y) { // 점의 위치를 이동시키는 메서드
     this.x = x;
     this.y = y;
 }
}

//Point를 상속받아 색을 가진 점을 나타내는 ColorPoint 클래스
class ColorPoint extends Point {
 private String color; // 색상 필드

 public ColorPoint(int x, int y, String color) {
     super(x, y); // 부모 클래스 Point의 생성자 호출하여 x, y 초기화
     this.color = color; // 색상 초기화
 }

 // 주어진 좌표로 점의 위치를 변경합니다.
 // Point 클래스의 protected move 메서드를 활용합니다.
 public void setXY(int x, int y) {
     move(x, y); // 부모의 move 메서드 호출
 }

 // 점의 색상을 변경합니다.
 public void setColor(String color) {
     this.color = color;
 }

 @Override // Object 클래스의 toString 메서드를 오버라이드합니다.
 public String toString() {
     // "BLUE색의 (10,20)의 점" 형식으로 출력하기 위해 재정의합니다.
     // getX()와 getY()는 부모 Point 클래스의 메서드를 활용합니다.
     return color + "색의 (" + getX() + "," + getY() + ")의 점";
 }
}

//메인 실행을 담당하는 public 클래스 (파일 이름과 같아야 합니다)
public class ColorPointProblem {

 public static void main(String[] args) {
     // [문제 3] ColorPoint 클래스 테스트 코드
     ColorPoint cp = new ColorPoint(5, 5, "RED"); // (5,5)에 RED색의 점 생성
     System.out.println("초기 점: " + cp.toString() + "입니다."); // 테스트용 출력

     cp.setXY(10, 20); // (10,20)으로 점의 위치 변경
     cp.setColor("BLUE"); // 색상을 BLUE로 변경

     String str = cp.toString(); // toString() 호출하여 문자열 얻기
     System.out.println(str + "입니다.");
     // 예상 출력: BLUE색의 (10,20)의 점입니다.
 }
}