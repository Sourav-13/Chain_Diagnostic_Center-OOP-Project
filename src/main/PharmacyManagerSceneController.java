/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import NonUserClass.ChemicalSolutionOrder;
import NonUserClass.Medicine;
import NonUserClass.PharmacyBill;
import NonUserClass.SalesReport;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author George
 */
public class PharmacyManagerSceneController implements Initializable {

    //Tab1
    //leftMostSeparator
    @FXML
    private TableView<Medicine> selectedMedicinetableView;
    @FXML
    private TableColumn<Medicine, String> medNameColOnSelectedMedicineList;
    @FXML
    private TableColumn<Medicine, Float> priceColOnSelectedMedicineList;
    @FXML
    private Label addedPrice;
    @FXML
    private TextField discountPertangeTextField;
    @FXML
    private Label totallBill;
    //----------------------------
    //Tab1
    //midSeparator
    @FXML
    private TableView<Medicine> medicineListTableView;
    @FXML
    private TableColumn<Medicine, String> medNameOnmedicineListTableView;
    @FXML
    private TableColumn<Medicine, Float> priceColOnmedicineListTableView;
    @FXML
    private TextField searchedMedicineName;
    //----------------------------------
    //Tab2
    @FXML
    private TableView<PharmacyBill> salesReporTable;
    @FXML
    private TableColumn<PharmacyBill, String> drugNamesColsalesReporTable;
    @FXML
    private TableColumn<PharmacyBill, Float> totalBillColsalesReporTable;
    @FXML
    private TableColumn<PharmacyBill, LocalDate> dateColsalesReporTable;
    @FXML
    private TableColumn<PharmacyBill, String> typeColOnSalesReportTableView;
    @FXML
    private ComboBox branchComboBox;
    @FXML
    private DatePicker dateDatePicker;
    @FXML
    private Label totalSaleLabel;
    //--------------------------------------------
    //Tab4
    @FXML
    private TextField drugNameTextField;
    @FXML
    private TextField companyNametextField;
    @FXML
    private ComboBox categoryComboBox;
    @FXML
    private TextField priceTextField;
    //----------------------------------
    //tab5
    @FXML
    private TableView<ChemicalSolutionOrder> labOrdertableView;
    @FXML
    private TableColumn<ChemicalSolutionOrder, String> medNameColOnlabOrdertableView;
    @FXML
    private TableColumn<ChemicalSolutionOrder, String> roomNoOnlabOrdertableView;
    @FXML
    private TableColumn<ChemicalSolutionOrder, String> labTechnicianNameOnlabOrdertableView;

    @FXML
    private TableView<Medicine> labSolutionListTableView;
    @FXML
    private TableColumn<Medicine, String> medNameColOnlabSolutionListTableView;
    @FXML
    private TableColumn< Medicine, Float> priceSolutionOnlabSolutionListTableView;

    @FXML
    private TableView<Medicine> selectedLabSolutionTableView;
    @FXML
    private TableColumn<Medicine, String> medNameselectedLabSolutionTableView;
    @FXML
    private TableColumn<Medicine, Float> priceColOnselectedLabSolutionTableView;

    @FXML
    private TextField searchlabSolutiontextField;
    @FXML
    private Label totalBillforLabTech;
    @FXML
    private Label labtechNameOnOrderExecution;
    @FXML
    private Label labNoOnOrderExecution;

    //-----------------------------------
    @FXML
    private TableView<Medicine> medicineListTableViewOnNewOffer;
    @FXML
    private TableView<Medicine> seletedMedicineForNewOfferTableView;

    @FXML
    private TextField searchedMedicineName1;
    @FXML
    private Button searchMedicineOnClick1;
    @FXML
    private Button selectMedicineOnClick1;

    @FXML
    private TableColumn<Medicine, String> medNameColOnmedicineListTableViewOnNewOffer;
    @FXML
    private TableColumn<?, ?> selectedStatusColOnmedicineListTableViewOnNewOffer;
    @FXML
    private TableColumn<?, ?> medNameColOnseletedMedicineForNewOfferTableView;
    @FXML
    private TableColumn<?, ?> priceColseletedMedicineForNewOfferTableView;

