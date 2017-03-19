package com.pkrm.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.pkrm.domain.Employee;

@Repository
public class EmployeeRepository implements IEmployeeRepository{
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public String save(Employee employee) {
		mongoTemplate.save(employee);
		return "employee details are saved";
	}

}
