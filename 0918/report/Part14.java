package kimhoon_report1;
import java.util.Scanner;

public class Part14 {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("*****갬블링 게임을 시작합니다*****");

	        while (true) {
	            while (true) {
	                System.out.print("엔터키 입력>>");
	                sc.nextLine(); // 엔터키 대기

	                int a = (int)(Math.random() * 3);
	                int b = (int)(Math.random() * 3);
	                int c = (int)(Math.random() * 3);

	                System.out.println(a + " " + b + " " + c);

	                if (a == b && b == c) {
	                    System.out.println("성공! 대박났어요!");
	                    break;
	                }
	            }

	            System.out.print("계속 하시겠습니까?(yes/no)>>");
	            String cont = sc.nextLine();
	            if (cont.equalsIgnoreCase("no")) {
	                System.out.println("게임을 종료합니다");
	                break;
	            }
	        }

	        sc.close();
	    }
	}
