package com.infotech.servic.impl;

import com.infotech.daoimpl.EmployeeDaoImpl;
import com.infotech.entites.Employee;
import com.infotech.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public void CreateEmployee(Employee employee) {
		new EmployeeDaoImpl().addEmployee(employee);
		
	}

	@Override
	public Employee getEmployeebyId(int employeeId) {
		return new EmployeeDaoImpl().fetchEmployeebyId(employeeId);
	}

	@Override
	public void updateEmployeebyId(int employeeId, Double newsal) {
		new EmployeeDaoImpl().updateEmployeebyId(employeeId, newsal);
	}

	@Override
	public void deleteEmployeebyId(Integer employeeId) {
		new EmployeeDaoImpl().deleteEmployeebyId(employeeId);
	}

}
