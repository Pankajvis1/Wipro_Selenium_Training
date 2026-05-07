package carrental;

import java.sql.*;
import java.util.Scanner;

public class BillingService {

    public static void generateBill(Scanner sc) {

        try {
            Connection con = DBConnection.getConnection();

            System.out.print("Enter Rental ID: ");
            int rentalId = sc.nextInt();
            sc.nextLine();

            String query =
                    "SELECT r.rental_id, c.name AS customer_name, " +
                    "ca.name AS car_name, ca.model, r.days, r.total_amount " +
                    "FROM rentals r " +
                    "JOIN customers c ON r.customer_id = c.customer_id " +
                    "JOIN cars ca ON r.car_id = ca.car_id " +
                    "WHERE r.rental_id = ?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, rentalId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int id = rs.getInt("rental_id");
                String customerName = rs.getString("customer_name");
                String carName = rs.getString("car_name");
                String model = rs.getString("model");
                int days = rs.getInt("days");
                double total = rs.getDouble("total_amount");

                double gst = total * 0.18;
                double finalAmount = total + gst;

                System.out.println("\n========== CAR RENTAL BILL ==========");
                System.out.println("Rental ID      : " + id);
                System.out.println("Customer Name  : " + customerName);
                System.out.println("Car            : " + carName + " " + model);
                System.out.println("Days Rented    : " + days);
                System.out.println("Rental Amount  : ₹" + (int) total);
                System.out.println("GST (18%)      : ₹" + (int) gst);
                System.out.println("-------------------------------------");
                System.out.println("Final Amount   : ₹" + (int) finalAmount);
                System.out.println("=====================================");

            } else {
                System.out.println("❌ Rental ID not found");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}