    private TableColumn<Medicine, Integer> remQtyColOnlabSolutionListTableView;

    private ArrayList<Medicine> genMedicineList;
    private ArrayList<Medicine> labSolutionList;

    float price = 0.0f;

    @FXML
    private TableColumn<?, ?> remQtyColOnmedicineListTableViewOnNewOffer;

    @FXML
    private TextField searchedMedicineNameOnUpdatePrice;
    @FXML
    private TextField newPrice;
    @FXML
    private ComboBox categoryComboBoxOnUpdatePrice;
    @FXML
    private Label selectedDrugNameOnUpdatePrice;
    @FXML
    private Label selecteDrugCompanyNameOnUpdatePrice;
    @FXML
    private Label oldPriceOnUpdatePrice;
    @FXML
    private Label informationAboutSearchedMedicine;

    private ArrayList<Medicine> selectedMedicine = new ArrayList<Medicine>();
    private ArrayList<Medicine> selectedSolution = new ArrayList<Medicine>();

    private ObservableList<Medicine> getMedicine() {
        ObservableList<Medicine> medList = FXCollections.observableArrayList();
        ObjectInputStream ois = null;
        try {
            Medicine med;
            ois = new ObjectInputStream(new FileInputStream("Medicine.bin"));

            while (true) {
                med = (Medicine) ois.readObject();
                medList.add(med);
            }

        } catch (Exception ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {

            }
            return medList;
        }
    }

    private ObservableList<Medicine> getLabSolutions() {
        ObservableList<Medicine> labSolList = FXCollections.observableArrayList();
        ObjectInputStream ois = null;
        try {
            Medicine med;
            ois = new ObjectInputStream(new FileInputStream("Lab Solution.bin"));

            while (true) {
                med = (Medicine) ois.readObject();
                labSolList.add(med);
            }

        } catch (Exception ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {

            }
            return labSolList;
        }

    }

    private ObservableList<PharmacyBill> getBill() {
        ObservableList<PharmacyBill> billList = FXCollections.observableArrayList();
        ObjectInputStream ois = null;
        try {
            PharmacyBill bill;
            ois = new ObjectInputStream(new FileInputStream("Pharmacy Bill.bin"));

            while (true) {
                bill = (PharmacyBill) ois.readObject();
                billList.add(bill);
            }

        } catch (Exception ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {

            }

            return billList;
        }

    }

