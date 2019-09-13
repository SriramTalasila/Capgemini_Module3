package com.cg.emp.dao;

import java.util.List;

import com.cg.emp.bean.Employee;
import com.cg.emp.exception.EmployeeException;

public interface EmployeeDao {
	
	public List<Employee> getAllEmployees() throws EmployeeException;
	
	public List<Employee> deleteEmployee(int id) throws EmployeeException;
}
