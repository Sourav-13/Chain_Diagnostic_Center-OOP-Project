/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NonUserClass;

import java.util.ArrayList;


public class FoodService {

    private final int orderId;
    private int patientId;
    private ArrayList <Food> foodList;

    public FoodService(int orderId, int patientId, ArrayList<Food> foodList) {
        this.orderId = orderId;
        this.patientId = patientId;
        this.foodList = foodList;
    }

    @Override
    public String toString() {
        return "FoodService{" + "orderId=" + orderId + ", patientId=" + patientId + ", foodlist=" + foodList + '}';
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public ArrayList<Food> getFood() {
        return foodList;
    }

    public void setFood(ArrayList<Food> foodList) {
        this.foodList = foodList;
    }
    
}
