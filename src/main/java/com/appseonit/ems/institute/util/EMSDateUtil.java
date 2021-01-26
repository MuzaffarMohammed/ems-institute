package com.appseonit.ems.institute.util;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class EMSDateUtil {

	//Java 8 date parse and format util class

	private String dateFormat = "dd-MM-yyyy";
    private DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern(dateFormat);
	
	
    /*
     * Date parsing Logic which accepts 'dateStr' parameter as a String and parse into LocalDate object.
     * Accepts 'parseFmt' as String (Optional, can be set as null to use default date format)
     * */
	public LocalDate parseDate(String dateStr, String parseFmt) throws DateTimeParseException{
		if(dateStr == null || dateStr.trim().equals("")) {
			return null;
		}
		if(parseFmt != null && !parseFmt.trim().equals("")) {
			dateFmt = DateTimeFormatter.ofPattern(parseFmt);
		}
		return LocalDate.parse(dateStr, dateFmt);
	}
	
	/*
	 * Format LocalDate object into desired date format string
	 * Accepts 'date' as LocalDate and 'format' as String (Optional, can be set as null to use default date format)
	 * */
	public String formatDate(LocalDate date, String format) throws DateTimeException{
		if(date == null) {
			return null;
		}
		if(format != null && !format.trim().equals("")) {
			dateFmt = DateTimeFormatter.ofPattern(format);
		}
		return date.format(dateFmt);
	}
	
	
	/*
	 * Parse and format date 
	 * Accepts dateStr as String and date format 'format' (Optional, can be set as null to use default date format) 
	 * */
	public String parseAndFormatDate(String dateStr, String parseFmt, String format) throws DateTimeParseException, DateTimeException{
		if(dateStr == null || dateStr.trim().equals("")) {
			return null;
		}
		if(format != null && !format.trim().equals("")) {
			dateFmt = DateTimeFormatter.ofPattern(format);
		}
		return parseDate(dateStr, parseFmt).format(dateFmt);
	}
	
}
