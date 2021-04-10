package com.softech.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtils {
	public static Connection openConnection() throws SQLException {
		String connectionUrl = "jdbc:sqlserver://DESKTOP-I60MCK3\\SQLEXPRESS:1433;databaseName=DemoDB;user=sa;password=Abc@1234567";
		
		Connection con = DriverManager.getConnection(connectionUrl); 
		return con;
	}

}
