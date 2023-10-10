/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NonUserClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS
 */
public class AmbulanceService {
    private int serialNo, patientId, empId;
    private String status = "To be Provided";
    public AmbulanceService(){}

    public AmbulanceService(int serialNo, int patientId) {
        this.serialNo = serialNo;
        this.patientId = patientId;
    }

    public AmbulanceService(int serialNo, int patientId, int empId) {
        this.serialNo = serialNo;
        this.patientId = patientId;
        this.empId = empId;
    }

    public ObservableList<AmbulanceService> getAmbulanceServiceList() {
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ObservableList<AmbulanceService> asList = FXCollections.observableArrayList();

        try {
            f = new File("AmbulanceService.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            try {
                while (true) {
                    //  equip = (ObservableList) ((EquipReqApp) ois.readObject());
                    asList.add((AmbulanceService) ois.readObject());
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
        return asList;
    }
    @Override
    public String toString() {
        return "AmbulanceService{" + "serialNo=" + serialNo + ", patientId=" + patientId + ", empId=" + empId + ", status=" + status + '}';
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
