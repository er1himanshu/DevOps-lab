/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vit.devops.macse639.customermanagementsystem;

/**
 *
 * @author DELL
 */
public class Check extends Payment{
    private String name;
    private String bankID;

    public Check(double amount, String name, String bankID) {
        super(amount);
        this.name = name;
        this.bankID = bankID;
    }

    public boolean authorized() {
        // Prototype: authorize if bankID starts with "VLD"
        return bankID != null && bankID.startsWith("VLD");
    }

    @Override
    public String getPaymentInfo() {
        return "Check | Name: " + name + " | Bank: " + bankID + " | Authorized: " + authorized();
    }

}
