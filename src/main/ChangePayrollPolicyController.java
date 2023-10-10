/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import UserClass.CEO;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ChangePayrollPolicyController implements Initializable {

    @FXML
    private TextArea newPolicyTextArea;
    @FXML
    private TextArea oldPolicyTextArea;
    private CEO ceo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ceo = new CEO();
        File f = null;
        FileInputStream fis = null;
        DataInputStream dis = null;
        String str = "";
        try {
            f = new File("PayrollPolicy.bin");
            if (!f.exists()) {
                oldPolicyTextArea.setText("\"There is currently no Payroll Policy!\n kindly add one.\"");
            } else {
                fis = new FileInputStream(f);
                dis = new DataInputStream(fis);
                while (true) {
                    str = dis.readUTF();
                }
            }
        } catch (IOException ex) {
            oldPolicyTextArea.setText(str);
        } finally {
            try {
                if (dis != null) {
                    dis.close();
                }
            } catch (IOException ex) {
            }
        }
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
    private void submitButtonOnClick(ActionEvent event) {

        if (newPolicyTextArea.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Kindly add new payroll policy before submitting.");
            a.showAndWait();
        } else {

            Boolean check;
            check = ceo.changePayrollPolicy(newPolicyTextArea.getText());
            if (check == true) {
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText("Payroll Policy has been successfully updated");
                a.showAndWait();
            }

            newPolicyTextArea.clear();
            oldPolicyTextArea.setText(ceo.getPayrollPolicy());
        }

    }

}
