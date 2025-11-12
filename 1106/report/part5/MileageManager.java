package report_20251106;

import java.util.*;

public class MileageManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> mileage = new HashMap<>();

        System.out.println("*** 마일리지 관리 프로그램입니다. ***");

        while (true) {
            System.out.print("이름과 마일리지>>");
            String name = sc.next();
            if (name.equals("그만"))
                break;

            int point = sc.nextInt();

            // 기존 고객이면 누적
            if (mileage.containsKey(name)) {
                mileage.put(name, mileage.get(name) + point);
            } else {
                mileage.put(name, point);
            }
        }

        // 전체 고객 출력
        for (String name : mileage.keySet()) {
            System.out.print("(" + name + ": " + mileage.get(name) + ") ");
        }
        System.out.println();

        // 가장 마일리지가 높은 고객 찾기
        String maxName = null;
        int maxPoint = 0;

        for (Map.Entry<String, Integer> entry : mileage.entrySet()) {
            if (entry.getValue() > maxPoint) {
                maxPoint = entry.getValue();
                maxName = entry.getKey();
            }
        }

        if (maxName != null)
            System.out.println("가장 마일리지가 높은 고객은 " + maxName + "입니다.");
        else
            System.out.println("등록된 고객이 없습니다.");

        System.out.println("프로그램을 종료합니다.");
        sc.close();
    }
}
