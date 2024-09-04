package org.example.calcfx.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CalcController {

    @FXML
    private TextField InputFunction;

    @FXML
    private Button Resolve;

    private SolutionController solutionController;
    private Stage solutionStage;

    @FXML
    public void initialize() {
        Resolve.setOnAction(event -> {
            String function = func();

            if (solutionController == null) {
                try {
                    FXMLLoader solutionLoader = new FXMLLoader(getClass().getResource("/org/example/calcfx/solution.fxml"));
                    Parent parent = solutionLoader.load();
                    solutionController = solutionLoader.getController();

                    solutionStage = new Stage();
                    solutionStage.setScene(new Scene(parent));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            solutionController.setOutputText(function);

            if (!solutionStage.isShowing()) {
                solutionStage.show();
            } else {
                solutionStage.toFront();
            }
        });
    }

    public String func(){
        return InputFunction.getText();
    }

    public void setSolutionController(SolutionController controller) {
        this.solutionController = controller;
    }
}