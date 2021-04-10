package com.softech.model;

public class Employee {
	
	private int employeeID;
	private String name;
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Employee(int employeeID, String name) {
		
		this.employeeID = employeeID;
		this.name = name;
	}
	
	public Employee() {
		
	}
	
	

}
