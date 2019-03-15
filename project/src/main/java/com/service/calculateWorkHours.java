/** IT17119122
 * Liyanage I.M */
package com.service;

//import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.apache.tomcat.jni.Time;

import com.model.markAttendance;
import com.model.user;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.util.dbConnect;

public class calculateWorkHours {
	
Connection conn = null;

	public String getIntime(markAttendance obj)
	{
		//Connect database
		conn = (Connection) dbConnect.conn();
		String intime =null;
		
	
	try {
		String query = "select * from attendance where eid=? and ename=? and year=? and month=? and day=?";
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
		
		ps.setInt(1, Integer.parseInt(obj.getEid()));
    	ps.setString(2, obj.getEname());
		ps.setString(3, obj.getYear());
		ps.setString(4, obj.getMonth());
		ps.setString(5, obj.getDay());
	
		System.out.println(obj.getEid());
		System.out.println(obj.getEname());
		System.out.println(obj.getYear());
		System.out.println(obj.getMonth());
		System.out.println(obj.getDay());
		
		ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
				 intime = rs.getString("intime");
				
			}
		conn.close();
		System.out.println("Disconnected from database");
		
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return intime;
	}
	
	public long calHours(String intime)
	{
		long diffHours = 2;
		//HH converts hour in 24 hours format (0-23), day calculation
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		Date d1 = null;
		Date d2 = null;
		try {
			
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		
		String outtime = sdf.format(cal.getTime());
		
		d1 = (Date) format.parse(intime);
		d2 = (Date) format.parse(outtime);

		//in milliseconds
		long diff = d2.getTime() - d1.getTime();
		
		diffHours = diff / (60 * 60 * 1000) % 24;
		
		
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return diffHours;

	}

}
