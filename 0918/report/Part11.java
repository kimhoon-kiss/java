package kimhoon_report1;
import java.util.Scanner;

public class Part11 {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int wrongCount = 0;

	        System.out.println("*****구구단을 맞추는 퀴즈입니다. *****");

	        while (wrongCount < 3) {
	            int a = (int)(Math.random() * 9) + 1; // 1~9
	            int b = (int)(Math.random() * 9) + 1; // 1~9
	            int correct = a * b;

	            System.out.print(a + "x" + b + "=");
	            int answer = sc.nextInt();

	            if (answer == correct) {
	                System.out.println("정답입니다. 잘했습니다.");
	            } else {
	                wrongCount++;
	                if (wrongCount < 3) {
	                    System.out.println(wrongCount + "번 틀렸습니다. 분발하세요");
	                } else {
	                    System.out.println(wrongCount + "번 틀렸습니다. 퀴즈 종료합니다.");
	                }
	            }
	        }

	        sc.close();
	    }
	}
