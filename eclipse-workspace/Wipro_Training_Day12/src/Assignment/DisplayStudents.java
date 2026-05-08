package Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayStudents {

    public static void main(String[] args) {

        try {

            // Database Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/car_rental",
                    "root",
                    "Pankajrock@123");

            // SQL Query
            String query = "SELECT * FROM students";

            // Create Statement
            Statement st = con.createStatement();

            // Execute Query
            ResultSet rs = st.executeQuery(query);

            // Display Records
            System.out.println("Student Records:");
            System.out.println("-------------------------------");

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String course = rs.getString("course");

                System.out.println(
                        id + "  " +
                        name + "  " +
                        age + "  " +
                        course);
            }

            // Close Resources
            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}