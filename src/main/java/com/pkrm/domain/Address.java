package com.pkrm.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Address {
	private String flatNum;
	private String area;
	private String village;
	private String district;
	private String state;
	private String country;
	private long pinCode;
	

}
