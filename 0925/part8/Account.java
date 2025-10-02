package kimhoon_report2_20250925;
public class Account {
    private int balance;  // 계좌 잔액 저장 필드

    // 생성자: 초기 잔액 설정
    public Account(int balance) {
        this.balance = balance;
    }

    // 입금 메서드 (단일 금액)
    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // 입금 메서드 (배열의 여러 금액)
    public void deposit(int[] amounts) {
        for (int amount : amounts) {
            deposit(amount);
        }
    }

    // 출금 메서드
    // 요청 금액보다 잔액이 적으면 잔액만 출금
    public int withdraw(int amount) {
        if (amount > balance) {
            int allMoney = balance;
            balance = 0;
            return allMoney;
        } else {
            balance -= amount;
            return amount;
        }
    }

    // 잔액 조회 메서드
    public int getBalance() {
        return balance;
    }

    // main 메서드 (문제에서 준 예시 코드 포함)
    public static void main(String[] args) {
        Account a = new Account(100);       // 100원 예금
        a.deposit(5000);                    // 5000원 입금
        System.out.println("잔금은 " + a.getBalance() + "원입니다.");

        int[] bulk = {100, 500, 200, 700};
        a.deposit(bulk);                    // 배열에 있는 모든 돈 입금
        System.out.println("잔금은 " + a.getBalance() + "원입니다.");

        int money = 1000;                   // 인출하려는 금액
        int wMoney = a.withdraw(money);    // 출금 시도
        if (wMoney < money) {
            System.out.println(wMoney + "원만 인출");  // 잔액이 부족할 경우
        } else {
            System.out.println(wMoney + "원 인출");    // 충분한 잔액일 경우
        }

        System.out.println("잔금은 " + a.getBalance() + "원입니다.");
    }
}