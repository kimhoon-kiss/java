package kimhoon;

import java.util.Scanner;
public class MoogFa {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("가위바위보 게임입니다. 가위, 바위, 보 중에서 입력하세요");
		System.out.print("철수 >>");
		String man=scanner.next();
		System.out.printf("영희 >>");
		String girl=scanner.next();
		
		if(man.equals(girl)) {
			System.out.println("비겼습니다");
		}else if(man.equals("가위")&& girl.equals("보")||
				man.equals("바위")&& girl.equals("가위")||
				man.equals("보")&& girl.equals("바위")
				) {
			System.out.print("철수가 이겼습니다");
		}else {
			System.out.print("영희가 이겼습니다");
		}
		scanner.close();
	}
}
