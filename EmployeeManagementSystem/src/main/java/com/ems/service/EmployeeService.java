package com.ems.service;

import java.util.List;

import com.ems.entity.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	List<Employee> getAllEmployee();

	Employee getEmployeeById(int employeeId);

	Employee updateEmployeeById(Employee employee, int employeeId);

	void deleteEmployeeById(int employeeId);

	List<Employee> getFirstName(String firstName);

	List<Employee> getLastName(String lastName);

	List<Employee> getEmployeeaddress(String employeeAddress);

	Employee getEmployeePhone(long employeePhone);

}
