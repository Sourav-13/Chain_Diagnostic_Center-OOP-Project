/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import NonUserClass.AppendableObjectOutputStream;
import UserClass.CEO;
import SupportingUsers.CleaningAndLaundryStaff;
import SupportingUsers.DeliveryStaff;
import UserClass.HeadOfSupportService;
import SupportingUsers.SecurityGuard;
import UserClass.Patient;
import UserClass.Receptionist;
import UserClass.User;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class RegisterSceneController implements Initializable {

    @FXML
    private DatePicker empDobDatePicker;
    @FXML
    private TextField empNameTextField;
    @FXML
    private TextField empPhnNoTextField;
    @FXML
    private RadioButton empMaleRadioButton;
    @FXML
    private RadioButton empFemaleRadioButton;
    @FXML
    private ComboBox<String> empDesigComboBox;
    @FXML
    private ComboBox<String> empBranchComboBox;
    private ToggleGroup tg1, tg2;
    @FXML
    private TextField nameTxt;
    @FXML
    private DatePicker dobDatePicker;
    @FXML
    private TextArea addressTxt;
    @FXML
    private TextField phoneTxt;
    @FXML
    private TextField nidTxt;
    @FXML
    private Button registerButton;
    @FXML
    private RadioButton patMaleRadioButton;
    @FXML
    private RadioButton patFemaleRadioButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tg1 = new ToggleGroup();
        tg2 = new ToggleGroup();
        patMaleRadioButton.setToggleGroup(tg1);
        patFemaleRadioButton.setToggleGroup(tg1);
        patMaleRadioButton.setSelected(true);
        empMaleRadioButton.setToggleGroup(tg2);
        empFemaleRadioButton.setToggleGroup(tg2);
        empMaleRadioButton.setSelected(true);

        empBranchComboBox.getItems().addAll("Uttara", "Dhanmondi");
        empDesigComboBox.getItems().addAll("CEO", "Doctor", "Lab Technician", "Receptionist",
                "Accountant", "Pharmacy Manager", "Head Of Support", "Security Guard", "Delivery Staff", "Cleaning & Laundry Staff", "Applicant", "Intern");

    }

    @FXML
    private void prevSceneButtonOnClick(ActionEvent event) throws IOException {

        Parent parent = FXMLLoader.load(getClass().getResource("LogInScene.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //   stg.setTitle("Checking... Stage switching");

        stg.setScene(scene);
        stg.show();

    }

    @FXML
    private void empYesButtonOnClick(ActionEvent event) throws IOException {

        User temp = null;
        if (empDesigComboBox.getValue().equals("Head Of Support")) {
            temp = HeadOfSupportService.addInstance(empNameTextField.getText(),
                    Integer.parseInt(empPhnNoTextField.getText()), empMaleRadioButton.isSelected() ? "Male" : "Female",
                    empBranchComboBox.getValue(), empDobDatePicker.getValue());

        } else if (empDesigComboBox.getValue().equals("CEO")) {
            temp = CEO.addInstance(empNameTextField.getText(),
                    Integer.parseInt(empPhnNoTextField.getText()), empMaleRadioButton.isSelected() ? "Male" : "Female",
                    empBranchComboBox.getValue(), empDobDatePicker.getValue());
        } else if (empDesigComboBox.getValue().equals("Cleaning & Laundry Staff")) {
            temp = CleaningAndLaundryStaff.addInstance(empNameTextField.getText(),
                    Integer.parseInt(empPhnNoTextField.getText()), empMaleRadioButton.isSelected() ? "Male" : "Female",
                    empBranchComboBox.getValue(), empDobDatePicker.getValue());
        } else if (empDesigComboBox.getValue().equals("Delivery Staff")) {
            temp = DeliveryStaff.addInstance(empNameTextField.getText(),
                    Integer.parseInt(empPhnNoTextField.getText()), empMaleRadioButton.isSelected() ? "Male" : "Female",
                    empBranchComboBox.getValue(), empDobDatePicker.getValue());
        } else if (empDesigComboBox.getValue().equals("Security Guard")) {
           temp = SecurityGuard.addInstance(empNameTextField.getText(),
                    Integer.parseInt(empPhnNoTextField.getText()), empMaleRadioButton.isSelected() ? "Male" : "Female",
                    empBranchComboBox.getValue(), empDobDatePicker.getValue());
        } else if (empDesigComboBox.getValue().equals("Receptionist")) {
            temp = Receptionist.addInstance(empNameTextField.getText(),
                    Integer.parseInt(empPhnNoTextField.getText()), empMaleRadioButton.isSelected() ? "Male" : "Female",
                    empBranchComboBox.getValue(), empDobDatePicker.getValue());
        }
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("YOUR ID: " + Integer.toString(temp.getId()) + "\nYOUR PASS: " + temp.getPassword());
        a.showAndWait();
        Parent parent = FXMLLoader.load(getClass().getResource("LogInScene.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //   stg.setTitle("Checking... Stage switching");

        stg.setScene(scene);
        stg.show();

    }

    @FXML
    private void registerPatientButtonOnClick(ActionEvent event) throws IOException {

        // public Patient(String name, LocalDate dob, String gender, String address, int phone, int nid, String password, int id) {
        Patient temp = Patient.addInstance(nameTxt.getText(), dobDatePicker.getValue(), patMaleRadioButton.isSelected() ? "Male" : "Female",
                addressTxt.getText(), Integer.parseInt(phoneTxt.getText()), Integer.parseInt(nidTxt.getText()));
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setContentText("YOUR ID: " + Integer.toString(temp.getId()) + "\nYOUR PASS: " + temp.getPassword());
        a.showAndWait();
        Parent parent = FXMLLoader.load(getClass().getResource("LogInScene.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //   stg.setTitle("Checking... Stage switching");

        stg.setScene(scene);
        stg.show();

    }

}
