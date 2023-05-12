package com.gabbo.studiodentistico;


import javafx.collections.FXCollections;
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
    private void getPatients() {
        file.printPatients(mainWindow);
    }
}

class RemovePatient extends ContextMenu {
    private FileManager file = new FileManager("file.json");
    public RemovePatient(ComboBox comboBox, Pane mainWindow) {
        MenuItem removePatient = new MenuItem("Remove");
        removePatient.setOnAction(ev -> {
            if (removePatient(comboBox)) {
                System.out.println("Done");
                file.printPatients(mainWindow);
            } else {
                System.out.println("F");
            }
            ev.consume();
        });
        getItems().add(removePatient);
    }

    private boolean removePatient(ComboBox comboBox) {
        JSONArray arr = file.manage("r", null);
        arr.remove(Integer.parseInt(comboBox.getId()));
        JSONObject obj = (JSONObject) file.manage("w", arr).get(0);
        if (!obj.get("status").equals("SuccessfullyWritten")) {
            return false;
        }
        return true;
    }
}
