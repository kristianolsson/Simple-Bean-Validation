package com.kristianolsson.validator.data;

import java.util.ArrayList;
import java.util.List;

import com.kristianolsson.validator.CustomValidation;
import com.kristianolsson.validator.Mandatory;
import com.kristianolsson.validator.Optional;
import com.kristianolsson.validator.Pattern;
import com.kristianolsson.validator.ValidationResult;

public class TestData implements CustomValidation {

	@Mandatory 
	@Pattern("[admin|user]+-[0-9]{5}")
	private String id;
	
	@Mandatory
	private String name;
	
	@Optional
	private Integer age;
	
	public TestData(String id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public List<ValidationResult> validate() {
		List<ValidationResult> result = new ArrayList<ValidationResult>();
		if (id != null && id.startsWith("admin") && age == null) {
			result.add(new ValidationResult("Admin requires age"));
		}
		return result;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "TestData [age=" + age + ", id=" + id + ", name=" + name + "]";
	}
}
