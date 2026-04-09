package vit.devops.macse639.customermanagementsystem;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {

        Item laptop = new Item("Laptop", 2.5, 55000.0);
        Item mouse  = new Item("Wireless Mouse", 0.3, 800.0);

        OrderDetail od1 = new OrderDetail(1, "taxable", laptop);
        OrderDetail od2 = new OrderDetail(2, "taxable", mouse);

        Order order = new Order("Pending");
        order.addLineItem(od1);
        order.addLineItem(od2);

        Customer customer = new Customer("Himanshu", "Vellore, TN");
        customer.addOrder(order);

        StringBuilder sb = new StringBuilder();
        sb.append("=== Customer Management System ===\n");
        sb.append(customer).append("\n");
        sb.append("Order Status : ").append(order.getStatus()).append("\n");
        sb.append(String.format("Sub Total    : Rs. %.2f%n", order.calcSubTotal()));
        sb.append(String.format("Tax          : Rs. %.2f%n", order.calcTax()));
        sb.append(String.format("Total        : Rs. %.2f%n", order.calcTotal()));
        sb.append(String.format("Total Weight : %.2f kg%n", order.calcTotalWeight()));

        Cash cash = new Cash(order.calcTotal(), 60000.0);
        sb.append("\n--- Payment ---\n");
        sb.append(cash.getPaymentInfo()).append("\n");

        Check chk = new Check(1000.0, "Himanshu", "VLD12345");
        sb.append(chk.getPaymentInfo()).append("\n");

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, 2);
        Date futureDate = cal.getTime();
        Credit credit = new Credit(500.0, "Himanshu", "VISA", futureDate);
        sb.append(credit.getPaymentInfo()).append("\n");

        String output = sb.toString();
        System.out.println(output);

        // THIS PART keeps Render alive
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", exchange -> {
            byte[] response = output.getBytes();
            exchange.getResponseHeaders().set("Content-Type", "text/plain");
            exchange.sendResponseHeaders(200, response.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response);
            }
        });
        server.start();
        System.out.println("Server running on port " + port);
    }
}