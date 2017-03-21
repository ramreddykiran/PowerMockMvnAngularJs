package com.pkrm.repository;

import java.util.List;

import com.pkrm.domain.Employee;

public interface IEmployeeRepository {

	String save(Employee employee);

	Employee getEmployee(String empId);

	List<Employee> getEmployees(String empName);

	List<Employee> getEmployees();

}
