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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author George
 */
public class Medicine implements Serializable {
    private final String medicineName;
    private final String companyName;
    private final String category;
    private float price;
   

    public Medicine(String medicineName, String companyName, String category, float price) {
        this.medicineName = medicineName;
        this.companyName = companyName;
        this.category = category;
        this.price = price;
        
    }

    public String getMedicineName() {
        return medicineName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }

   
    public void setPrice(float price) {
        this.price = price;
    }

     
    
    public static boolean addNewMedicine(String medicineName, String companyName, String category, float price)
    {
    
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            if(category.equals("Drug"))
            {f = new File("Medicine.bin");}
            else if(category.equals("Lab Solution"))
            {f=new File("Lab Solution.bin");}
            else
            {return false;}
            
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
            Medicine med=new Medicine(medicineName, companyName, category, price);
            oos.writeObject(med);
           
            oos.close();
            return true;
        } catch (IOException ex) {
            
                if(oos != null) try {
                    oos.close();
                    return false;
                    
                } catch (IOException ex1) {
                    Logger.getLogger(Medicine.class.getName()).log(Level.SEVERE, null, ex1);
                    return false;
                } 
            
        }
    
       return false;
    }
   
    
    
    
    
    
    
    
    
   
   
    
   
    
    
    
}
