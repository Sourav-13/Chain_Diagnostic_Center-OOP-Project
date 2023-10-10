/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NonUserClass;

/**
 *
 * @author Rahat
 */
public class SafetyEquipment {
    String labRoomNum;
    String safetyEquipName;

    public SafetyEquipment(String labRoomNum, String safetyEquipName) {
        this.labRoomNum = labRoomNum;
        this.safetyEquipName = safetyEquipName;
    }

    public String getLabRoomNum() {
        return labRoomNum;
    }

    public void setLabRoomNum(String labRoomNum) {
        this.labRoomNum = labRoomNum;
    }

    public String getSafetyEquipName() {
        return safetyEquipName;
    }

    public void setSafetyEquipName(String safetyEquipName) {
        this.safetyEquipName = safetyEquipName;
    }
  
}
