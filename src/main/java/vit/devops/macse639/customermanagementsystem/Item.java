/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vit.devops.macse639.customermanagementsystem;

/**
 *
 * @author DELL
 */
public class Item {
    private double shippingWeight;
    private String description;
    private double pricePerUnit;

    public Item(String description, double shippingWeight, double pricePerUnit) {
        this.description = description;
        this.shippingWeight = shippingWeight;
        this.pricePerUnit = pricePerUnit;
    }

    public double getPriceForQuantity(int quantity) {
        return pricePerUnit * quantity;
    }

    public double getTax() {
        return pricePerUnit * 0.18; // 18% GST
    }

    public boolean inStock() {
        return true; // prototype always returns true
    }

    public double getShippingWeight() {
        return shippingWeight;
    }

    public String getDescription() {
        return description;
    }

}
