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
 
 
package org.xmlportletfactory.example01.order;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;

import org.xmlportletfactory.example01.order.model.kunde;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.ParamUtil;

public class kundeValidator {

	public static ArrayList<String> validatekunde(kunde kunde, ActionRequest request) throws IOException {
		ArrayList<String> errors = new ArrayList<String>();
		Properties props = new Properties();
		ClassLoader classLoader = kundeValidator.class.getClassLoader();
		InputStream is = classLoader.getResourceAsStream("regexp.properties");
		props.load(is);


	//Field kundeDescription
	
	
		if(!validateKundeDescription(props, request.getAttribute("kundeDescription").toString())){
		    errors.add("error");
		}
		if (Validator.isNull(kunde.getKundeDescription())) {
			errors.add("kunde-kundedescription-required");
		}

	//Field userKunde
	
	
		if(!validateUserKunde(props, request.getAttribute("userKunde").toString())){
		    errors.add("error");
		}


	//Field userCity
	
	
		if(!validateUserCity(props, request.getAttribute("userCity").toString())){
		    errors.add("error");
		}

	//Field userEmail
	
	
		if(!validateUserEmail(props, request.getAttribute("userEmail").toString())){
			errors.add(props.getProperty("email_error"));
		}
		if (Validator.isNull(kunde.getUserEmail())) {
			errors.add("kunde-useremail-required");
		}
		return errors;
	}

	public static boolean validateEditkunde(
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
	//Field kundeDescription
	private static boolean validateKundeDescription(Properties props,String field) {
		boolean valid = true;
		return valid;
	}
	//Field userKunde
	private static boolean validateUserKunde(Properties props,String field) {
		boolean valid = true;
		return valid;
	}
	//Field userDocument
	private static boolean validateUserDocument(Properties props,String field) {
		boolean valid = true;
		return valid;
	}
	//Field userCity
	private static boolean validateUserCity(Properties props,String field) {
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
