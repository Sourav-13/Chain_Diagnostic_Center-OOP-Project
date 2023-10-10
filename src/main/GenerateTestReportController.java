/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.File;
import java.io.FileOutputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;



/**
 * FXML Controller class
 *
 * @author Rahat
 */
public class GenerateTestReportController implements Initializable {

    @FXML
    private Button dashboardButton;
    @FXML
    private TextArea reportTextArea;
    @FXML
    private TextField TypeOfTest;
    @FXML
    private TextField patientName;
    @FXML
    private TextField patientID;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void dashboardSceneOnCick(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("LabTechnicianDashboardScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage stg = (Stage)((Node)event.getSource()).getScene().getWindow();
        stg.setScene(scene2);
        stg.show();
    }

    @FXML
    private void generateTextReportPDFOnClick(ActionEvent event) {
        try{
           
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new ExtensionFilter("PDF files", "*.pdf"));
            fc.getExtensionFilters().add(new ExtensionFilter("Image files", "*.jpg", "*.bmp", "*.png"));
            File f = fc.showSaveDialog(null);
            if(f!=null){              
                PdfWriter pw = new PdfWriter(new FileOutputStream(f));
                //PdfWriter pw = new PdfWriter(new FileOutputStream("testPDF.pdf"));
                PdfDocument pdf =  new PdfDocument(pw);
                pdf.addNewPage();
                Document doc = new Document(pdf);
                doc.setLeftMargin(70);
               
                //----------------------------------------------------
                //adding paragrapg to the pdf
                String newline = "\n";
                Paragraph lineSpace = new Paragraph(newline);
                lineSpace.setHeight(8);
                
                String paraText1 
                        = "Patient name: " + patientName.getText() + "\n"
                        + "Patient ID: " + patientID.getText() + "\n"
                        + "Type of Test: " + TypeOfTest.getText() + "\n"
                        + "Report: " + "\n" + "\n"
                        + reportTextArea.getText();
                Paragraph para1 = new Paragraph(paraText1);
                
                Text titleText = new Text("Test Report");
                titleText.setFontSize(18f);
                Paragraph pageTitle = new Paragraph(titleText);
                pageTitle.setBold();    //OR titleText.setBold();

                PdfFont font2 = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
                PdfFont fontBold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
                Text title = new Text("Report generated").setFont(fontBold);
                Text author = new Text("OOP Chain Diagnostic Center").setFont(font2);
                author.setFontColor(Color.RED);
                Paragraph bookInfo = new Paragraph().add(title).add(" -- by ").add(author);
                
                doc.add(pageTitle);
                doc.add(lineSpace);
                doc.add(para1);
                doc.add(lineSpace);
                doc.add(bookInfo);
                doc.add(lineSpace);
                
                doc.close();
                
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("The PDF is saved successfully.");
                a.showAndWait();    
            }
            else{
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Saving as PDF: cancelled!");
                a.showAndWait();               
            }
        }
        catch(Exception e){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Oops! Exception: " + e.toString()+ " occured.");
            a.showAndWait(); 
            //System.out.println("Something went wrong...");
            //System.out.println(e);
        }
    }
   
}
