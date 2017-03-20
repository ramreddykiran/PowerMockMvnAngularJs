package com.pkrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(value="get-employee/{emp-id}", method=RequestMethod.GET)
	public ResponseEntity<?> getEmployee(@PathVariable(value="emp-id") String empId) {
		Employee employee = employeeService.getEmployee(empId);
		return null;
	}
	
	@RequestMapping(value="getEmployees", method=RequestMethod.GET)
	public ResponseEntity<?> getEmployees(@RequestParam(value="name", required=false) String empName) {
		return null;
	}
	

}
