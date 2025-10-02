package kimhoon_report2_20250925;
public class Average {
    private int[] scores = new int[10];  // 최대 10개 점수 저장 배열
    private int nextIndex = 0;            // 현재 저장 개수

    // 점수 저장 메서드
    public void put(int score) {
        if (nextIndex < scores.length) {
            scores[nextIndex++] = score;
        } else {
            System.out.println("저장 공간이 부족합니다.");
        }
    }

    // 저장된 모든 점수 출력 메서드
    public void showAll() {
        System.out.print("***** 저장된 데이터 모두 출력 *****\n");
        for (int i = 0; i < nextIndex; i++) {
            System.out.print(scores[i] + " ");
        }
        System.out.println();
    }

    // 평균 계산 및 반환 메서드
    public double getAvg() {
        if (nextIndex == 0) {
            return 0;  // 저장된 점수가 없으면 0 반환
        }
        int sum = 0;
        for (int i = 0; i < nextIndex; i++) {
            sum += scores[i];
        }
        return (double) sum / nextIndex;
    }

    // main 메서드 (문제에 주어진 예시 실행 코드 포함)
    public static void main(String[] args) {
        Average avg = new Average();

        avg.put(10);   // 10 저장
        avg.put(15);   // 15 저장
        avg.put(100);  // 100 저장

        avg.showAll(); // 저장된 모든 원소 출력

        System.out.println("평균은 " + avg.getAvg());  // 평균 출력
    }
}