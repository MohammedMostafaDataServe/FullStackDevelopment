package com.jumia.dev.JumiaService.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * PhoneNumberValidator class to validate phone number against specific rules
 * 
 * @author Mohammed Mostafa
 *
 */
public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberConstraint, String> {

	@Override
	public void initialize(PhoneNumberConstraint contactNumber) {
	}

	/**
	 * 
	 * Validate phone number against specific regular expression
	 * 
	 * @return boolean
	 */
	@Override
	public boolean isValid(String contactField, ConstraintValidatorContext cxt) {

		contactField = contactField.trim();

		return contactField.matches("^((\\(\\d{3}\\)))\\s?\\d+$");
		
	}
}
