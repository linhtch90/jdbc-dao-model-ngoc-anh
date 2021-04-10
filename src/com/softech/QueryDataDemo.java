package com.softech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryDataDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://DESKTOP-I60MCK3\\SQLEXPRESS:1433;databaseName=DemoDB;user=sa;password=Abc@1234567";
		
		String sql = "select * from Student";
		
        try (
        		Connection con = DriverManager.getConnection(connectionUrl); 
        		Statement stmt = con.createStatement();
        		) {
//            String SQL = "SELECT TOP 10 * FROM Person.Contact";
//            ResultSet rs = stmt.executeQuery(SQL);
        	System.out.println("Connected...");
        	System.out.println("" + con);
        	System.out.println("" + stmt);
        	
        	try (ResultSet rs = stmt.executeQuery(sql);) {
        		while (rs.next()) {
        			System.out.println("EmployeeID: " + rs.getInt("EmployeeID") + " - Name: " + rs.getString("Name"));
        		}
        	}
        	
//        	int resultCount = stmt.executeUpdate(sql);
//        	System.out.println("Result count: " + resultCount);

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
