/**
 *     Copyright (C) 2009-2014  Jack A. Rider All rights reserved.
 * 
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 */
 
 
package org.xmlportletfactory.tnsoft.qrperson;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;

import org.xmlportletfactory.tnsoft.qrperson.model.person;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.ParamUtil;

public class personValidator {

	public static ArrayList<String> validateperson(person person, ActionRequest request) throws IOException {
		ArrayList<String> errors = new ArrayList<String>();
		Properties props = new Properties();
		ClassLoader classLoader = personValidator.class.getClassLoader();
		InputStream is = classLoader.getResourceAsStream("regexp.properties");
		props.load(is);


	//Field Firstname
	
	
		if(!validateFirstname(props, request.getAttribute("Firstname").toString())){
		    errors.add("error");
		}
		if (Validator.isNull(person.getFirstname())) {
			errors.add("qrperson-firstname-required");
		}

	//Field Middlename
	
	
		if(!validateMiddlename(props, request.getAttribute("Middlename").toString())){
		    errors.add("error");
		}

	//Field Lastname
	
	
		if(!validateLastname(props, request.getAttribute("Lastname").toString())){
		    errors.add("error");
		}
		if (Validator.isNull(person.getLastname())) {
			errors.add("qrperson-lastname-required");
		}

	//Field kundeDescription
	
	
		if(!validateKundeDescription(props, request.getAttribute("kundeDescription").toString())){
		    errors.add("error");
		}


	//Field City
	
	
		if(!validateCity(props, request.getAttribute("City").toString())){
		    errors.add("error");
		}

	//Field userEmail
	
	
		if(!validateUserEmail(props, request.getAttribute("userEmail").toString())){
			errors.add(props.getProperty("email_error"));
		}
		if (Validator.isNull(person.getUserEmail())) {
			errors.add("qrperson-useremail-required");
		}
		return errors;
	}

	public static boolean validateEditperson(
		String rowsPerPage, String dateFormat, String datetimeFormat, List errors) {
		boolean valid = true;
		if (Validator.isNull(rowsPerPage)) {
			errors.add("rows-per-page-required");
			valid = false;
		} else if (!Validator.isNumber(rowsPerPage)) {
			errors.add("rows-per-page-invalid");
			valid = false;
		} else if (Validator.isNull(dateFormat)) {
			errors.add("date-format-required");
			valid = false;
		} else if (Validator.isNull(datetimeFormat)) {
			errors.add("datetime-format.required");
			valid = false;
		}
		return valid;
	}

	//Field kundeId
	private static boolean validateKundeId(Properties props,String field) {
		boolean valid = true;
		try {
			Double.parseDouble(field);
		} catch (NumberFormatException nfe) {
		    valid = false;
		}
		return valid;
	}
	//Field Firstname
	private static boolean validateFirstname(Properties props,String field) {
		boolean valid = true;
		return valid;
	}
	//Field Middlename
	private static boolean validateMiddlename(Properties props,String field) {
		boolean valid = true;
		return valid;
	}
	//Field Lastname
	private static boolean validateLastname(Properties props,String field) {
		boolean valid = true;
		return valid;
	}
	//Field kundeDescription
	private static boolean validateKundeDescription(Properties props,String field) {
		boolean valid = true;
		return valid;
	}
	//Field userDocument
	private static boolean validateUserDocument(Properties props,String field) {
		boolean valid = true;
		return valid;
	}
	//Field City
	private static boolean validateCity(Properties props,String field) {
		boolean valid = true;
		return valid;
	}
	//Field userEmail
	private static boolean validateUserEmail(Properties props,String field) {
		boolean valid = true;
		if(!field.equals("")) {
			Pattern p = Pattern.compile(props.getProperty("email"),Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher((CharSequence) field.trim());
			valid = m.matches();
		}
		return valid;
	}
}
