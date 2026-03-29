/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Er.Himanshu
 */
package vit.devops.macse639.customermanagementsystem;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // --- Create Items ---
        Item laptop = new Item("Laptop", 2.5, 55000.0);
        Item mouse  = new Item("Wireless Mouse", 0.3, 800.0);

        // --- Create Order Details ---
        OrderDetail od1 = new OrderDetail(1, "taxable", laptop);
        OrderDetail od2 = new OrderDetail(2, "taxable", mouse);

        // --- Create Order ---
        Order order = new Order("Pending");
        order.addLineItem(od1);
        order.addLineItem(od2);

        // --- Create Customer and attach order ---
        Customer customer = new Customer("Himanshu", "Chennai, TN");
        customer.addOrder(order);

        // --- Print Order Summary ---
        System.out.println("=== Customer Management System ===");
        System.out.println(customer);
        System.out.println("Order Status : " + order.getStatus());
        System.out.printf("Sub Total    : Rs. %.2f%n", order.calcSubTotal());
        System.out.printf("Tax          : Rs. %.2f%n", order.calcTax());
        System.out.printf("Total        : Rs. %.2f%n", order.calcTotal());
        System.out.printf("Total Weight : %.2f kg%n",  order.calcTotalWeight());

        // --- Payment: Cash ---
        Cash cash = new Cash(order.calcTotal(), 60000.0);
        System.out.println("\n--- Payment ---");
        System.out.println(cash.getPaymentInfo());

        // --- Payment: Check ---
        Check chk = new Check(1000.0, "Himanshu", "VLD12345");
        System.out.println(chk.getPaymentInfo());

        // --- Payment: Credit ---
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 2); // card expires 2 years from now
        Date futureDate = cal.getTime();
        Credit credit = new Credit(500.0, "Himanshu", "VISA", futureDate);
        System.out.println(credit.getPaymentInfo());
    }
}