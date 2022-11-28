package com.ems.seviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Department;
import com.ems.exception.EmployeeNotFoundException;
import com.ems.repositary.DepartmentRepositary;
import com.ems.service.DepartmentService;

//implementing all method of department service
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepositary departmentrepositary;

	// saving department details using save() of jpaRepository
	@Override
	public Department saveDepartment(Department department) {

		return departmentrepositary.save(department);
	}

	// fetching all department details using finalAll() of JpaRepository
	@Override
	public List<Department> getAllDepartment() {

		return departmentrepositary.findAll();
	}

	// fetching department details based on id using findById() of JpaRepository,
	// if not found then throw exception
	@Override
	public Department getDepartmentById(int departmentId) {

		return departmentrepositary.findById(departmentId)
				.orElseThrow(() -> new EmployeeNotFoundException("no department exists in table"));
	}

	// fetching user details based on id using findById() of JpaRepository, if not
	// found throw exception
	// & update any contact details of department
	@Override
	public Department updateDepartmentById(Department department, int departmentId) {

		Department newdepartment = departmentrepositary.findById(departmentId)
				.orElseThrow(() -> new EmployeeNotFoundException("no department exists in table"));
		// updated value
		newdepartment.setDepartmentPhone(department.getDepartmentPhone());
		departmentrepositary.save(newdepartment);
		return newdepartment;
	}

	// fetching user details based on id using findById() of JpaRepository, if not
	// found throw exception
	// delete enter department id
	@Override
	public void deleteDepartmentById(int departmentId) {
		departmentrepositary.findById(departmentId)
				.orElseThrow(() -> new EmployeeNotFoundException("no department exists in table"));
		departmentrepositary.deleteById(departmentId);

	}

//	@Override
//	public List<Department> getDepartmentname(String departmentName) {
//
//		return departmentrepositary.getDepartmentname(departmentName);
//	}
//
//	@Override
//	public List<Department> getDepartmentHead(String departmentHead) {
//
//		return departmentrepositary.getDepartmentHead(departmentHead);
//	}
//
//	@Override
//	public Department getdepartmentPhone(long departmentPhone) {
//
//		return departmentrepositary.getdepartmentPhone(departmentPhone);
//	}

}
