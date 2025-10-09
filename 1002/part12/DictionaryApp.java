package kimhoon_report3_20251002;

//이 전체 코드를 복사하여 "DictionaryApp.java" 파일로 저장하시면 됩니다.

//추상 클래스 PairMap 정의
abstract class PairMap {
 protected String keyArray[];   // 키 문자열을 저장하는 배열
 protected String valueArray[]; // 값 문자열을 저장하는 배열

 // 각 배열의 최대 크기를 받아 초기화하는 생성자 (Dictionary에서 사용될 예정)
 public PairMap(int capacity) {
     keyArray = new String[capacity];
     valueArray = new String[capacity];
 }

 abstract public String get(String key); // key 값으로 value 검색
 abstract public void put(String key, String value); // key와 value를 쌍으로 저장. key가 이미 저장되어 있으면 값을 value로 수정
 abstract public String delete(String key); // key 값을 가진 아이템(value와 함께) 삭제. 삭제된 value 값 리턴
 abstract public int length(); // 현재 저장된 아이템 개수 리턴
}

//PairMap을 상속받아 Dictionary 클래스 구현
class Dictionary extends PairMap {
 private int currentSize; // 현재 저장된 아이템 개수

 public Dictionary(int capacity) {
     super(capacity); // 부모 PairMap의 생성자 호출
     currentSize = 0; // 초기 아이템 개수는 0
 }

 @Override
 public String get(String key) {
     int index = findKeyIndex(key);
     if (index != -1) { // 키를 찾았다면
         return valueArray[index]; // 해당 값 리턴
     }
     return null; // 키를 찾지 못했다면 null 리턴
 }

 @Override
 public void put(String key, String value) {
     int index = findKeyIndex(key);
     if (index != -1) { // 키가 이미 존재하면 값을 수정
         valueArray[index] = value;
         return;
     }

     // 키가 존재하지 않고, 저장 공간이 남아있다면 새로운 키-값 쌍 추가
     if (currentSize < keyArray.length) {
         keyArray[currentSize] = key;
         valueArray[currentSize] = value;
         currentSize++;
     } else {
         // 저장 공간이 꽉 찼을 경우 (문제 예시에는 없지만, 스택 문제와 유사하게 처리)
         System.out.println("딕셔너리가 꽉 찼습니다. " + key + " - " + value + " 저장 불가");
     }
 }

 @Override
 public String delete(String key) {
     int index = findKeyIndex(key);
     if (index == -1) { // 키를 찾지 못했다면
         return null; // null 리턴
     }

     String deletedValue = valueArray[index]; // 삭제될 값 저장

     // 아이템 삭제 후 배열 재정렬: 삭제된 아이템 뒤의 요소들을 한 칸씩 앞으로 당김
     for (int i = index; i < currentSize - 1; i++) {
         keyArray[i] = keyArray[i + 1];
         valueArray[i] = valueArray[i + 1];
     }
     // 마지막 요소 비우기 (메모리 관리 및 논리적 비움)
     keyArray[currentSize - 1] = null;
     valueArray[currentSize - 1] = null;

     currentSize--; // 저장된 아이템 개수 감소
     return deletedValue; // 삭제된 값 리턴
 }

 @Override
 public int length() {
     return currentSize; // 현재 저장된 아이템 개수 리턴
 }

 // 헬퍼 메서드: 키가 저장된 배열 내 인덱스를 검색
 // 키를 찾으면 인덱스 반환, 없으면 -1 반환
 private int findKeyIndex(String key) {
     for (int i = 0; i < currentSize; i++) {
         if (keyArray[i].equals(key)) { // 문자열 비교는 equals() 사용
             return i;
         }
     }
     return -1;
 }
}

//Dictionary 클래스를 활용하는 main() 메소드를 가진 DictionaryApp 클래스
public class DictionaryApp {
 public static void main(String[] args) {
     Dictionary dic = new Dictionary(10); // 최대 10개의 아이템을 저장할 수 있는 딕셔너리 생성

     dic.put("황기태", "자바");
     dic.put("이재문", "파이선");
     dic.put("이재문", "C++"); // 이재문의 값을 C++로 수정 (기존 "파이선" 대신 "C++")

     System.out.println("이재문의 값은 " + dic.get("이재문")); // C++ 출력
     System.out.println("황기태의 값은 " + dic.get("황기태")); // 자바 출력

     dic.delete("황기태"); // "황기태" 아이템 삭제

     // 삭제 후 "황기태" 검색 시 null 출력
     System.out.println("황기태의 값은 " + dic.get("황기태"));
 }
}