/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import NonUserClass.EquipentRequestApplication;
import NonUserClass.SuggestionAndComplain;
import UserClass.CEO;
import UserClass.HeadOfSupportService;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class MonitorSuggestionAndComplainController implements Initializable {

    @FXML
    private TableView<SuggestionAndComplain> tableView;
    @FXML
    private TableColumn<SuggestionAndComplain, String> serialNoCol;
    @FXML
    private TableColumn<SuggestionAndComplain, String> patIdCol;
    @FXML
    private TableColumn<SuggestionAndComplain, String> nameCol;
    @FXML
    private TableColumn<SuggestionAndComplain, String> titleCol;
    @FXML
    private TableColumn<SuggestionAndComplain, String> typeCol;
    @FXML
    private TableColumn<SuggestionAndComplain, String> statusCol;
    @FXML
    private Label viewDetailsLabel;
    private HeadOfSupportService hss;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hss = new HeadOfSupportService();
        serialNoCol.setCellValueFactory(new PropertyValueFactory<SuggestionAndComplain, String>("equipReqId"));
        titleCol.setCellValueFactory(new PropertyValueFactory<SuggestionAndComplain, String>("reqTitle"));
        statusCol.setCellValueFactory(new PropertyValueFactory<SuggestionAndComplain, String>("reqAppStat"));
        patIdCol.setCellValueFactory(new PropertyValueFactory<SuggestionAndComplain, String>(""));
        nameCol.setCellValueFactory(new PropertyValueFactory<SuggestionAndComplain, String>(""));
        typeCol.setCellValueFactory(new PropertyValueFactory<SuggestionAndComplain, String>(""));

        tableView.setItems(hss.monitorSuggestionAndComplain());
        // TODO
    }

    @FXML
    private void yesButtonOnClick(ActionEvent event) throws IOException {
        if (tableView.getSelectionModel().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Oops! No row is selected. \nCan't load data.");
            a.showAndWait();
        }

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SuggestionAndComplainInDetails.fxml"));
        Parent parent = loader.load();
        //Parent personViewParent = FXMLLoader.load(getClass().getResource("FXMLScene2.fxml"));
        Scene scene = new Scene(parent);

        //access the controller
        SuggestionAndComplainInDetailsController controller = loader.getController();

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
        Parent parent = FXMLLoader.load(getClass().getResource("HomeSceneOfSupport.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //   stg.setTitle("Checking... Stage switching");

        stg.setScene(scene);
        stg.show();
    }

}
