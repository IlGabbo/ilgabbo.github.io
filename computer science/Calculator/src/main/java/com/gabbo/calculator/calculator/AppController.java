package com.gabbo.calculator.calculator;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AppController {
    @FXML
    private Label result, history;
    private String operation = "";
    private String displayed_operation = "";

    @FXML
    private void getButtonValue(Event e) {
        Object node = e.getSource();
        Button btn = (Button) node;
        String button_text = btn.getText();
        String button_id = btn.getId();
        switch (button_id) {
            case "calc" -> {
                if (!Objects.equals(operation, "0")) {
                    history.setText(displayed_operation);
                    displayed_operation = calc(operation);
                    operation = calc(operation);
                    System.out.println(operation + " CALC");
                } else {
                    history.setText("");
                }
                result.setText(displayed_operation);
            }
            case "ce_button", "c_button" -> {
                operation = "";
                history.setText("");
                displayed_operation = "";
            }
            case "delete_button" -> {
                if (result.getText() != "0") {
                    try {
                        operation = operation.substring(0, operation.length()-1);
                        displayed_operation = displayed_operation.substring(0, displayed_operation.length()-1);
                        result.setText(displayed_operation);
                    } catch (StringIndexOutOfBoundsException err) {
                        result.setText("0");
                    }
                }

            }
            case "onedividedx_button" -> {
                displayed_operation += "1/";
                operation += "1/";
            }
            case "raisedtosecond_button" -> {
                displayed_operation += "²";
            }
            case "percent_button" -> {
                operation += "%";
                displayed_operation += "%";
            }
            case "square_button" -> {
                displayed_operation += "√";
            }
            case "plus_or_minus" -> {
                operation += "-";
                displayed_operation += "-";
            }
            case "comma" -> {
                operation += ".";
                displayed_operation += ",";
            }
            case "multiplication_button" -> {
                operation += "*";
                displayed_operation += "x";
            }
            default -> {
                operation += button_text;
                displayed_operation += button_text;
            }
        }
        result.setText(displayed_operation);
    }

    @FXML
    private void closeWindow() {
        System.exit(0);
    }

    private String calc(String operation) {
        String res;
        Pattern pow = Pattern.compile("²");
        Pattern square = Pattern.compile("√");
        Pattern percent = Pattern.compile("%");
        if (pow.matcher(displayed_operation).find()) {
            res = Double.toString(Math.pow(Double.parseDouble(operation), 2));
            return res;
        }
        if (square.matcher(displayed_operation).find()) {
            res = Double.toString(Math.sqrt(Double.parseDouble(operation)));
            // operation += res;
            return res;
        }
        if (percent.matcher(operation).find()) {
            String[] a = operation.split("%");
            double result = (Double.parseDouble(a[0])*Double.parseDouble(a[1]))/100;
            res = Double.toString(result);
            return res;
        }

        ScriptEngineManager scriptEngine = new ScriptEngineManager();
        ScriptEngine engine = scriptEngine.getEngineByName("nashorn");

        try {
            res = engine.eval(operation).toString();
        } catch (ScriptException e) {
            e.printStackTrace();
            res = "error";
        }
        return res;
    }
}
