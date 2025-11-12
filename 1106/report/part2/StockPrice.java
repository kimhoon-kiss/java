package report_20251106;

import java.util.*;

public class StockPrice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();

        System.out.println("주식 종목과 주가를 입력하세요(예: 삼송전자 75000)");

        // 종목과 주가 입력
        while (true) {
            System.out.print("종목, 주가>>");
            String name = sc.next();
            if (name.equals("그만"))
                break;
            int price = sc.nextInt();
            map.put(name, price);
        }

        System.out.println("주가를 검색합니다.");

        // 종목 검색
        while (true) {
            System.out.print("종목>>");
            String name = sc.next();
            if (name.equals("그만"))
                break;
            Integer price = map.get(name);
            if (price == null)
                System.out.println(name + "은 없는 종목입니다.");
            else
                System.out.println(name + "의 주가는 " + price + "원");
        }

        sc.close();
    }
}
