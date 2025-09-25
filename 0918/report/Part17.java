package kimhoon_report1;
import java.util.Scanner;

public class Part17 {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        String[] coffee = {"핫아메리카노", "아이스아메리카노", "카푸치노", "라떼"};
	        int[] price = {3000, 3500, 4000, 5000};

	        System.out.println("핫아메리카노,아이스아메리카노,카푸치노,라떼 있습니다.");

	        while (true) {
	            System.out.print("주문>>");
	            String line = sc.nextLine();

	            if (line.equals("그만")) {
	                break;
	            }

	            String[] parts = line.split(" ");
	            if (parts.length != 2) {
	                System.out.println("잔 수는 양의 정수로 입력해주세요");
	                continue;
	            }

	            String order = parts[0];
	            int count = 0;
	            try {
	                count = Integer.parseInt(parts[1]);
	                if (count <= 0) {
	                    System.out.println("잔 수는 양의 정수로 입력해주세요");
	                    continue;
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("잔 수는 양의 정수로 입력해주세요");
	                continue;
	            }

	            boolean found = false;
	            for (int i = 0; i < coffee.length; i++) {
	                if (coffee[i].equals(order)) {
	                    int total = price[i] * count;
	                    System.out.println("가격은 " + total + "원입니다.");
	                    found = true;
	                    break;
	                }
	            }

	            if (!found) {
	                System.out.println(order + "은 없는 메뉴입니다");
	            }
	        }

	        sc.close();
	    }
	}
