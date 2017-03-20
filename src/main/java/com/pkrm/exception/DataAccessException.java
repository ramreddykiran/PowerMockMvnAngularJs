package com.pkrm.exception;

public class DataAccessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DataAccessException(String message, Throwable e) {
		super(message, e);
	}

}
