package kimhoon_report1;
import java.util.Scanner;

public class Part3 {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int num;

	        // 양의 정수가 입력될 때까지 반복
	        do {
	            System.out.print("양의 정수 입력>>");
	            num = sc.nextInt();
	        } while (num <= 0);

	        // 별 출력
	        for (int i = num; i > 0; i--) {
	            for (int j = 0; j < i; j++) {
	                System.out.print("*");
	            }
	            System.out.println();
	        }

	        sc.close();
	    }
	}
