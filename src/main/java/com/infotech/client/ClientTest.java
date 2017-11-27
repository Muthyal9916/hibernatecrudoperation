package com.infotech.client;

import java.util.Date;

import org.hibernate.Session;

import com.infotech.entites.Employee;
import com.infotech.servic.impl.EmployeeServiceImpl;
import com.infotech.service.EmployeeService;
import com.infotech.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {
		EmployeeService empService = new EmployeeServiceImpl();
		
//		CreateEmployee(empService);
//		getEmployeebyId(empService);
//		updateEmployeebyId(empService);	
		deleteEmployeebyId(empService);
		
	}
	
	private static void deleteEmployeebyId(EmployeeService empService) {
        empService.deleteEmployeebyId(1);
	}

	private static void updateEmployeebyId(EmployeeService empService) {
		 empService.updateEmployeebyId(1,65000.00);

	}

	private static void getEmployeebyId(EmployeeService empService) {
		Employee employee = empService.getEmployeebyId(1);
		System.out.println(employee);
	}
	
	private static void CreateEmployee(EmployeeService empService) {
		empService.CreateEmployee(getEmployee());	
	}
	
	
	private static Employee getEmployee() {
		
		Employee emp = new Employee();
		emp.setEmployeeName("muthu");
		emp.setEmail("muthu@gmial.com");
		emp.setSalary(45122.00);
		emp.setDoj(new Date());
		return emp;
	}

}
