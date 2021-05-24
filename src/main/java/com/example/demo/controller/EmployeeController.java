package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.Employee;
import com.example.demo.form.EmployeeForm;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeRepository repository;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@RequestMapping("/employee/new")
	public String empNew(@ModelAttribute EmployeeForm form) {
//		model.addAttribute("employeeForm", form);
		return "emp/new";
	}
	
	@PostMapping("/employee/new_confirm")
	public String empNewConfirm(@Valid @ModelAttribute EmployeeForm form,
			BindingResult result, RedirectAttributes flash) {
		if (result.hasErrors()) {
			return empNew(form);
		}
		return "emp/confirm";
	}
	
	@GetMapping("/employees")
	public String index(Model model) {
		model.addAttribute("emp", repository.findAll());
		return "emp/index";
	}
	
	@PostMapping("/employee")
	public String create(@Valid @ModelAttribute EmployeeForm form,
			BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/employee/new";
		}
		Employee emp = new Employee();
		emp.setEmpName(form.getEmpName());
		emp.setEmpPass(form.getEmpPass());
		emp.setGender(form.getGender());
		emp.setAddress(form.getAddress());
		emp.setBirthday(form.getBirthday());
		emp.setAuthority(form.getAuthority());
		emp.setDept(departmentRepository.getOne(form.getDeptId()));
		repository.save(emp);
		return "redirect:/employees";
	}
	
}









