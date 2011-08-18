package com.kristianolsson.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class Validator {

	public ValidationResult[] validate(Object data) throws Exception {
		List<ValidationResult> result = new ArrayList<ValidationResult>();
		Field[] fields = data.getClass().getDeclaredFields();
		for(Field f: fields) {
			f.setAccessible(true);
			Object value = f.get(data);
			Annotation[] annotations = f.getAnnotations();
			for(Annotation a: annotations) {
				if (a.annotationType() == Mandatory.class && value == null) {
					result.add(new ValidationResult("Missing mandatory " + f.getName()));
				}
				if (a.annotationType() == Pattern.class && value != null && !((String)value).matches(f.getAnnotation(Pattern.class).value())) {
					result.add(new ValidationResult("Not mathing " + f.getAnnotation(Pattern.class).value() + " on " + f.getName() + " = " + value));
				}
			}
		}
		if (data instanceof CustomValidation) {
			result.addAll(((CustomValidation)data).validate());
		}
		return result.toArray(new ValidationResult[result.size()]);
	}

}
