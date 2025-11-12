package report_20251106;

import java.util.*;

public class VirtualMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> memory = new HashMap<>(); // 변수 저장소
        ArrayList<String> program = new ArrayList<>();     // 명령어 리스트

        System.out.println("나의 가상 컴퓨터가 작동합니다. 프로그램을 입력해주세요. 80를 입력하면 작동합니다.");

        while (true) {
            System.out.print(">> ");
            String input = scanner.nextLine().trim();

            if (input.equals("80")) { // 프로그램 실행 준비
                System.out.println("프로그램을 입력하세요. 'go'를 입력하면 실행합니다.");
                program.clear();

                while (true) {
                    System.out.print(program.size() + ">> ");
                    String line = scanner.nextLine().trim();
                    if (line.equals("go"))
                        break;
                    program.add(line);
                }

                runProgram(program, memory);
            }
        }
    }

    // 프로그램 실행 메서드
    public static void runProgram(ArrayList<String> program, HashMap<String, Integer> memory) {
        int pc = 0; // Program Counter

        while (pc < program.size()) {
            String[] tokens = program.get(pc).split("\\s+");
            String cmd = tokens[0];

            switch (cmd) {
                case "mov": { // mov x y → x에 y 저장
                    String var = tokens[1];
                    String value = tokens[2];
                    int val = getValue(value, memory);
                    memory.put(var, val);
                    pc++;
                    break;
                }

                case "add": { // add x y → x = x + y
                    String var1 = tokens[1];
                    String var2 = tokens[2];
                    int val = getValue(var2, memory);
                    memory.put(var1, memory.getOrDefault(var1, 0) + val);
                    pc++;
                    break;
                }

                case "sub": { // sub x y → x = x - y
                    String var1 = tokens[1];
                    String var2 = tokens[2];
                    int val = getValue(var2, memory);
                    memory.put(var1, memory.getOrDefault(var1, 0) - val);
                    pc++;
                    break;
                }

                case "jne": { // jne x n → x != 0이면 n번째 명령으로 점프
                    String var = tokens[1];
                    int line = Integer.parseInt(tokens[2]);
                    int value = memory.getOrDefault(var, 0);
                    if (value != 0) pc = line;
                    else pc++;
                    break;
                }

                case "prt": { // prt x → x값 출력
                    String var = tokens[1];
                    int value = memory.getOrDefault(var, 0);
                    System.out.println("[prt " + var + "]에 의해 출력된 " + var + " 변수 값: " + value);
                    pc++;
                    break;
                }

                case "exi": { // exi → 종료
                    System.out.println("프로그램 실행 종료, 변수들의 최종 값을 출력합니다.");
                    for (String key : memory.keySet()) {
                        System.out.println(key + ":" + memory.get(key));
                    }
                    return;
                }

                default:
                    System.out.println("⚠ 알 수 없는 명령어: " + cmd);
                    pc++;
            }
        }
    }

    // 숫자인지 변수인지 구분해 값 가져오기
    public static int getValue(String s, HashMap<String, Integer> memory) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return memory.getOrDefault(s, 0);
        }
    }
}
