/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import NonUserClass.BudgetRequestApplication;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class BudgetRequestInDetailsController implements Initializable {
     @FXML
    private TextArea budgetDescripTextArea;
    @FXML
    private Button approveButton;
    @FXML
    private Button declineButton;
    @FXML
    private Label budgetIdLabel;
    @FXML
    private Label branchLabel;
    @FXML
    private Label empNameLabel;
    @FXML
    private Label budgetTitleLabel;
    BudgetRequestApplication e;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        declineButton.setStyle("-fx-background-color: #ff0000; ");
        approveButton.setStyle("-fx-background-color: #00ff00");
        // TODO
    }    

     public void passingData(BudgetRequestApplication equip) {
        e = equip;
        //branchLabel
        //reqNameLabel
        //reqIdLAbel
        budgetDescripTextArea.setText(e.getBudgetDescription());
        //budgetTitleLabel.setText(Integer.toString(equip.getEquipReqId()));
        budgetTitleLabel.setText(e.getBudgetTitle());
    }
    @FXML
    private void signOutButtonOnClick(ActionEvent event)throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("LogInScene.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //   stg.setTitle("Checking... Stage switching");

        stg.setScene(scene);
        stg.show();
    }


    @FXML
    private void prevSceneButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("BudgetRequest.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //   stg.setTitle("Checking... Stage switching");

        stg.setScene(scene);
        stg.show();
    }

    @FXML
    private void approveButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void declineButtonOnClick(ActionEvent event) {
    }
    
}
