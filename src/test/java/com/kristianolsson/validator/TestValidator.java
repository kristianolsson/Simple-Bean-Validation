package com.kristianolsson.validator;

import com.kristianolsson.validator.data.TestData;

public class TestValidator {

	public static void main(String[] args) throws Exception {
		new TestValidator().testValidate();
		new TestValidator().testValidateMissingMandatory();
		new TestValidator().testValidatePatternMatching();
		new TestValidator().testValidateCustomMatcher();
	}
	
	public void testValidate() throws Exception {
		TestData data = new TestData("admin-12345", "Kristian", 30);
		ValidationResult[] result = new Validator().validate(data);
		
		print("testValidate", result);
		
	}
	
	public void testValidateMissingMandatory() throws Exception {
		TestData data = new TestData(null, "Kristian", 30);
		ValidationResult[] result = new Validator().validate(data);
		
		print("testValidateMissingMandatory", result);
	}
	
	public void testValidatePatternMatching() throws Exception {
		TestData data = new TestData("badId", "Kristian", 30);
		ValidationResult[] result = new Validator().validate(data);
		
		print("testValidatePatternMatching", result);
	}
	
	public void testValidateCustomMatcher() throws Exception {
		TestData data = new TestData("admin-12345", "Kristian", null);
		ValidationResult[] result = new Validator().validate(data);
		
		print("testValidateCustomMatcher", result);
	}
	
	private void print(String test, ValidationResult[] result) {
		System.out.println(test + ":");
		for(ValidationResult r: result) {
			System.out.println(r);
		}
		System.out.println();
	}
}
