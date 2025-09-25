package kimhoon_report1;

public class Part7 {
	    public static void main(String[] args) {
	        int[] numbers = new int[10];
	        int sum = 0;

	        System.out.print("랜덤한 정수들...");
	        for (int i = 0; i < numbers.length; i++) {
	            numbers[i] = (int)(Math.random() * 9) + 11; // 11~19 랜덤
	            System.out.print(numbers[i] + " ");
	            sum += numbers[i];
	        }

	        double average = sum / 10.0;
	        System.out.println("\n평균은 " + average);
	    }
	}
