package com.gabbo.studiodentistico;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;
import java.util.ArrayList;

public class Sql {

    private JSONArray patients = new JSONArray();

    private Connection connection;
    public boolean connectToDb() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:denti.db");
            Statement stat = connection.createStatement();
            stat.execute("create table if not exists patients(name, surname, age, phonenumber, pathology)");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean savePatient(String name, String surname, String age, String phonenumber, String pathology) {
        if (connectToDb()) {
            try {
                PreparedStatement stat = connection.prepareStatement("insert into patients(name, surname, age, phonenumber, pathology) values (?,?,?,?,?)");
                stat.setString(1, name);
                stat.setString(2, surname);
                stat.setString(3, age);
                stat.setString(4, phonenumber);
                stat.setString(5, pathology);
                stat.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    public JSONArray readDb() {
        if (connectToDb()) {
            try {
                Statement stat = connection.createStatement();
                ResultSet result = stat.executeQuery("select * from patients");

                while (result.next()) {
                    JSONObject json = new JSONObject();
                    json.put("name", result.getString("name"));
                    json.put("surname", result.getString("surname"));
                    json.put("age", result.getString("age"));
                    json.put("phonenumber", result.getString("phonenumber"));
                    json.put("pathology", result.getString("pathology"));
                    patients.put(json);
                }

            } catch (SQLException e) {
                e.printStackTrace();
                patients.put("SqlReadError");
            }
        } else {
            patients.put("SqlConnectionError");
        }

        return patients;
    }
}
