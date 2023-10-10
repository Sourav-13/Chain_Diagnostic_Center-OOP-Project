/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import UserClass.Patient;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rahat
 */
public class PatientAdmissionSceneController implements Initializable {

    @FXML
    private DatePicker admisssionDateDatePicker;
    @FXML
    private TextField nameTextField;
    @FXML
    private ComboBox<String> branchComboBox;
    @FXML
    private TextField idTextField;
    @FXML
    private RadioButton bedRadioButton;
    @FXML
    private RadioButton cabinRaddioButton;
    private ToggleGroup tg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tg = new ToggleGroup();
        bedRadioButton.setToggleGroup(tg);
        cabinRaddioButton.setToggleGroup(tg);
        
        ObservableList<String> branchList = FXCollections.observableArrayList("Dhaka", "Chittagong");
        branchComboBox.setItems(branchList);
    }    

    @FXML
    private void dashboardSceneOnCick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("ReceptionistDashboardScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(scene2);
        stg.show();
    }

    @FXML
    private void confirmAddmisssionOnClick(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("name: " + nameTextField.getText() + "\n"
                + "ID: " + idTextField.getText() + "\n"
                + "Branch: " + branchComboBox.getValue() + "\n"
                + "Date of Admission: " + admisssionDateDatePicker.getValue() + "\n"
                + "Type of Admission: " + (cabinRaddioButton.isSelected()?"Cabin":"Bed")
                );
        alert.showAndWait();
                
///////////////////////////////////
        /*Optional<ButtonType> alertResult = alert.showAndWait();
        if (alertResult.get() == ButtonType.OK) {
            Patient newPatient = new Patient(nameTxt.getText(),
                    dobDatePicker.getValue(),
                    genderComboBox.getValue(),
                    addressTxt.getText(),
                    Integer.parseInt(phoneTxt.getText()),
                    Integer.parseInt(nidTxt.getText())
            );*/
////////////////////////////////////
    }

}
