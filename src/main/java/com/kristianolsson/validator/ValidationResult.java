package com.kristianolsson.validator;

public class ValidationResult {

	private String reason;
	
	public ValidationResult(String reason) {
		this.reason = reason;
	}
	
	@Override
	public String toString() {
		return reason;
	}
}
