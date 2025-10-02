package kimhoon_report2_20250925;

public class TV {
    private String manufacturer;
    private int price;
    private int size;

    public TV(String manufacturer, int price, int size) {
        this.manufacturer = manufacturer;
        this.price = price;
        this.size = size;
    }

    public void show() {
        System.out.println(manufacturer + "에서 만든 " + price + "원짜리 " + size + "인치 TV");
    }

    public static void main(String[] args) {
        TV tv = new TV("Samsung", 300, 50);
        tv.show();
    }
}