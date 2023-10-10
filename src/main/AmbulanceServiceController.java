package main;

import NonUserClass.AmbulanceService;
import NonUserClass.EquipentRequestApplication;
import SupportingUsers.DeliveryStaff;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AmbulanceServiceController implements Initializable {

    @FXML
    private TableView<AmbulanceService> ambTableView;
    @FXML
    private TableColumn<AmbulanceService, String> ambSerialCol;
    @FXML
    private TableColumn<AmbulanceService, String> patIdCol;
    @FXML
    private TableColumn<AmbulanceService, String> ambStatusCol;
    @FXML
    private TableColumn<DeliveryStaff, String> empIdCol;
    @FXML
    private TableColumn<DeliveryStaff, String> empNameCol;
    @FXML
    private TableColumn<DeliveryStaff, String> empTaskCol;
    @FXML
    private TableView<DeliveryStaff> empTableView;
    AmbulanceService as;
    DeliveryStaff ds;
    HeadOfSupportService hss;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        as = new AmbulanceService();
        ds = new DeliveryStaff();

        empIdCol.setCellValueFactory(new PropertyValueFactory<DeliveryStaff, String>("empId"));
        empNameCol.setCellValueFactory(new PropertyValueFactory<DeliveryStaff, String>("name"));
        empTaskCol.setCellValueFactory(new PropertyValueFactory<DeliveryStaff, String>("noOfTask"));
        ambSerialCol.setCellValueFactory(new PropertyValueFactory<AmbulanceService, String>("serialNo"));
        patIdCol.setCellValueFactory(new PropertyValueFactory<AmbulanceService, String>("patientId"));
        ambStatusCol.setCellValueFactory(new PropertyValueFactory<AmbulanceService, String>("status"));

        empTableView.setItems(ds.getDeliveryStaffList());
        ambTableView.setItems(as.getAmbulanceServiceList());
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
        //stg.setTitle("Checking... Stage switching");
        stg.setScene(scene);
        stg.show();
    }

    @FXML
    private void yesButtonOnClick(ActionEvent event) {
        if (empTableView.getSelectionModel().isEmpty() || ambTableView.getSelectionModel().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Kindly select two rows.");
            a.showAndWait();
        }
        Boolean check;
        check = hss.provideAmbulanceService();
        if (check == true) {
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("This employee has been successfully assigned to provide Ambulance service.");
            a.showAndWait();
        }
    }
}
