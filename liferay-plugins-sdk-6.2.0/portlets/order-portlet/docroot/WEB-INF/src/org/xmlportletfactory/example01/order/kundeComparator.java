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

import java.util.Date;

import com.liferay.portal.kernel.util.OrderByComparator;
import org.xmlportletfactory.example01.order.model.kunde;

public class kundeComparator {

	public static String ORDER_BY_ASC =  " ASC";
	public static String ORDER_BY_DESC = " DESC";

	public static OrderByComparator getkundeOrderByComparator(String orderByCol,String orderByType) {

		boolean orderByAsc = false;
		if(orderByType==null) {
			orderByAsc = true;
		} else if (orderByType.trim().equalsIgnoreCase(ORDER_BY_ASC.trim())){
			orderByAsc = true;
		}

		OrderByComparator orderByComparator = null;
			if(orderByCol==null) {
			orderByComparator = new OrderBykundeKundeId(orderByAsc);
			} else if(orderByCol.equals("kundeId")){
			orderByComparator = new OrderBykundeKundeId(orderByAsc);
			} else if(orderByCol.equals("kundeDescription")){
			orderByComparator = new OrderBykundeKundeDescription(orderByAsc);
			} else if(orderByCol.equals("userKunde")){
			orderByComparator = new OrderBykundeUserKunde(orderByAsc);
				} else if(orderByCol.equals("userCity")){
			orderByComparator = new OrderBykundeUserCity(orderByAsc);
			} else if(orderByCol.equals("userEmail")){
			orderByComparator = new OrderBykundeUserEmail(orderByAsc);
	    }
	    return orderByComparator;
	}
}

class OrderBykundeKundeId extends OrderByComparator {
	public static String ORDER_BY_FIELD = "kundeId";

	public OrderBykundeKundeId(){
		this(false);
	}

	public OrderBykundeKundeId(boolean asc){
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
		if(_asc) return ORDER_BY_FIELD + kundeComparator.ORDER_BY_ASC;
		else return ORDER_BY_FIELD + kundeComparator.ORDER_BY_DESC;
	}

	private boolean _asc;
}

class OrderBykundeKundeDescription extends OrderByComparator {
	public static String ORDER_BY_FIELD = "kundeDescription";

	public OrderBykundeKundeDescription(){
		this(false);
	}

	public OrderBykundeKundeDescription(boolean asc){
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
		if(_asc) return ORDER_BY_FIELD + kundeComparator.ORDER_BY_ASC;
		else return ORDER_BY_FIELD + kundeComparator.ORDER_BY_DESC;
	}

	private boolean _asc;
}
class OrderBykundeUserKunde extends OrderByComparator {
	public static String ORDER_BY_FIELD = "userKunde";

	public OrderBykundeUserKunde(){
		this(false);
	}

	public OrderBykundeUserKunde(boolean asc){
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
		if(_asc) return ORDER_BY_FIELD + kundeComparator.ORDER_BY_ASC;
		else return ORDER_BY_FIELD + kundeComparator.ORDER_BY_DESC;
	}

	private boolean _asc;
}
class OrderBykundeUserCity extends OrderByComparator {
	public static String ORDER_BY_FIELD = "userCity";

	public OrderBykundeUserCity(){
		this(false);
	}

	public OrderBykundeUserCity(boolean asc){
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
		if(_asc) return ORDER_BY_FIELD + kundeComparator.ORDER_BY_ASC;
		else return ORDER_BY_FIELD + kundeComparator.ORDER_BY_DESC;
	}

	private boolean _asc;
}
class OrderBykundeUserEmail extends OrderByComparator {
	public static String ORDER_BY_FIELD = "userEmail";

	public OrderBykundeUserEmail(){
		this(false);
	}

	public OrderBykundeUserEmail(boolean asc){
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
		if(_asc) return ORDER_BY_FIELD + kundeComparator.ORDER_BY_ASC;
		else return ORDER_BY_FIELD + kundeComparator.ORDER_BY_DESC;
	}

	private boolean _asc;
}



