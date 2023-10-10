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
public class Food {
    private final String foodName;
    private float price;
    private int quantity;

    public Food(String foodName, float price, int quantity) {
        this.foodName = foodName;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Food{" + "foodName=" + foodName + ", price=" + price + ", quantity=" + quantity + '}';
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    
}
