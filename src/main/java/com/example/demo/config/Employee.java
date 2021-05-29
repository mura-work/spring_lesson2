package com.example.demo.config;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
@JsonPropertyOrder({
    "empId",
    "empName",
    "gender",
    "address",
    "birthday",
    "authority",
    "deptName"
})
public class Employee {
	@JsonProperty("empId")
	private Integer empId;
	
	@JsonProperty("empName")
	private String empName;
	
	@JsonProperty("gender")
	private Integer gender;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("birthday")
	private Date birthday;
	
	@JsonProperty("authority")
	private Integer authority;
	
	@JsonProperty("deptName")
	private String deptName;
	
	public Employee(){}

	public Employee(Integer empId, String empName, Integer gender, String address, Date birthday, Integer authority,
			String deptName) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.authority = authority;
		this.deptName = deptName;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
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

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
