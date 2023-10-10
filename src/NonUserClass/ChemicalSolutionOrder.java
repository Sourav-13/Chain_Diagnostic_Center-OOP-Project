/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NonUserClass;

import java.io.Serializable;

/**
 *
 * @author Rahat
 */
public class ChemicalSolutionOrder implements Serializable{

    String name;
    int id;
    String roomNum;
    String chemical;

    public ChemicalSolutionOrder(String name, int id, String roomNum, String chemical) {
        this.name = name;
        this.id = id;
        this.roomNum = roomNum;
        this.chemical = chemical;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getChemical() {
        return chemical;
    }

    public void setChemical(String chemical) {
        this.chemical = chemical;
    }
    
}
