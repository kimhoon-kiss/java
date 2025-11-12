package report_20251106;

import java.util.*;

public class ShoppingCostHashMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> priceMap = new HashMap<>();

        // 미리 물건과 가격 저장
        priceMap.put("고추장", 3000);
        priceMap.put("만두", 500);
        priceMap.put("새우깡", 1500);
        priceMap.put("콜라", 600);
        priceMap.put("참치캔", 2000);
        priceMap.put("치약", 1000);
        priceMap.put("연어", 2500);
        priceMap.put("삼겹살", 2500);

        System.out.println("쇼핑 비용을 계산해드립니다. 구입 가능 물건과 가격은 다음과 같습니다.");
        for (String item : priceMap.keySet())
            System.out.print("[" + item + ", " + priceMap.get(item) + "] ");
        System.out.println();

        while (true) {
            System.out.print("물건과 개수를 입력하세요>>");
            String line = sc.nextLine().trim();

            if (line.equals("그만")) break;
            if (line.isEmpty()) continue;

            String[] tokens = line.split(" ");
            if (tokens.length % 2 != 0) { // 물건-개수 짝이 안 맞는 경우
                System.out.println("입력에 문제가 있습니다!");
                continue;
            }

            int total = 0;
            boolean error = false;

            for (int i = 0; i < tokens.length; i += 2) {
                String item = tokens[i];
                int quantity = 0;

                try {
                    quantity = Integer.parseInt(tokens[i + 1]);
                } catch (NumberFormatException e) {
                    error = true;
                    break;
                }

                if (!priceMap.containsKey(item)) {
                    System.out.println(item + "은 없는 상품입니다!");
                    error = true;
                    break;
                }
                total += priceMap.get(item) * quantity;
            }

            if (!error)
                System.out.println("전체 비용은 " + total + "원입니다.");
        }
        sc.close();
    }
}
