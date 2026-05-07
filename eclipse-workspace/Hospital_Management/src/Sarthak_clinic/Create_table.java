package Sarthak_clinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_table {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/mydata";
		String user = "root";
		String password = "Pankajrock@123";

		// create table
		String sql = "create table if not exists students(rollno int," + " name varchar(50)," + " per int,"
				+ " email varchar(50))";

		// insert record
		String insertSQL = "insert into students values(101,'Neeva Sharma',98,'abc@gmail.com'),"
				+ "(102,'Reeva Sharma',89,'Reeva@gmail.com')," + "(103,'Shiva Upadhyay',79,'shiva@gmail.com'),"
				+ "(104,'Aman Verma',85,'aman@gmail.com')," + "(105,'Riya Singh',91,'riya@gmail.com')";

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			// establish connection
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection created");

			// create statement
			Statement stmt = con.createStatement();

			// create table
			stmt.executeUpdate(sql);
			System.out.println("Students table ready");

			// truncate old data
			stmt.executeUpdate("TRUNCATE TABLE students");
			System.out.println("Old records deleted");

			// insert new records
			int rowInserted = stmt.executeUpdate(insertSQL);
			if (rowInserted > 0) {
				System.out.println("New student records inserted");
			}

			// display table
			ResultSet rs = stmt.executeQuery("SELECT * FROM students");
			System.out.println("rollno\tname\tPer\temail");

			while (rs.next()) {
				int rollno = rs.getInt("rollno");
				String name = rs.getString("name");
				int per = rs.getInt("per");
				String email = rs.getString("email");

				System.out.println(rollno + "\t" + name + "\t" + per + "\t" + email);
			}

			// close resources
			rs.close();
			stmt.close();
			con.close();

		} catch (SQLException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
	}
}