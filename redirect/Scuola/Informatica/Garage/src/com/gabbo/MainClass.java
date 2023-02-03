package com.gabbo;
import java.util.Scanner;

public class MainClass {
    private static <Undefined> void print(Undefined ... arg) {  // Print undefined and unlimited given arguments on the same row
        for(Undefined args: arg) {
            System.out.print(args);
        }
    }

    public static void main(String[] args) {
        int choice = 0;
        String vehicle_type;
        Scanner k = new Scanner(System.in);

        Garage garage = new Garage();

        SQL.connectToDb();

        while (true) {
            print("\n"+"""
                    [0] Enter vehicle
                    [1] Exit vehicle
                    [2] Search for a vehicle and print its information
                    [3] Print available places
                    [4] Print all vehicles
                    [5] Exit                    
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
                case 4 -> {
                    print(garage.getAllVehicles());
                }
                case 5 -> {
                    print("Leaving...");
                    System.exit(0);
                }
            }

        }

    }
}
