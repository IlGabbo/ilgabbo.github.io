package com.gabbo;

import java.util.Scanner;

public class Garage {
    private static SQL sql = new SQL();

    private static <Undefined> void print(Undefined ... arg) {  // Print undefined and unlimited given arguments on the same row
        for(Undefined args: arg) {
            System.out.print(args);
        }
    }

    public static String enterVehicle(String type) {
        String brand, name, license_place, date;
        float entrance_hour;
        Scanner k = new Scanner(System.in);

        print("Brand" + "\n");
        brand = k.next();
        print("Name" + "\n");
        name = k.next();
        print("License plate" + "\n");
        license_place = k.next();
        print("Entry date" + "\n");
        date = k.next();
        print("Entrance hour" + "\n");
        entrance_hour = k.nextFloat();

        if (type.equalsIgnoreCase("car")) {
            if (getCarAvailablePlaces() >= 1) {
                return sql.insertNewVehicle(brand, name, license_place, date, entrance_hour, 2, "Car");
            } else {
                return "Not enough space";
            }
        } else if (type.equalsIgnoreCase("bike")) {
            if (getBikeAvailablePlaces() >= 1) {
                return sql.insertNewVehicle(brand, name, license_place, date, entrance_hour, 1, "Motorbike");
            } else {
                return "Not enough space";
            }
        } else {
            return type + " is not a valid vehicle type";
        }

    }

    public static String getVehiclesFromPlate(String license_plate) {
        return sql.readFromTable(license_plate);
    }

    public static String getAllVehicles() {
        return sql.readAllFromTable();
    }

    public static String exitVehicle(String license_plate) {
        return sql.removeVehicle(license_plate);
    }

    public static int getCarAvailablePlaces() {
        return sql.getCarAvailablePlaces();
    }

    public static int getBikeAvailablePlaces() {
        return sql.getBikeAvailablePlaces();
    }
}
