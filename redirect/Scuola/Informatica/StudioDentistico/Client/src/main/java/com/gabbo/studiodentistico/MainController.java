package com.gabbo.studiodentistico;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class MainController {
    private Stage addPatientStage;
    private Scene addPatientScene;
    private Parent root;
    private ComboBox comboBox;
    @FXML
    private Pane mainWindow;
    @FXML
    private MenuBar menubar;
    private FileManager file = new FileManager("file.json");
    private JSONParser parser = new JSONParser();


    @FXML
    private void switchScene() throws IOException {
        root = FXMLLoader.load(getClass().getResource("AddPatient.fxml"));
        addPatientStage = (Stage) menubar.getScene().getWindow();
        addPatientScene = new Scene(root);
        addPatientStage.setScene(addPatientScene);
        addPatientStage.setResizable(false);
        addPatientStage.setTitle("Aggiungi un paziente");
        addPatientStage.show();
    }

    @FXML
    private boolean getPatients() {
        mainWindow.getChildren().clear();
        double y = 10;
        JSONArray data = file.manage("r", null);
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
            comboBox.setContextMenu(new RemovePatient(comboBox));
            mainWindow.getChildren().add(comboBox);
            y += 40;
        }
        return true;
    }
}

class RemovePatient extends ContextMenu {
    public RemovePatient(ComboBox comboBox) {
        MenuItem removePatient = new MenuItem("Remove");
        removePatient.setOnAction(ev -> {
            System.out.println(comboBox.getId());
            ev.consume();
        });
        getItems().add(removePatient);
    }
}
