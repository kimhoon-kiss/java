package kimhoon_report3_20251002;
// TV 클래스는 이전 문제에서 사용했던 그대로입니다.
class TV {
    private int size;

    public TV(int size) {
        this.size = size;
    }

    protected int getSize() {
        return size;
    }
}

// ColorTV 클래스도 이전 문제에서 사용했던 그대로입니다.
class ColorTV extends TV {
    private int color;

    public ColorTV(int size, int color) {
        super(size);     // 부모 생성자 호출로 크기 초기화
        this.color = color; // 컬러 수 초기화
    }

    protected int getColor() { // SmartTV에서 컬러 정보를 사용하기 위해 추가 (protected)
        return color;
    }

    public void printProperty() {
        System.out.println(getSize() + "인치 " + color + "컬러");
    }
}

// SmartTV 클래스 작성
class SmartTV extends ColorTV {
    private String address; // IP 주소 필드 추가

    public SmartTV(String address, int size, int color) {
        super(size, color); // ColorTV의 생성자 호출하여 size와 color 초기화
        this.address = address; // IP 주소 초기화
    }

    @Override
    public void printProperty() {
        // "나의 Smart TV는 192.168.0.5 주소의 77인치 20000000컬러" 형태로 출력
        System.out.println("나의 Smart TV는 " + address + " 주소의 " + getSize() + "인치 " + getColor() + "컬러");
    }
}

// 실행을 위한 메인 클래스 (위 클래스들과 함께 하나의 파일에 넣어 실행할 수 있습니다)
public class TVApp {
    public static void main(String[] args) {
        // 이전 문제의 TV, ColorTV 코드도 이 파일에 함께 있어야 합니다.

        // SmartTV 예제 실행
        SmartTV smartTV = new SmartTV("192.168.0.5", 77, 20000000);
        smartTV.printProperty();
        // 예상 출력: 나의 Smart TV는 192.168.0.5 주소의 77인치 20000000컬러
    }
}