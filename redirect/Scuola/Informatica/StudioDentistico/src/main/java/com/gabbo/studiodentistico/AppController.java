package com.gabbo.studiodentistico;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;

public class AppController {
    private Register registerForm = new Register();
    private Actions actions = new Actions();
    @FXML
    private TextField name, last_name, pathology;

    @FXML
    private void openRegisterForm() throws IOException {
        registerForm.show();
    }

    @FXML
    private void saveUser() {
        int errors = 0;
        if (Objects.equals(name.getText(), "")) {
            errors += 1;
        }
        if (Objects.equals(last_name.getText(), "")) {
            errors += 1;
        }
        if (Objects.equals(pathology.getText(), "")) {
            errors += 1;
        }

        if (errors > 1) {
            System.out.println("Fill all fields");
        } else {
            actions.saveUser(name.getText(), last_name.getText(), pathology.getText());
        }
    }

    @FXML
    private void resetFields() {
        name.setText("");
        last_name.setText("");
        pathology.setText("");
    }

    @FXML
    private void discard() {
        registerForm.close();
    }
}