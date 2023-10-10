/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import NonUserClass.AppendableObjectOutputStream;
import NonUserClass.ChemicalSolutionOrder;
import NonUserClass.SafetyEquipment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rahat
 */
public class LabTechnicianDashboardSceneController implements Initializable {

    @FXML
    private Button requestForCleaningButton;
    @FXML
    private Button viewFoodMenuButton;
    @FXML
    private Button makeApplicationButton;
    @FXML
    private Button proceedToRequestForChemicalSolutionButton;
    @FXML
    private Button proceedToGenerateTesetReportButton;
    @FXML
    private TextArea SafetyEquipmentTxtArea;
    @FXML
    private TextField labRoomNumTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void requestSupportForSafetyEquipmentsButtonOnClick(ActionEvent event) {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("SafetyEquipmentsRequest.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);

            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);

            }
            SafetyEquipment chemical = new SafetyEquipment(
                    labRoomNumTxt.getText(),
                    SafetyEquipmentTxtArea.getText() 
            );
            oos.writeObject(chemical);

        } catch (IOException ex) {
            System.out.println(ex);

        } finally {

            if (oos != null) {
                try {
                    oos.close();

                } catch (IOException ex1) {
                    System.out.println(ex1);
                }
            }

        }
    }

    @FXML
    private void requestSupportForCleaningServiceButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void viewFoodMenuButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("FoodMenuScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(scene2);
        stg.show();
    }

    @FXML
    private void goToApplicationScene(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("ApplicationScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(scene2);
        stg.show();
    }

    @FXML
    private void goToChemicalSolutionRequestSceneButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("ChemicalSolutionRequestScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(scene2);
        stg.show();
    }

    @FXML
    private void goToGenerateTestReportSceneButtonOnClick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("GenerateTestReport.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(scene2);
        stg.show();
    }
    
}
