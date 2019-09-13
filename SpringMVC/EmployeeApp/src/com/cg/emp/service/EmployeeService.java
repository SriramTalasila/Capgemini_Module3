package com.cg.emp.service;

import java.util.List;

import com.cg.emp.bean.Employee;
import com.cg.emp.exception.EmployeeException;

public interface EmployeeService {
	public List<Employee> getAllEmployees() throws EmployeeException;
	public List<Employee> deleteEmployee(int id) throws EmployeeException;
}
