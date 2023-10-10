/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import NonUserClass.AppendableObjectOutputStream;
import NonUserClass.EquipentRequestApplication;
import UserClass.CEO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class EquipmentRequestController implements Initializable {

    @FXML
    private TableView<EquipentRequestApplication> tableView;
    @FXML
    private TableColumn<EquipentRequestApplication, String> reqIdCol;
    @FXML
    private TableColumn<EquipentRequestApplication, String> titleCol;
    private CEO ceo;
    @FXML
    private TableColumn<EquipentRequestApplication, String> statusCol;
    @FXML
    private TableColumn<EquipentRequestApplication, String> requesterIdCol;
    @FXML
    private ComboBox<String> branchComboBox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //tableView.getItems();
        //rivate int empId;
        //private String reqTitle, reqDescription;
        reqIdCol.setCellValueFactory(new PropertyValueFactory<EquipentRequestApplication, String>("equipReqId"));
        titleCol.setCellValueFactory(new PropertyValueFactory<EquipentRequestApplication, String>("reqTitle"));
        statusCol.setCellValueFactory(new PropertyValueFactory<EquipentRequestApplication, String>("status"));
        requesterIdCol.setCellValueFactory(new PropertyValueFactory<EquipentRequestApplication, String>("empId"));
        ceo = new CEO();
        branchComboBox.getItems().addAll("Uttara", "Dhanmondi");
        tableView.setItems(ceo.approveEquipmentRequest());

    }

    @FXML
    private void yesButtonOnClick(ActionEvent event) throws IOException {
        if (tableView.getSelectionModel().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Oops! No row is selected. \nCan't load data.");
            a.showAndWait();
        }

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EquipmentRequestInDetails.fxml"));
        Parent parent = loader.load();
        //Parent personViewParent = FXMLLoader.load(getClass().getResource("FXMLScene2.fxml"));
        Scene scene = new Scene(parent);

        //access the controller
        EquipmentRequestInDetailsController controller = loader.getController();

        //controller = new PersonViewSceneController();
        controller.passingData(tableView.getSelectionModel().getSelectedItem());

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
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
        Parent parent = FXMLLoader.load(getClass().getResource("HomeSceneOfCEO.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //   stg.setTitle("Checking... Stage switching");

        stg.setScene(scene);
        stg.show();
    }

    @FXML
    private void branchComboBoxOnClick(ActionEvent event) {

        if (branchComboBox.getValue().equals("Uttara")) {
            tableView.setItems(ceo.approveEquipmentRequest("Uttara"));

        } else if (branchComboBox.getValue().equals("Dhanmondi")) {
            tableView.setItems(ceo.approveEquipmentRequest("Dhanmondi"));
        }

    }

}
