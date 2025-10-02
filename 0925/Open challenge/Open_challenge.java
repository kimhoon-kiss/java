package kimhoon_report2_20250925;

	import java.util.Scanner;

	// Player 클래스
	class Player {
	    private String name;
	    private Scanner sc;

	    public Player(String name, Scanner sc) {
	        this.name = name;
	        this.sc = sc;
	    }

	    public String getName() {
	        return name;
	    }

	    // 단어 입력받는 메소드
	    public String getWordFromUser() {
	        System.out.print(name + " >> ");
	        return sc.next();
	    }
	}

	// OpenChallenge 클래스
	public class Open_Challenge {
	    private Player[] players; // 참가자 배열
	    private int numOfPlayers;
	    private Scanner sc = new Scanner(System.in);

	    public void run() {
	        System.out.println("끝말잇기 게임을 시작합니다...");
	        System.out.print("게임에 참가하는 인원은 몇 명입니까?>> ");
	        numOfPlayers = sc.nextInt();
	        players = new Player[numOfPlayers];

	        // 참가자 이름 등록
	        for (int i = 0; i < numOfPlayers; i++) {
	            System.out.print("참가자 이름을 입력하세요>> ");
	            String name = sc.next();
	            players[i] = new Player(name, sc);
	        }

	        System.out.println("시작하는 단어는 아버지입니다.");
	        String word = "아버지";

	        int turn = 0; // 순서
	        while (true) {
	            Player currentPlayer = players[turn % numOfPlayers];
	            String newWord = currentPlayer.getWordFromUser();

	            // 끝말잇기 규칙 확인
	            char lastChar = word.charAt(word.length() - 1);
	            char firstChar = newWord.charAt(0);

	            if (lastChar != firstChar) {
	                System.out.println(currentPlayer.getName() + "이(가) 졌습니다.");
	                break;
	            }

	            word = newWord; // 단어 갱신
	            turn++;
	        }
	    }

	    public static void main(String[] args) {
	        Open_Challenge game = new Open_Challenge();
	        game.run();
	    }
	}

