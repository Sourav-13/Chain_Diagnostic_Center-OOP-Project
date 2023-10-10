package main;

import NonUserClass.EquipentRequestApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle; 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class EquipmentRequestInDetailsController implements Initializable {

    @FXML
    private TextArea descripTextArea;
    @FXML
    private Label equipReqIdLabel;
    @FXML
    private Label branchLabel;
    
    @FXML
    private Label titleLabel;
    @FXML
    private Label reqIdLAbel;
    @FXML
    private Button approveButton;
    @FXML
    private Button declineButton;
    EquipentRequestApplication e;
    @FXML
    private Label dateLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        declineButton.setStyle("-fx-background-color: #ff0000; ");
        approveButton.setStyle("-fx-background-color: #00ff00");
        // TODO
    }

    public void passingData(EquipentRequestApplication equip) {
        e = equip;
        //branchLabel
        //reqNameLabel
        //reqIdLAbel
        dateLabel.setText(equip.getSubmissionDate().toString());
        branchLabel.setText(equip.getBranch());
        reqIdLAbel.setText(Integer.toString(equip.getEmpId()));
        descripTextArea.setText(equip.getReqDescription());
        equipReqIdLabel.setText(Integer.toString(equip.getEquipReqId()));
        titleLabel.setText(equip.getReqTitle());
    }

    @FXML
    private void signOutButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("LogInScene.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg.setScene(scene);
        stg.show();
    }

    @FXML
    private void prevSceneButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("EquipmentRequest.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //   stg.setTitle("Checking... Stage switching");

        stg.setScene(scene);
        stg.show();
    }

    @FXML
    private void approveButtonOnClick(ActionEvent event) {
      e.setStatus("Approved");
        Alert a = new Alert(AlertType.CONFIRMATION);
        a.setContentText("This request has been approved successfully");
        a.showAndWait();
    }

    @FXML
    private void declineButtonOnClick(ActionEvent event) {
      e.setStatus("Declined");

        Alert a = new Alert(AlertType.CONFIRMATION);
        a.setContentText("This request has been declined successfully");
        a.showAndWait();
    }

}
