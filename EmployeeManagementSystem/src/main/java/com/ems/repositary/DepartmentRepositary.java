package com.ems.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.entity.Department;

public interface DepartmentRepositary extends JpaRepository<Department, Integer> {
//	@Query("select d from department d where d.departmentId = ?1")
//	Department getdepartmentId(int departmentId);
//
//	@Query("select d from department d where d.departmentName = ?1")
//	List<Department> getDepartmentname(String departmentName);
//
//	@Query("select d from department d where d.departmentHead = ?1")
//	List<Department> getDepartmentHead(String departmentHead);
//
//	@Query("select d from department d where d.departmentPhone = ?1")
//	Department getdepartmentPhone(long departmentPhone);

}
