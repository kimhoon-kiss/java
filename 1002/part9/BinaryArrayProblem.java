package kimhoon_report3_20251002;

//이 전체 코드를 복사하여 "BinaryArrayProblem.java" 파일로 저장하시면 됩니다.

import java.util.Scanner;

//정수를 배열로 저장하는 클래스 BaseArray (문제에서 주어진 형태)
class BaseArray {
 protected int array[];     // 배열 메모리
 protected int nextIndex;   // 다음에 삽입할 배열에 대한 인덱스

 public BaseArray(int size) {
     array = new int[size];
     nextIndex = 0; // 초기 nextIndex는 0
 }

 public int length() {
     return array.length;
 }

 public void add(int n) { // 정수 n을 배열 끝에 추가
     if (nextIndex == array.length) { // 배열이 꽉 찼으면 추가 안 함
         return;
     }
     array[nextIndex] = n;
     nextIndex++;
 }

 public void print() {
     for (int i = 0; i < nextIndex; i++) { // nextIndex까지 출력 (실제로 값이 있는 부분만)
         System.out.print(array[i] + " ");
     }
     System.out.println();
 }
}

//BaseArray를 상속받아 임계값(threshold)을 기준으로 0 또는 1을 저장하는 BinaryArray
class BinaryArray extends BaseArray {
 private int threshold; // 임계값

 // 생성자: size와 threshold를 초기화
 public BinaryArray(int size, int threshold) {
     super(size); // BaseArray의 생성자 호출
     this.threshold = threshold;
 }

 // 정수 n을 배열 끝에 추가. n이 임계값보다 크면 1, 아니면 0으로 변환하여 저장.
 @Override
 public void add(int n) {
     int valueToStore = (n > threshold) ? 1 : 0; // 임계값 기준으로 0 또는 1 결정
     super.add(valueToStore); // BaseArray의 add 메서드를 호출하여 실제 배열에 저장
 }

 // 저장된 0 또는 1 값을 공백 없이 연속해서 출력
 @Override
 public void print() {
     for (int i = 0; i < nextIndex; i++) {
         System.out.print(array[i]); // 공백 없이 출력
     }
     System.out.println(); // 마지막에 줄바꿈
 }
}

//메인 실행을 담당하는 public 클래스 (파일 이름과 같아야 합니다)
public class BinaryArrayProblem {

 public static void main(String[] args) {
     int threshold = 50; // 임계값 50

     // 크기 10, 임계값 50을 갖는 BinaryArray 객체 생성
     BinaryArray bArray = new BinaryArray(10, threshold);

     Scanner scanner = new Scanner(System.in);
     System.out.print(">>");

     // 배열의 길이(10)만큼 정수를 입력받아 bArray에 추가
     for (int i = 0; i < bArray.length(); i++) {
         int n = scanner.nextInt();
         bArray.add(n);
     }

     bArray.print(); // 결과 출력

     scanner.close(); // Scanner 리소스 해제
 }
}