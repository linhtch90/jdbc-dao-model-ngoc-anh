package com.softech;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CallableStatementDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://DESKTOP-I60MCK3\\SQLEXPRESS:1433;databaseName=DemoDB;user=sa;password=Abc@1234567";
		
		String sql = "{call FindAll()}";
		
        try (
        		Connection con = DriverManager.getConnection(connectionUrl); 
        		CallableStatement cstmt = con.prepareCall(sql);
        		) {
            try (ResultSet rs = cstmt.executeQuery();) {
            	while (rs.next()) {
            		System.out.println("Book ID: " + rs.getInt("BookID") + " - Title: " + rs.getString("Title"));
            	}
            }
        	
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

	}

}
