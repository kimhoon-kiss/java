package kimhoon_report2_20250925;
import java.util.Scanner;

class Seat {
    private String type;
    private int number;
    private String name;

    public Seat(String type, int number) {
        this.type = type;
        this.number = number;
        this.name = "";  // 빈 자리 표시
    }

    public boolean isReserved() {
        return !name.equals("");
    }

    public String getName() {
        return name;
    }

    public void reserve(String name) {
        this.name = name;
    }

    public void cancel() {
        this.name = "";
    }

    public String toString() {
        if (name.equals("")) {
            return "---";
        } else {
            return name;
        }
    }

    public String getSeatInfo() {
        return type + number + ": " + toString();
    }
}

public class Concert {
    private Seat[] sSeats = new Seat[10];
    private Seat[] aSeats = new Seat[10];
    private Seat[] bSeats = new Seat[10];

    private Scanner scanner = new Scanner(System.in);

    public Concert() {
        for (int i = 0; i < 10; i++) {
            sSeats[i] = new Seat("S", i + 1);
            aSeats[i] = new Seat("A", i + 1);
            bSeats[i] = new Seat("B", i + 1);
        }
    }

    public void run() {
        System.out.println("명품콘서트 예약 시스템입니다.");
        while (true) {
            System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>> ");
            int menu = scanner.nextInt();

            switch (menu) {
                case 1: reserve(); break;
                case 2: show(); break;
                case 3: cancel(); break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 메뉴입니다. 다시 입력하세요.");
            }
        }
    }

    private void reserve() {
        System.out.print("좌석 구분 S(1), A(2), B(3)>> ");
        int seatType = scanner.nextInt();
        Seat[] seats;
        switch (seatType) {
            case 1: seats = sSeats; break;
            case 2: seats = aSeats; break;
            case 3: seats = bSeats; break;
            default:
                System.out.println("잘못된 좌석 구분입니다.");
                return;
        }

        showSeats(seats);

        System.out.print("이름>> ");
        String name = scanner.next();

        System.out.print("번호>> ");
        int number = scanner.nextInt();
        if (number < 1 || number > 10) {
            System.out.println("잘못된 번호입니다.");
            return;
        }

        if (seats[number - 1].isReserved()) {
            System.out.println("이미 예약된 자리입니다.");
        } else {
            seats[number - 1].reserve(name);
            System.out.println("예약이 완료되었습니다.");
        }
    }

    private void showSeats(Seat[] seats) {
        for (Seat seat : seats) {
            System.out.print(seat.toString() + " ");
        }
        System.out.println();
    }

    private void show() {
        System.out.print("S>> ");
        showSeats(sSeats);
        System.out.print("A>> ");
        showSeats(aSeats);
        System.out.print("B>> ");
        showSeats(bSeats);
        System.out.println("<<<조회를 완료하였습니다.>>>");
    }

    private void cancel() {
        System.out.print("이름>> ");
        String name = scanner.next();

        boolean found = false;
        found |= cancelInArray(sSeats, name);
        found |= cancelInArray(aSeats, name);
        found |= cancelInArray(bSeats, name);

        if (!found) {
            System.out.println("예약 내역이 없습니다.");
        } else {
            System.out.println("예약이 취소되었습니다.");
        }
    }

    private boolean cancelInArray(Seat[] seats, String name) {
        boolean cancelled = false;
        for (Seat seat : seats) {
            if (seat.getName().equals(name)) {
                seat.cancel();
                cancelled = true;
            }
        }
        return cancelled;
    }

    public static void main(String[] args) {
        Concert concert = new Concert();
        concert.run();
    }
}