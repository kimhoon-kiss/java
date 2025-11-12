package report_20251106;

import java.util.*;

public class WalkManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, ArrayList<Integer>> walkMap = new HashMap<>();

        System.out.println("*** 걸음수 관리 프로그램입니다. ***");

        // -------- 입력 단계 --------
        while (true) {
            System.out.print("이름과 걸음수>>");
            String name = scanner.next();

            if (name.equals("그만"))
                break;

            // 한 줄에 여러 개의 걸음 수를 입력받기 위해 남은 한 줄을 처리
            String line = scanner.nextLine().trim(); // 나머지 입력
            if (line.isEmpty()) continue;

            String[] steps = line.split("\\s+");

            // 이름이 이미 존재하면 기존 리스트에 추가, 없으면 새로 생성
            ArrayList<Integer> list = walkMap.getOrDefault(name, new ArrayList<>());
            for (String s : steps) {
                try {
                    list.add(Integer.parseInt(s));
                } catch (NumberFormatException e) {
                    System.out.println("⚠ 숫자가 아닌 입력이 포함되어 있습니다: " + s);
                }
            }
            walkMap.put(name, list);
        }

        // -------- 통계 계산 --------
        String topName = null;
        int maxSum = 0;

        for (String name : walkMap.keySet()) {
            ArrayList<Integer> list = walkMap.get(name);
            int sum = 0;
            for (int n : list)
                sum += n;

            if (sum > maxSum) {
                maxSum = sum;
                topName = name;
            }
        }

        System.out.println("걸음수가 가장 많은 사람은 " + topName + " " + maxSum + "보");

        // -------- 검색 단계 --------
        while (true) {
            System.out.print("검색할 이름>>");
            String search = scanner.next();

            if (search.equals("그만"))
                break;

            ArrayList<Integer> list = walkMap.get(search);
            if (list == null) {
                System.out.println(search + "은(는) 없는 학생입니다.");
            } else {
                int sum = 0;
                for (int n : list)
                    sum += n;
                double avg = (double) sum / list.size();

                for (int n : list)
                    System.out.print(n + " ");
                System.out.println("평균 " + (int) avg);
            }
        }

        System.out.println("프로그램을 종료합니다.");
        scanner.close();
    }
}
