/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import NonUserClass.AppendableObjectOutputStream;
import SupportingUsers.Applicant;
import SupportingUsers.CleaningAndLaundryStaff;
import SupportingUsers.DeliveryStaff;
import SupportingUsers.SecurityGuard;
import UserClass.CEO;
import UserClass.Employee;
import UserClass.HeadOfSupportService;
import UserClass.Patient;
import UserClass.Receptionist;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class LogInSceneController implements Initializable {

    @FXML
    private TextField idTextField;
    @FXML
    private ComboBox<String> userTypeComboBox;
    @FXML
    private PasswordField passPasswordField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        userTypeComboBox.getItems().addAll("Patient", "CEO", "Doctor", "Lab Technician", "Receptionist", "Accountant", "Pharmacy Manager", "Head Of Support", "Security Guard", "Delivery Staff", "Clean & Laundry Staff", "Applicant", "Intern");

    }

    @FXML
    private void logInButtonOnClick(ActionEvent event) throws IOException {
        if(userTypeComboBox.getValue().equals("Patient"))
        {   
            ObjectInputStream ois = null;
        try {
           Patient patient;
            ois = new ObjectInputStream(new FileInputStream("Patient.bin"));

            while (true) {
                patient = (Patient) ois.readObject();
                if(patient.getId()==Integer.parseInt(idTextField.getText())  && patient.getPassword().equals("123"))
                {
        Parent parent = FXMLLoader.load(getClass().getResource("patientScene.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        

        stg.setScene(scene);
        stg.show();
                
                }
                    
                }   

        } catch (Exception ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {

            }
            
        }

            
            
        
        
        
        }
        else if (userTypeComboBox.getValue().equals("Head Of Support")) {
            ArrayList<HeadOfSupportService> empList;
            empList = new ArrayList<HeadOfSupportService>();

            ObjectInputStream ois = null;
            try {
                HeadOfSupportService temp;
                ois = new ObjectInputStream(new FileInputStream("HeadOfSupportService.bin"));
                while (true) {
                    temp = (HeadOfSupportService) ois.readObject();
                    empList.add(temp);
                }
            } catch (Exception ex) {
            } finally {
                try {
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException e) {
                }
            }

            if ((passPasswordField.getText()).equals("123")) {

                int id = Integer.parseInt(idTextField.getText());

                for (Employee emp : empList) {
                    if (emp.getId() == id) {

                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("HomeSceneOfSupport.fxml"));
                        Parent parent = loader.load();
                        //Parent personViewParent = FXMLLoader.load(getClass().getResource("FXMLScene2.fxml"));
                        Scene scene = new Scene(parent);

                        //access the controller
                        HomeSceneOfSupportController controller = loader.getController();

                        //controller = new PersonViewSceneController();
                        controller.passingData(emp);

                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                        window.setScene(scene);
                        window.show();

                    }

                }

            }

        } else if (userTypeComboBox.getValue().equals("CEO")) {

            ArrayList<CEO> empList;
            empList = new ArrayList<CEO>();
            ObjectInputStream ois = null;
            try {
                CEO temp;
                ois = new ObjectInputStream(new FileInputStream("CEO.bin"));
                while (true) {
                    temp = (CEO) ois.readObject();
                    empList.add(temp);
                }
            } catch (Exception ex) {
            } finally {
                try {
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException e) {
                }
            }

            if ((passPasswordField.getText()).equals("123")) {
                int id = Integer.parseInt(idTextField.getText());

                for (Employee emp : empList) {
                    if (emp.getId() == id) {

                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("HomeSceneOfCEO.fxml"));
                        Parent parent = loader.load();
                        //Parent personViewParent = FXMLLoader.load(getClass().getResource("FXMLScene2.fxml"));
                        Scene scene = new Scene(parent);

                        //access the controller
                        HomeSceneOfCEOController controller = loader.getController();

                        //controller = new PersonViewSceneController();
                        controller.passingData(emp);

                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                        window.setScene(scene);
                        window.show();

                    }

                }

            }

        } else if (userTypeComboBox.getValue().equals("Receptionist")) {
            ArrayList<Receptionist> empList;
            empList = new ArrayList<Receptionist>();
            ObjectInputStream ois = null;
            try {
                Receptionist temp;
                ois = new ObjectInputStream(new FileInputStream("Employee.bin"));
                while (true) {
                    temp = (Receptionist) ois.readObject();
                    empList.add(temp);
                }
            } catch (Exception ex) {
            } finally {
                try {
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException e) {
                }
            }

            if ((passPasswordField.getText()).equals("123")) {

                int id = Integer.parseInt(idTextField.getText());

                for (Employee emp : empList) {
                    if (emp.getId() == id) {

                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("ReceptionistDashboardScene.fxml"));
                        Parent parent = loader.load();
                        //Parent personViewParent = FXMLLoader.load(getClass().getResource("FXMLScene2.fxml"));
                        Scene scene = new Scene(parent);

                        //access the controller
                        ReceptionistDashboardSceneController controller = loader.getController();

                        //controller = new PersonViewSceneController();
                        controller.passingData(emp);

                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                        window.setScene(scene);
                        window.show();
                    }
                }
            }

        } else if (userTypeComboBox.getValue().equals("Security Guard")) {

            ArrayList<SecurityGuard> empList;
            empList = new ArrayList<SecurityGuard>();
            ObjectInputStream ois = null;
            try {
                SecurityGuard temp;
                ois = new ObjectInputStream(new FileInputStream("SecurityGuard.bin"));
                while (true) {
                    temp = (SecurityGuard) ois.readObject();
                    empList.add(temp);
                }
            } catch (Exception ex) {
            } finally {
                try {
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException e) {
                }
            }

            if ((passPasswordField.getText()).equals("123")) {

                int id = Integer.parseInt(idTextField.getText());

                for (Employee emp : empList) {
                    if (emp.getId() == id) {

                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("SecurityGuardDashboard.fxml"));
                        Parent parent = loader.load();
                        //Parent personViewParent = FXMLLoader.load(getClass().getResource("FXMLScene2.fxml"));
                        Scene scene = new Scene(parent);

                        //access the controller
                        SecurityGuardDashboardController controller = loader.getController();

                        //controller = new PersonViewSceneController();
                        controller.passingData(emp);

                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                        window.setScene(scene);
                        window.show();

                    }

                }

            }

        } else if (userTypeComboBox.getValue().equals("Applicant")) {

            ArrayList<Applicant> empList;
            empList = new ArrayList<Applicant>();
            ObjectInputStream ois = null;
            try {
                Applicant temp;
                ois = new ObjectInputStream(new FileInputStream("Applicant.bin"));
                while (true) {
                    temp = (Applicant) ois.readObject();
                    empList.add(temp);
                }
            } catch (Exception ex) {
            } finally {
                try {
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException e) {
                }
            }

            if ((passPasswordField.getText()).equals("123")) {

                int id = Integer.parseInt(idTextField.getText());

                for (Employee emp : empList) {
                    if (emp.getId() == id) {

                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("ApplicantDashboard.fxml"));
                        Parent parent = loader.load();
                        //Parent personViewParent = FXMLLoader.load(getClass().getResource("FXMLScene2.fxml"));
                        Scene scene = new Scene(parent);

                        //access the controller
                        ApplicantDashboardController controller = loader.getController();

                        //controller = new PersonViewSceneController();
                        controller.passingData(emp);

                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                        window.setScene(scene);
                        window.show();

                    }

                }

            }

        } else if (userTypeComboBox.getValue().equals("Clean & Laundry Staff")) {

            ArrayList<CleaningAndLaundryStaff> empList;
            empList = new ArrayList<CleaningAndLaundryStaff>();
            ObjectInputStream ois = null;
            try {
                CleaningAndLaundryStaff temp;
                ois = new ObjectInputStream(new FileInputStream("CleaningAndLaundryStaff.bin"));
                while (true) {
                    temp = (CleaningAndLaundryStaff) ois.readObject();
                    empList.add(temp);
                }
            } catch (Exception ex) {
            } finally {
                try {
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException e) {
                }
            }

            if ((passPasswordField.getText()).equals("123")) {

                int id = Integer.parseInt(idTextField.getText());

                for (Employee emp : empList) {
                    if (emp.getId() == id) {
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("CleaningAndLaundryStaffDashboard.fxml"));
                        Parent parent = loader.load();
                        //Parent personViewParent = FXMLLoader.load(getClass().getResource("FXMLScene2.fxml"));
                        Scene scene = new Scene(parent);

                        //access the controller
                        CleaningAndLaundryStaffDashboardController controller = loader.getController();

                        //controller = new PersonViewSceneController();
                        controller.passingData(emp);

                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                        window.setScene(scene);
                        window.show();

                    }

                }

            }

        } else if (userTypeComboBox.getValue().equals("Delivery Staff")) {

            ArrayList<DeliveryStaff> empList;
            empList = new ArrayList<DeliveryStaff>();
            ObjectInputStream ois = null;
            try {
                DeliveryStaff temp;
                ois = new ObjectInputStream(new FileInputStream("DeliveryStaff.bin"));
                while (true) {
                    temp = (DeliveryStaff) ois.readObject();
                    empList.add(temp);
                }
            } catch (Exception ex) {
            } finally {
                try {
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException e) {
                }
            }

            if ((passPasswordField.getText()).equals("123")) {

                int id = Integer.parseInt(idTextField.getText());

                for (Employee emp : empList) {
                    if (emp.getId() == id) {

                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("DeliveryStaffDashboard.fxml"));
                        Parent parent = loader.load();
                        //Parent personViewParent = FXMLLoader.load(getClass().getResource("FXMLScene2.fxml"));
                        Scene scene = new Scene(parent);

                        //access the controller
                        DeliveryStaffDashboardController controller = loader.getController();

                        //controller = new PersonViewSceneController();
                        controller.passingData(emp);

                        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                        window.setScene(scene);
                        window.show();

                    }

                }

            }

        }

    }

    @FXML
    private void RegisterButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("RegisterScene.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //   stg.setTitle("Checking... Stage switching");

        stg.setScene(scene);
        stg.show();

    }

}
