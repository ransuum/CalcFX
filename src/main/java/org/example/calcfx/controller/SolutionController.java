package org.example.calcfx.controller;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.example.calcfx.service.HelperService;
import org.example.calcfx.main.Menu;

public class SolutionController {

    @FXML
    private TextArea output;

    @FXML
    private Button okButton;

    @FXML
    public void initialize() {
        okButton.setOnAction(actionEvent -> {
            Stage stage = (Stage) okButton.getScene().getWindow();
            stage.close();
        });
    }

    public void setOutputText(String text) {
        Menu menu = new HelperService(text);
        menu.putInList();
        String stringBuilder = "before equal = " + menu.getBeforeEquals() +
                "\n" +
                "after equal = " + menu.getAfterEquals() +
                "\n" +
                "before equals we find all this numbers: " + menu.getBeforeEqual() +
                "\n" +
                "after equals we find all this numbers: " + menu.getAfterEqual() +
                "\n" +
                "answer = " + menu.answer();
        output.setText(stringBuilder);
    }
}
