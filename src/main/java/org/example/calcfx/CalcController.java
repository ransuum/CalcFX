package org.example.calcfx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.calcfx.service.HelperService;
import org.example.calcfx.service.Menu;

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
                    FXMLLoader solutionLoader = new FXMLLoader(getClass().getResource("solution.fxml"));
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