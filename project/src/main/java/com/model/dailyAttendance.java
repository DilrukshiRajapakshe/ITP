/** IT17119122
 * Liyanage I.M */
package com.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class dailyAttendance {
	private String day;
	private String month;
	private String year;
	
	public String getDay() {
		return day;
	}
	public void setDay() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd");
	    LocalDate localDate = LocalDate.now();
	    System.out.println(dtf.format(localDate)); //16
	    	
	    day = dtf.format(localDate);
	}
	public String getMonth() {
		return month;
	}
	public void setMonth() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM");
	    LocalDate localDate = LocalDate.now();
	    System.out.println(dtf.format(localDate)); //11
	    	
	    month = dtf.format(localDate);
	}
	public String getYear() {
		return year;
	}
	public void setYear() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
	    LocalDate localDate = LocalDate.now();
	    System.out.println(dtf.format(localDate)); //2016
	    	
	    year = dtf.format(localDate);
	}

}
