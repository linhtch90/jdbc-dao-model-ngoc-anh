package com.softech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDataDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://DESKTOP-I60MCK3\\SQLEXPRESS:1433;databaseName=DemoDB;user=sa;password=Abc@1234567";
		
		String sql = "insert into Student(EmployeeID, name) values (3, 'Yen')";
		
        try (
        		Connection con = DriverManager.getConnection(connectionUrl); 
        		Statement stmt = con.createStatement();
        		) {
//            String SQL = "SELECT TOP 10 * FROM Person.Contact";
//            ResultSet rs = stmt.executeQuery(SQL);
        	System.out.println("Connected...");
        	System.out.println("" + con);
        	System.out.println("" + stmt);
        	
        	int resultCount = stmt.executeUpdate(sql);
        	System.out.println("Result count: " + resultCount);

            // Iterate through the data in the result set and display it.
//            while (rs.next()) {
//                System.out.println(rs.getString("FirstName") + " " + rs.getString("LastName"));
//            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

	}

}
