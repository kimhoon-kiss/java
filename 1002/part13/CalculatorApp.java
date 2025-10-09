package kimhoon_report3_20251002;

//이 전체 코드를 복사하여 "CalculatorApp.java" 파일로 저장하시면 됩니다.

import java.util.Scanner;

//추상 클래스 Calc
abstract class Calc {
 protected String errorMsg = null; // 연산 도중 발생한 오류 메시지 저장. null 이면 오류 없음
 protected int a, b; // 2개의 피연산자

 // 피연산자 값을 전달받아 객체 내에 저장하고, 새로운 연산 시작 시 오류 메시지를 초기화합니다.
 public void setValue(int a, int b) {
     this.a = a;
     this.b = b;
     this.errorMsg = null; // 새로운 연산 시작 시 오류 메시지 초기화
 }

 // 클래스의 목적에 맞는 연산을 실행하고 결과 리턴 (추상 메서드)
 public abstract int calculate();

 // 저장된 오류 메시지를 리턴합니다.
 public String getErrorMsg() {
     return errorMsg;
 }
}

//Calc를 상속받는 Add 클래스
class Add extends Calc {
 @Override
 public int calculate() {
     return a + b;
 }
}

//Calc를 상속받는 Sub 클래스
class Sub extends Calc {
 @Override
 public int calculate() {
     return a - b;
 }
}

//Calc를 상속받는 Mul 클래스
class Mul extends Calc {
 @Override
 public int calculate() {
     return a * b;
 }
}

//Calc를 상속받는 Div 클래스 (나눗셈 연산과 0으로 나누는 경우 오류 처리)
class Div extends Calc {
 @Override
 public int calculate() {
     if (b == 0) { // 0으로 나누는 경우
         this.errorMsg = "0으로 나눌 수 없음.";
         return 0; // 오류 발생 시 calculate()는 0을 리턴 (반환 타입 int를 맞춰주기 위함)
     }
     return a / b;
 }
}

//CalculatorApp 클래스: main() 메서드를 포함하여 사용자 입력 및 연산 처리
public class CalculatorApp {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     Calc currentCalc = null; // 연산 객체를 담을 변수

     while (true) {
         System.out.print("두 정수와 연산자를 입력하시오>>");
         int a = scanner.nextInt();
         int b = scanner.nextInt();
         String operator = scanner.next(); // 연산자 문자열로 받기

         // 'q'를 입력받으면 프로그램 종료
         if (operator.equals("q") || operator.equals("Q")) {
             System.out.println("계산기 프로그램을 종료합니다.");
             break;
         }

         switch (operator) {
             case "+":
                 currentCalc = new Add();
                 break;
             case "-":
                 currentCalc = new Sub();
                 break;
             case "*":
                 currentCalc = new Mul();
                 break;
             case "/":
                 currentCalc = new Div();
                 break;
             default:
                 System.out.println("잘못된 연산자입니다. 다시 입력해주세요.");
                 continue; // 다음 입력으로 넘어감
         }

         currentCalc.setValue(a, b); // 피연산자 설정
         int result = currentCalc.calculate(); // 연산 수행

         if (currentCalc.getErrorMsg() != null) { // 오류가 발생했는지 확인
             System.out.println(currentCalc.getErrorMsg() + " 프로그램 종료");
             scanner.close(); // Scanner 닫기
             return; // main 메서드 종료 -> 프로그램 종료
         } else {
             System.out.println("계산 결과: " + result);
         }
     }
     scanner.close(); // 프로그램 정상 종료 시 Scanner 닫기
 }
}