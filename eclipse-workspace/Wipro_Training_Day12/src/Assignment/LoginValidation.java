package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginValidation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        try {

            // Database Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/car_rental",
                    "root",
                    "Pankajrock@123");

            // SQL Query
            String query = "SELECT * FROM users12 WHERE username=? AND password=?";

            // Prepared Statement
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password);

            // Execute Query
            ResultSet rs = ps.executeQuery();

            // Validate Login
            if (rs.next()) {
                System.out.println("Login Successful");
            } else {
                System.out.println("Invalid Username or Password");
            }

            // Close Resources
            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}