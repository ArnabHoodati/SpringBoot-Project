package com.ems.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeId;

	@Column(length = 20, nullable = false)
	@NotBlank(message = "please enter firstname")
	private String firstName;

	@Column(length = 20, nullable = false)
	@NotBlank(message = "please enter lastname")
	private String lastName;

	@Column(length = 50, nullable = false)
	@NotBlank(message = "please enter address")
	private String employeeAddress;

	@Column(length = 11, nullable = false, unique = true)
	@NotNull(message = "please enter firstname")
	private long employeePhone;

	@Column(length = 10, nullable = false)
	@NotNull(message = "please enter employee salary")
	private double employeeSalary;

	@Column(length = 20, nullable = false, unique = true)
	@NotBlank(message = "please enter email id")
	@Email
	private String employeeEmailId;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "department_id")
	@NotNull(message = "please enter department id")
	private Department department;

//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.ALL)
//	@JsonBackReference
////	private List<Department> department;
//
////	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
////	@JoinColumn(name = "departmentid", referencedColumnName = "departmentId")
////	@JsonBackReference
//	private Department department;

//	@OneToOne(targetEntity = Department.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "department_id")
//	private Department department;

}
