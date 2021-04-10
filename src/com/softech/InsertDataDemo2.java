package com.softech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDataDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://DESKTOP-I60MCK3\\SQLEXPRESS:1433;databaseName=DemoDB;user=sa;password=Abc@1234567";
		
		String sql = "insert into Student(EmployeeID, name) values (?, ?)";
		
        try (
        		Connection con = DriverManager.getConnection(connectionUrl); 
        		PreparedStatement pstmt = con.prepareStatement(sql);
        		) {
//            String SQL = "SELECT TOP 10 * FROM Person.Contact";
//            ResultSet rs = stmt.executeQuery(SQL);
        	System.out.println("Connected...");
        	Scanner scanner = new Scanner(System.in);
        	int choice = 0;
        	do {
        		System.out.println("Employee ID: ");
        		int id = scanner.nextInt();
        		scanner.nextLine();
        		
        		System.out.println("Name: ");
        		String name = scanner.nextLine();
        		
        		pstmt.setInt(1, id);
        		pstmt.setString(2, name);
        		
        		int result = pstmt.executeUpdate();
        		System.out.println("Exit? Press 0...");
        		choice = scanner.nextInt();
        	} while (choice != 0);
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

	}

}
