package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class MultipleInsert {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            // Database Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/car_rental",
                    "root",
                    "Pankajrock@123");

            // SQL Query
            String query = "INSERT INTO employees VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            System.out.print("How many records do you want to insert? ");
            int n = sc.nextInt();

            for (int i = 1; i <= n; i++) {

                System.out.println("\nEnter Details for Employee " + i);

                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Department: ");
                String department = sc.nextLine();

                System.out.print("Enter Salary: ");
                double salary = sc.nextDouble();

                // Set Values
                ps.setInt(1, id);
                ps.setString(2, name);
                ps.setString(3, department);
                ps.setDouble(4, salary);

                // Execute Insert
                ps.executeUpdate();

                System.out.println("Record Inserted Successfully");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}