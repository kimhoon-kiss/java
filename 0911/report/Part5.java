package kimhoon;

	import java.util.Scanner;

	public class Part5 {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        // 첫 번째 학생 입력
	        System.out.print("학생1>>> ");
	        String name1 = sc.next();      // 이름
	        int late1 = sc.nextInt();      // 지각 횟수
	        int absent1 = sc.nextInt();    // 결석 횟수

	        // 두 번째 학생 입력
	        System.out.print("학생2>>> ");
	        String name2 = sc.next();
	        int late2 = sc.nextInt();
	        int absent2 = sc.nextInt();

	        // 감점 계산
	        int penalty1 = late1 * 3 + absent1 * 8;
	        int penalty2 = late2 * 3 + absent2 * 8;

	        // 출석 점수 계산
	        int score1 = 100 - penalty1;
	        int score2 = 100 - penalty2;

	        // 감점 출력
	        System.out.print(name1 + "의 감점은 " + penalty1+", ");
	        System.out.println(name2 + "의 감점은 " + penalty2);

	        // 결과 비교
	        if (score1 > score2) {
	            System.out.print(name1 + "의 출석 점수가 높음. ");
	            System.out.println(name1 + " 출석 점수는 " + score1);
	        } else if (score2 > score1) {
	            System.out.print(name2 + "의 출석 점수가 높음. ");
	            System.out.println(name2 + " 출석 점수는 " + score2);
	        } else {
	            System.out.println("점수 동일 (" + score1 + "점)");
	        }

	        sc.close();
	    }
	}
