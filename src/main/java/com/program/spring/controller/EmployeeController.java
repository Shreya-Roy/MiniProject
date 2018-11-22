package com.program.spring.controller;

import java.util.List;
import com.program.spring.model.Employee;
import com.program.spring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController 
{
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "/getAllEmployee" ,  method = RequestMethod.GET ,headers = "Accept=application/json")
	public String getAllEmployee(Model model)
	{
		List<Employee> listofEmployee = employeeService.getAllEmployee();
		model.addAttribute("employee" , new Employee());
		model.addAttribute("listofEmployee",listofEmployee);
		return "employeeDetails";
	}
	
	@RequestMapping(value = "/" , method = RequestMethod.GET, headers = "Accept=application/json")
	public String goToHomePage()
	{
		return "redirect:/getAllEmployee";
	}
	
	@RequestMapping(value = "/getEmployee/{id}" , method = RequestMethod.GET,headers = "Accept=application/json")
	public Employee getEmployeeById(@PathVariable int id)
	{
		return employeeService.getEmployee(id);
	}
	
	@RequestMapping(value = "/addEmployee" , method = RequestMethod.POST,headers = "Accept=application/json")
	public String addEmployee(@ModelAttribute("employee") Employee employee)
	{
		if(employee.getId()==0)
		{
			employeeService.addEmployee(employee);
		}
		else
		{
			employeeService.updateEmployee(employee);
		}
		return "redirect:/getAllEmployee";
	}
	
	@RequestMapping(value = "/updateEmployee/{id}" , method = RequestMethod.GET, headers = "Accept=application/json")
	public String updateEmployee(@PathVariable("id") int id , Model model)
	{
		model.addAttribute("employee",this.employeeService.getEmployee(id));
		model.addAttribute("listofEmployee", this.employeeService.getAllEmployee());
		return "employeeDetails";
	}
	
	@RequestMapping(value = "/deleteEmployee/{id}" , method = RequestMethod.GET,headers = "Accept=application/json" )
	public String deleteEmployee(@PathVariable("id") int id)
	{
		employeeService.deleteEmployee(id);
		return "redirect:/getAllEmployee";
	}
	
	@RequestMapping(value = "/searchEmployee/searchView" , method = RequestMethod.GET , headers = "Accept=application/json")
	public String searchEmployee(@PathVariable("id") int id)
	{
		employeeService.searchEmployee(id);
		return "searchView";
	}
}
