package kimhoon_report3_20251002;
//이 전체 코드를 복사하여 "Point3DProblem.java" 파일로 저장하시면 됩니다.

//Point 클래스는 Point3D의 부모 클래스입니다.
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

//Point 클래스를 상속받아 3차원의 점을 나타내는 Point3D 클래스
class Point3D extends Point {
 private int z; // z 좌표 필드 추가

 // 생성자: x, y, z 좌표를 받아 초기화
 public Point3D(int x, int y, int z) {
     super(x, y); // 부모 클래스 Point의 생성자 호출하여 x, y 초기화
     this.z = z;  // z 좌표 초기화
 }

 // z 축으로 주어진 값만큼 이동 (z 좌표 증가)
 public void moveUp(int dz) {
     this.z += dz;
 }

 // z 축으로 주어진 값만큼 이동 (z 좌표 감소)
 public void moveDown(int dz) {
     this.z -= dz;
 }

 // x, y, z 좌표를 모두 변경하는 메서드
 public void move(int x, int y, int z) {
     super.move(x, y); // 부모 Point 클래스의 move(x, y) 메서드를 호출하여 x, y 변경
     this.z = z;        // z 좌표 변경
 }

 @Override // Object 클래스의 toString 메서드를 오버라이드합니다.
 public String toString() {
     // (x,y,z)의 점 형식으로 출력하기 위해 재정의합니다.
     // getX()와 getY()는 부모 Point 클래스의 메서드를 활용합니다.
     return "(" + getX() + "," + getY() + "," + z + ")";
 }
}

//메인 실행을 담당하는 public 클래스 (파일 이름과 같아야 합니다)
public class Point3DProblem {

 public static void main(String[] args) {
     // [문제 5] Point3D 클래스 테스트 코드
     Point3D p = new Point3D(3, 2, 1); // (3,2,1)의 점 생성
     System.out.println(p.toString() + "입니다."); // (3,2,1)의 점입니다.

     p.moveUp(3); // z 축으로 3 이동 (z = 1 + 3 = 4)
     System.out.println(p.toString() + "입니다."); // (3,2,4)의 점입니다.

     p.moveDown(2); // z 축으로 -2 이동 (z = 4 - 2 = 2)
     System.out.println(p.toString() + "입니다."); // (3,2,2)의 점입니다.

     p.move(5, 5); // x=5, y=5으로 이동. (Point 클래스에서 상속받은 move(x,y) 사용. z는 변경 없음)
     System.out.println(p.toString() + "입니다."); // (5,5,2)의 점입니다.

     p.move(100, 200, 300); // x=100, y=200, z=300으로 이동
     System.out.println(p.toString() + "입니다."); // (100,200,300)의 점입니다.
 }
}