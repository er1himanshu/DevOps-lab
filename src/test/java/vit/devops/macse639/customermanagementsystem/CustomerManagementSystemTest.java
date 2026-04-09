/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vit.devops.macse639.customermanagementsystem;

/**
 *
 * @author Er.Himanshu
 */


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;
import java.util.Date;

public class CustomerManagementSystemTest {

    // Test 1 — Order subtotal calculation
    @Test
    public void testCalcSubTotal() {
        Item laptop = new Item("Laptop", 2.5, 50000.0);
        OrderDetail od = new OrderDetail(2, "taxable", laptop);
        Order order = new Order("Pending");
        order.addLineItem(od);
        assertEquals(100000.0, order.calcSubTotal(), 0.01);
    }

    // Test 2 — Order tax calculation
    @Test
    public void testCalcTax() {
        Item mouse = new Item("Mouse", 0.3, 1000.0);
        OrderDetail od = new OrderDetail(1, "taxable", mouse);
        Order order = new Order("Pending");
        order.addLineItem(od);
        // 18% GST on 1000 = 180
        assertEquals(180.0, order.calcTax(), 0.01);
    }

    // Test 3 — Order total = subtotal + tax
    @Test
    public void testCalcTotal() {
        Item item = new Item("Keyboard", 0.5, 2000.0);
        OrderDetail od = new OrderDetail(1, "taxable", item);
        Order order = new Order("Pending");
        order.addLineItem(od);
        // subtotal=2000, tax=360, total=2360
        assertEquals(2360.0, order.calcTotal(), 0.01);
    }

    // Test 4 — Cash payment change calculation
    @Test
    public void testCashChange() {
        Cash cash = new Cash(500.0, 1000.0);
        assertEquals(500.0, cash.getChange(), 0.01);
    }

    // Test 5 — Check authorization with valid bank ID
    @Test
    public void testCheckAuthorizedValid() {
        Check chk = new Check(1000.0, "Himanshu", "VLD12345");
        assertTrue(chk.authorized());
    }

    // Test 6 — Check authorization with invalid bank ID
    @Test
    public void testCheckAuthorizedInvalid() {
        Check chk = new Check(1000.0, "Deep", "INV99999");
        assertFalse(chk.authorized());
    }

    // Test 7 — Credit card authorization with future date
    @Test
    public void testCreditAuthorized() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 2);
        Credit credit = new Credit(500.0, "Himanshu", "VISA", cal.getTime());
        assertTrue(credit.authorized());
    }

    // Test 8 — Customer name check
    @Test
    public void testCustomerName() {
        Customer customer = new Customer("Himanshu", "Vellore");
        assertEquals("Himanshu", customer.getName());
    }

    // Test 9 — Order total weight calculation
    @Test
    public void testCalcTotalWeight() {
        Item item = new Item("Laptop", 2.5, 50000.0);
        OrderDetail od = new OrderDetail(3, "taxable", item);
        Order order = new Order("Pending");
        order.addLineItem(od);
        // 2.5 * 3 = 7.5 kg
        assertEquals(7.5, order.calcTotalWeight(), 0.01);
    }

    // Test 10 — Item in stock check
    @Test
    public void testItemInStock() {
        Item item = new Item("Monitor", 3.0, 15000.0);
        assertTrue(item.inStock());
    }
}