package com.pkrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pkrm.domain.Employee;
import com.pkrm.exception.InvalidInputException;
import com.pkrm.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		String response = null;
		try {
			response = employeeService.save(employee);
		} catch (InvalidInputException e) {
			return new ResponseEntity<String>(e.getMessage() + "empId, empName and atlease one address is allowed",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

}
