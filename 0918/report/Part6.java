package kimhoon_report1;
import java.util.Scanner;

public class Part6 {
	    public static int digitSum(int num) {
	        int sum = 0;
	        while (num > 0) {
	            sum += num % 10; // 마지막 자리수 더하기
	            num /= 10;       // 마지막 자리수 제거
	        }
	        return sum;
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int[] numbers = new int[10];

	        System.out.print("양의 정수 10개 입력>>");
	        for (int i = 0; i < numbers.length; i++) {
	            numbers[i] = sc.nextInt();
	        }

	        System.out.print("자리수의 합이 9인 것은 ...");
	        for (int i = 0; i < numbers.length; i++) {
	            if (digitSum(numbers[i]) == 9) {
	                System.out.print(numbers[i] + " ");
	            }
	        }

	        sc.close();
	    }
	}
