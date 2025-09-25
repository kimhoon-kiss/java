package kimhoon_report1;

public class Part1_0 {

	public static void main(String[] args) {
		int sum = 0, i = 1;
		while (true) {          
		    if(i > 50)
		        break;
		    sum = sum + i;
		    i += 3;
		}
		System.out.println(sum);
	}

}
//답:1부터 50까지 3씩 증가하는 수들의 합을 계산합니다.