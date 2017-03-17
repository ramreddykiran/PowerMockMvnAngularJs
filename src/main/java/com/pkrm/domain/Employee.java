package com.pkrm.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee {
	
	private String empId;
	private String empName;
	private List<Address> addresses;

}
