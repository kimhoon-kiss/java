package kimhoon;

import java.util.Scanner;
public class Part1_daler {
	public static void main(String[] args) {
		Scanner one=new Scanner(System.in);
		System.out.print("$1=1200원입니다 달러를 입력하세요>>");
		int daluer =one.nextInt();
		int daluer0=daluer*1200;
		System.out.print("$"+daluer+"는 "+daluer0+"원입니다");
		
		one.close();
	}
	
}
