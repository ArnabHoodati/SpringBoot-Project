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

import com.ems.entity.Department;
import com.ems.service.DepartmentService;

//Department controller to handling all rest api incoming request
@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentservice;

	// save department in db table using rest api PostMapping
	@PostMapping("/saveD")
	public ResponseEntity<Department> saveDepartment(@Valid @RequestBody Department department) {
		return new ResponseEntity<Department>(departmentservice.saveDepartment(department), HttpStatus.CREATED);
	}

	// fetch department details from the db table using rest api GetMapping
	@GetMapping("/getAllD")
	public List<Department> getAll() {
		return departmentservice.getAllDepartment();
	}

	// fetch department details from db table using rest api GetMapping based on id
	@GetMapping("/getD/{departmentId}")
	public ResponseEntity<Department> getE(@PathVariable("departmentId") int departmentId) {
		return new ResponseEntity<Department>(departmentservice.getDepartmentById(departmentId), HttpStatus.OK);
	}

	// update department details in db table using rest api PutMapping based on id
	@PutMapping("/updateD/{departmentId}")
	public ResponseEntity<Department> updateDepartment(@PathVariable("departmentId") int departmentId,
			@RequestBody Department Department) {
		return new ResponseEntity<Department>(departmentservice.updateDepartmentById(Department, departmentId),
				HttpStatus.OK);
	}

	// delete department details in db table using rest api PutMapping based on id
	@DeleteMapping("/deleteD/{departmentId}")
	public ResponseEntity<String> deleteDepartment(@PathVariable("departmentId") int departmentId) {
		departmentservice.deleteDepartmentById(departmentId);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}

//	@GetMapping("/getDn/{departmentName}")
//	List<Department> getDepartmentname(@PathVariable String departmentName) {
//		return departmentservice.getDepartmentname(departmentName);
//	}
//
//	@GetMapping("/getDh/{departmentHead}")
//	List<Department> getDepartmentHead(@PathVariable String departmentHead) {
//		return departmentservice.getDepartmentHead(departmentHead);
//	}
//
//	@GetMapping("/getDh/{departmentPhone}")
//	Department getdepartmentPhone(@PathVariable long departmentPhone) {
//		return departmentservice.getdepartmentPhone(departmentPhone);
//	}

}
