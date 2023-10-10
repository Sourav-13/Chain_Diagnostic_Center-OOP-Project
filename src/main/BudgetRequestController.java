/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import NonUserClass.BudgetRequestApplication;
import NonUserClass.EquipentRequestApplication;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class BudgetRequestController implements Initializable {

    @FXML
    private TableView<BudgetRequestApplication> tableView;
    @FXML
    private TableColumn<BudgetRequestApplication, String> budgetIdCol;
    @FXML
    private TableColumn<BudgetRequestApplication, String>titleCol;
    @FXML
    private TableColumn<BudgetRequestApplication, String> requesterCol;
    @FXML
    private TableColumn<BudgetRequestApplication, String> branchCol;
    @FXML
    private TableColumn<BudgetRequestApplication, String> statCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        budgetIdCol.setCellValueFactory(new PropertyValueFactory<BudgetRequestApplication, String>("budegtReqId"));
        titleCol.setCellValueFactory(new PropertyValueFactory<BudgetRequestApplication, String>("fundTitle"));
        requesterCol.setCellValueFactory(new PropertyValueFactory<BudgetRequestApplication, String>("empId"));
        branchCol.setCellValueFactory(new PropertyValueFactory<BudgetRequestApplication, String>("equipReqId"));
        statCol.setCellValueFactory(new PropertyValueFactory<BudgetRequestApplication, String>("budgetDescription"));
        // TODO
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
    private void prevSceneButtonOnClick(ActionEvent event)throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("HomeSceneOfCEO.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //   stg.setTitle("Checking... Stage switching");

        stg.setScene(scene);
        stg.show();
    }

    @FXML
    private void yesButtonOnClick(ActionEvent event)throws IOException {
          if (tableView.getSelectionModel().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Oops! No row is selected. \nCan't load data.");
            a.showAndWait();
        }

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("BudgetRequestInDetails.fxml"));
        Parent parent = loader.load();
        //Parent personViewParent = FXMLLoader.load(getClass().getResource("FXMLScene2.fxml"));
        Scene scene = new Scene(parent);

        //access the controller
        BudgetRequestInDetailsController controller = loader.getController();

        //controller = new PersonViewSceneController();
        controller.passingData(tableView.getSelectionModel().getSelectedItem());

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }

  
}