    private ObservableList<ChemicalSolutionOrder> getLaborder() {
        ObservableList<ChemicalSolutionOrder> labOrderList = FXCollections.observableArrayList();
        ObjectInputStream ois = null;
        try {
            ChemicalSolutionOrder order;
            ois = new ObjectInputStream(new FileInputStream("ChemicalSolutionRequest.bin"));

            while (true) {
                order = (ChemicalSolutionOrder) ois.readObject();
                labOrderList.add(order);
            }

        } catch (Exception ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {

            }

            return labOrderList;
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        discountPertangeTextField.setText("0");

        categoryComboBox.getItems().addAll("Drug", "Lab Solution");
        categoryComboBoxOnUpdatePrice.getItems().addAll("Drug", "Lab Solution");
        branchComboBox.getItems().addAll("Dhanmondi", "Uttara");
        branchComboBox.setValue("Dhanmondi");
        categoryComboBox.setValue("Drug");
        categoryComboBoxOnUpdatePrice.setValue("Drug");
        drugNamesColsalesReporTable.setCellValueFactory(new PropertyValueFactory<PharmacyBill, String>("soldDrugNames"));
        totalBillColsalesReporTable.setCellValueFactory(new PropertyValueFactory<PharmacyBill, Float>("total"));
        dateColsalesReporTable.setCellValueFactory(new PropertyValueFactory<PharmacyBill, LocalDate>("billDate"));
        typeColOnSalesReportTableView.setCellValueFactory(new PropertyValueFactory<PharmacyBill, String>("type"));

        medNameOnmedicineListTableView.setCellValueFactory(new PropertyValueFactory<Medicine, String>("medicineName"));
        medNameColOnmedicineListTableViewOnNewOffer.setCellValueFactory(new PropertyValueFactory<Medicine, String>("medicineName"));
        medNameColOnlabSolutionListTableView.setCellValueFactory(new PropertyValueFactory<Medicine, String>("medicineName"));
        medNameColOnSelectedMedicineList.setCellValueFactory(new PropertyValueFactory<Medicine, String>("medicineName"));
        priceColOnSelectedMedicineList.setCellValueFactory(new PropertyValueFactory<Medicine, Float>("price"));
        priceColOnmedicineListTableView.setCellValueFactory(new PropertyValueFactory<Medicine, Float>("price"));
        priceSolutionOnlabSolutionListTableView.setCellValueFactory(new PropertyValueFactory<Medicine, Float>("price"));

        medNameColOnlabOrdertableView.setCellValueFactory(new PropertyValueFactory<ChemicalSolutionOrder, String>("chemical"));
        roomNoOnlabOrdertableView.setCellValueFactory(new PropertyValueFactory<ChemicalSolutionOrder, String>("roomNum"));
        labTechnicianNameOnlabOrdertableView.setCellValueFactory(new PropertyValueFactory<ChemicalSolutionOrder, String>("name"));

        medNameselectedLabSolutionTableView.setCellValueFactory(new PropertyValueFactory<Medicine, String>("medicineName"));
        priceColOnselectedLabSolutionTableView.setCellValueFactory(new PropertyValueFactory<Medicine, Float>("price"));

        medicineListTableView.setItems(getMedicine());
        medicineListTableViewOnNewOffer.setItems(getMedicine());
        labSolutionListTableView.setItems(getLabSolutions());
        salesReporTable.setItems(getBill());
        labOrdertableView.setItems(getLaborder());
    }

    //Tab1
    //leftMostSeparator
    @FXML
    private void discountCalculation(ActionEvent event) {

        float discountPrice = (price * ((Float.parseFloat(discountPertangeTextField.getText())) / 100));
        if ((price - discountPrice) < 0) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Price is less than 0 Taka");
            a.setHeaderText("Can't have a discount more than 100%\nCheck your inputs again");
            a.showAndWait();
            totallBill.setText("ERROR");

        } else {
            totallBill.setText(String.valueOf(price - discountPrice));

        }

    }

    @FXML
    private void makerReceiptOnClick(ActionEvent event) {

        String drugName = "";
        discountPertangeTextField.setText(null);
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation Alert");
        a.setHeaderText("Successful Payment!\n"
                + totallBill.getText() + " Taka paid."
        );
        a.showAndWait();

        for (Medicine med : selectedMedicine) {

            drugName = drugName + med.getMedicineName() + ", ";

        }
        System.out.println(drugName);
        PharmacyBill.addPharmacyBillInstance(drugName, Float.parseFloat(totallBill.getText()), "General Medicine");

        selectedMedicinetableView.getItems().clear();
        totallBill.setText("0");
        addedPrice.setText("0");
        price = 0.0f;
        salesReporTable.setItems(getBill());

    }

//---------------------------------
    //Tab1
    //midSeparator
    @FXML
    private void searchMedicineOnClick(ActionEvent event) {

        String medName = searchedMedicineName.getText();
        ArrayList<Medicine> temp = new ArrayList<Medicine>(getMedicine());
        for (Medicine med : temp) {
            if (med.getMedicineName().equals(medName)) {
                System.out.println("asche");
                ObservableList<Medicine> searchedMedicine = FXCollections.observableArrayList();
                searchedMedicine.add(med);
                medicineListTableView.setItems(searchedMedicine);

            }
        }
    }

    @FXML
    private void refreshMedicineListOnClick(ActionEvent event) {
        medicineListTableView.setItems(getMedicine());
    }

