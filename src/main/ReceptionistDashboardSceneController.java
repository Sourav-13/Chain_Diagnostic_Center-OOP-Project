/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import UserClass.Employee;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rahat
 */
public class ReceptionistDashboardSceneController implements Initializable {

    @FXML
    private Button tempAppointmentButton;
    @FXML
    private Button registerPatientButton;
    @FXML
    private Button queriesButton;
    @FXML
    private Button proceedToPayBillButton;
    @FXML
    private Button admitPatientButton;
    @FXML
    private Button bookTestButton;
    private Employee hss;
    @FXML
    private TextField patientName;
    @FXML
    private TextField testName;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void passingData(Employee h) {
        hss = h;
    }

    @FXML
    private void tempPatientAppointmentButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("PatientAppointmentScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(scene2);
        stg.show();
    }

    @FXML
    private void registerAPatientButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("PatientRegisterScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(scene2);
        stg.show();
    }

    @FXML
    private void viewQueryListButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("QueryListScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(scene2);
        stg.show();
    }

    @FXML
    private void goToBillPaySceneButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("BillPayScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(scene2);
        stg.show();
    }

    @FXML
    private void patientAdmissionSceneOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("PatientAdmissionScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(scene2);
        stg.show();
    }

    @FXML
    private void goToBookingTesetSceneButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("BookingTestScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(scene2);
        stg.show();
    }
    
}
