package report_20251106;

import java.util.*;

class Location {
    private String name;
    private double latitude;
    private double longitude;

    public Location(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return name + "\n" + latitude + "\n" + longitude;
    }
}

public class LocationManagerArrayList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Location> list = new ArrayList<>();

        System.out.println("도시, 경도, 위도를 입력하세요.");
        for (int i = 0; i < 4; i++) {
            System.out.print(">> ");
            String text = scanner.nextLine();
            String[] parts = text.split(",\\s*");
            String name = parts[0];
            double latitude = Double.parseDouble(parts[1]);
            double longitude = Double.parseDouble(parts[2]);
            list.add(new Location(name, latitude, longitude));
        }

        System.out.println("--------------------------------------------------------------");
        for (Location city : list) {
            System.out.println(city);
            System.out.println();
        }
        System.out.println("--------------------------------------------------------------");

        while (true) {
            System.out.print("도시 이름 >> ");
            String name = scanner.nextLine();
            if (name.equals("그만"))
                break;

            boolean found = false;
            for (Location city : list) {
                if (city.getName().equals(name)) {
                    System.out.println(city);
                    found = true;
                    break;
                }
            }

            if (!found)
                System.out.println(name + "는 없습니다.");
        }

        scanner.close();
    }
}
