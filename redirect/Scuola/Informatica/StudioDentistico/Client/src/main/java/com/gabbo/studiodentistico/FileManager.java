package com.gabbo.studiodentistico;

import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class FileManager {
    String filename;
    public FileManager(String filename) {
        this.filename = filename;
    }
    private ComboBox comboBox;

    public JSONArray manage(String openmode, JSONArray content) {
        JSONArray status = new JSONArray();
        JSONObject key = new JSONObject();
        String st;
        switch (openmode) {
            case "w" -> {
                try {
                    BufferedWriter file = new BufferedWriter(new FileWriter(this.filename));
                    file.write(content.toJSONString());
                    file.close();
                    st = "SuccessfullyWritten";
                    key.put("status", st);
                    status.add(key);
                } catch (IOException e) {
                    e.printStackTrace();
                    st = "WriteError";
                    key.put("status", st);
                    status.add(key);
                }
            }
            case "r" -> {
                try {
                    BufferedReader file = new BufferedReader(new FileReader(this.filename));
                    Stream<String> lines = file.lines();
                    String data = lines.collect(Collectors.joining("\n"));
                    lines.close();
                    file.close();
                    try {
                        JSONParser parser = new JSONParser();
                        JSONArray arr = (JSONArray) parser.parse(data);
                        status = arr;
                    } catch (ParseException e) {
                        e.printStackTrace();
                        key.put("status", "ParseError");
                        status.add(key);
                    }

                } catch (IOException e) {
                    manage("w", new JSONArray());
                    st = "ReadError";
                    key.put("status", st);
                    status.add(key);
                }
            }
            default -> {
                st = "sas";
                key.put("status", st);
                status.add(key);
            }
        }

        return status;
    }

    public boolean printPatients(Pane mainWindow) {
        mainWindow.getChildren().clear();
        int y = 10;
        JSONArray data = manage("r", null);
        for (int i = 0; i < data.size(); i++) {
            JSONObject obj = (JSONObject) data.get(i);
            if (obj.get("status") != null) {
                return false;
            }
            comboBox = new ComboBox();  // to add multiple items in a single combo box
            comboBox.setId(String.valueOf(i));
            comboBox.setPrefWidth(150);
            comboBox.setPrefHeight(30);
            comboBox.setLayoutX(30);
            comboBox.setLayoutY(y);
            for (int j = 0; j < obj.size(); j++) {
                comboBox.setItems(FXCollections.observableArrayList(
                        "Name: " + obj.get("name"),
                        "Surname: " + obj.get("surname"),
                        "Age: " + obj.get("age"),
                        "Phonenumber: " + obj.get("phonenumber"),
                        "Pathology: " + obj.get("pathology")
                ));
            }
            comboBox.getSelectionModel().select(0);
            comboBox.setContextMenu(new RemovePatient(comboBox, mainWindow));
            mainWindow.getChildren().add(comboBox);
            y += 40;
        }
        return true;
    }
}
