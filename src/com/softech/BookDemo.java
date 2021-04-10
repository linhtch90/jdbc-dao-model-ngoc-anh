package com.softech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BookDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String connectionUrl = "jdbc:sqlserver://DESKTOP-I60MCK3\\SQLEXPRESS:1433;databaseName=DemoDB;user=sa;password=Abc@1234567";

		String sqlCreateBookTable = "create table Book (BookID int, Title nvarchar(50), Quantity int, Price float)";
		
		String insertBook = "insert into Book values (?, ?, ?, ?)";
		
		try (
        		Connection con = DriverManager.getConnection(connectionUrl); 
        		Statement stmt = con.createStatement();
				PreparedStatement pstmt = con.prepareStatement(insertBook);
        		) {
			int resultReturn = stmt.executeUpdate(sqlCreateBookTable);
			
			int choice = 1;
			Scanner scanner = new Scanner(System.in);
			
			do {
				System.out.println("Insert data into Book table...");
				System.out.println("Book ID: ");
				int bookID = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("Title:");
				String bookTitle = scanner.nextLine();
				
				System.out.println("Quantity:");
				int bookQuantity = scanner.nextInt();
				
				System.out.println("Price:");
				float bookPrice = scanner.nextFloat();
				
				pstmt.setInt(1, bookID);
				pstmt.setString(2, bookTitle);
				pstmt.setInt(3, bookQuantity);
				pstmt.setFloat(4, bookPrice);
				
				resultReturn = pstmt.executeUpdate();
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
