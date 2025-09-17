package kimhoon;

import java.util.Scanner;
public class Part3boon {
	public static void main(String[] args) {
		Scanner boonsic= new Scanner(System.in);
		System.out.println("****자바 분식입니다. 주문하면 금액을 알려드립니다. ****");
		System.out.print("떡볶이 몇 인분>>>");
		int duc= boonsic.nextInt();
		System.out.print("김말이 몇 인분>>>");
		int kim= boonsic.nextInt();
		System.out.print("쫄면 몇 인분>>>");
		int jol= boonsic.nextInt();
		
		int duc0=2000*duc;
		int kim0=1000*kim;
		int jol0=3000*jol;
		
		int sum=duc0+kim0+jol0;
		System.out.print("전체 금액은 "+sum+"원입니다");
	}
}
