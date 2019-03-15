/** IT17119122
 * Liyanage I.M */
package com.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class markAttendance {
	
	private String eid;
	private String ename;
	private static String intime;
	private static String outtime;
	private String day;
	private String month;
	private String year;
	private String WorkHours;
	
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	public String getOuttime() {
		return outtime;
	}
	public void setOuttime() {
		
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        System.out.println( sdf.format(cal.getTime()));
        
        outtime = sdf.format(cal.getTime());
	}
	public void setIntime() {
		
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        System.out.println( sdf.format(cal.getTime()));
        
    	intime = sdf.format(cal.getTime());
    	
	}

	public String getIntime() {
		return intime;
	}


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
	
	public String getWorkHours() {
		return WorkHours;
	}
	public void setWorkHours(String workHours) {
		WorkHours = workHours;
	}

}
