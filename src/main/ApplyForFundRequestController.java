/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import NonUserClass.EquipentRequestApplication;
import NonUserClass.FundRequestApplication;
import UserClass.CEO;
import UserClass.HeadOfSupportService;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ApplyForFundRequestController implements Initializable {

    @FXML
    private TextArea descripTextArea;
    @FXML
    private TextArea titleTextArea;
    private ArrayList< FundRequestApplication> fundReqList;
    private CEO ceo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ceo = new CEO();
        // TODO
    }

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
         if (titleTextArea.getText().isEmpty() || descripTextArea.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Kindly fill up the form properly");
            a.showAndWait();
        } else {

            Boolean check;
            check = ceo.aproveFund(titleTextArea.getText(), descripTextArea.getText());
            if (check == true) {
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText("Equipment Request has been successfully sent to CEO");
                a.showAndWait();
            }
            titleTextArea.clear();
            descripTextArea.clear();
        }
    }

    @FXML
    private void signOutButtonOnClick(ActionEvent event)  throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("LogInScene.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg.setScene(scene);
        stg.show();
    }

    @FXML
    private void prevSceneButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("AccountantDashboard.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg.setScene(scene);
        stg.show();
    }

}
