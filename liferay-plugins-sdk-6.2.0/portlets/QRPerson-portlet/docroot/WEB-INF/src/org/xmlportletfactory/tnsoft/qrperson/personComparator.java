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

import java.util.Date;

import com.liferay.portal.kernel.util.OrderByComparator;
import org.xmlportletfactory.tnsoft.qrperson.model.person;

public class personComparator {

	public static String ORDER_BY_ASC =  " ASC";
	public static String ORDER_BY_DESC = " DESC";

	public static OrderByComparator getpersonOrderByComparator(String orderByCol,String orderByType) {

		boolean orderByAsc = false;
		if(orderByType==null) {
			orderByAsc = true;
		} else if (orderByType.trim().equalsIgnoreCase(ORDER_BY_ASC.trim())){
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;
			if(orderByCol==null) {
			orderByComparator = new OrderBypersonKundeId(orderByAsc);
			} else if(orderByCol.equals("kundeId")){
			orderByComparator = new OrderBypersonKundeId(orderByAsc);
			} else if(orderByCol.equals("Firstname")){
			orderByComparator = new OrderBypersonFirstname(orderByAsc);
			} else if(orderByCol.equals("Middlename")){
			orderByComparator = new OrderBypersonMiddlename(orderByAsc);
			} else if(orderByCol.equals("Lastname")){
			orderByComparator = new OrderBypersonLastname(orderByAsc);
			} else if(orderByCol.equals("kundeDescription")){
			orderByComparator = new OrderBypersonKundeDescription(orderByAsc);
				} else if(orderByCol.equals("City")){
			orderByComparator = new OrderBypersonCity(orderByAsc);
			} else if(orderByCol.equals("userEmail")){
			orderByComparator = new OrderBypersonUserEmail(orderByAsc);
	    }
	    return orderByComparator;
	}
}

class OrderBypersonKundeId extends OrderByComparator {
	public static String ORDER_BY_FIELD = "kundeId";

	public OrderBypersonKundeId(){
		this(false);
	}

	public OrderBypersonKundeId(boolean asc){
		_asc = asc;
	}

	@Override
	public int compare(Object o1,Object o2) {

		Long lo1 = 0L;
		Long lo2 = 0L;

		if(o1!=null) lo1 = (Long)o1;
		if(o2!=null) lo2 = (Long)o2;

		return lo1.compareTo(lo2);
	}

	@Override
	public String[] getOrderByFields() {
		String[] orderByFields = new String[1];
		orderByFields[0] = ORDER_BY_FIELD;
		return orderByFields;
	}

	@Override
	public String getOrderBy() {
		if(_asc) return ORDER_BY_FIELD + personComparator.ORDER_BY_ASC;
		else return ORDER_BY_FIELD + personComparator.ORDER_BY_DESC;
	}

	private boolean _asc;
}

class OrderBypersonFirstname extends OrderByComparator {
	public static String ORDER_BY_FIELD = "Firstname";

	public OrderBypersonFirstname(){
		this(false);
	}

	public OrderBypersonFirstname(boolean asc){
		_asc = asc;
	}

	@Override
	public int compare(Object o1,Object o2) {

		String str1 = "";
		String str2 = "";

		if(str1!=null) str1 = (String)o1;
		if(str2!=null) str2 = (String)o1;

		return str1.compareTo(str2);
	}

	@Override
	public String[] getOrderByFields() {
		String[] orderByFields = new String[1];
		orderByFields[0] = ORDER_BY_FIELD;
		return orderByFields;
	}

	@Override
	public String getOrderBy() {
		if(_asc) return ORDER_BY_FIELD + personComparator.ORDER_BY_ASC;
		else return ORDER_BY_FIELD + personComparator.ORDER_BY_DESC;
	}

	private boolean _asc;
}
class OrderBypersonMiddlename extends OrderByComparator {
	public static String ORDER_BY_FIELD = "Middlename";

	public OrderBypersonMiddlename(){
		this(false);
	}

	public OrderBypersonMiddlename(boolean asc){
		_asc = asc;
	}

	@Override
	public int compare(Object o1,Object o2) {

		String str1 = "";
		String str2 = "";

		if(str1!=null) str1 = (String)o1;
		if(str2!=null) str2 = (String)o1;

		return str1.compareTo(str2);
	}

