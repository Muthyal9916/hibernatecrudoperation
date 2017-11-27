package com.infotech.service;


import com.infotech.entites.Employee;

public interface EmployeeService {

	public abstract void CreateEmployee(Employee employee);
	public abstract Employee getEmployeebyId(int employeeId);
	public abstract void updateEmployeebyId(int employeeId,Double newsal);
	public abstract void deleteEmployeebyId(Integer employeeId);
}
