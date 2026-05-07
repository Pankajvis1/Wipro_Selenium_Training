package Sarthak_clinic;

import java.sql.*;

public class Jdbc_conn {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // Database credentials
        String url = "jdbc:mysql://localhost:3306/mydata";
        String user = "root";
        String password = "Pankajrock@123";

        // Load and register driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish connection
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("Connection created");

        // Create statement
        Statement stmt = con.createStatement();

        // Execute query
        ResultSet rs = stmt.executeQuery("SELECT * FROM Student");

        // Process result
        System.out.println("rollno\tName\tper");
        while (rs.next()) {
            int rollno = rs.getInt("rollno");
            String name = rs.getString("name");
            float per = rs.getFloat("per");

            System.out.println(rollno +" " + "\t" + name+ " " + "\t" + per+ " ");
        }

        // Close resources
        rs.close();
        stmt.close();
        con.close();
        
        System.out.println("Connection closed");
    }
}