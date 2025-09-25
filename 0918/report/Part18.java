package kimhoon_report1;
import java.util.Scanner;

public class Part18 {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        int[] studentId = new int[10];
	        int[] score = new int[10];

	        System.out.println("10명 학생의 학번과 점수 입력");
	        for (int i = 0; i < 10; i++) {
	            while (true) {
	                System.out.print((i + 1) + ">>");
	                String line = sc.nextLine();
	                String[] parts = line.split(" ");
	                if (parts.length != 2) {
	                    System.out.println("경고!! 학번과 점수를 공백으로 구분하여 입력하세요.");
	                    continue;
	                }
	                try {
	                    studentId[i] = Integer.parseInt(parts[0]);
	                    score[i] = Integer.parseInt(parts[1]);
	                    break;
	                } catch (NumberFormatException e) {
	                    System.out.println("경고!! 정수를 입력하세요.");
	                }
	            }
	        }

	        while (true) {
	            System.out.print("학번으로 검색: 1, 점수로 검색: 2, 끝내려면 3>>");
	            int option;
	            try {
	                option = Integer.parseInt(sc.nextLine());
	            } catch (NumberFormatException e) {
	                System.out.println("경고!! 정수를 입력하세요.");
	                continue;
	            }

	            if (option == 3) {
	                System.out.println("프로그램을 종료합니다.");
	                break;
	            }

	            if (option == 1) { // 학번 검색
	                System.out.print("학번>>");
	                int id;
	                try {
	                    id = Integer.parseInt(sc.nextLine());
	                } catch (NumberFormatException e) {
	                    System.out.println("경고!! 정수를 입력하세요.");
	                    continue;
	                }
	                boolean found = false;
	                for (int i = 0; i < studentId.length; i++) {
	                    if (studentId[i] == id) {
	                        System.out.println(score[i] + "점");
	                        found = true;
	                        break;
	                    }
	                }
	                if (!found) {
	                    System.out.println(id + "학생은 없습니다");
	                }
	            } else if (option == 2) { // 점수 검색
	                System.out.print("점수>>");
	                int s;
	                try {
	                    s = Integer.parseInt(sc.nextLine());
	                } catch (NumberFormatException e) {
	                    System.out.println("경고!! 정수를 입력하세요.");
	                    continue;
	                }
	                boolean found = false;
	                System.out.print("점수가 " + s + "점인 학생은 ");
	                for (int i = 0; i < score.length; i++) {
	                    if (score[i] == s) {
	                        System.out.print(studentId[i] + " ");
	                        found = true;
	                    }
	                }
	                if (!found) {
	                    System.out.println("없습니다.");
	                } else {
	                    System.out.println();
	                }
	            } else {
	                System.out.println("1, 2, 3 중에서 입력하세요.");
	            }
	        }

	        sc.close();
	    }
	}
