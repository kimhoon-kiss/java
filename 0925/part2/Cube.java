package kimhoon_report2_20250925;

public class Cube {
    private int width;
    private int height;
    private int depth;

    public Cube(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public int getVolume() {
        return width * height * depth;
    }

    public void increase(int w, int h, int d) {
        this.width += w;
        this.height += h;
        this.depth += d;
    }

    public boolean isZero() {
        return width == 0 || height == 0 || depth == 0;
    }

    public static void main(String[] args) {
        Cube cube = new Cube(1, 2, 3);
        System.out.println("큐브의 부피는 " + cube.getVolume());
        cube.increase(1, 2, 3);
        System.out.println("큐브의 부피는 " + cube.getVolume());
        if (cube.isZero()) {
            System.out.println("큐브의 부피는 0");
        } else {
            System.out.println("큐브의 부피는 0이 아님");
        }
    }
}