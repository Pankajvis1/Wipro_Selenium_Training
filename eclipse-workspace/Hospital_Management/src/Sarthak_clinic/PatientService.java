package Sarthak_clinic;
import java.sql.*;
import java.util.Scanner;

public class PatientService {
    public static void registerPatient(Scanner sc) {
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("Name: ");
            String name = sc.nextLine();
            sc.nextLine();
            System.out.println("Age: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.println("Gender: ");
            String gender = sc.nextLine();
            System.out.println("Phone: ");
            String phone = sc.nextLine();
            System.out.println("Address: ");
            String address = sc.nextLine();

            String sql = "INSERT INTO patients (name, age, gender, phone, address) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, gender);
            ps.setString(4, phone);
            ps.setString(5, address);
            ps.executeUpdate();

            System.out.println("✅ Patient registered successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewPatients() {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM patients";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.printf("\n%-5s %-20s %-5s %-10s %-15s %-30s\n", "ID", "Name", "Age", "Gender", "Phone", "Address");
            while (rs.next()) {
                System.out.printf("%-5d %-20s %-5d %-10s %-15s %-30s\n",
                        rs.getInt("patient_id"), rs.getString("name"), rs.getInt("age"),
                        rs.getString("gender"), rs.getString("phone"), rs.getString("address"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
