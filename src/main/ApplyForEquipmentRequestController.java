/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import NonUserClass.AppendableObjectOutputStream;
import NonUserClass.EquipentRequestApplication;
import UserClass.Employee;
import UserClass.HeadOfSupportService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ApplyForEquipmentRequestController implements Initializable {

    @FXML
    private TextArea descripTextArea;
    @FXML
    private TextArea titleTextArea;
    // private ArrayList< EquipentRequestApplication> equipReqList;
    private HeadOfSupportService hss;
    @FXML
    private TextField requesterIdTextField;
    @FXML
    private DatePicker submissionDatePicker;
    @FXML
    private ComboBox<String> branchComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //  equipReqList = new ArrayList< EquipentRequestApplication>();
        hss = new HeadOfSupportService();
        branchComboBox.getItems().addAll("Uttara", "Dhanmondi");
    }

    private int getAppId() {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList<EquipentRequestApplication> eqCount =  new  ArrayList<EquipentRequestApplication>();
        File f = new File("EquipmentRequestApplication.bin");
        //int temp=0;
        if (!f.exists()) {
            return 1;
        } else {
            try {     
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                //EquipentRequestApplication eq;
                try {
                    while (true) {
                        eqCount.add( (EquipentRequestApplication) ois.readObject());
                       // temp = eq.getEquipReqId();
                    }
                }//end of nested try
                catch (Exception e) {
                    //
                }//nested catch     

            } catch (IOException ex) {
            } finally {
               // temp++;
                try {
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException ex) {
                }
            }
        }
        return  eqCount.size() + 1;
    }

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
        if (titleTextArea.getText().isEmpty() || descripTextArea.getText().isEmpty()) {
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("Kindly fill up the form properly");
            a.showAndWait();
        } else {
            int id = Integer.parseInt(requesterIdTextField.getText());
            boolean checkId = false;

            //HeadOfSupportService hss = null;
            //int temp = 0;
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            ArrayList<HeadOfSupportService> hssList = new ArrayList<HeadOfSupportService>();

            try {
                // File f = new File("Employee.bin");

                File f = new File("HeadOfSupportService.bin");
                fis = new FileInputStream(f);
                ois = new ObjectInputStream(fis);
                //  Employee emp;
                try {

                    while (true) {

                        hss = (HeadOfSupportService) ois.readObject();
                        hssList.add(hss);

                    }
                }//end of nested try
                catch (Exception e) {
                    //
                }//nested catch     

            } catch (IOException ex) {
            } finally {
                try {
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException ex) {
                }
            }
            for (HeadOfSupportService h : hssList) {
                if (id == h.getId()) {
                    checkId = true;
                }
            }
            if (checkId == false) {
                Alert a = new Alert(AlertType.ERROR);
                a.setContentText("Please type your Employee ID properly");
                a.showAndWait();
            } else {
                Boolean check;
                //  reqId, empid,  sub,  title,  des, branch
                check = hss.requestEquipment(getAppId(), id, submissionDatePicker.getValue(), titleTextArea.getText(), descripTextArea.getText(), branchComboBox.getValue());
                if (check == true) {
                    Alert a = new Alert(AlertType.CONFIRMATION);
                    a.setContentText("Equipment Request has been successfully sent to CEO");
                    a.showAndWait();
                }
                titleTextArea.clear();
                descripTextArea.clear();
            }
        }
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
