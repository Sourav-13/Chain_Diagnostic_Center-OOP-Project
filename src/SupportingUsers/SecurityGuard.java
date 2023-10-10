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

/**
 *
 * @author ASUS
 */
public class SecurityGuard extends Employee implements Serializable {

    private String shift;

    public SecurityGuard() {
    }

    public SecurityGuard(int phnNo, String name, String gender, String branchName, String desig, LocalDate dob, float salary, String password, int id) {
        super(phnNo, name, gender, branchName, desig, dob, salary, password, id);
    }

    public SecurityGuard(int phnNo, String name, String gender, String branchName, String desig, LocalDate dob) {
        super(phnNo, name, gender, branchName, desig, dob);
    }

    public SecurityGuard(String shift, int phnNo, String name, String gender, String branchName, String desig, LocalDate dob) {
        super(phnNo, name, gender, branchName, desig, dob);
        this.shift = shift;
    }

    public static SecurityGuard addInstance(String name, int phone, String gender, String branch, LocalDate doB) {

        SecurityGuard s = null;
        int temp = 0;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            File f = new File("SecurityGuard.bin");

            //File f = new File("SecurityGuard.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Employee emp;
            try {

                while (true) {

                    emp = (SecurityGuard) ois.readObject();
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

            // File f = new File("SecurityGuard.bin");
            File f = new File("SecurityGuard.bin");

            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
                s = new SecurityGuard(phone, name, gender, branch, "Security Guard", doB, 20000, "123", temp + 1);
                oos.writeObject(s);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
                s = new SecurityGuard(phone, name, gender, branch, "Security Guard", doB, 20000, "123", (branch.equals("Uttara") ? 1500 : 2500));

                oos.writeObject(s);
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
        return s;
    }

    @Override
    public String toString() {
        return "SecurityGuards{" + "shift=" + shift + '}';
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

}
