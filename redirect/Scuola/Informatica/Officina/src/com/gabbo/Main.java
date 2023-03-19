package com.gabbo;

class Main {
    public static void main(String[] args){
        Vehicle alfa_romeo = new Vehicle("Alfa Romeo", true);
        Vehicle ferrari = new Vehicle("Ferrari", false);
        Vehicle lambo = new Vehicle("Lamborghini", true);
        Officina officina = new Officina();

        if (officina.repair(alfa_romeo)) {
            System.out.println("Prezzo di riparazione di " + alfa_romeo.getBrand() + ": " + alfa_romeo.price());
        }
        if (officina.repair(ferrari)) {
            System.out.println("Prezzo di riparazione di " + ferrari.getBrand() + ": " + ferrari.price());
        }
        if (officina.repair(lambo)) {
            System.out.println("Prezzo di riparazione di " + lambo.getBrand() + ": " + lambo.price());
        }
    }
}

class Officina {
    static private boolean status;
    public static boolean repair(Vehicle vehicle){
        if (vehicle.getStatus()){
            switch(vehicle.getBrand()) {
                case "Alfa Romeo":
                    vehicle.changePrice(vehicle, 2000);
                    vehicle.editStatus();
                    break;
                case "Ferrari":
                    vehicle.changePrice(vehicle, 4000);
                    vehicle.editStatus();
                    break;
                case "Lamborghini":
                    vehicle.changePrice(vehicle, 6000);
                    vehicle.editStatus();
                    break;
            }
            status = true;
        } else{
            status = false;
        }
        return status;
    }
}

class Vehicle {
    private String brand;
    private double price;
    private boolean brokenCar;

    public Vehicle(String brand, boolean brokenCar){
        this.brand = brand;
        this.price = 20000;
        this.brokenCar = brokenCar;
    }

    public String getBrand(){
        return brand;
    }

    public double price(){
        return price;
    }

    public boolean getStatus(){
        return brokenCar;
    }

    public boolean editStatus(){
        if (getStatus()) {
            this.brokenCar = false;
        }
        return this.brokenCar;
    }

    public double changePrice(Vehicle vehicle, double value) { // to fix change price
        if (vehicle.brokenCar) {
            return price = value;
        }
        else {
            return 0;
        }
    }
}