package com.infotech.client;

import java.util.Date;

import org.hibernate.Session;

import com.infotech.entites.Employee;
import com.infotech.util.HibernateUtil;

public class ClientTest {

	public static void main(String[] args) {

		
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			//	CreateEmployee(session);;
			//	getEmployeebyId(session);
			//	updateEmployeebyId(session);	
			deleteEmployeebyId(session);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void deleteEmployeebyId(Session session) {

		Employee employee = session.get(Employee.class, 2);
		if(employee != null) {
			session.beginTransaction();
			session.delete(employee);
			session.getTransaction().commit();
			
		}else {
			System.out.println("Employee dosen't exist with provided id,,,.");
		}
	}

	private static void updateEmployeebyId(Session session) {
		Employee employee = session.get(Employee.class, 2);
		if(employee != null) {
			
			employee.setSalary(65000.00);
			
			session.beginTransaction();
			session.update(employee);
			session.getTransaction().commit();
			
		}else {
			System.out.println("Employee dosen't exist with provided id,,,.");
		}
		
	}

	private static void getEmployeebyId(Session session) {
		Employee employee = session.load(Employee.class, 21);
		if(employee != null) {
			System.out.println(employee);
		}else {
			System.out.println("Employee dosen't exist with provided id,,,.");
		}
	}
	
	private static void CreateEmployee(Session session) {
		session.beginTransaction();
		Integer id = (Integer) session.save(getEmployee());
		System.out.println("Employee  is created with id::"+id);
		session.getTransaction().commit();
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
