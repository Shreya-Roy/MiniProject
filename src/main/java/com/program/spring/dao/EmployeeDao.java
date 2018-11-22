package com.program.spring.dao;

import java.util.List;
import com.program.spring.model.Employee;

public interface EmployeeDao 
{
	public List<Employee> getAllEmployee();
	public Employee getEmployee(int id);
	public Employee addEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(int id);
	public Employee searchEmployee(int id);
}
