package kimhoon;
import java.util.Scanner;

public class Part4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력 받기
        System.out.print("여행지>>> ");
        String destination = sc.nextLine();

        System.out.print("인원수>>> ");
        int people = sc.nextInt();

        System.out.print("숙박일>>> ");
        int nights = sc.nextInt();

        System.out.print("1인당 항공료>>> ");
        int flightCost = sc.nextInt();

        System.out.print("1방 숙박비>>> ");
        int roomCost = sc.nextInt();

        // 방 개수 계산 (2명까지 1방, 홀수면 +1)
        int rooms = (people + 1) / 2;

        // 총 경비 계산
        int totalCost = (flightCost * people) + (roomCost * nights * rooms);

        // 출력
        System.out.println();
        System.out.println(people + "명의 " + destination + " " + nights + "박" + (nights + 1) + "일 여행에는 "
                + "방이 " + rooms + "개 필요하며 경비는 " + totalCost + "원 입니다");

        sc.close();
    }
}
