/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import NonUserClass.AppendableObjectOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import UserClass.Patient;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * FXML Controller class
 *
 * @author Rahat
 */
public class PatientRegisterSceneController implements Initializable {

    @FXML
    private TextField nameTxt;
    @FXML
    private TextField nidTxt;
    @FXML
    private TextField phoneTxt;
    @FXML
    private DatePicker dobDatePicker;
    @FXML
    private ComboBox<String> genderComboBox;
    @FXML
    private TextArea addressTxt;
    @FXML
    private Button registerButton;
    @FXML
    private Button dashboardButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        genderComboBox.getItems().addAll("Male", "Female");
    }

    @FXML
    private void dashboardSceneOnCick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("ReceptionistDashboardScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg.setScene(scene2);
        stg.show();
    }

    @FXML
    private void registerPatientButtonOnClick(ActionEvent event) {
        Alert alert = new Alert(AlertType.NONE);
        alert.setAlertType(AlertType.CONFIRMATION);
        alert.setContentText("name: " + nameTxt.getText() + "\n"
                + "Date of Birth: " + dobDatePicker.getValue() + "\n"
                + "Gender: " + genderComboBox.getValue() + "\n"
                + "Address: " + addressTxt.getText() + "\n"
                + "Phone: " + phoneTxt.getText() + "\n"
                + "NID: " + nidTxt.getText());

        Optional<ButtonType> alertResult = alert.showAndWait();
        if (alertResult.get() == ButtonType.OK) {
            Patient newPatient = new Patient(nameTxt.getText(),
                    dobDatePicker.getValue(),
                    genderComboBox.getValue(),
                    addressTxt.getText(),
                    Integer.parseInt(phoneTxt.getText()),
                    Integer.parseInt(nidTxt.getText())
            );

            File f = null;
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;

            try {
                f = new File("Patient.bin");
            
            
                if (f.exists()) {
                    fos = new FileOutputStream(f, true);
                    oos = new AppendableObjectOutputStream(fos);

                } else {
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);

                }
                
                oos.writeObject(newPatient);

            } catch (IOException ex) {

            }
            finally
            {

                if (oos != null) {
                    try {
                        oos.close();

                    } catch (IOException ex1) {
                        System.out.println("exl");
                    }
                }

            }

        }
    }

    @FXML
    private void gendersIsSelected(ActionEvent event) {
    }

}
