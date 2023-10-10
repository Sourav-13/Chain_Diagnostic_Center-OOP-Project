
package main;

import UserClass.Employee;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class SecurityGuardDashboardController implements Initializable {

    @FXML
    private Label Idlabel;
    @FXML
    private Label nameLbael;
    @FXML
    private Label dobLabel;
    @FXML
    private Label genderLabel;
    @FXML
    private Label phnNoLabel;
    @FXML
    private Label branchNameLabel;
    @FXML
    private Label salaryLabel;
    @FXML
    private Label shiftLabel;
    private Employee e;

    /**
     * Initializes the controller class.
     */
   public void passingData(Employee equip) {
        e = equip;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Idlabel.setText(Integer.toString(e.getId()));
        nameLbael.setText(e.getName());
        dobLabel.setText(e.getDob().toString());
        genderLabel.setText((e.getGender()));
        phnNoLabel.setText(Integer.toString(e.getPhnNo()));
        branchNameLabel.setText(e.getBranchName());
        salaryLabel.setText(Integer.toString(e.getId()));
        // taskLabel.setText(Integer.toString(e.getNoOfTask()));
        // TODO
    }

    @FXML
    private void prevSceneButtonOnClick(ActionEvent event)  throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("LogInScene.fxml"));

        Scene scene = new Scene(parent);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //   stg.setTitle("Checking... Stage switching");

        stg.setScene(scene);
        stg.show();
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
}
