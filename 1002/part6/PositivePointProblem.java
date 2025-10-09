package kimhoon_report3_20251002;

//이 전체 코드를 복사하여 "PositivePointProblem.java" 파일로 저장하시면 됩니다.

//Point 클래스는 PositivePoint의 부모 클래스입니다.
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

//Point 클래스를 상속받아 양수만 가능한 점을 나타내는 PositivePoint 클래스
class PositivePoint extends Point {

 // 생성자: x, y 좌표를 받아 양수만 가능하도록 초기화
 // 음수가 입력되면 (1,1)로 디폴트 설정됩니다.
 public PositivePoint(int x, int y) {
     // 일단 부모 Point 클래스의 생성자를 호출하여 x, y를 초기화합니다.
     // 이때 음수값이 들어와도 일단 부모에는 저장됩니다.
     super(x, y);

     // PositivePoint의 조건: x, y가 모두 0 이상이어야 합니다.
     // 만약 초기값이 음수이거나 (1,1)이 디폴트되어야 하는 상황이면 super.move(1,1) 호출
     if (x < 0 || y < 0) {
         super.move(1, 1); // 음수점이 들어오면 (1,1)로 강제 설정
     }
     // x,y가 양수인 경우는 이미 super(x,y)에서 설정되었으므로 별도 처리 없음.
     // PositivePoint의 오버라이딩된 move 메서드를 호출하는 대신,
     // 문제에서 "적절히 super.move()를 호출해야 한다."고 명시했으므로
     // super.move()를 사용하여 부모의 move 기능을 직접 이용했습니다.
 }

 // Point 클래스의 move()를 오버라이딩하여 양수 공간으로만 이동 가능하도록 재작성
 @Override
 protected void move(int x, int y) {
     // x, y 좌표가 모두 0보다 크거나 같을 때만 부모 클래스의 move 메서드를 호출하여 이동 허용
     if (x >= 0 && y >= 0) {
         super.move(x, y); // 부모 클래스의 move 메서드 호출하여 실제로 이동
     }
     // 음수 좌표인 경우 아무것도 하지 않음 (현재 위치 유지)
 }

 @Override // Object 클래스의 toString 메서드를 오버라이드합니다.
 public String toString() {
     // "(x,y)의 점" 형식으로 출력하기 위해 재정의합니다.
     // getX()와 getY()는 부모 Point 클래스의 메서드를 활용합니다.
     return "(" + getX() + "," + getY() + ")";
 }
}

//메인 실행을 담당하는 public 클래스 (파일 이름과 같아야 합니다)
public class PositivePointProblem {

 public static void main(String[] args) {
     // [문제 6] PositivePoint 클래스 테스트 코드
     PositivePoint p = new PositivePoint(10, 10); // (10, 10)의 점
     p.move(5, 5); // p는 (5, 5) 점으로 이동
     System.out.println(p.toString() + "입니다."); // 예상 출력: (5,5)의 점입니다.

     p.move(-2, 2); // 점 p는 양수 공간만 가능. x가 음수이므로 이동 없음
     System.out.println(p.toString() + "입니다."); // 예상 출력: (5,5)의 점입니다.

     PositivePoint q = new PositivePoint(-10, -10); // 음수점 불가. 디폴트 (1, 1)의 점 생성
     System.out.println(q.toString() + "입니다."); // 예상 출력: (1,1)의 점입니다.
 }
}