package kimhoon_report1;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Part8 {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("정수 몇 개 저장하시겠습니까>>");
	        int n = sc.nextInt();

	        int[] numbers = new int[n];
	        Set<Integer> used = new HashSet<>(); // 중복 방지용
	        int sum = 0;
	        int count = 0;

	        System.out.print("랜덤한 정수들...");
	        while (count < n) {
	            int rand = (int)(Math.random() * 100) + 1; // 1~100
	            if (!used.contains(rand)) {
	                numbers[count] = rand;
	                used.add(rand);
	                System.out.print(rand + " ");
	                sum += rand;
	                count++;
	            }
	        }

	        double average = sum / (double)n;
	        System.out.println("\n평균은 " + average);

	        sc.close();
	    }
	}
