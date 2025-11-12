package report_20251106;

import java.util.*;

public class ShoppingCostArrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> items = new ArrayList<>();
        ArrayList<Integer> prices = new ArrayList<>();

        // 품목과 가격 저장
        items.add("고추장"); prices.add(3000);
        items.add("만두"); prices.add(500);
        items.add("새우깡"); prices.add(1500);
        items.add("콜라"); prices.add(600);
        items.add("참치캔"); prices.add(2000);
        items.add("치약"); prices.add(1000);
        items.add("연어"); prices.add(2500);
        items.add("삼겹살"); prices.add(2500);

        System.out.println("쇼핑 비용을 계산해드립니다. 구입 가능 물건과 가격은 다음과 같습니다.");
        for (int i = 0; i < items.size(); i++)
            System.out.print("[" + items.get(i) + ", " + prices.get(i) + "] ");
        System.out.println();

        while (true) {
            System.out.print("물건과 개수를 입력하세요>>");
            String line = sc.nextLine().trim();

            if (line.equals("그만")) break;
            if (line.isEmpty()) continue;

            String[] tokens = line.split(" ");
            if (tokens.length % 2 != 0) {
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

                int index = items.indexOf(item);
                if (index == -1) {
                    System.out.println(item + "은 없는 상품입니다!");
                    error = true;
                    break;
                }
                total += prices.get(index) * quantity;
            }

            if (!error)
                System.out.println("전체 비용은 " + total + "원입니다.");
        }

        sc.close();
    }
}
