/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Er.Himanshu
 */

package vit.devops.macse639.customermanagementsystem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date date;
    private String status;
    private List<OrderDetail> lineItems;
    private List<Payment> payments;

    public Order(String status) {
        this.date = new Date();
        this.status = status;
        this.lineItems = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    public void addLineItem(OrderDetail detail) {
        lineItems.add(detail);
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    public double calcSubTotal() {
        double total = 0;
        for (OrderDetail od : lineItems) {
            total += od.calcSubTotal();
        }
        return total;
    }

    public double calcTax() {
        double tax = 0;
        for (OrderDetail od : lineItems) {
            tax += od.calcTax();
        }
        return tax;
    }

    public double calcTotal() {
        return calcSubTotal() + calcTax();
    }

    public double calcTotalWeight() {
        double weight = 0;
        for (OrderDetail od : lineItems) {
            weight += od.calcWeight();
        }
        return weight;
    }

    public String getStatus() { return status; }
    public Date getDate() { return date; }
}