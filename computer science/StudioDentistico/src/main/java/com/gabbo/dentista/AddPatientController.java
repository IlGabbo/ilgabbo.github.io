package com.gabbo.dentista;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.IOException;


public class AddPatientController {
    @FXML
    private TextField name, surname, age, phonenumber;
    @FXML
    private TextArea pathology;
    @FXML
    private Label result;


    private Stage addPatientStage;
    private Scene addPatientScene;
    private Parent root;
    private JSONArray jsonArray = new JSONArray();

    private boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @FXML
    private void savePatient() {
        FileManager file = new FileManager("file.json");
        jsonArray = file.manage("r", null);
        System.out.println(jsonArray);
        if (isNumber(age.getText())) {
            JSONObject json = new JSONObject();
            json.put("name", name.getText());
            json.put("surname", surname.getText());
            json.put("age", age.getText());
            json.put("phonenumber", phonenumber.getText());
            json.put("pathology", pathology.getText());
            jsonArray.add(json);
            JSONArray arr =  file.manage("w", jsonArray);
            JSONObject obj = (JSONObject) arr.get(0);
            if (obj.get("status").equals("SuccessfullyWritten")) {
                result.setText("Paziente salvato");
                result.setTextFill(Color.color(0,1,0));
                resetFields();
            } else {
                result.setText("Errore nella scrittura");
                result.setTextFill(Color.color(1,0,0));
            }
        } else {
            result.setText("Inserisci un'età valida");
            result.setTextFill(Color.color(1,0,0));
        }
    }

    @FXML
    private void resetFields() {
        name.setText("");
        surname.setText("");
        age.setText("");
        phonenumber.setText("");
        pathology.setText("");
    }

    @FXML
    private void back(ActionEvent ev) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        addPatientStage = (Stage)((Node)ev.getSource()).getScene().getWindow();
        addPatientScene = new Scene(root);
        addPatientStage.setScene(addPatientScene);
        addPatientStage.setTitle("Studio Dentistico Rossi");
        addPatientStage.show();
    }
}
