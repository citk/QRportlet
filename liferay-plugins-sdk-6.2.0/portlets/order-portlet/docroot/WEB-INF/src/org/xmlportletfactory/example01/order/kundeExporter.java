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

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import javax.portlet.PortletConfig;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.JavaConstants;

import org.xmlportletfactory.example01.order.model.kunde;
import org.xmlportletfactory.example01.order.service.kundeLocalServiceUtil;


public class kundeExporter {

	public static LinkedHashMap<String, String> generateDataHeader(PortletConfig portletConfig, Locale locale) {
		LinkedHashMap<String,String> dataHeader = new LinkedHashMap<String, String>();
				dataHeader.put(LanguageUtil.get(portletConfig, locale,"kunde-kundeId"),"long");
				dataHeader.put(LanguageUtil.get(portletConfig, locale,"kunde-kundeDescription"),"varchar");
				dataHeader.put(LanguageUtil.get(portletConfig, locale,"kunde-userKunde"),"varchar");
				dataHeader.put(LanguageUtil.get(portletConfig, locale,"kunde-userDocument"),"document");
				dataHeader.put(LanguageUtil.get(portletConfig, locale,"kunde-userCity"),"varchar");
				dataHeader.put(LanguageUtil.get(portletConfig, locale,"kunde-userEmail"),"varchar");
	   return dataHeader;
	}

	public static Workbook generateSampleExcel(long groupId, PortletConfig portletConfig, Locale locale) throws SystemException {
		LinkedHashMap dataHeader = generateDataHeader(portletConfig, locale);
		return generateExcel(groupId,true, true, dataHeader);
	}

	public static Workbook generateFullExcel(long groupId, PortletConfig portletConfig, Locale locale) throws SystemException  {
		LinkedHashMap dataHeader = generateDataHeader(portletConfig, locale);
		return generateExcel(groupId, false, false, dataHeader);
	}

	public static Workbook generateExcel (long groupId, boolean first, boolean showTypes, LinkedHashMap<String, String> dataHeaders) throws SystemException {
		Workbook book = new HSSFWorkbook();
		Sheet sheet = book.createSheet();

		int itRow = 0;
		int itCell = 0;
		Row row = null;
		Cell cell = null;

		row = sheet.createRow(itRow);
		itRow++;
		if(showTypes) {
			Row row2 = sheet.createRow(itRow);
			itRow++;
			Cell cell2 = null;
			for(String key: dataHeaders.keySet()) {
				//Head
				cell = row.createCell(itCell);
				cell.setCellValue(key);
				//Types
				cell2 = row2.createCell(itCell);
				cell2.setCellValue(dataHeaders.get(key));
				itCell++;
			}
		} else {
			for(String key: dataHeaders.keySet()) {
				//Head
				cell = row.createCell(itCell);
				cell.setCellValue(key);
				itCell++;
			}
		}

		List<kunde> listEntities = kundeLocalServiceUtil.findAllInGroup(groupId);
		if(first) {
			if(listEntities.size()>0) {
				row = sheet.createRow(itRow);
				kunde entity = listEntities.get(0);
				row = generateRow(entity,row);
				itRow++;
			}
		} else  {
			for(kunde entity : listEntities){
				row = sheet.createRow(itRow);
				row = generateRow(entity,row);
				itRow++;
			}
		}

		//Autosize columns
		for(int x = 0; x<(itCell+1) ; x++) {
			sheet.autoSizeColumn(x);
		}
		return book;
	}

	public static Row generateRow(kunde entity, Row row) throws SystemException  {

		int column = 0;

		Cell cell = null;

		cell = row.createCell(column);
		cell.setCellValue(entity.getKundeId());
	    column++;

		cell = row.createCell(column);
		cell.setCellValue(entity.getKundeDescription());
	    column++;

		cell = row.createCell(column);
		cell.setCellValue(entity.getUserKunde());
	    column++;

		cell = row.createCell(column);
		cell.setCellValue("DOCUMENT");
	    column++;

		cell = row.createCell(column);
		cell.setCellValue(entity.getUserCity());
	    column++;

		cell = row.createCell(column);
		cell.setCellValue(entity.getUserEmail());
	    column++;

	    return row;
	}

}


