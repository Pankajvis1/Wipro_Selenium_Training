package Assignment;

import java.sql.*;

import java.util.Scanner;

public class InsertData {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String department = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/car_rental",
                    "root",
                    "Pankajrock@123");

            String query = "INSERT INTO employees VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, department);
            ps.setDouble(4, salary);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Data Inserted Successfully");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}