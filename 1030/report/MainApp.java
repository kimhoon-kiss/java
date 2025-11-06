package main;

import util.Calc;  // util 패키지의 Calc 클래스를 불러옴

public class MainApp {
    public static void main(String[] args) {
        Calc c = new Calc(10, 20);
        System.out.println(c.sum());
    }
}
