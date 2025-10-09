package kimhoon_report3_20251002;

class TV {
    private int size;

    public TV(int size) {
        this.size = size;
    }

    protected int getSize() {
        return size;
    }
}

class ColorTV extends TV {
    private int color;

    public ColorTV(int size, int color) {
        super(size);     // 부모 생성자 호출로 크기 초기화
        this.color = color; // 컬러 수 초기화
    }

    public void printProperty() {
        System.out.println(getSize() + "인치 " + color + "컬러");
    }
}

public class Main {
    public static void main(String[] args) {
        ColorTV myTv = new ColorTV(65, 65536);
        myTv.printProperty(); // 출력: 65인치 65536컬러
    }
}