package com.gabbo;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class SQL {
    private static int car_places = 3;
    private static int bike_places = 5;
    static Connection conn = null;
    private static <Undefined> void print(Undefined ... arg) {  // Print undefined and unlimited given arguments on the same row
        for(Undefined args: arg) {
            System.out.print(args);
        }
    }
    public static boolean connectToDb() {
        try {
            String db_url = "jdbc:sqlite:src\\com\\gabbo\\database\\database.db";
            conn = DriverManager.getConnection(db_url);
            String sql_create_table = "CREATE TABLE IF NOT EXISTS parking(brand text NOT NULL, name text NOT NULL, license_plate text NOT NULL, date text NOT NULL, entrance_hour float, price float, type text)";
            String sql_create_places = "CREATE TABLE IF NOT EXISTS places(car_places int, bike_places int)";
            Statement stat = conn.createStatement();
            stat.execute(sql_create_table);
            stat.execute(sql_create_places);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static String insertNewVehicle(String brand, String name, String license_plate, String date, float entrance_hour, float price, String type) {
        try {
            String sql_insert_data = "INSERT INTO parking(brand, name, license_plate, date, entrance_hour, price, type) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stat = conn.prepareStatement(sql_insert_data);
            stat.setString(1, brand);
            stat.setString(2, name);
            stat.setString(3, license_plate);
            stat.setString(4, date);
            stat.setFloat(5, entrance_hour);
            stat.setFloat(6, price);
            stat.setString(7, type);
            stat.executeUpdate();
            return "\n"+"Vehicle added"+"\n";
        } catch (SQLException e) {
            e.printStackTrace();
            return "\n"+"Error while inserting vehicle"+"\n";
        }
    }
    public static String readFromTable(String license_plate) {
        boolean is_plate_found = false;
        try {
            String sql_read = "SELECT * FROM parking";
            String value = "";
            Statement stat = conn.createStatement();
            ResultSet result = stat.executeQuery(sql_read);
            while (result.next()) {
                if (result.getString("license_plate").equals(license_plate)) {
                    value = value + "Brand: " + result.getString("brand") + "\n" +
                            "Name: " + result.getString("name") + "\n" +
                            "License plate: " + result.getString("license_plate") + "\n" +
                            "Date: " + result.getString("date") + "\n" +
                            "Entrance hour: " + result.getFloat("entrance_hour") + "\n" +
                            "Price: €" + result.getFloat("price") + "\n" +
                            "Vehicle type: " + result.getString("type") + "\n";
                    is_plate_found = true;
                    break;
                } else {
                    is_plate_found = false;
                }
            }

            if (!is_plate_found) {
                value = "\n"+"No vehicle found with that license plate"+"\n";
            }
            return "-------------------------------------------" + "\n" +
                    value + "\n" +
                    "-------------------------------------------";
        } catch (SQLException e) {
            e.printStackTrace();
            return "\n"+"Error while reading to db"+"\n";
        }
    }

    public static String readAllFromTable() {
        try {
            String sql_read = "SELECT * FROM parking";
            String value = "";
            Statement stat = conn.createStatement();
            ResultSet result = stat.executeQuery(sql_read);
            while (result.next()) {
                value = value + "Brand: " + result.getString("brand") + "\n" +
                       "Name: " + result.getString("name") + "\n" +
                       "License plate: " + result.getString("license_plate") + "\n" +
                       "Date: " + result.getString("date") + "\n" +
                       "Entrance hour: " + result.getFloat("entrance_hour") + "\n" +
                       "Price: €" + result.getFloat("price") + "\n" +
                       "Vehicle type: " + result.getString("type") + "\n" +
                       "-----------------------------------------------------------" + "\n" ;
            }

            return value;
        } catch (SQLException e) {
            e.printStackTrace();
            return "\n" + "Error while reading to db" + "\n";
        }
    }

    public static String removeVehicle(String license_plate) {
        boolean does_license_plate_exists = false;
        String value = "";
        try {
            String sql_read = "SELECT * FROM parking";
            Statement stat = conn.createStatement();
            ResultSet result = stat.executeQuery(sql_read);
            while (result.next()) {
                if (license_plate.equals(result.getString("license_plate"))) {
                    String sql_delete = "DELETE FROM parking WHERE license_plate = ?";
                    PreparedStatement statement = conn.prepareStatement(sql_delete);
                    statement.setString(1, license_plate);
                    statement.executeUpdate();
                    does_license_plate_exists = true;
                    value = "\n" + "Successful vehicle exit" + "\n";
                    break;
                } else {
                    does_license_plate_exists = false;
                }
            }

            if (!does_license_plate_exists) {
                value = "\n" + "Invalid license plate" + "\n";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            value = "\n" + "Error while removing vehicle" + "\n";
        }
        return value;
    }

    public static int getCarAvailablePlaces() {
        try {
            String read_places = "SELECT * FROM places";
            Statement stat = conn.createStatement();
            ResultSet result = stat.executeQuery(read_places);
            if (result.getInt("car_places") != 0) {
                return result.getInt("car_places");
            } else {
                String insert_value = "INSERT INTO places(car_places) VALUES (15)";
                PreparedStatement in_stat = conn.prepareStatement(insert_value);
                in_stat.executeUpdate();
                String reread_places = "SELECT * FROM places";
                Statement read_stat = conn.createStatement();
                ResultSet read_result = read_stat.executeQuery(reread_places);
                return  read_result.getInt("car_places");
            }
        } catch (SQLException e) {
            return -1;  // Read error
        }
    }

    public static int getBikeAvailablePlaces() {
        try {
            String read_places = "SELECT * FROM places";
            Statement stat = conn.createStatement();
            ResultSet result = stat.executeQuery(read_places);
            if (result.getInt("bike_places") != 0) {
                return result.getInt("bike_places");
            } else {
                String insert_value = "INSERT INTO places(bike_places) VALUES (10)";
                PreparedStatement in_stat = conn.prepareStatement(insert_value);
                in_stat.executeUpdate();
                String reread_places = "SELECT * FROM places";
                Statement read_stat = conn.createStatement();
                ResultSet read_result = read_stat.executeQuery(reread_places);
                return read_result.getInt("bike_places");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;  // Read error
        }
    }
}
