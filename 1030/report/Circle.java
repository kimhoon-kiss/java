package component;

import graphic.Shape;  // Shape 클래스는 graphic 패키지에 있으므로 import 필요

public class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}
