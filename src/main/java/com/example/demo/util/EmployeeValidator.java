package com.example.demo.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.example.demo.form.EmployeeForm;

public class EmployeeValidator implements ConstraintValidator<Employee, EmployeeForm> {
//	private String empPass;
  private String empName;
//  private String address;
//  private String birthday;
	
	private Employee emp;
  
  @Override
  public void initialize(Employee annotation) {
      this.empName = annotation.fieldEmpName();
//      this.empPass = annotation.fieldEmpPass();
//      this.address = annotation.fieldAddress();
//      this.birthday = annotation.fieldBirthday();
  	
//  	this.emp = annotation;
  }
  @Override
  public boolean isValid(EmployeeForm value, ConstraintValidatorContext context) {
      BeanWrapper beanWrapper = new BeanWrapperImpl(value);
//      String empPass = (String) beanWrapper.getPropertyValue(this.empPass);
      String empName = (String) beanWrapper.getPropertyValue(this.empName);
//      String address = (String) beanWrapper.getPropertyValue(this.address);
//      String birthday = (String) beanWrapper.getPropertyValue(this.birthday);
  	if (empName.length() > 16) {
  		return false;
  	}
  	
  	if (value.getEmpPass().isEmpty() 
  			|| value.getEmpName() .isEmpty()
  			|| value.getAddress().isEmpty()) {
  		return false;
  	}
      return true;
      
  }
}
