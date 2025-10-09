package kimhoon_report3_20251002;
//이 전체 코드를 복사하여 "GraphicEditorApp.java" 파일로 저장하시면 됩니다.

import java.util.Scanner;

//추상 클래스 Shape (문제에서 주어진 형태와 동일)
abstract class Shape {
 private Shape next; // 다음 Shape 객체를 가리키는 링크 (private)

 public Shape() {
     next = null;
 }

 public void setNext(Shape obj) { // 다음 링크 연결
     next = obj;
 }

 public Shape getNext() { // 다음 링크 리턴
     return next;
 }

 public abstract void draw(); // 추상 메서드: 각 도형을 그리는 기능
}

//Shape를 상속받는 Line 클래스
class Line extends Shape {
 @Override
 public void draw() {
     System.out.println("Line");
 }
}

//Shape를 상속받는 Rect 클래스
class Rect extends Shape {
 @Override
 public void draw() {
     System.out.println("Rect");
 }
}

//Shape를 상속받는 Circle 클래스
class Circle extends Shape {
 @Override
 public void draw() {
     System.out.println("Circle");
 }
}

//그래픽 편집기 클래스 GraphicEditor
public class GraphicEditorApp { // 클래스 이름을 GraphicEditorApp으로 변경하여 main 메서드를 가질 수 있게 함
 private Shape head; // 링크드 리스트의 첫 번째 Shape 객체
 private Shape tail; // 링크드 리스트의 마지막 Shape 객체
 private Scanner scanner;

 public GraphicEditorApp() { // 생성자 이름을 클래스 이름과 동일하게 변경
     head = null; // 초기에는 리스트가 비어있음
     tail = null;
     scanner = new Scanner(System.in);
     System.out.println("그래픽 에디터 Beauty Graphic Editor를 실행합니다.");
 }

 // 도형 삽입 기능
 public void insert() {
     System.out.print("Line(1), Rect(2), Circle(3)>>");
     int type = scanner.nextInt();
     Shape newShape = null;

     switch (type) {
         case 1: newShape = new Line(); break;
         case 2: newShape = new Rect(); break;
         case 3: newShape = new Circle(); break;
         default:
             System.out.println("잘못된 도형 타입입니다. 삽입 취소.");
             return;
     }

     if (head == null) { // 리스트가 비어있으면 새 도형이 head이자 tail이 됨
         head = newShape;
         tail = newShape;
     } else { // 리스트의 맨 뒤에 추가
         tail.setNext(newShape);
         tail = newShape;
     }
 }

 // 도형 삭제 기능
 public void delete() {
     if (head == null) {
         System.out.println("삭제할 도형이 없습니다.");
         return;
     }

     System.out.print("삭제할 도형의 위치>>");
     int index = scanner.nextInt();

     if (index <= 0) { // 유효하지 않은 인덱스 (1부터 시작해야 함)
         System.out.println("삭제할 수 없습니다. (위치는 1 이상이어야 합니다)");
         return;
     }

     // head(첫 번째) 삭제
     if (index == 1) {
         head = head.getNext(); // head를 다음 노드로 이동
         if (head == null) { // head가 null이 되면 리스트가 비어있는 것이므로 tail도 null
             tail = null;
         }
         // System.out.println("첫 번째 도형이 삭제되었습니다."); // 예시 출력에 이 문구는 없음
         return;
     }

     // 그 외 위치 삭제
     Shape current = head;
     Shape prev = null; // 이전 노드를 저장
     int count = 1;
     while (current != null && count < index) {
         prev = current;
         current = current.getNext();
         count++;
     }

     if (current != null && prev != null) { // 삭제할 노드(current)가 있고, 이전 노드(prev)도 있다면
         prev.setNext(current.getNext()); // 이전 노드가 다음 노드를 가리키도록 연결
         if (current == tail) { // 삭제되는 노드가 tail이었다면 tail 갱신
             tail = prev; // 이전 노드가 새로운 tail이 됨
         }
         // System.out.println(index + "번째 도형이 삭제되었습니다."); // 예시 출력에 이 문구는 없음
     } else { // 인덱스가 리스트 길이를 초과했거나, prev가 없는데 current가 있으면 head였어야 함
         System.out.println("삭제할 수 없습니다.");
     }
 }

 // 모든 도형 보기 기능
 public void showAll() {
     if (head == null) {
         System.out.println("현재 저장된 도형이 없습니다."); // 예시 출력에는 없으나 명확성을 위해 추가
         return;
     }

     Shape current = head;
     while (current != null) {
         current.draw(); // 각 도형의 draw 메서드 호출
         current = current.getNext();
     }
 }

 // 종료 기능
 public void exit() {
     System.out.println("Beauty Graphic Editor를 종료합니다.");
     scanner.close(); // Scanner 리소스 해제
     System.exit(0); // 프로그램 강제 종료
 }

 // 그래픽 편집기 실행 메서드
 public void run() {
     int choice;
     while (true) {
         System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
         choice = scanner.nextInt();

         switch (choice) {
             case 1: insert(); break;
             case 2: delete(); break;
             case 3: showAll(); break;
             case 4: exit(); break;
             default:
                 System.out.println("잘못된 메뉴 선택입니다. 다시 입력해주세요.");
         }
         // System.out.println(); // 메뉴 출력 사이 간격 조절 (예시와 맞추기 위해 주석처리)
     }
 }

 public static void main(String[] args) {
     GraphicEditorApp editor = new GraphicEditorApp(); // GraphicEditorApp 객체 생성
     editor.run();
 }
}