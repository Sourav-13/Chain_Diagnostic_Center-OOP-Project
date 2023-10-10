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
public class BudgetRequestApplication implements Serializable {

    private final int budegtReqId;
    private int empId;
    private String BudgetTitle, budgetDescription, status = "To be reviewed";

    public BudgetRequestApplication(int budegtReqId, int empId, String BudgetTitle, String budgetDescription) {
        this.budegtReqId = budegtReqId;
        this.empId = empId;
        this.BudgetTitle = BudgetTitle;
        this.budgetDescription = budgetDescription;
    }

    public BudgetRequestApplication(int budegtReqId, String BudgetTitle, String budgetDescription) {
        this.budegtReqId = budegtReqId;
        this.BudgetTitle = BudgetTitle;
        this.budgetDescription = budgetDescription;
    }

    @Override
    public String toString() {
        return "Budget{" + "budegtReqId=" + budegtReqId + ", empId=" + empId + ", BudgetTitle=" + BudgetTitle + ", budgetDescription=" + budgetDescription + ", status=" + status + '}';
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getBudgetTitle() {
        return BudgetTitle;
    }

    public void setBudgetTitle(String BudgetTitle) {
        this.BudgetTitle = BudgetTitle;
    }

    public String getBudgetDescription() {
        return budgetDescription;
    }

    public void setBudgetDescription(String budgetDescription) {
        this.budgetDescription = budgetDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   
}
