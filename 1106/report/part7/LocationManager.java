package report_20251106;

import java.util.*;

//도시 정보를 담는 클래스
class Location {
 private String name;
 private double latitude;  // 위도
 private double longitude; // 경도

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

//도시를 관리하는 클래스
public class LocationManager {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     HashMap<String, Location> map = new HashMap<>();

     System.out.println("도시, 경도, 위도를 입력하세요.");
     for (int i = 0; i < 4; i++) {
         System.out.print(">> ");
         String text = scanner.nextLine();
         String[] parts = text.split(",\\s*"); // 쉼표+공백 구분
         String name = parts[0];
         double latitude = Double.parseDouble(parts[1]);
         double longitude = Double.parseDouble(parts[2]);
         map.put(name, new Location(name, latitude, longitude));
     }

     System.out.println("--------------------------------------------------------------");

     // 모든 도시 정보 출력
     for (String key : map.keySet()) {
         System.out.println(map.get(key));
         System.out.println();
     }

     System.out.println("--------------------------------------------------------------");

     // 검색 기능
     while (true) {
         System.out.print("도시 이름 >> ");
         String name = scanner.nextLine();
         if (name.equals("그만"))
             break;
         Location city = map.get(name);
         if (city == null)
             System.out.println(name + "는 없습니다.");
         else
             System.out.println(city);
     }

     scanner.close();
 }
}
