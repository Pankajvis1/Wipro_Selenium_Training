package carrental;

import java.sql.*;
import java.util.Scanner;

public class RentalService {

	public static void rentCar(Scanner sc) {

		try {
			Connection con = DBConnection.getConnection();

			// Customer details
			System.out.print("Customer Name: ");
			String name = sc.nextLine();

			System.out.print("Phone: ");
			String phone = sc.nextLine();

			// Insert customer
			PreparedStatement ps1 = con.prepareStatement("INSERT INTO customers(name, phone) VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps1.setString(1, name);
			ps1.setString(2, phone);
			ps1.executeUpdate();

			ResultSet rs = ps1.getGeneratedKeys();
			rs.next();
			int customerId = rs.getInt(1);

			// Car selection
			System.out.print("Car ID: ");
			int carId = sc.nextInt();

			System.out.print("Days: ");
			int days = sc.nextInt();
			sc.nextLine(); 

			// 🔍 Check availability
			ResultSet check = con.createStatement()
					.executeQuery("SELECT available, price_per_day FROM cars WHERE car_id=" + carId);

			if (!check.next()) {
				System.out.println("❌ Invalid Car ID");
				return;
			}

			boolean available = check.getBoolean("available");

			if (!available) {
				System.out.println("❌ Car not available");
				return;
			}

			double price = check.getDouble("price_per_day");
			double total = price * days;

			// Insert rental
			PreparedStatement ps2 = con.prepareStatement(
					"INSERT INTO rentals(customer_id, car_id, days, total_amount) VALUES (?, ?, ?, ?)");
			ps2.setInt(1, customerId);
			ps2.setInt(2, carId);
			ps2.setInt(3, days);
			ps2.setDouble(4, total);
			ps2.executeUpdate();

			// Update availability
			PreparedStatement updateCar = con.prepareStatement("UPDATE cars SET available = false WHERE car_id = ?");
			updateCar.setInt(1, carId);
			updateCar.executeUpdate();

			System.out.println("✅ Car rented successfully!");
			System.out.println("💰 Total Amount = ₹" + (int) total);

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}