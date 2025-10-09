package kimhoon_report3_20251002;

//이 전체 코드를 복사하여 "ColorPoint2Problem.java" 파일로 저장하시면 됩니다.
import java.lang.Math; // Math.sqrt()를 사용하기 위해 필요합니다.

//Point 클래스는 ColorPoint2의 부모 클래스입니다.
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

//Point를 상속받아 색을 가진 점을 나타내는 ColorPoint2 클래스
class ColorPoint2 extends Point {
 private String color; // 색상 필드

 // 기본 생성자: (0,0) 위치의 "WHITE" 색점
 public ColorPoint2() {
     super(0, 0); // 부모 Point 클래스의 생성자 호출 (x=0, y=0)
     this.color = "WHITE"; // 색상 기본값 "WHITE"로 설정
 }

 // 생성자: (x,y) 위치의 특정 "color" 색점
 public ColorPoint2(int x, int y, String color) {
     super(x, y); // 부모 Point 클래스의 생성자 호출
     this.color = color; // 색상 초기화
 }

 // 생성자: (x,y) 위치의 "BLACK" 색점 (문제 요구사항)
 public ColorPoint2(int x, int y) {
     super(x, y); // 부모 Point 클래스의 생성자 호출
     this.color = "BLACK"; // 색상 기본값 "BLACK"으로 설정
 }

 // 색상만 변경하는 set 메서드 (메서드 오버로딩)
 public void set(String color) {
     this.color = color;
 }

 // x, y 좌표만 변경하는 set 메서드 (메서드 오버로딩, 부모의 move 메서드 활용)
 public void set(int x, int y) {
     move(x, y); // protected 메서드 move를 사용 (부모 Point 클래스의 move 호출)
 }

 @Override // Object 클래스의 toString 메서드를 오버라이드합니다.
 public String toString() {
     // "색상색의 (x,y)의 점" 형식으로 출력하기 위해 재정의합니다.
     return color + "색의 (" + getX() + "," + getY() + ")의 점";
 }

 // 다른 ColorPoint2 객체까지의 거리를 계산하는 메서드
 public double getDistance(ColorPoint2 p) {
     // 두 점 사이의 거리 계산 공식: sqrt((x2-x1)^2 + (y2-y1)^2)
     // Math.pow(값, 제곱)은 double을 반환하므로 주의
     double dx = this.getX() - p.getX(); // x 좌표 차이
     double dy = this.getY() - p.getY(); // y 좌표 차이
     return Math.sqrt(dx * dx + dy * dy); // 제곱근 계산
 }
}

//메인 실행을 담당하는 public 클래스 (파일 이름과 같아야 합니다)
public class ColorPoint2Problem {

 public static void main(String[] args) {
     // [문제 4] ColorPoint2 클래스 테스트 코드
     ColorPoint2 zeroPoint = new ColorPoint2(); // (0,0) 위치의 "WHITE" 색점
     System.out.println(zeroPoint.toString() + "입니다.");
     // 예상 출력: WHITE색의 (0,0)의 점입니다.

     ColorPoint2 cp = new ColorPoint2(10, 10, "RED"); // (10,10) 위치의 "RED" 색점
     
     cp.set("BLUE"); // 색상을 BLUE로 변경
     cp.set(10, 20); // 위치를 (10,20)으로 변경

     System.out.println(cp.toString() + "입니다.");
     // 예상 출력: BLUE색의 (10,20)의 점입니다.

     ColorPoint2 thresholdPoint = new ColorPoint2(100, 100); // (100, 100) 위치의 "BLACK" 점

     System.out.println("cp에서 임계점까지의 거리는 " + cp.getDistance(thresholdPoint));
     // 예상 출력: cp에서 임계점까지의 거리는 120.41594578792295
 }
}