package com.gabbo;
import java.util.Scanner;

public class MainClass {
    private static <Undefined> void print(Undefined ... arg) {  // Print undefined and unlimited given arguments on the same row
        for(Undefined args: arg) {
            System.out.print(args);
        }
    }
    private static boolean isNumber(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static void main(String[] args) {
        int choice = 0;
        String vehicle_type;
        Scanner k = new Scanner(System.in);

        Garage garage = new Garage();

        while (true) {
            print("\n"+"""
                    [0] Enter vehicle
                    [1] Exit vehicle
                    [2] Search for a vehicle and print its information
                    [3] Print available places
                    [4] Print occupied places
                    [5] Print all cars
                    [6] Exit                    
                    """);
            choice = k.nextInt();
            switch (choice) {
                case 0 -> {
                    print("Vehicle type (car, bike)");
                    vehicle_type = k.next();
                    print(garage.enterVehicle(vehicle_type));
                }
                case 1 -> {
                    print("License plate"+"\n");
                    String license_plate = k.next();
                    print(garage.exitVehicle(license_plate));
                }
                case 2 -> {
                    print("License plate"+"\n");
                    String license_plate = k.next();
                    print(garage.getVehiclesFromPlate(license_plate));
                }
                case 3 -> {
                    print("Car: " + garage.getCarAvailablePlaces()+"\n");
                    print("MotorBike: " + garage.getBikeAvailablePlaces()+"\n");
                }
                case 5 -> {
                    print(garage.getAllVehicles());
                }
                case 6 -> {
                    print("Leaving...");
                    System.exit(0);
                }
            }

        }

    }
}
