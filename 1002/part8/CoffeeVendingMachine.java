package kimhoon_report3_20251002;
//이 전체 코드를 복사하여 "CoffeeVendingMachine.java" 파일로 저장하시면 됩니다.

import java.util.Scanner;

//추상 클래스 Box
abstract class Box {
 protected int size; // 현재 박스에 들어 있는 재료의 양

 public Box(int size) { // 생성자
     this.size = size;
 }

 public boolean isEmpty() {
     return size == 0;
 } // 박스가 빈 경우 true

 // 박스에 들어 있는 재료를 일정량 소모. 성공하면 true, 실패하면 false 반환.
 public abstract boolean consume(int amount);

 public abstract void print(); // 박스에 들어 있는 양을 문자로 출력
}

//Box를 상속받아 재료를 담는 IngredientBox 클래스
class IngredientBox extends Box {
 private String name; // 재료 이름 (예: 커피, 프림, 설탕)

 public IngredientBox(String name, int size) { // 생성자
     super(size); // 부모 Box의 생성자 호출하여 size 초기화
     this.name = name;
 }

 // amount 만큼 재료를 소모. 재료가 충분하면 소모하고 true 반환, 부족하면 false 반환.
 @Override
 public boolean consume(int amount) {
     if (this.size >= amount) {
         this.size -= amount;
         return true;
     }
     return false; // 재료가 부족함
 }

 // 재료의 이름과 현재 남은 양을 '*' 문자로 출력
 @Override
 public void print() {
     System.out.print(name);
     for (int i = 0; i < size; i++) {
         System.out.print("*");
     }
     System.out.println(size); // 남은 양 숫자로도 출력
 }
 
 // 현재 남은 재료의 양을 반환하는 getter 추가 (외부에서 재료 확인용)
 public int getSize() {
     return size;
 }
}

//커피 자판기 프로그램
public class CoffeeVendingMachine {
 private IngredientBox coffee;
 private IngredientBox cream; // 프림
 private IngredientBox sugar;
 private Scanner scanner;

 public CoffeeVendingMachine() {
     coffee = new IngredientBox("커피", 5);
     cream = new IngredientBox("프림", 5);
     sugar = new IngredientBox("설탕", 5);
     scanner = new Scanner(System.in);
 }

 // 초기 재료 상태를 출력하고 메뉴를 표시
 private void printMenu() {
     System.out.println("*****청춘 커피 자판기 입니다.*****");
     coffee.print();
     cream.print();
     sugar.print();
     System.out.print("다방커피:1, 설탕 커피:2, 블랙 커피:3, 종료:4>>");
 }

 // 커피 제조 시 필요한 재료가 충분한지 확인
 private boolean checkIngredients(int coffeeAmt, int creamAmt, int sugarAmt) {
     return coffee.getSize() >= coffeeAmt &&
            cream.getSize() >= creamAmt &&
            sugar.getSize() >= sugarAmt;
 }

 // 커피 제조 및 재료 소모
 private void makeCoffee(int type) {
     switch (type) {
         case 1: // 다방커피
             if (checkIngredients(1, 1, 1)) {
                 coffee.consume(1);
                 cream.consume(1);
                 sugar.consume(1);
                 System.out.println("다방커피 나왔습니다.");
             } else {
                 System.out.println("원료가 부족합니다.");
             }
             break;
         case 2: // 설탕 커피
             if (checkIngredients(1, 0, 1)) {
                 coffee.consume(1);
                 sugar.consume(1);
                 System.out.println("설탕 커피 나왔습니다.");
             } else {
                 System.out.println("원료가 부족합니다.");
             }
             break;
         case 3: // 블랙 커피
             if (checkIngredients(1, 0, 0)) {
                 coffee.consume(1);
                 System.out.println("블랙 커피 나왔습니다.");
             } else {
                 System.out.println("원료가 부족합니다.");
             }
             break;
     }
 }

 public void run() {
     int choice;
     while (true) {
         printMenu();
         choice = scanner.nextInt();

         if (choice == 4) {
             System.out.println("청춘 커피자판기 프로그램을 종료합니다.");
             break;
         } else if (choice >= 1 && choice <= 3) {
             makeCoffee(choice);
         } else {
             System.out.println("잘못된 메뉴 선택입니다. 다시 입력해주세요.");
         }
         System.out.println(); // 출력 간격 조절
     }
     scanner.close();
 }

 public static void main(String[] args) {
     CoffeeVendingMachine machine = new CoffeeVendingMachine();
     machine.run();
 }
}