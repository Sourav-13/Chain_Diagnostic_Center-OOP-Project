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

/**
 *
 * @author ASUS
 */
public class SuggestionAndComplain {

    private int serialNo, patientId;
    private String title, description, type, status = "To be reviewed", feedback;

    public SuggestionAndComplain() {
    }

    public SuggestionAndComplain(int serialNo, int patientId, String title, String description, String type) {
        this.serialNo = serialNo;
        this.patientId = patientId;
        this.title = title;
        this.description = description;
        this.type = type;
    }

    @Override
    public String toString() {
        return "SuggestionAndComplain{" + "serialNo=" + serialNo + ", patientId=" + patientId + ", title=" + title + ", description=" + description + ", type=" + type + ", status=" + status + '}';
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

}
