/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserClass;

import NonUserClass.AppendableObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class Patient extends User implements Serializable {

    String name;
    LocalDate dob;
    String gender;
    String address;
    int phone;
    int nid;

    public Patient(String name, LocalDate dob, String gender, String address, int phone, int nid, String password, int id) {
        super(password, id);
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.nid = nid;
    }

    public Patient(String name, LocalDate dob, String gender, String address, int phone, int nid) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.nid = nid;
    }

    public static Patient addInstance(String name, LocalDate dob, String gender, String address, int phone, int nid) {

        Patient p = null;
        int temp = 0;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            File f = new File("Patient.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Patient emp;
            try {

                while (true) {

                    emp = (Patient) ois.readObject();
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

            File f = new File("Patient.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
                p = new Patient(name, dob, gender, address, phone, nid, "123", temp + 1);
                oos.writeObject(p);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
                p = new Patient(name, dob, gender, address, phone, nid, "123", 123000);

                oos.writeObject(p);
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
        return p;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

}
