package kimhn_report4_20251105;

import java.util.Scanner;

public class StringRotate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("문자열을 입력하세요. 빈 칸이 있어도 되고 영어 한글 모두 됩니다.");
        String str = scanner.nextLine(); // 한 줄 전체 입력 받기

        int len = str.length();

        for (int i = 0; i < len; i++) {
            // 맨 앞 글자를 떼서 뒤로 붙이기
            String rotated = str.substring(1) + str.charAt(0);
            System.out.println(rotated);
            str = rotated; // 다음 회전을 위해 문자열 갱신
        }

        scanner.close();
    }
}
