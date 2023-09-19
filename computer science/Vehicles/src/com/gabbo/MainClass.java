package com.gabbo;

import java.util.ArrayList;
import java.util.Random;

class MainClass {
    public static void main(String[] args){
        ArrayList<Vehicle> vehicle_list = new ArrayList<>();
        Random random = new Random();

        vehicle_list.add(new Car("123456", "Ferrari", "Roma", false));
        vehicle_list.add(new Motorbike("11lll11", "Aprilia", "125", 500, false));
        vehicle_list.add(new Car("ddkkkda", "Alfa Romeo", "Giulia", false));
        vehicle_list.add(new Motorbike("dwadda", "Yamaha", "r125", 125, false));
        vehicle_list.add(new Motorbike("00000", "Ducati", "Panigale", 1000, false));

        for(int i=0; i<vehicle_list.size(); i++){
            vehicle_list.get(random.nextInt(3 - 1 + 1) + 1).setBroken();  // random breaking to vehicles
            if(vehicle_list.get(i).getStatus()){
                System.out.println("[" + i + "] " + vehicle_list.get(i).getLicensePlate());
            }
        }
    }
}
class Vehicle{
    private String license_plate;
    private String brand;
    private String model;
    private boolean broken = false;

    public Vehicle(String license_plate, String brand, String model, boolean broken){
        this.license_plate = license_plate;
        this.brand = brand;
        this.model = model;
        this.broken = broken;
    }

    public String getLicensePlate(){
        return license_plate;
    }

    public String getBrand(){
        return brand;
    }

    public String getModel(){
        return model;
    }

    public boolean getStatus(){
        return broken;
    }

    public void setBroken(){
        this.broken = true;
    }
}

class Car extends Vehicle{

    public Car(String license_plate, String brand, String model, boolean broken) {
        super(license_plate, brand, model, broken);
    }
}

class Motorbike extends Vehicle{
    public Motorbike(String license_plate, String brand, String model, int displacement, boolean broken) {
        super(license_plate, brand, model, broken);
    }
}