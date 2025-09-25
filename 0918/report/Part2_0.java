package kimhoon_report1;

public class Part2_0 {
	 public static void main(String[] args) { 
	int n[] = {1, -2, 6, 20, 5, 72, -16, 256};
	for(int i=0; i<n.length; i++){ 
		if(n[i]>0 && n[i] % 4 ==0){ 
			System.out.print(n[i]+" "); 
			} 
		}
	 }
}
//n 배열에서 양수이면서 4의 배수인 수만 출력하는 코드입니다. 	출력내용:20 72 256