package com.pkrm.service;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pkrm.domain.Employee;
import com.pkrm.exception.InvalidInputException;
import com.pkrm.repository.IEmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private IEmployeeRepository employeeRepository;

	public String save(Employee employee) throws InvalidInputException {
		validateEmployee(employee);
		return employeeRepository.save(employee);
	}

	private void validateEmployee(Employee employee) throws InvalidInputException {
		if(StringUtils.isBlank(employee.getEmpId()) || StringUtils.isBlank(employee.getEmpName())
				|| CollectionUtils.isEmpty(employee.getAddresses())){
			throw new InvalidInputException("Input is invalid");
		}
	}

}
