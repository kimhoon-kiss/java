package kimhoon_report1;

public class Part1_1 {
    public static void main(String[] args) {
        int sum = 0, i = 1;
        while (true) {  // true로 수정
            if (i > 50)
                break;
            sum = sum + i;
            i += 3;
        }
        System.out.println(sum);
    }
}
