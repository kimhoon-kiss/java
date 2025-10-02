package kimhoon_report2_20250925;
public class VArray {
    private int[] arr;
    private int count;  // 저장된 데이터 개수

    // 생성자
    public VArray(int capacity) {
        arr = new int[capacity];
        count = 0;
    }

    // 배열 용량 리턴
    public int capacity() {
        return arr.length;
    }

    // 저장된 데이터 개수 리턴
    public int size() {
        return count;
    }

    // 모든 저장값 출력
    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 배열이 꽉 찼을 때 크기 2배로 확장
    private void resize() {
        int newCapacity = arr.length * 2;
        int[] temp = new int[newCapacity];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        arr = temp;
    }

    // 값 추가 (배열 끝에)
    public void add(int value) {
        if (count == arr.length) {
            resize();
        }
        arr[count++] = value;
    }

    // index 위치에 값 삽입 (index는 0 이상 count 이하)
    public void insert(int index, int value) {
        if (index < 0 || index > count) {
            System.out.println("인덱스 오류: " + index);
            return;
        }
        if (count == arr.length) {
            resize();
        }
        for (int i = count; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = value;
        count++;
    }

    // index 위치의 값 삭제
    public void remove(int index) {
        if (index < 0 || index >= count) {
            System.out.println("인덱스 오류: " + index);
            return;
        }
        for (int i = index; i < count - 1; i++) {
            arr[i] = arr[i + 1];
        }
        count--;
    }

    // main 실행 예시는 문제에 주어진 대로 사용하시면 됩니다.
    public static void main(String[] args) {
        VArray v = new VArray(5);
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());

        for (int i = 0; i < 7; i++) {
            v.add(i);
        }
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();

        v.insert(3, 100);
        v.insert(5, 200);
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();

        v.remove(10);
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();

        for (int i = 50; i < 55; i++) {
            v.add(i);
        }
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();
    }
}