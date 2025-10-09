package kimhoon_report3_20251002;

//이 전체 코드를 복사하여 "StackApp.java" 파일로 저장하시면 됩니다.

import java.util.Scanner;

//IStack 인터페이스 정의
interface IStack {
 int capacity(); // 스택에 저장 가능한 개수 리턴
 int length();   // 스택에 현재 저장된 개수 리턴
 boolean push(String val); // 스택의 톱(top)에 문자열 저장하고 true 리턴, 꽉 차면 false 리턴
 String pop();   // 스택의 톱(top)에 저장된 문자열 리턴, 스택이 비어 있으면 null 리턴
}

//IStack 인터페이스를 구현하는 StringStack 클래스
class StringStack implements IStack {
 private String[] stackArray; // 스택 저장 공간
 private int top;             // 스택의 톱(맨 위)을 가리키는 인덱스 (다음에 push될 위치)

 public StringStack(int capacity) {
     stackArray = new String[capacity];
     top = 0; // 스택이 비어있는 상태
 }

 @Override
 public int capacity() {
     return stackArray.length; // 배열의 길이 = 스택의 총 용량
 }

 @Override
 public int length() {
     return top; // 현재 top 인덱스가 스택에 저장된 개수
 }

 @Override
 public boolean push(String val) {
     if (top == stackArray.length) { // 스택이 꽉 찼다면
         return false;
     }
     stackArray[top] = val; // 현재 top 위치에 값 저장
     top++;                 // top 인덱스 증가
     return true;
 }

 @Override
 public String pop() {
     if (top == 0) { // 스택이 비어있다면
         return null;
     }
     top--;                  // top 인덱스 감소 (맨 위 요소 가리킴)
     String val = stackArray[top]; // 해당 위치의 값 가져오기
     stackArray[top] = null; // 선택사항: pop된 위치는 null로 비워줌
     return val;
 }
}

//StringStack 클래스를 활용하는 main() 메서드를 가진 StackApp 클래스
public class StackApp {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     System.out.print("스택 용량>>");
     int capacity = scanner.nextInt();
     scanner.nextLine(); // 버퍼 비우기 (nextInt() 후 nextLine() 사용 시 필수)

     StringStack stack = new StringStack(capacity);

     while (true) {
         System.out.print("문자열 입력>>");
         String input = scanner.nextLine();

         if (input.equals("그만")) {
             break;
         }

         if (!stack.push(input)) { // 스택에 문자열 저장 시도
             System.out.println("스택이 꽉 차서 " + input + " 저장 불가");
         }
     }

     System.out.print("스택에 저장된 문자열 팝: ");
     int len = stack.length(); // 현재 스택에 저장된 개수
     for (int i = 0; i < len; i++) {
         System.out.print(stack.pop() + " ");
     }
     System.out.println(); // 줄바꿈

     scanner.close();
 }
}