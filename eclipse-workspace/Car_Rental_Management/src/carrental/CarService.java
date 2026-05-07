package carrental;

import java.sql.*;

public class CarService {

    public static void viewCars() {

        try {
            Connection con = DBConnection.getConnection();

            ResultSet rs = con.createStatement()
                    .executeQuery("SELECT * FROM cars");

            System.out.println("ID\tName\tModel\tPrice\tAvailable");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("car_id") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("model") + "\t" +
                        rs.getDouble("price_per_day") + "\t" +
                        rs.getBoolean("available")
                );
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}