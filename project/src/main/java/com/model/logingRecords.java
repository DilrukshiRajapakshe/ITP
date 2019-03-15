/** IT17119122
 * Liyanage I.M */
package com.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class logingRecords {
	
	private static String uname;
	private static String ltime;
	private String otime;
	private static String year;
	private static String month;
	private static String day;
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public static String getLtime() {
		return ltime;
	}
	public static void setLtime() {
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        System.out.println( sdf.format(cal.getTime()));
        
        ltime = sdf.format(cal.getTime());
	}
	public String getOtime() {
		return otime;
	}
	public void setOtime() {
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        System.out.println( sdf.format(cal.getTime()));
        
        otime = sdf.format(cal.getTime());
	}
	public static String getYear() {
		return year;
	}
	public static void setYear() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
	    LocalDate localDate = LocalDate.now();
	    System.out.println(dtf.format(localDate)); //2016
	    
	    year = dtf.format(localDate);
	}
	public static String getMonth() {
		return month;
	}
	public static void setMonth() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM");
	    LocalDate localDate = LocalDate.now();
	    System.out.println(dtf.format(localDate)); //11
	    
	    month = dtf.format(localDate);
	}
	public static String getDay() {
		return day;
	}
	public static void setDay() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd");
	    LocalDate localDate = LocalDate.now();
	    System.out.println(dtf.format(localDate)); //16
	    
	    day = dtf.format(localDate);
	}

	
}
