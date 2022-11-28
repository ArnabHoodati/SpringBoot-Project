package com.ems.seviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Employee;
import com.ems.exception.EmployeeNotFoundException;
import com.ems.repositary.EmployeeRepositary;
import com.ems.service.EmployeeService;

//implementing all method of employee service
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepositary employeerepositary;

	// saving employee details using save() of jpaRepository
	@Override
	public Employee saveEmployee(Employee employee) {

		return employeerepositary.save(employee);
	}

	// fetching all employee details using finalAll() of JpaRepository
	@Override
	public List<Employee> getAllEmployee() {

		return employeerepositary.findAll();
	}

	// fetching employee details based on id using findById() of JpaRepository,
	// if not found then throw exception
	@Override
	public Employee getEmployeeById(int employeeId) {

		return employeerepositary.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("no employee exists in table"));
	}

	// fetching user details based on id using findById() of JpaRepository, if not
	// found throw exception
	// & update any contact details of employee
	@Override
	public Employee updateEmployeeById(Employee employee, int employeeId) {
		Employee newemployee = employeerepositary.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("no employee exists in table"));
		// updated value
		newemployee.setEmployeeEmailId(employee.getEmployeeEmailId());
		newemployee.setEmployeePhone(employee.getEmployeePhone());
		employeerepositary.save(newemployee);
		return newemployee;
	}

	// fetching user details based on id using findById() of JpaRepository, if not
	// found throw exception
	// delete enter employee id
	@Override
	public void deleteEmployeeById(int employeeId) {
		employeerepositary.findById(employeeId)
				.orElseThrow(() -> new EmployeeNotFoundException("no employee exists in table"));
		employeerepositary.deleteById(employeeId);

	}

	// fetching employee details based on first name
	@Override
	public List<Employee> getFirstName(String firstName) {

		return employeerepositary.getFirstName(firstName);
	}

	// fetching employee details based on last name
	@Override
	public List<Employee> getLastName(String lastName) {

		return employeerepositary.getLastName(lastName);
	}

	// fetching employee details based on address
	@Override
	public List<Employee> getEmployeeaddress(String employeeAddress) {

		return employeerepositary.getEmployeeaddress(employeeAddress);
	}

	// fetching employee details based on phone no.
	@Override
	public Employee getEmployeePhone(long employeePhone) {

		return employeerepositary.getEmployeePhone(employeePhone);
	}

}
