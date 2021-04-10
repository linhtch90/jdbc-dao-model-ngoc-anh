package com.softech.business;

import java.sql.SQLException;
import java.util.List;

import com.softech.dao.EmployeeDao;
import com.softech.model.Employee;

public class EmployeeBusiness {
	private EmployeeDao dao = new EmployeeDao();

	public boolean insert(Employee emp) throws SQLException {
		return dao.insert(emp);
	}

	public boolean update(Employee emp) throws SQLException {
		return dao.update(emp);
	}

	public boolean delete(Employee emp) throws SQLException {
		return dao.delete(emp);
	}

	public Employee findByID(int employeeID) throws SQLException {
		return dao.findByID(employeeID);
	}

	public List<Employee> findAll() throws SQLException {
		return dao.findAll();
	}
	
	

}
