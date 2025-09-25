package kimhoon_report1;
import java.util.Scanner;

public class Part10 {
	    public static void main(String[] args) {
	        int[][] arr = new int[4][4];
	        Scanner sc = new Scanner(System.in);

	        System.out.println("4X4 배열에 랜덤한 값을 저장한 후 출력합니다");
	        for (int i = 0; i < 4; i++) {
	            for (int j = 0; j < 4; j++) {
	                arr[i][j] = (int)(Math.random() * 256); // 0~255 랜덤
	                System.out.print(arr[i][j] + "\t");
	            }
	            System.out.println();
	        }

	        System.out.print("임계값 입력>>");
	        int threshold = sc.nextInt();

	        System.out.println("임계값 적용 후 배열:");
	        for (int i = 0; i < 4; i++) {
	            for (int j = 0; j < 4; j++) {
	                if (arr[i][j] > threshold) {
	                    arr[i][j] = 255;
	                } else {
	                    arr[i][j] = 0;
	                }
	                System.out.print(arr[i][j] + "\t");
	            }
	            System.out.println();
	        }

	        sc.close();
	    }
	}
