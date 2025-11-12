package report_20251106;

import java.util.*;

public class RemoveDuplicate {
    private ArrayList<String> arrayList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // 🔹 한 라인 입력받아 arrayList에 단어 저장
    private void read() {
        System.out.print("문자열들을 입력하세요>>");
        String line = scanner.nextLine();
        if (line.equals("그만")) {
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }

        // 공백 기준으로 분리 후 ArrayList에 저장
        String[] words = line.split("\\s+");
        arrayList.clear();
        for (String w : words)
            arrayList.add(w);
    }

    // 🔹 중복 문자열 제거 (핵심 부분)
    private void removeDuplicate() {
        int i = 0;
        while (i < arrayList.size()) {
            String src = arrayList.get(i);
            searchAndRemove(src, i + 1);
            i++;
        }
    }

    // 🔹 src와 동일한 문자열을 j번째 이후에서 모두 제거
    private void searchAndRemove(String src, int j) {
        while (j < arrayList.size()) {
            String dest = arrayList.get(j);
            if (src.equals(dest))
                arrayList.remove(j); // 같은 단어 제거
            else
                j++; // 다르면 다음으로
        }
    }

    // 🔹 결과 출력
    private void show() {
        for (String w : arrayList)
            System.out.print(w + " ");
        System.out.println();
    }

    // 🔹 main 동작
    public void run() {
        while (true) {
            read();
            removeDuplicate();
            show();
        }
    }

    public static void main(String[] args) {
        RemoveDuplicate app = new RemoveDuplicate();
        app.run();
    }
}
