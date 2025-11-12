package report_20251106;

import java.util.*;

//단어 클래스
class Word {
 private String english; // 영어 단어
 private String korean;  // 뜻

 public Word(String english, String korean) {
     this.english = english;
     this.korean = korean;
 }

 public String getEnglish() {
     return english;
 }

 public String getKorean() {
     return korean;
 }
}

//단어 퀴즈 클래스 (메인 포함)
public class WordQuiz {
 private Vector<Word> v = new Vector<>();
 private Scanner scanner = new Scanner(System.in);
 private Random rand = new Random();

 public WordQuiz() {
     // 단어 등록 (예시 17개)
     v.add(new Word("love", "사랑"));
     v.add(new Word("animal", "동물"));
     v.add(new Word("painting", "그림"));
     v.add(new Word("emotion", "감정"));
     v.add(new Word("baby", "아기"));
     v.add(new Word("error", "오류"));
     v.add(new Word("bear", "곰"));
     v.add(new Word("doll", "인형"));
     v.add(new Word("eye", "눈"));
     v.add(new Word("statue", "조각상"));
     v.add(new Word("picture", "사진"));
     v.add(new Word("human", "인간"));
     v.add(new Word("society", "사회"));
     v.add(new Word("deal", "거래"));
     v.add(new Word("look", "보기"));
     v.add(new Word("emotion", "감정"));
     v.add(new Word("art", "예술"));
 }

 // 랜덤 보기 4개 생성
 private boolean makeQuiz() {
     int answerIndex = rand.nextInt(v.size()); // 정답 단어 선택
     Word answerWord = v.get(answerIndex);

     // 보기 4개 (정답 포함)
     HashSet<Integer> optionsSet = new HashSet<>();
     optionsSet.add(answerIndex);

     while (optionsSet.size() < 4) {
         int n = rand.nextInt(v.size());
         optionsSet.add(n);
     }

     // 보기 순서 섞기
     ArrayList<Integer> optionsList = new ArrayList<>(optionsSet);
     Collections.shuffle(optionsList);

     // 문제 출력
     System.out.println(answerWord.getEnglish() + "?");
     for (int i = 0; i < 4; i++) {
         System.out.print("(" + (i + 1) + ")" + v.get(optionsList.get(i)).getKorean() + " ");
     }

     System.out.print(":>");
     int choice = scanner.nextInt();

     // -1이면 종료
     if (choice == -1) {
         return false;
     }

     // 정답 판별
     int correctIndex = optionsList.indexOf(answerIndex);
     if (choice - 1 == correctIndex) {
         System.out.println("Excellent!!\n");
     } else {
         System.out.println("No!!\n");
     }
     return true;
 }

 public void run() {
     System.out.println("\"명품영어\"의 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.");
     System.out.println("현재 " + v.size() + "개의 단어가 들어 있습니다.");

     while (true) {
         if (!makeQuiz()) {
             System.out.println("\"명품영어\"를 종료합니다...");
             break;
         }
     }
 }

 public static void main(String[] args) {
     WordQuiz quiz = new WordQuiz();
     quiz.run();
 }
}
