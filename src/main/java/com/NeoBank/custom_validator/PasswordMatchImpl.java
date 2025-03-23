package com.NeoBank.custom_validator;

import java.lang.reflect.Field;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchImpl implements ConstraintValidator<PasswordMatch, Object>{
	
	private String firstFieldName;		// password
	private String secondFieldName;		// confirm password
	
	@Override
	public void initialize(PasswordMatch matchFields) {
		 this.firstFieldName = matchFields.firstFieldName();
	     this.secondFieldName = matchFields.secondFieldName();
	}
	

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		
		try {
			// annotation is to be implemented on class level. get the class
			Class<?> clazz = value.getClass();
			
			// get the password field, enable access and get the String value
			Field firstField = clazz.getDeclaredField(firstFieldName);
			firstField.setAccessible(true);
			String firstFieldVal = (String) firstField.get(value);
			
			// get the confirm password field, enable access and get the String value
			Field secondField = clazz.getDeclaredField(secondFieldName);
			secondField.setAccessible(true);
			String secondFieldVal = (String) secondField.get(value);
			
			// compare the password and confirm password field values
			if (firstFieldVal != null && firstFieldVal.equals(secondFieldVal)) {
				return true;
			} else {
//				context.disableDefaultConstraintViolation();	// disable default error message
				
				// bind the error message to the second field, ie the Confirm Password field. This means error
				// messages are to appear on the Confirm Password field
				context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
					.addPropertyNode(secondFieldName)
					.addConstraintViolation();
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