    @FXML
    private void selectMedicineOnClick(ActionEvent event) {

        Medicine med = medicineListTableView.getSelectionModel().getSelectedItem();

        selectedMedicine.add(med);
        selectedMedicinetableView.getItems().add(med);

        price += med.getPrice();

        addedPrice.setText(String.valueOf(price));
        totallBill.setText(addedPrice.getText());
        System.out.println("select");

    }

//-------------------------------
//Tab2
    @FXML
    private void calculateTotalAmountOfMedicineSold(ActionEvent event) {
        float total = 0;
        for (PharmacyBill bill : getBill()) {
            total += bill.getTotal();

        }
        totalSaleLabel.setText(String.valueOf(total));

    }

    @FXML
    private void sendSalesReportToAccountant(ActionEvent event) {
        float total = 0;
        for (PharmacyBill bill : getBill()) {
            total += bill.getTotal();

        }

        SalesReport.addSalesReport(branchComboBox.getValue().toString(), dateDatePicker.getValue(), total);

    }

    //------------------------
    //Tab4
    @FXML
    private void addNewMedicineOnClick(MouseEvent event) {

        boolean status
                = Medicine.addNewMedicine(
                        drugNameTextField.getText(),
                        companyNametextField.getText(),
                        categoryComboBox.getValue().toString(), Float.parseFloat(priceTextField.getText())
                );
        System.out.println(status);
        if (status == true) {
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setTitle("Confirmation Alert");
            a.setHeaderText("Successful!\n"
                    + drugNameTextField.getText()
                    + " added to the system");
            a.showAndWait();
            drugNameTextField.setText(null);
            companyNametextField.setText(null);
            categoryComboBox.setValue("Drug");
            priceTextField.setText(null);

        } else {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Try Again");
            a.setHeaderText("Unsuccessful to add medicine to the system!!\nCheck your inputs again");
            a.showAndWait();
        }
        medicineListTableView.setItems(getMedicine());
        medicineListTableViewOnNewOffer.setItems(getMedicine());
        labSolutionListTableView.setItems(getLabSolutions());

    }

//--------------------------------
//Tab6
    @FXML
    private void searchMedicineOnClickOnUpdatePrice(ActionEvent event) {
        ArrayList<Medicine> temp;
        if (categoryComboBoxOnUpdatePrice.getValue().equals("Drug")) {
            String medName = searchedMedicineNameOnUpdatePrice.getText();
            temp = new ArrayList<Medicine>(getMedicine());
            for (Medicine med : temp) {
                if (med.getMedicineName().equals(medName)) {
                    informationAboutSearchedMedicine.setText(medName + " is found on database.");
                    selectedDrugNameOnUpdatePrice.setText(medName);
                    selecteDrugCompanyNameOnUpdatePrice.setText(med.getCompanyName());
                    oldPriceOnUpdatePrice.setText(String.valueOf(med.getPrice()));
                    return;
                }
                informationAboutSearchedMedicine.setText(medName + " is NOT FOUND on database.");

            }

        } else if (categoryComboBoxOnUpdatePrice.getValue().equals("Lab Solution")) {
            System.out.println("lb");
            String medName = searchedMedicineNameOnUpdatePrice.getText();
            temp = new ArrayList<Medicine>(getLabSolutions());
            for (Medicine med : temp) {
                if (med.getMedicineName().equals(medName)) {
                    informationAboutSearchedMedicine.setText(medName + " is found on database.");
                    selectedDrugNameOnUpdatePrice.setText(medName);
                    selecteDrugCompanyNameOnUpdatePrice.setText(med.getCompanyName());
                    oldPriceOnUpdatePrice.setText(String.valueOf(med.getPrice()));
                    return;
                }

                informationAboutSearchedMedicine.setText(medName + " is NOT FOUND on database.");
            }

        }

    }

    @FXML
    private void updateMedicinePriceOnClick(ActionEvent event) {
        if (newPrice.getText().equals(null)) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("ERROR");
            a.setHeaderText("NO INPUT IN NEW PRICE TEXTFIELD");
            a.showAndWait();
            return;
        }

