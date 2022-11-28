package com.ems.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "department_details")
@Entity
public class Department {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private int departmentId;

	@Column(length = 20, nullable = false)
	@NotBlank(message = "Enter department name")
	private String departmentName;

	@Column(length = 30, nullable = false)
	@NotBlank(message = "Enter department Ceo name")
	private String departmentHead;

	@Column(length = 11, nullable = false, unique = true)
	@NotNull(message = "Enter department phone no.")
	private long departmentPhone;

//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "departmentId")
//	private List<Employee> employee;

//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
//
//	@JsonManagedReference
//	private List<Employee> employee;

//	@OneToOne(targetEntity = Employee.class)
//	private Employee employee;
}
