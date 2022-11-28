package com.ems.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ems.entity.Employee;

public interface EmployeeRepositary extends JpaRepository<Employee, Integer> {

	@Query("select e from Employee e where e.firstName = ?1")
	List<Employee> getFirstName(String firstName);

	@Query("select e from Employee e where e.lastName = ?1")
	List<Employee> getLastName(String lastName);

	@Query("select e from Employee e where e.employeeAddress = ?1")
	List<Employee> getEmployeeaddress(String employeeAddress);

	@Query("select e from Employee e where e.employeePhone = ?1")
	Employee getEmployeePhone(long employeePhone);

}
