package com.pkrm.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.pkrm.domain.Employee;
import com.pkrm.exception.DataAccessException;

@Repository
public class EmployeeRepository implements IEmployeeRepository{
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public String save(Employee employee) {
		try{
			mongoTemplate.save(employee);
		} catch(Exception e) {
			throw new DataAccessException(e.getMessage(), e);
		}
			
		return "employee details are saved";
	}

	@Override
	public Employee getEmployee(String empId) {
		Employee employee = null;
		try {
			Query query = new Query();
			query.addCriteria(new Criteria().and("_id").is(empId));
			employee = mongoTemplate.findOne(query, Employee.class);
		} catch(Exception e) {
			throw new DataAccessException(e.getMessage(), e);
		}
		return employee;
	}

}
