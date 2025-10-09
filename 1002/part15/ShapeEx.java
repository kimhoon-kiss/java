package kimhoon_report3_20251002;
//이 전체 코드를 복사하여 "ShapeEx.java" 파일로 저장하시면 됩니다.

//Shape 인터페이스 정의 (문제에서 주어진 형태와 동일)
interface Shape {
 final double PI = 3.14; // 상수 (final이므로 자동으로 static final)

 void draw();      // 도형을 그리는 추상 메소드 (자동으로 public abstract)
 double getArea(); // 도형의 면적을 리턴하는 추상 메소드 (자동으로 public abstract)

 // 디폴트 메소드: 다시 그릴 때 출력 메시지와 함께 draw() 호출
 default public void redraw() {
     System.out.print("--- 다시 그립니다. ");
     draw();
 }
}

//Shape 인터페이스를 구현하는 Circle 클래스
class Circle implements Shape {
 private int radius; // 반지름

 public Circle(int radius) {
     this.radius = radius;
 }

 @Override // Shape 인터페이스의 draw() 메서드 구현
 public void draw() {
     System.out.println("반지름이 " + radius + "인 원");
 }

 @Override // Shape 인터페이스의 getArea() 메서드 구현
 public double getArea() {
     return PI * radius * radius;
 }
}

//Shape 인터페이스를 구현하는 Oval 클래스 (타원)
class Oval implements Shape {
 private int width;  // 타원의 가로 축 길이
 private int height; // 타원의 세로 축 길이

 public Oval(int width, int height) {
     this.width = width;
     this.height = height;
 }

 @Override // Shape 인터페이스의 draw() 메서드 구현
 public void draw() {
     System.out.println(width + "x" + height + "에 내접하는 타원");
 }

 @Override // Shape 인터페이스의 getArea() 메서드 구현
 public double getArea() {
     // 타원의 면적 = PI * (가로 지름의 절반) * (세로 지름의 절반)
     // 문제에서 "20x30 사각형에 내접하는 타원"으로 주어졌기에, width와 height를 각각 지름으로 해석하여 계산합니다.
     return PI * (width / 2.0) * (height / 2.0);
 }
}

//Shape 인터페이스를 구현하는 Rect 클래스 (사각형)
class Rect implements Shape {
 private int width;  // 사각형의 가로 길이
 private int height; // 사각형의 세로 길이

 public Rect(int width, int height) {
     this.width = width;
     this.height = height;
 }

 @Override // Shape 인터페이스의 draw() 메서드 구현
 public void draw() {
     System.out.println(width + "x" + height + "크기의 사각형");
 }

 @Override // Shape 인터페이스의 getArea() 메서드 구현
 public double getArea() {
     return (double) width * height; // 면적 계산 (정수 나눗셈 방지 위해 double 형변환)
 }
}

//main() 메소드를 포함하는 ShapeEx 클래스
public class ShapeEx {
 static public void main(String[] args) {
     // Shape을 상속받은 클래스 객체의 레퍼런스를 저장하는 배열
     Shape[] list = new Shape[3];

     list[0] = new Circle(5);      // 반지름이 5인 원 객체
     list[1] = new Oval(20, 30);   // 20x30 사각형에 내접하는 타원
     list[2] = new Rect(10, 40);   // 10x40 크기의 사각형

     // 모든 도형을 다시 그립니다. (redraw() 디폴트 메서드 활용)
     for (int i = 0; i < list.length; i++) {
         list[i].redraw();
     }

     System.out.println(); // 줄바꿈 (출력 예시와 동일하게)

     // 모든 도형의 면적을 출력합니다.
     for (int i = 0; i < list.length; i++) {
         System.out.println("면적은 " + list[i].getArea());
     }
 }
}