        String medName = searchedMedicineNameOnUpdatePrice.getText();
        ArrayList<Medicine> temp;
        if (categoryComboBox.getValue().equals("Drug")) {
            temp = new ArrayList<Medicine>(getMedicine());
            /*File f = new File ("Medicine.bin");
                    f.delete();*/
            for (Medicine med : temp) {
                if (med.getMedicineName().equals(medName)) {
                    med.setPrice(Float.parseFloat(newPrice.getText()));
                    Medicine.addNewMedicine(med.getMedicineName(), med.getCompanyName(), med.getCategory(),
                            med.getPrice());
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                    a.setTitle("UPDATE PRICE SUCCESSFUL");
                    a.setHeaderText(medName + "'s Price is Updated.");
                    a.showAndWait();

                }
                Medicine.addNewMedicine(med.getMedicineName(), med.getCompanyName(), med.getCategory(),
                        med.getPrice());

            }
            medicineListTableView.setItems(getMedicine());
            medicineListTableViewOnNewOffer.setItems(getMedicine());
            labSolutionListTableView.setItems(getLabSolutions());

            return;
        }
        if (categoryComboBox.getValue().equals("Lab Solution")) {

            temp = new ArrayList<Medicine>(getLabSolutions());
            for (Medicine med : temp) {
                if (med.getMedicineName().equals(medName)) {
                    float oldPrice = med.getPrice();
                    med.setPrice(Float.parseFloat(newPrice.getText()));
                    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                    a.setTitle("UPDATE PRICE SUCCESSFUL");
                    a.setHeaderText(medName + "'s Price is Updated from " + oldPrice + "to " + med.getPrice());
                    a.showAndWait();

                }

            }

            medicineListTableView.setItems(getMedicine());
            medicineListTableViewOnNewOffer.setItems(getMedicine());
            labSolutionListTableView.setItems(getLabSolutions());

            return;

        }

    }

//---------------------------------------------
    @FXML
    private void searchLabSolutionOnClick(ActionEvent event) {
        String medName = searchlabSolutiontextField.getText();
        ArrayList<Medicine> temp = new ArrayList<Medicine>(getLabSolutions());
        for (Medicine med : temp) {
            if (med.getMedicineName().equals(medName)) {
                System.out.println("asche");
                ObservableList<Medicine> searchedMedicine = FXCollections.observableArrayList();
                searchedMedicine.add(med);
                labSolutionListTableView.setItems(searchedMedicine);

            }
        }
    }

    @FXML
    private void refreshSolutionListOnClick(ActionEvent event) {
        labSolutionListTableView.setItems(getLabSolutions());
    }

    @FXML
    private void selectLabSolutionOnClick(ActionEvent event) {
        Medicine med = labSolutionListTableView.getSelectionModel().getSelectedItem();

        selectedSolution.add(med);
        selectedLabSolutionTableView.getItems().add(med);

        price += med.getPrice();

        totalBillforLabTech.setText(String.valueOf(price));

    }

    @FXML
    private void makeAVoucharForLabTechnician(ActionEvent event) {
        String drugName = "";
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation Alert");
        a.setHeaderText("Successful Lab Order Execution!\n"
                + totalBillforLabTech.getText() + " is collected.\n Room No: "
                + labNoOnOrderExecution.getText() + "\n To: "
                + labtechNameOnOrderExecution.getText()
        );
        a.showAndWait();
        for (Medicine med : selectedSolution) {

            drugName = drugName + med.getMedicineName() + ", ";

        }

        PharmacyBill.addPharmacyBillInstance(drugName, Float.parseFloat(totalBillforLabTech.getText()), "Lab Solution");

        price = 0.0f;
        salesReporTable.setItems(getBill());
    }

    @FXML
    private void proceedOrderOnClick(ActionEvent event) {
        ChemicalSolutionOrder order = labOrdertableView.getSelectionModel().getSelectedItem();
        labtechNameOnOrderExecution.setText(order.getName());
        labNoOnOrderExecution.setText(order.getRoomNum());

    }
}
