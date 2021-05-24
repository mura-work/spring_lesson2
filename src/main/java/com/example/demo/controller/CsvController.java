package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.config.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

@Controller
public class CsvController {
	@PostMapping(value = "/employee.csv",
      produces = MediaType.APPLICATION_OCTET_STREAM_VALUE + 
      "; charset=Shift_JIS; Content-Disposition: attachment")
	@ResponseBody
	 public Object getCsv(@ModelAttribute("csvform") Employee emp) throws JsonProcessingException {
		List<Employee> list = new ArrayList<Employee>();
		
		for (int i = 0; i < emp.getEmpId(); i++) {
			list.add(new Employee (
					emp.getEmpId(),
					emp.getEmpName(),
					emp.getGender(),
					emp.getAddress(),
					emp.getBirthday(),
					emp.getAuthority(),
					emp.getDeptName()
			));
		}
		
		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(Employee.class).withHeader();
		return mapper.writer(schema).writeValueAsString(list);
		}
}

