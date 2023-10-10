/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NonUserClass;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George
 */
public class PharmacyBill implements Serializable{
    private String soldDrugNames;
    private float total;
    private LocalDate billDate;
    private String type;

    public PharmacyBill(String soldDrugNames, float total, LocalDate billDate, String type) {
        this.soldDrugNames = soldDrugNames;
        this.total = total;
        this.billDate = billDate;
        this.type = type;
    }

    public String getSoldDrugNames() {
        return soldDrugNames;
    }

    public void setSoldDrugNames(String soldDrugNames) {
        this.soldDrugNames = soldDrugNames;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public LocalDate getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    
    public static void addPharmacyBillInstance(String drugname, float total, String type)
    {
        PharmacyBill bill=null;
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f=new File("Pharmacy Bill.bin");
           
            
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
            bill=new PharmacyBill(drugname, total, LocalDate.now(), type);;
            oos.writeObject(bill);
           
            oos.close();
            
        } catch (IOException ex) {
            
                if(oos != null) try {
                    oos.close();
                    
                    
                } catch (IOException ex1) {
                   
                } 
            
        }
        
      
       
    }
    
}
