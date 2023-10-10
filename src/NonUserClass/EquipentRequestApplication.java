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

/**
 *
 * @author ASUS
 */
public class EquipentRequestApplication implements Serializable {

    private int equipReqId,empId;
    private LocalDate submissionDate;
    private String reqTitle, reqDescription, branch,  status = "To be reviewed";

    public EquipentRequestApplication() {
    }
    
    public EquipentRequestApplication(int equipReqId, int empId, LocalDate submissionDate, String reqTitle, String reqDescription, String branch) {
        this.equipReqId = equipReqId;
        this.empId = empId;
        this.submissionDate = submissionDate;
        this.reqTitle = reqTitle;
        this.reqDescription = reqDescription;
        this.branch = branch;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getBranch() {
        return branch;
    }

    /*
    public EquipentRequestApplication(int equipReqId, int empId, String reqTitle, String reqDescription) {
    this.equipReqId = equipReqId;
    this.empId = empId;
    this.reqTitle = reqTitle;
    this.reqDescription = reqDescription;
    }
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }


    @Override
    public String toString() {
        return "EquipmentRequestApplication{" + "equipReqId=" + equipReqId + ", empId=" + empId + ", reqTitle=" + reqTitle + ", reqDescription=" + reqDescription + '}';
    }

    public int getEmpId() {
        return empId;
    }

    public int getEquipReqId() {
        return equipReqId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getReqTitle() {
        return reqTitle;
    }

    public void setReqTitle(String reqTitle) {
        this.reqTitle = reqTitle;
    }

    public String getReqDescription() {
        return reqDescription;
    }

    public void setReqDescription(String reqDescription) {
        this.reqDescription = reqDescription;
    }

    public String getStatus() {
        return status;
    }

    // public void setStatus(EquipentRequestApplication equip,String status) {
    public void setStatus(String status) {

        this.status = status;
        /* File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        String str = "";
        try {
            f = new File("StudObject.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            EquipentRequestApplication eq;
            try {
                //outputTextArea.setText("");
                while (true) {
                    // System.out.println("Printing objects.");
                    eq = (EquipentRequestApplication) ois.readObject();
                    if(eq == equip)
                    {
                        eq.status = status;
                        //oos.writeObject(equipReq);
                    }
                    //Object obj = ois.readObject();
                    //obj.submitReport();
                    //emp.submitReport();
                    // System.out.println(emp.toString());
                  //  outputTextArea.appendText(s.toString() + "\n");
                }
            }//end of nested try
            catch (Exception e) {
                //
            }//nested catch     
           // outputTextArea.appendText("All objects are loaded successfully...\n");
        } catch (IOException ex) {
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
        }
         */
    }

}
