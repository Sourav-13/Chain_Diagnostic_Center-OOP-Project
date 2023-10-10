/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupportingUsers;

import NonUserClass.AppendableObjectOutputStream;
import UserClass.Employee;
import UserClass.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author ASUS
 */
public class Applicant extends Employee implements Serializable {

    public Applicant() {
    }

    public Applicant(int phnNo, String name, String gender, String branchName, String desig, LocalDate dob, float salary, String password, int id) {
        super(phnNo, name, gender, branchName, desig, dob, salary, password, id);
    }

    public Applicant(int phnNo, String name, String gender, String branchName, String desig, LocalDate dob) {
        super(phnNo, name, gender, branchName, desig, dob);
    }

    public static Applicant addInstance(String name, int phone, String gender, String branch, LocalDate doB) {

        Applicant a = null;
        int temp = 0;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {

            //File f = new File("Employee.bin");
            File f = new File("Applicant.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Employee emp;
            try {

                while (true) {

                    emp = (Applicant) ois.readObject();
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
            File f = new File("Applicant.bin");

            //File f = new File("Applicant.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
                a = new Applicant(phone, name, gender, branch, "Applicant", doB, 0, "123", temp + 1);
                oos.writeObject(a);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
                a = new Applicant(phone, name, gender, branch, "Applicant", doB, 0, "123", (branch.equals("Uttara") ? 1800 : 2800));

                oos.writeObject(a);
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
        return a;
    }

}
