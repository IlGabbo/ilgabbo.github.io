package com.gabbo.studiodentistico;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

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


    @FXML
    private void switchScene(ActionEvent ev) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AddPatient.fxml"));
        addPatientStage = (Stage) menubar.getScene().getWindow();
        addPatientScene = new Scene(root);
        addPatientStage.setScene(addPatientScene);
        addPatientStage.setResizable(false);
        addPatientStage.setTitle("Aggiungi un paziente");
        addPatientStage.show();
    }

    @FXML
    private void getPatients() {
        mainWindow.getChildren().clear();
        double y = 0;
        file.manage("r", null);

        comboBox = new ComboBox();  // to add multiple items in a single combo box
        comboBox.setPrefWidth(120);
        comboBox.setPrefHeight(30);
        comboBox.setLayoutX(30);
        comboBox.setLayoutY(y);
        mainWindow.getChildren().add(comboBox);
    }
}
