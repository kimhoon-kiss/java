package kimhoon_report3_20251002;

//이 전체 코드를 복사하여 "Point3DColorProblem.java" 파일로 저장하시면 됩니다.

//Point 클래스는 Point3DColor의 부모 클래스입니다.
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

//Point 클래스를 상속받아 3차원의 색 점을 나타내는 Point3DColor 클래스
class Point3DColor extends Point {
 private int z; // z 좌표 필드
 private String color; // 색상 필드

 // 생성자: x, y, z 좌표와 색상을 받아 초기화
 public Point3DColor(int x, int y, int z, String color) {
     super(x, y); // 부모 클래스 Point의 생성자 호출하여 x, y 초기화
     this.z = z;  // z 좌표 초기화
     this.color = color; // 색상 초기화
 }

 // z 좌표 getter (move 메서드에서 다른 객체의 z 값을 가져올 때 필요)
 public int getZ() {
     return z;
 }

 // color getter (equals 메서드에서 다른 객체의 color 값을 가져올 때 필요)
 public String getColor() {
     return color;
 }

 // 점 p를 현재 점의 위치로 이동 (색상은 변경하지 않음)
 public void move(Point3DColor p) {
     super.move(p.getX(), p.getY()); // 부모 Point 클래스의 move(x, y) 메서드를 호출하여 x, y 변경
     this.z = p.getZ();               // z 좌표 변경
     // 이 때, 현재 객체의 색상(this.color)은 변경되지 않습니다.
 }

 @Override // Object 클래스의 toString 메서드를 오버라이드합니다.
 public String toString() {
     // (x,y,z) COLOR점입니다. 형식으로 출력하기 위해 재정의합니다.
     // getX()와 getY()는 부모 Point 클래스의 메서드를 활용합니다.
     return "(" + getX() + "," + getY() + "," + z + ") " + color + "점";
 }

 @Override // Object 클래스의 equals 메서드를 오버라이드합니다.
 public boolean equals(Object obj) {
     // 1. 같은 객체인지 확인
     if (this == obj) return true;
     // 2. null이거나 클래스 타입이 다른지 확인
     if (obj == null || getClass() != obj.getClass()) return false;

     // 3. 타입 캐스팅
     Point3DColor other = (Point3DColor) obj;

     // 4. 모든 필드(x, y, z, color)의 값이 같은지 비교
     return getX() == other.getX() &&  // x 좌표 비교 (부모의 getter 활용)
            getY() == other.getY() &&  // y 좌표 비교 (부모의 getter 활용)
            z == other.z &&            // z 좌표 비교
            color.equals(other.color); // 문자열 color 비교는 .equals() 사용
 }
}

//메인 실행을 담당하는 public 클래스 (파일 이름과 같아야 합니다)
public class Point3DColorProblem {

 public static void main(String[] args) {
     // [문제 7] Point3DColor 클래스 테스트 코드
     Point3DColor p = new Point3DColor(10, 20, 30, "RED"); // (10,20,30) RED점 생성
     System.out.println(p.toString() + "입니다."); // (10,20,30) RED점입니다.

     Point3DColor q = new Point3DColor(1, 2, 3, "BLUE"); // (1,2,3) BLUE점 생성

     p.move(q); // 점 p를 점 q의 위치로 이동 (p의 x, y, z가 q의 x, y, z로 바뀜, p의 색상은 RED 유지)
     System.out.println(p.toString() + "입니다."); // (1,2,3)RED점입니다.

     Point3DColor r = new Point3DColor(1, 2, 3, "RED"); // (1,2,3) RED점 생성

     // p와 r의 위치와 색상이 모두 같은지 비교
     if(p.equals(r)) {
         System.out.println("예. 같은 위치 같은 색깔의 점입니다."); // 예상 출력
     } else {
         System.out.println("아니오");
     }
 }
}