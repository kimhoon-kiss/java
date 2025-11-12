package report_20251106;

import java.util.*;

//🔹 추상 클래스 Shape
abstract class Shape {
 public abstract void draw(); // 각 도형마다 다르게 동작할 draw()
}

//🔹 Line 클래스
class Line extends Shape {
 @Override
 public void draw() {
     System.out.println("Line");
 }
}

//🔹 Rect 클래스
class Rect extends Shape {
 @Override
 public void draw() {
     System.out.println("Rect");
 }
}

//🔹 Circle 클래스
class Circle extends Shape {
 @Override
 public void draw() {
     System.out.println("Circle");
 }
}

//🔹 그래픽 에디터 클래스
public class GraphicEditor {
 private Vector<Shape> shapes = new Vector<>();
 private Scanner scanner = new Scanner(System.in);

 public void run() {
     System.out.println("그래픽 에디터 Beauty Graphic Editor를 실행합니다.");

     while (true) {
         System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
         int choice = scanner.nextInt();

         switch (choice) {
             case 1:
                 insert();
                 break;
             case 2:
                 delete();
                 break;
             case 3:
                 showAll();
                 break;
             case 4:
                 System.out.println("Beauty Graphic Editor를 종료합니다.");
                 return;
             default:
                 System.out.println("잘못된 입력입니다.");
         }
     }
 }

 // 🔹 도형 삽입
 private void insert() {
     System.out.print("Line(1), Rect(2), Circle(3)>>");
     int type = scanner.nextInt();
     Shape s = null;

     switch (type) {
         case 1:
             s = new Line();
             break;
         case 2:
             s = new Rect();
             break;
         case 3:
             s = new Circle();
             break;
         default:
             System.out.println("잘못된 도형 종류입니다.");
             return;
     }
     shapes.add(s);
 }

 // 🔹 도형 삭제
 private void delete() {
     System.out.print("삭제할 도형의 위치>>");
     int index = scanner.nextInt();

     if (index < 1 || index > shapes.size()) {
         System.out.println("삭제할 수 없습니다.");
     } else {
         shapes.remove(index - 1);
     }
 }

 // 🔹 모든 도형 출력
 private void showAll() {
     for (Shape s : shapes) {
         s.draw();
     }
 }

 // 🔹 main
 public static void main(String[] args) {
     GraphicEditor editor = new GraphicEditor();
     editor.run();
 }
}
