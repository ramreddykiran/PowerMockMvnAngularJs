package com.pkrm.controller;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.common.base.Optional;
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
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
 		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value="/get-employee/{emp-id}", method=RequestMethod.GET)
	public ResponseEntity<?> getEmployee(@PathVariable(value="emp-id") String empId) {
		Employee employee = employeeService.getEmployee(empId);
		if(!Optional.fromNullable(employee).isPresent()) {
			return new ResponseEntity<String>("employee is not present in DB ", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
	
	@RequestMapping(value="/get-employees", method=RequestMethod.GET)
	public ResponseEntity<?> getEmployees(@RequestParam(value="emp-name", required=false) String empName) {
		List<Employee> employees = null;
		try {
			employees = employeeService.getEmployees(empName);
		} catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(CollectionUtils.isEmpty(employees)) {
			return new ResponseEntity<String>("unable to retrieve employee details", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}
	

}
