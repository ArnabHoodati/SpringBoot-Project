package com.ems.service;

import java.util.List;

import com.ems.entity.Department;

public interface DepartmentService {

	Department saveDepartment(Department department);

	List<Department> getAllDepartment();

	Department getDepartmentById(int departmentId);

	Department updateDepartmentById(Department department, int departmentId);

	void deleteDepartmentById(int departmentId);

//	List<Department> getDepartmentname(String departmentName);
//
//	List<Department> getDepartmentHead(String departmentHead);
//
//	Department getdepartmentPhone(long departmentPhone);

}
