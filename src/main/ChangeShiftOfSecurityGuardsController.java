/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import UserClass.HeadOfSupportService;
import SupportingUsers.SecurityGuard;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ChangeShiftOfSecurityGuardsController implements Initializable {

    @FXML
    private RadioButton dayShiftRadioButton;
    @FXML
    private RadioButton nightShiftRadioButton;
    @FXML
    private TableView<SecurityGuard> tableView;
    @FXML
    private TableColumn<SecurityGuard, String> idCol;
    @FXML
    private TableColumn<SecurityGuard, String> nameCol;
    @FXML
    private TableColumn<SecurityGuard, String> desigCol;
    @FXML
    private TableColumn<SecurityGuard, String> genderCol;
    @FXML
    private TableColumn<SecurityGuard, String> salCol;
    @FXML
    private TableColumn<SecurityGuard, String> shiftCol;
    private HeadOfSupportService hss;
    private ToggleGroup tg;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        /*
        empId, phnNo;
    protected String name, desig, gender, branchName;
    protected LocalDate doj, dob;
    protected float salary;
         */
        hss = new HeadOfSupportService();
        tg = new ToggleGroup();
        dayShiftRadioButton.setToggleGroup(tg);
        nightShiftRadioButton.setToggleGroup(tg);
        dayShiftRadioButton.setSelected(true);
        
        idCol.setCellValueFactory(new PropertyValueFactory<SecurityGuard, String>("empId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<SecurityGuard, String>("name"));
        desigCol.setCellValueFactory(new PropertyValueFactory<SecurityGuard, String>("desig"));
        genderCol.setCellValueFactory(new PropertyValueFactory<SecurityGuard, String>("gender"));
        salCol.setCellValueFactory(new PropertyValueFactory<SecurityGuard, String>("salary"));
        shiftCol.setCellValueFactory(new PropertyValueFactory<SecurityGuard, String>("shift"));
        
        tableView.setItems(hss.securityGuardDetails());
    }

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
        
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
        Parent parent = FXMLLoader.load(getClass().getResource("HomeSceneOfSupport.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //   stg.setTitle("Checking... Stage switching");

        stg.setScene(scene);
        stg.show();
    }

}
