package com.softech.dao;

import java.util.List;

import com.softech.model.Employee;

public class DaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Employee emp = new Employee(45, "Testing");
			EmployeeDao dao = new EmployeeDao();
			
			dao.insert(emp);
			
			List<Employee> list = dao.findAll();
			
			list.forEach(item -> {
				System.out.println("Name: " + item.getName());
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
