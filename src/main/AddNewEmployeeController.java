/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AddNewEmployeeController implements Initializable {

    @FXML
    private ComboBox<?> evaluateComboBox;
    @FXML
    private Label somthingLabel;
    @FXML
    private DatePicker dojDatePicker;
    @FXML
    private DatePicker dobDatePicker;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField desigTextField;
    @FXML
    private TextField salaryTextField;
    @FXML
    private TextField phnNoTextField;
    @FXML
    private ComboBox<?> branchNameTextField;
    @FXML
    private RadioButton maleRadioButton;
    @FXML
    private RadioButton femaleRadioButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void prevSceneButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("HomeSceneOfCEO.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //   stg.setTitle("Checking... Stage switching");

        stg.setScene(scene);
        stg.show();
    }

    @FXML
    private void signOutButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void yesButtonOnClick(ActionEvent event) {
    }
    
}
