/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportingUsers;

import NonUserClass.AppendableObjectOutputStream;
import UserClass.Employee;
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
 * @author ASUS
 */
public class DeliveryStaff extends Employee implements Serializable {

    int noOfTask;

    public DeliveryStaff() {
    }

    public DeliveryStaff(int phnNo, String name, String gender, String branchName, String desig, LocalDate dob, float salary, String password, int id) {
        super(phnNo, name, gender, branchName, desig, dob, salary, password, id);
    }

    public DeliveryStaff(int phnNo, String name, String gender, String branchName, String desig, LocalDate dob) {
        super(phnNo, name, gender, branchName, desig, dob);
    }

    public static DeliveryStaff addInstance(String name, int phone, String gender, String branch, LocalDate doB) {

        DeliveryStaff d = null;
        int temp = 0;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            File f = new File("DeliveryStaff.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Employee emp;
            try {

                while (true) {

                    emp = (DeliveryStaff) ois.readObject();
                    temp = emp.getId();

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
        try {

            File f = new File("DeliveryStaff.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
                d = new DeliveryStaff(phone, name, gender, branch, "Delivery Staff", doB, 10000, "123", temp + 1);
                oos.writeObject(d);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
                d = new DeliveryStaff(phone, name, gender, branch, "Delivery Staff", doB, 10000, "123", (branch.equals("Uttara") ? 1700 : 2700));

                oos.writeObject(d);
            }

        } catch (IOException ex) {

        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
            }
        }
        return d;
    }

    public ObservableList<DeliveryStaff> getDeliveryStaffList() {
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ObservableList<DeliveryStaff> equip = FXCollections.observableArrayList();

        try {
            f = new File("DeliveryStaff.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            try {
                while (true) {
                    //  equip = (ObservableList) ((EquipReqApp) ois.readObject());
                    equip.add((DeliveryStaff) ois.readObject());
                }

            } catch (Exception e) {
            }
        } catch (IOException ex) {
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
        }
        return equip;
    }

    public int getNoOfTask() {
        return noOfTask;
    }

    public void setNoOfTask(int noOfTask) {
        this.noOfTask = noOfTask;
    }

}
