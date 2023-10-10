/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NonUserClass;

/**
 *
 * @author ASUS
 */
public class SafetyGearRequestApplication {

    private int equipReqId;
    private int empId;
    private String reqTitle, reqDescription, status = "To be reviewed";

    public SafetyGearRequestApplication(int equipReqId, int empId, String reqTitle, String reqDescription) {
        this.equipReqId = equipReqId;
        this.empId = empId;
        this.reqTitle = reqTitle;
        this.reqDescription = reqDescription;
    }

    @Override
    public String toString() {
        return "EquipmentRequestApplication{" + "equipReqId=" + equipReqId + ", empId=" + empId + ", reqTitle=" + reqTitle + ", reqDescription=" + reqDescription + '}';
    }
}
