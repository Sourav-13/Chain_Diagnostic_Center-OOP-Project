/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import NonUserClass.SuggestionAndComplain;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class SuggestionAndComplainInDetailsController implements Initializable {

    @FXML
    private Label sugComLabel;
    @FXML
    private TextArea feedbackTextArea;
    @FXML
    private Label patientIdLabel;
    @FXML
    private TextArea titleTextArea;
    @FXML
    private TextArea descriptionTextArea;
    @FXML
    private Label serialNoLabel;
 private SuggestionAndComplain sac;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sac = new SuggestionAndComplain();
        // TODO
    }    
    
    public void passingData(SuggestionAndComplain sc) {
        sac=sc;
        serialNoLabel.setText(Integer.toString(sc.getSerialNo()));
        patientIdLabel.setText(Integer.toString(sc.getPatientId()));
        sugComLabel.setText(sc.getType() + " in details");
        descriptionTextArea.setText(sc.getDescription());
        titleTextArea.setText(sc.getTitle());
       
    }

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
        sac.setFeedback(feedbackTextArea.getText());
         Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("Feedback has been sent successfully");
        a.showAndWait();
    }

    @FXML
    private void signOutButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("LogInScene.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //   stg.setTitle("Checking... Stage switching");

        stg.setScene(scene);
        stg.show();
    }

    @FXML
    private void prevSceneButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("MonitorSuggestionAndComplain.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //   stg.setTitle("Checking... Stage switching");
        stg.setScene(scene);
        stg.show();
    }
    
}
