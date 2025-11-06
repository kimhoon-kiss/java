package kimhn_report4_20251105;

import java.util.Scanner;

public class LetterHistogram {

    // 입력받는 메소드
    static String readString() {
        StringBuffer sb = new StringBuffer();  // 입력 누적용
        Scanner scanner = new Scanner(System.in);
        System.out.println("영문 텍스트를 입력하고 세미콜론(;)을 입력하세요.");

        while (true) {
            String line = scanner.nextLine();  // 한 줄 입력
            if (line.equals(";"))  // 세미콜론만 있으면 입력 종료
                break;
            sb.append(line).append(" ");  // 입력 누적 (공백 추가)
        }
        return sb.toString();
    }

    // 메인 실행
    public static void main(String[] args) {
        String text = readString();  // 전체 입력
        int[] count = new int[26];   // A~Z 카운트 배열

        // 문자 하나씩 확인
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isLetter(ch)) { // 알파벳이면
                ch = Character.toUpperCase(ch); // 대문자로 통일
                count[ch - 'A']++;
            }
        }

        // 히스토그램 출력
        System.out.println("\n히스토그램을 그립니다");
        for (int i = 0; i < 26; i++) {
            System.out.print((char) ('A' + i));
            for (int j = 0; j < count[i]; j++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }
}
