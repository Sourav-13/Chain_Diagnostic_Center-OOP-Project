/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserClass;

import NonUserClass.AppendableObjectOutputStream;
import NonUserClass.EquipentRequestApplication;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS
 */
public class CEO extends Employee implements Serializable {

    //  ArrayList< EquipentRequestApplication> equipReqList;
    String payrollPolicy;

    public CEO() {
    }

    public CEO(int phnNo, String name, String gender, String branchName, String desig, LocalDate dob, float salary, String password, int id) {
        super(phnNo, name, gender, branchName, desig, dob, salary, password, id);
    }

    public CEO(int phnNo, String name, String gender, String branchName, String desig, LocalDate dob) {
        super(phnNo, name, gender, branchName, desig, dob);
    }

    public static CEO addInstance(String name, int phone, String gender, String branch, LocalDate doB) {

        CEO ceo = null;
        int temp = 0;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            File f = new File("CEO.bin");
            //File f = new File("Employee.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Employee emp;
            try {

                while (true) {

                    emp = (CEO) ois.readObject();
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

            File f = new File("CEO.bin");
            //  File f = new File("Employee.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
                ceo = new CEO(phone, name, gender, branch, "CEO", doB, 100000, "123", temp + 1);
                oos.writeObject(ceo);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
                ceo = new CEO(phone, name, gender, branch, "CEO", doB, 100000, "123", 100);

                oos.writeObject(ceo);
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
        return ceo;
    }

    public void evaluateEmployees() {
    }

    public void approvebudgetReport() {
    }

    public ObservableList<EquipentRequestApplication> approveEquipmentRequest(String branch) {
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ObservableList<EquipentRequestApplication> equip = FXCollections.observableArrayList();
        //ArrayList<EquipentRequestApplication>equip = new ArrayList<EquipentRequestApplication>();
        try {
            f = new File("EquipmentRequestApplication.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            try {
                while (true) {
                    equip.add((EquipentRequestApplication) ois.readObject());
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
        ObservableList<EquipentRequestApplication> equipUtt = FXCollections.observableArrayList();
        ObservableList<EquipentRequestApplication> equipDha = FXCollections.observableArrayList();

        for (EquipentRequestApplication e : equip) {
            if (e.getBranch().equals("Uttara")) {
                System.out.println(e.getBranch());
                equipUtt.add(e);
            } else {
                System.out.println(e.getBranch());
                equipDha.add(e);
            }
        }
        //return equipUtt;
        
        if (branch.equals("Uttara")) {
            return equipUtt;
        } else {
            return equipDha;
        
    }}

    public ObservableList<EquipentRequestApplication> approveEquipmentRequest() {
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ObservableList<EquipentRequestApplication> equip = FXCollections.observableArrayList();

        try {
            f = new File("EquipmentRequestApplication.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            try {
                while (true) {
                    //  equip = (ObservableList) ((EquipentRequestApplication) ois.readObject());
                    equip.add((EquipentRequestApplication) ois.readObject());
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

    public Boolean aproveFund(String s, String x) {
        return true;
    }

    public void viewFinancialReport() {
    }

    public void addNewEmployee() {
    }

    public void viewStatisticalReport() {
    }

    public Boolean changePayrollPolicy(String payrollPolicy) {
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            File f = new File("PayrollPolicy.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                // oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                // oos = new ObjectOutputStream(fos);
            }
            dos = new DataOutputStream(fos);

            setPayrollPolicy(payrollPolicy);
            dos.writeUTF(payrollPolicy);

        } catch (IOException ex) {

        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (IOException ex) {
            }
        }
        return true;
    }

    public String getPayrollPolicy() {
        return payrollPolicy;
    }

    public void setPayrollPolicy(String payrollPolicy) {
        this.payrollPolicy = payrollPolicy;
    }

}
