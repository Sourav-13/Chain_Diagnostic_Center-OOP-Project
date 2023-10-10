/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NonUserClass;

import java.util.ArrayList;

/**
 *
 * @author Rahat
 */
public class PurchasableItem {
    String name;
    int price;

    private PurchasableItem(String name, int price) {
        this.name = name;
        this.price = price;
    }
    private void viewPurchasableItem(){
        ArrayList<PurchasableItem> itemList = new ArrayList<PurchasableItem>();
        itemList.add(new PurchasableItem("Appointment fee", 1000));
        itemList.add(new PurchasableItem("Membership fee", 10000));
        itemList.add(new PurchasableItem("chemical A", 5000));
        itemList.add(new PurchasableItem("chemical B", 5000));
        itemList.add(new PurchasableItem("chemical C", 5000));
        itemList.add(new PurchasableItem("chemical D", 5000));
        itemList.add(new PurchasableItem("chemical E", 5000));
        itemList.add(new PurchasableItem("chemical A", 5000));
    }
}
