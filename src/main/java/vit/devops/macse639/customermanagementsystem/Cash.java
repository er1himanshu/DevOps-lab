/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Er.Himanshu
 */
package vit.devops.macse639.customermanagementsystem;

public class Cash extends Payment {
    private double cashTendered;

    public Cash(double amount, double cashTendered) {
        super(amount);
        this.cashTendered = cashTendered;
    }

    public double getChange() {
        return cashTendered - amount;
    }

    @Override
    public String getPaymentInfo() {
        return "Cash | Tendered: " + cashTendered + " | Change: " + getChange();
    }
}