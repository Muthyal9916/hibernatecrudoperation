package com.infotech.daoimpl;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.infotech.Dao.EmployeeDao;
import com.infotech.entites.Employee;
import com.infotech.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public void addEmployee(Employee employee) {
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			session.beginTransaction();
			Integer id = (Integer) session.save(employee);
			System.out.println("Employee  is created with id::"+id);
			session.getTransaction().commit();
			
		}catch (HibernateException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Employee fetchEmployeebyId(int employeeId) {
		Employee employee = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			employee = session.get(Employee.class, employeeId);
			if(employee != null) {
				return employee;
			}else {
				System.out.println("Employee dosen't exist with provided id,,,.");
			}
			
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateEmployeebyId(int employeeId, Double newsal) {
		
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			Employee employee = session.get(Employee.class, employeeId);
			if(employee != null) {
				
				employee.setSalary(newsal);
				
				session.beginTransaction();
				session.update(employee);
				session.getTransaction().commit();
				
			}else {
				System.out.println("Employee dosen't exist with provided id,,,.");
			}
			
		}catch (HibernateException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteEmployeebyId(Integer employeeId) {
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			Employee employee = session.get(Employee.class, employeeId);
			if(employee != null) {
				
				session.beginTransaction();
				session.delete(employee);
				session.getTransaction().commit();
				
			}else {
				System.out.println("Employee dosen't exist with provided id,,,.");
			}
		}catch (HibernateException e) {
			e.printStackTrace();
		}

	}

}
