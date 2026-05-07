package carrental;

import java.sql.*;
import java.util.Scanner;

public class ReturnService {

    public static void returnCar(Scanner sc) {

        try {

            Connection con = DBConnection.getConnection();

            System.out.print("Enter Car ID to return: ");
            int carId = sc.nextInt();
            sc.nextLine();

            double penalty = 0;

            // Car Inspection
            System.out.println("\n🔍 Car Inspection");

            System.out.print("Any damage in car? (yes/no): ");
            String damage = sc.nextLine();

            System.out.print("Fuel level full? (yes/no): ");
            String fuel = sc.nextLine();

            System.out.print("Car returned late? (yes/no): ");
            String late = sc.nextLine();

            // Damage penalty
            if (damage.equalsIgnoreCase("yes")) {

                penalty += 50000;
                System.out.println("⚠ Damage penalty added: ₹50000");

            } else {

                System.out.println("✅ No damage found");
            }

            // Fuel penalty
            if (fuel.equalsIgnoreCase("no")) {

                penalty += 10000;
                System.out.println("⚠ Fuel penalty added: ₹10000");

            } else {

                System.out.println("✅ Fuel level checked");
            }

            // Late return penalty
            if (late.equalsIgnoreCase("yes")) {

                penalty += 20000;
                System.out.println("⚠ Late return penalty added: ₹20000");

            } else {

                System.out.println("✅ Returned on time");
            }

            // Final inspection result
            if (penalty > 0) {

                System.out.println("\n❌ Car inspection failed");
                System.out.println("💰 Total Penalty Amount: ₹" + (int) penalty);

            } else {

                System.out.println("\n✅ Car inspection passed");
            }

            // Update availability
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE cars SET available = true WHERE car_id = ?"
            );

            ps.setInt(1, carId);

            int rows = ps.executeUpdate();

            if (rows > 0) {

                System.out.println("✅ Car returned successfully");
                System.out.println("🚗 Car is now available");

            } else {

                System.out.println("❌ Invalid Car ID");
            }

            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}