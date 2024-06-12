package org.example;

import java.util.*;

class Wall {
    public String paintBrand;
    public float length;
    public float width;
    public float area;
    public float paintNeeded;

    public Wall(String paintBrand, float length, float width, float coverage) {
        this.paintBrand = paintBrand;
        this.length = length;
        this.width = width;
        this.area = length * width;
        this.paintNeeded = this.area / coverage;
    }
}

class Room {
    List<Wall> walls;

    public Room() {
        walls = new ArrayList<>();
    }

    public void addWall(Wall wall) {
        walls.add(wall);
    }
}

class Main {
   private static String[] PAINT_BRANDS = {"Dulux", "Crown", "Farrow & Ball", "Johnstone's", "Leyland"};
   private static int coverage = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the number of rooms: ");
        int numberOfRooms = Integer.parseInt(scanner.nextLine());

        List<Room> rooms = new ArrayList<>();
        Map<String, Double> paintRequired = new HashMap<>();

        for (int i = 0; i < numberOfRooms; i++) {
            Room room = new Room();

            System.out.printf("Enter the number of walls for room %d: ", i + 1);
            int numberOfWalls = Integer.parseInt(scanner.nextLine());

            for (int j = 0; j < numberOfWalls; j++) {
                System.out.printf("Select paint brand for wall %d (0: Dulux, 1: Crown, 2: Farrow & Ball, 3: Johnstone's, 4: Leyland): ", j + 1);
                int paintBrandIndex = Integer.parseInt(scanner.nextLine());
                String paintBrand = PAINT_BRANDS[paintBrandIndex];

                System.out.printf("Enter the length of wall %d: ", j + 1);
                float length = Float.parseFloat(scanner.nextLine());

                System.out.printf("Enter the width of wall %d: ", j + 1);
                float width = Float.parseFloat(scanner.nextLine());

                Wall wall = new Wall(paintBrand, length, width, coverage);
                room.addWall(wall);

                double currentPaint = paintRequired.getOrDefault(paintBrand, 0.0);
                paintRequired.put(paintBrand, currentPaint + wall.paintNeeded);
            }
            rooms.add(room);
        }
        scanner.close();
    }

}