package com.gabbo.studiodentistico;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainController {
    private Stage addPatientStage;
    private Scene addPatientScene;
    private Parent root;

    private Actions action = new Actions();

    @FXML
    private MenuBar menubar;


    @FXML
    private void switchScene(ActionEvent ev) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AddPatient.fxml"));
        addPatientStage = (Stage) menubar.getScene().getWindow();
        addPatientScene = new Scene(root);
        addPatientStage.setScene(addPatientScene);
        addPatientStage.show();
    }

    @FXML
    private void getPatients() {

    }
}
