package com.softech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.softech.common.DbUtils;
import com.softech.model.Employee;

public class EmployeeDao {
	
	public boolean insert(Employee emp) throws SQLException {
		String sql = "insert into Student(EmployeeID, Name) values (?, ?)";
		try (
				Connection con = DbUtils.openConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				) {
			pstmt.setInt(1, emp.getEmployeeID());
			pstmt.setString(2, emp.getName());
			
			return pstmt.executeUpdate() > 0;
			
		}
	}
	
	public boolean update(Employee emp) throws SQLException {
		String sql = "update Student set Name = ? where EmployeeID = ?";
		try (
				Connection con = DbUtils.openConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				) {
			pstmt.setInt(2, emp.getEmployeeID());
			pstmt.setString(1, emp.getName());
			
			return pstmt.executeUpdate() > 0;
			
		}
	}
	
	public boolean delete(Employee emp) throws SQLException {
		String sql = "delete from Student where EmployeeID = ?";
		try (
				Connection con = DbUtils.openConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				) {
			pstmt.setInt(1, emp.getEmployeeID());
						
			return pstmt.executeUpdate() > 0;
			
		}
	}
	
	public Employee findByID(int employeeID) throws SQLException {
		String sql = "select * from Student where EmployeeID = ?";
		try (
				Connection con = DbUtils.openConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				) {
			pstmt.setInt(1, employeeID);
			
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					Employee emp = new Employee();
					emp.setEmployeeID(rs.getInt("EmployeeID"));
					emp.setName(rs.getString("Name"));
					
					return emp;
				}
				
			}
						
			return null;
			
		}
	}
	
	public List<Employee> findAll() throws SQLException {
		String sql = "select * from Student";
		try (
				Connection con = DbUtils.openConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				) {			
			try (ResultSet rs = pstmt.executeQuery()) {
				List<Employee> list = new ArrayList<Employee>();
				while (rs.next()) {
					Employee emp = new Employee();
					emp.setEmployeeID(rs.getInt("EmployeeID"));
					emp.setName(rs.getString("Name"));
					list.add(emp);				
					
				}
				return list;
				
			}		
			
		}
	}

}
