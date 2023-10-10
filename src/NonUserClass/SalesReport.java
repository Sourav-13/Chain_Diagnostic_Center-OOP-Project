/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NonUserClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author George
 */
public class SalesReport implements Serializable {
    private String branch;
    private LocalDate salesReportDate;
    private float totalAmountOfSale;

    public SalesReport(String branch, LocalDate salesReportDate, float totalAmountOfSale) {
        this.branch = branch;
        this.salesReportDate = salesReportDate;
        this.totalAmountOfSale = totalAmountOfSale;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public LocalDate getSalesReportDate() {
        return salesReportDate;
    }

    public void setSalesReportDate(LocalDate salesReportDate) {
        this.salesReportDate = salesReportDate;
    }

    public float getTotalAmountOfSale() {
        return totalAmountOfSale;
    }

    public void setTotalAmountOfSale(float totalAmountOfSale) {
        this.totalAmountOfSale = totalAmountOfSale;
    }

    
    public static void addSalesReport(String branchName, LocalDate dateOfSalesReport,Float totalAmount)
    {
        SalesReport salesReport=null;
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f=new File("Pharmacy Sales Report.bin");
           
            
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
                System.out.println("Append");
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
                System.out.println("New");
            }
            salesReport=new SalesReport(branchName, dateOfSalesReport, totalAmount);
            oos.writeObject(salesReport);
           
            oos.close();
            
        } catch (IOException ex) {
            
                if(oos != null) try {
                    oos.close();
                    
                    
                } catch (IOException ex1) {
                   
                } 
            
        }
    
    }
    
    public static ObservableList<SalesReport> getSalesReport()
    {
        ObservableList<SalesReport> salesReportList = FXCollections.observableArrayList();
        ObjectInputStream ois = null;
        try {
            SalesReport salesReport;
            ois = new ObjectInputStream(new FileInputStream("Pharmacy Sales Report.bin"));

            while (true) {
                salesReport = (SalesReport) ois.readObject();
                salesReportList.add(salesReport);
            }

        } catch (Exception ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {

            }
            
            return salesReportList;
        }

    
    }
    
    
    
}
