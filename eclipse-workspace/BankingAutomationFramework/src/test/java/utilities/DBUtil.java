package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/bankdb";
    private static final String USER = "root";
    private static final String PASSWORD = "Pankajrock@123";

    public static String getSingleData(String query, String columnName) {

        String value = "";

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                value = rs.getString(columnName);
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    public static void updateData(String query) {

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = con.createStatement();

            stmt.executeUpdate(query);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}