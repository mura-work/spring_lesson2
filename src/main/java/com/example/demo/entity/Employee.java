package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_emp_gen")
	@SequenceGenerator(name = "seq_emp_gen", sequenceName ="seq_emp_gen", allocationSize = 1)
	@Column(name = "emp_id")
	private Integer empId;
	
	@Column(name = "emp_pass")
	private String empPass;
	
	@Column(name = "emp_name")
	private String empName;
	
	@Column(name = "gender")
	private Integer gender;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "birthday")
	private Date birthday;
	
	@Column(name = "authority")
	private Integer authority;
	
	@ManyToOne
	@JoinColumn(name = "dept_id", referencedColumnName="dept_id")
	private Department dept;
	
	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpPass() {
		return empPass;
	}

	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getAuthority() {
		return authority;
	}

	public void setAuthority(Integer authority) {
		this.authority = authority;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
}
