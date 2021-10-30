package com.example.romancalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    public Label outputLabel;

    @FXML
    public TextField inputLabel;

    private final Logic logic;

    public HelloController() {
        logic = new Logic();
    }

    @FXML
    public void convertActionButton(ActionEvent actionEvent) {
        String text = inputLabel.getText();
        if (text.equals("")) {
            text = outputLabel.getText();
        }
        String[] tokens = text.split(" ");
        Logic logic = new Logic();
        if (tokens.length != 1 || text.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setContentText("Invalid Number");
            alert.show();
            return;
        }
        boolean isRomans = Character.isDigit(text.charAt(0));
        if (isRomans) {
            int num = Integer.parseInt(text);
            outputLabel.setText(logic.intToRoman(num));
        } else {
            try {
                outputLabel.setText(String.valueOf(logic.romanToDecimal(text)));
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("Invalid Number");
                alert.show();
                return;
            }
        }
        inputLabel.setText("");
    }

    @FXML
    public void onClick(ActionEvent actionEvent) {
        Button source = (Button) actionEvent.getSource();
        char ch = (source).getText().charAt(0);

        String text = inputLabel.getText();
        if (ch == '-' || ch == '+') {
            inputLabel.setText(text + " " + (source).getText() + " ");
        } else {
            inputLabel.setText(text + (source).getText());
        }

        if (ch == '=') {
            if (text.split(" ").length != 3) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setContentText("ERROR");
                alert.show();
                inputLabel.setText("");
                return;
            }
            String calculate = logic.calculate(text);
            outputLabel.setText(calculate);
            inputLabel.setText("");
        }
    }

    public void clearAction(ActionEvent actionEvent) {
        inputLabel.setText("");
        outputLabel.setText("");
    }
}