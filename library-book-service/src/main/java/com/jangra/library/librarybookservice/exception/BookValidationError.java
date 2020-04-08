package com.jangra.library.librarybookservice.exception;


public class BookValidationError {
	
	private String errorCode;
    private String message;
 
	public BookValidationError(String errorCode, String message) {
		super();
        this.errorCode = errorCode;
        this.message = message;	
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}