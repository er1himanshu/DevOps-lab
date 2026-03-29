/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vit.devops.macse639.customermanagementsystem;

/**
 *
 * @author DELL
 */
public class Credit extends Payment {
    private String name;
    private String type;
    private Date expDate;

    public Credit(double amount, String name, String type, Date expDate) {
        super(amount);
        this.name = name;
        this.type = type;
        this.expDate = expDate;
    }

    public boolean authorized() {
        // Prototype: authorize if card is not expired
        return expDate != null && expDate.after(new Date());
    }

    @Override
    public String getPaymentInfo() {
        return "Credit | Name: " + name + " | Type: " + type + " | Authorized: " + authorized();
    }
}

