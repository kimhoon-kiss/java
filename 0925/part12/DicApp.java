package kimhoon_report2_20250925;

import java.util.Scanner;

class Dictionary {
    private String[] kor = { "사랑", "아기", "돈", "미래", "희망", "행복" };
    private static String[] eng = { "love", "baby", "money", "future", "hope", "happy" };

    public String kor2Eng(String word) {
        for (int i = 0; i < kor.length; i++) {
            if (kor[i].equals(word)) {
                return eng[i];
            }
        }
        return null;
    }
}

public class DicApp {
    public static void main(String[] args) {
        Dictionary dict = new Dictionary();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("한글 단어? ");
            String word = sc.nextLine();
            if (word.equals("그만")) {
                System.out.println("그만 입력하면 프로그램 종료");
                break;
            }
            String result = dict.kor2Eng(word);
            if (result == null) {
                System.out.println("없는 단어입니다.");
            } else {
                System.out.println(word + "의 영어단어는 " + result);
            }
        }
        sc.close();
    }
}