package com.pkrm.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection="employee")
@Setter
@Getter
public class Employee {
	
	@Id
	private String empId;
	private String empName;
	private List<Address> addresses;

}
