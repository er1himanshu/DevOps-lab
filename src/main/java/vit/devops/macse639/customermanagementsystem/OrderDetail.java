/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vit.devops.macse639.customermanagementsystem;

/**
 *
 * @author DELL
 */
public class OrderDetail {
     private int quantity;
    private String taxStatus;
    private Item item;

    public OrderDetail(int quantity, String taxStatus, Item item) {
        this.quantity = quantity;
        this.taxStatus = taxStatus;
        this.item = item;
    }

    public double calcSubTotal() {
        return item.getPriceForQuantity(quantity);
    }

    public double calcWeight() {
        return item.getShippingWeight() * quantity;
    }

    public double calcTax() {
        if (taxStatus.equalsIgnoreCase("taxable")) {
            return item.getTax() * quantity;
        }
        return 0.0;
    }

    public int getQuantity() { return quantity; }
    public String getTaxStatus() { return taxStatus; }
    public Item getItem() { return item; }

}
