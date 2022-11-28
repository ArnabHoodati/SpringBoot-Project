package com.ems.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entity.Employee;
import com.ems.service.EmployeeService;

//Employee controller to handling all rest api incoming request
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;

	// save employee save in db table using rest api PostMapping
	@PostMapping("/saveE")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeservice.saveEmployee(employee), HttpStatus.CREATED);
	}

	// fetch employee details from the db table using rest api GetMapping
	@GetMapping("/getAllE")
	public List<Employee> getAll() {
		return employeeservice.getAllEmployee();
	}

	// fetch employee details from db table using rest api GetMapping based on id
	@GetMapping("/getE/{employeeId}")
	public ResponseEntity<Employee> getE(@PathVariable("employeeId") int employeeId) {
		return new ResponseEntity<Employee>(employeeservice.getEmployeeById(employeeId), HttpStatus.OK);
	}

	// update employee details in db table using rest api PutMapping based on id
	@PutMapping("/updateE/{employeeId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("employeeId") int employeeId,
			@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeservice.updateEmployeeById(employee, employeeId), HttpStatus.OK);
	}

	// delete employee details in db table using rest api PutMapping based on id
	@DeleteMapping("/deleteE/{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId") int employeeId) {
		employeeservice.deleteEmployeeById(employeeId);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}

	// fetch employee details from db table using rest api GetMapping based on
	// firstname
	@GetMapping("/getFn/{firstName}")
	public List<Employee> getFname(@PathVariable String firstName) {
		return employeeservice.getFirstName(firstName);
	}

	// fetch employee details from db table using rest api GetMapping based on
	// lastname
	@GetMapping("/getLn/{lastName}")
	public List<Employee> getLname(@PathVariable String lastName) {
		return employeeservice.getLastName(lastName);
	}

	// fetch employee details from db table using rest api GetMapping based on
	// address
	@GetMapping("/getaddress/{employeeAddress}")
	public List<Employee> getEmployeeaddress(@PathVariable String employeeAddress) {
		return employeeservice.getEmployeeaddress(employeeAddress);

	}

	// fetch employee details from db table using rest api GetMapping based on
	// phone no.
	@GetMapping("/getPh/{employeePhone}")
	public Employee getEmployeePhone(@PathVariable long employeePhone) {
		return employeeservice.getEmployeePhone(employeePhone);
	}

}
