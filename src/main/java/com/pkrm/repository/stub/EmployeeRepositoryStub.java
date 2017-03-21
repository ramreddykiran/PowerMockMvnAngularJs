package com.pkrm.repository.stub;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.pkrm.domain.Employee;
import com.pkrm.repository.IEmployeeRepository;

@Repository
public class EmployeeRepositoryStub implements IEmployeeRepository{

	@Override
	public String save(Employee employee) {
		return null;
	}

	@Override
	public Employee getEmployee(String empId) {
		return null;
	}

	@Override
	public List<Employee> getEmployees(String empName) {
		return null;
	}

	@Override
	public List<Employee> getEmployees() {
		return null;
	}

}
