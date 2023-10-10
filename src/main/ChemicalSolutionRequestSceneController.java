/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import NonUserClass.AppendableObjectOutputStream;
import NonUserClass.ChemicalSolutionOrder;
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
public class ChemicalSolutionRequestSceneController implements Initializable {

    @FXML
    private Button requestButton;
    @FXML
    private Button dashboardButton;
    @FXML
    private TextField labRoomNum;
    @FXML
    private TextArea chemicalNameForRequestTxtArea;
    @FXML
    private TextField labTechnicianNameTxt;
    @FXML
    private TextField labTechnicianIdTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void dashboardSceneOnCick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("LabTechnicianDashboardScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg.setScene(scene2);
        stg.show();
    }

    @FXML
    private void requestPharmacyForChemicalSolutionButtonOnClick(ActionEvent event) throws IOException {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("ChemicalSolutionRequest.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);

            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);

            }
            ChemicalSolutionOrder chemical = new ChemicalSolutionOrder(
                    labTechnicianNameTxt.getText(),
                    Integer.parseInt(labTechnicianIdTxt.getText()),
                    labRoomNum.getText(),
                    chemicalNameForRequestTxtArea.getText() 
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

}