	@Override
	public String[] getOrderByFields() {
		String[] orderByFields = new String[1];
		orderByFields[0] = ORDER_BY_FIELD;
		return orderByFields;
	}

	@Override
	public String getOrderBy() {
		if(_asc) return ORDER_BY_FIELD + personComparator.ORDER_BY_ASC;
		else return ORDER_BY_FIELD + personComparator.ORDER_BY_DESC;
	}

	private boolean _asc;
}
class OrderBypersonLastname extends OrderByComparator {
	public static String ORDER_BY_FIELD = "Lastname";

	public OrderBypersonLastname(){
		this(false);
	}

	public OrderBypersonLastname(boolean asc){
		_asc = asc;
	}

	@Override
	public int compare(Object o1,Object o2) {

		String str1 = "";
		String str2 = "";

		if(str1!=null) str1 = (String)o1;
		if(str2!=null) str2 = (String)o1;

		return str1.compareTo(str2);
	}

	@Override
	public String[] getOrderByFields() {
		String[] orderByFields = new String[1];
		orderByFields[0] = ORDER_BY_FIELD;
		return orderByFields;
	}

	@Override
	public String getOrderBy() {
		if(_asc) return ORDER_BY_FIELD + personComparator.ORDER_BY_ASC;
		else return ORDER_BY_FIELD + personComparator.ORDER_BY_DESC;
	}

	private boolean _asc;
}
class OrderBypersonKundeDescription extends OrderByComparator {
	public static String ORDER_BY_FIELD = "kundeDescription";

	public OrderBypersonKundeDescription(){
		this(false);
	}

	public OrderBypersonKundeDescription(boolean asc){
		_asc = asc;
	}

	@Override
	public int compare(Object o1,Object o2) {

		String str1 = "";
		String str2 = "";

		if(str1!=null) str1 = (String)o1;
		if(str2!=null) str2 = (String)o1;

		return str1.compareTo(str2);
	}

	@Override
	public String[] getOrderByFields() {
		String[] orderByFields = new String[1];
		orderByFields[0] = ORDER_BY_FIELD;
		return orderByFields;
	}

	@Override
	public String getOrderBy() {
		if(_asc) return ORDER_BY_FIELD + personComparator.ORDER_BY_ASC;
		else return ORDER_BY_FIELD + personComparator.ORDER_BY_DESC;
	}

	private boolean _asc;
}
class OrderBypersonCity extends OrderByComparator {
	public static String ORDER_BY_FIELD = "City";

	public OrderBypersonCity(){
		this(false);
	}

	public OrderBypersonCity(boolean asc){
		_asc = asc;
	}

	@Override
	public int compare(Object o1,Object o2) {

		String str1 = "";
		String str2 = "";

		if(str1!=null) str1 = (String)o1;
		if(str2!=null) str2 = (String)o1;

		return str1.compareTo(str2);
	}

	@Override
	public String[] getOrderByFields() {
		String[] orderByFields = new String[1];
		orderByFields[0] = ORDER_BY_FIELD;
		return orderByFields;
	}

	@Override
	public String getOrderBy() {
		if(_asc) return ORDER_BY_FIELD + personComparator.ORDER_BY_ASC;
		else return ORDER_BY_FIELD + personComparator.ORDER_BY_DESC;
	}

	private boolean _asc;
}
class OrderBypersonUserEmail extends OrderByComparator {
	public static String ORDER_BY_FIELD = "userEmail";

	public OrderBypersonUserEmail(){
		this(false);
	}

	public OrderBypersonUserEmail(boolean asc){
		_asc = asc;
	}

	@Override
	public int compare(Object o1,Object o2) {

		String str1 = "";
		String str2 = "";

		if(str1!=null) str1 = (String)o1;
		if(str2!=null) str2 = (String)o1;

		return str1.compareTo(str2);
	}

	@Override
	public String[] getOrderByFields() {
		String[] orderByFields = new String[1];
		orderByFields[0] = ORDER_BY_FIELD;
		return orderByFields;
	}

	@Override
	public String getOrderBy() {
		if(_asc) return ORDER_BY_FIELD + personComparator.ORDER_BY_ASC;
		else return ORDER_BY_FIELD + personComparator.ORDER_BY_DESC;
	}

	private boolean _asc;
}



