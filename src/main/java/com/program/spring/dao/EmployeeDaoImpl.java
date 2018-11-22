package com.program.spring.dao;

import java.util.List;
import com.program.spring.model.Employee;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf)
	{
		this.sessionFactory = sf;
	}
	
	public List<Employee> getAllEmployee()
	{
		Session session = this.sessionFactory.getCurrentSession();
		List<Employee> employeeList = session.createQuery("from Employee").list();
		return employeeList;
	}
	
	public Employee getEmployee(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, id);
		return employee;
	}
	
	public Employee addEmployee(Employee employee)
	{
		Session session = this.sessionFactory.getCurrentSession();
		session.save(employee);
		return employee;
	}
	
	public void updateEmployee(Employee employee)
	{
		Session session = this.sessionFactory.getCurrentSession();
		Hibernate.initialize(employee);
		session.update(employee);

	}
	
	public void deleteEmployee(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();
		Employee e = (Employee) session.load(Employee.class, new Integer(id));
		if(null!=e)
		{
			session.delete(e);
		}
	}
	
	public Employee searchEmployee(int id)
	{
		Session session = this.sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, id);
		return employee;
	}
}
