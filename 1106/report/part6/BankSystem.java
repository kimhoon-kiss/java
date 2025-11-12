package report_20251106;

import java.util.*;

public class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> account = new HashMap<>();

        System.out.println("*** 명품 은행에 오신 것을 환영합니다. ***");

        while (true) {
            System.out.print("입금:1, 출금:2, 조회:3, 전체 조회:4, 종료:5>>");
            int choice = sc.nextInt();

            if (choice == 5) { // 종료
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            switch (choice) {
                case 1: // 입금
                    System.out.print("계좌명과 액수>>");
                    String name1 = sc.next();
                    int deposit = sc.nextInt();

                    // 기존 계좌면 누적, 없으면 새로 생성
                    account.put(name1, account.getOrDefault(name1, 0) + deposit);
                    break;

                case 2: // 출금
                    System.out.print("계좌명과 액수>>");
                    String name2 = sc.next();
                    int withdraw = sc.nextInt();

                    if (!account.containsKey(name2)) {
                        System.out.println("없는 계좌입니다!");
                        break;
                    }

                    int balance = account.get(name2);
                    if (balance < withdraw) {
                        System.out.println("잔액이 부족하여 출금할 수 없음!!");
                    } else {
                        account.put(name2, balance - withdraw);
                    }
                    break;

                case 3: // 개별 조회
                    System.out.print("계좌명>>");
                    String name3 = sc.next();
                    if (!account.containsKey(name3)) {
                        System.out.println("없는 계좌입니다!");
                    } else {
                        System.out.println("(" + name3 + ": " + account.get(name3) + "원)");
                    }
                    break;

                case 4: // 전체 조회
                    for (Map.Entry<String, Integer> entry : account.entrySet()) {
                        System.out.print("(" + entry.getKey() + ": " + entry.getValue() + "원) ");
                    }
                    System.out.println();
                    break;

                default:
                    System.out.println("잘못된 선택입니다!");
            }
        }

        sc.close();
    }
}
