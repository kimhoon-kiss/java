package kimhoon_report1;
import java.util.Scanner;

public class Part12 {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        String[] boyMiddleList = {"기", "민", "용", "종", "현", "진", "재", "승", "소", "상", "지"};
	        String[] boyLastList = {"태", "진", "광", "혁", "우", "철", "빈", "준", "구", "호", "석"};
	        String[] girlMiddleList = {"은", "원", "경", "수", "현", "예", "여", "송", "서", "채", "하"};
	        String[] girlLastList = {"진", "연", "경", "서", "리", "숙", "미", "원", "린", "희", "수"};

	        System.out.println("*****작명 프로그램이 실행됩니다*****");

	        while (true) {
	            System.out.print("남/여 선택>>");
	            String gender = sc.nextLine();

	            if (gender.equals("그만")) {
	                break;
	            } else if (!gender.equals("남") && !gender.equals("여")) {
	                System.out.println("남/여/그만 중에서 입력하세요");
	                continue;
	            }

	            System.out.print("성 입력>>");
	            String surname = sc.nextLine();

	            String middle, last;

	            if (gender.equals("남")) {
	                middle = boyMiddleList[(int)(Math.random() * boyMiddleList.length)];
	                last = boyLastList[(int)(Math.random() * boyLastList.length)];
	            } else {
	                middle = girlMiddleList[(int)(Math.random() * girlMiddleList.length)];
	                last = girlLastList[(int)(Math.random() * girlLastList.length)];
	            }

	            System.out.println("추천 이름:" + surname + middle + last);
	        }

	        sc.close();
	    }
	}
