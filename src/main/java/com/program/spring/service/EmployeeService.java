package com.program.spring.service;

import java.util.List;
import javax.transaction.Transactional;
import com.program.spring.model.Employee;
import com.program.spring.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeservice")
public class EmployeeService 
{
	@Autowired
	EmployeeDao employeeDao;
	
	@Transactional
	public List<Employee> getAllEmployee()
	{
		return employeeDao.getAllEmployee();
	}
	
	@Transactional
	public Employee getEmployee(int id)
	{
		return employeeDao.getEmployee(id);
	}
	
	@Transactional
	public void addEmployee(Employee employee)
	{
		employeeDao.addEmployee(employee);
	}
	
	@Transactional
	public void updateEmployee(Employee employee)
	{
		employeeDao.updateEmployee(employee);
	}
	
	@Transactional
	public void deleteEmployee(int id)
	{
		employeeDao.deleteEmployee(id);
	}
	
	@Transactional
	public void searchEmployee(int id)
	{
		employeeDao.searchEmployee(id);
	}
	
}
