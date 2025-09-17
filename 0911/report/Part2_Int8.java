package kimhoon;

import java.util.Scanner;
public class Part2_Int8 {
	public static void main(String[] args) {
		Scanner birthday=new Scanner(System.in);
		System.out.print("생일을 입력하세요>>");
		
		int barithday8=birthday.nextInt();		//8자리 입력
		
		int year= barithday8/10000; 
		int month=(barithday8/100)%100; 
		int day=barithday8 % 100;
		
		System.out.println(year + "년 " + month + "월 " + day + "일");
		
		birthday.close();
	}
}
