/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NonUserClass;

import java.io.Serializable;

/**
 *
 * @author ASUS
 */
public class FundRequestApplication implements Serializable{
    private int fundReqId;
    private int empId;
    private String fundTitle, fundDescription, status = "To be reviewed";

    public FundRequestApplication(int fundReqId) {
        this.fundReqId = fundReqId;
    }
    

    public FundRequestApplication(int fundReqId, int empId, String fundTitle, String fundDescription) {
        this.fundReqId = fundReqId;
        this.empId = empId;
        this.fundTitle = fundTitle;
        this.fundDescription = fundDescription;
    }

    public FundRequestApplication(int fundReqId, String fundTitle, String fundDescription) {
        this.fundReqId = fundReqId;
        this.fundTitle = fundTitle;
        this.fundDescription = fundDescription;
    }

    @Override
    public String toString() {
        return "Fund{" + "fundReqId=" + fundReqId + ", empId=" + empId + ", fundTitle=" + fundTitle + ", fundDescription=" + fundDescription + ", status=" + status + '}';
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getFundTitle() {
        return fundTitle;
    }

    public void setFundTitle(String fundTitle) {
        this.fundTitle = fundTitle;
    }

    public String getFundDescription() {
        return fundDescription;
    }

    public void setFundDescription(String fundDescription) {
        this.fundDescription = fundDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFundReqId() {
        return fundReqId;
    }

    public void setFundReqId(int fundReqId) {
        this.fundReqId = fundReqId;
    }
    
    
    
}
