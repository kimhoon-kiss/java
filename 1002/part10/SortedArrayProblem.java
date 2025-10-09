package kimhoon_report3_20251002;

//이 전체 코드를 복사하여 "SortedArrayProblem.java" 파일로 저장하시면 됩니다.

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

 public void add(int n) { // 정수 n을 배열 끝에 추가 (이 메서드는 BinaryArray에서 오버라이딩 되었지만, SortedArray에서는 다르게 동작함)
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

//BaseArray를 상속받아 값이 큰 순서(오름차순)로 배열을 항상 유지하는 SortedArray
class SortedArray extends BaseArray {

 public SortedArray(int size) {
     super(size); // BaseArray의 생성자 호출
 }

 // 정수 n을 배열에 추가하되, 오름차순을 유지하도록 삽입
 @Override
 public void add(int n) {
     if (nextIndex == array.length) { // 배열이 꽉 찼으면 추가하지 않고 종료
         return;
     }

     // 삽입될 위치를 찾기 위해 배열의 끝에서부터 역순으로 탐색
     int insertIndex = nextIndex;
     for (int i = nextIndex - 1; i >= 0; i--) {
         if (array[i] > n) { // 현재 요소가 삽입할 값보다 크면
             array[i + 1] = array[i]; // 한 칸 뒤로 밀기
             insertIndex = i;         // 삽입 위치 업데이트
         } else { // 현재 요소가 삽입할 값보다 작거나 같으면 올바른 위치를 찾음
             break;
         }
     }

     array[insertIndex] = n; // 찾은 위치에 값 삽입
     nextIndex++; // 다음 삽입할 인덱스 증가
 }
}

//메인 실행을 담당하는 public 클래스 (파일 이름과 같아야 합니다)
public class SortedArrayProblem {

 public static void main(String[] args) {
     SortedArray sArray = new SortedArray(10); // 크기가 10인 SortedArray 생성

     Scanner scanner = new Scanner(System.in);
     System.out.print(">> ");

     // 배열의 길이(10)만큼 정수를 입력받아 sArray에 추가
     for (int i = 0; i < sArray.length(); i++) {
         int n = scanner.nextInt();
         sArray.add(n);
     }

     sArray.print(); // 최종 정렬된 결과 출력

     scanner.close(); // Scanner 리소스 해제
 }
}