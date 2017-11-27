package com.infotech.Dao;

import com.infotech.entites.Employee;

public interface EmployeeDao {
	
	public abstract void addEmployee(Employee employee);
	public abstract Employee fetchEmployeebyId(int employeeId);
	public abstract void updateEmployeebyId(int employeeId,Double newsal);
	public abstract void deleteEmployeebyId(Integer employeeId);

}
