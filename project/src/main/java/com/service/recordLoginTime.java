/** IT17119122
 * Liyanage I.M */
package com.service;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import com.model.logingRecords;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class recordLoginTime {
	
Connection conn = null;
	
	public void logingRecord(String uname)
	{
		//Connect database
				conn = (Connection) dbConnect.conn();
				
				Calendar cal = Calendar.getInstance();
		        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		        System.out.println( sdf.format(cal.getTime()));
		        
		        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		    	LocalDate localDate = LocalDate.now();
		    	System.out.println(dtf.format(localDate)); //2016/11/16
		    	
		    	
		    	logingRecords LR = new logingRecords();
		    	LR.setUname(uname);
		    	LR.setLtime();
		    	LR.setYear(); 
		    	LR.setMonth(); 
		    	LR.setDay(); 
		    	
				try {
				    String query1 = "insert into report(uname,ltime,otime,year,month,day) values(?,?,?,?,?,?)";
				    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query1);
				    
				    ps.setString(1, uname);
					ps.setString(2, LR.getLtime());
					ps.setString(3, "still loged in");
					ps.setString(4, LR.getYear());
					ps.setString(5, LR.getMonth());
					ps.setString(6, LR.getDay());
					
					ps.executeUpdate();
					ResultSet rs = ps.executeQuery();
					System.out.println("Successfuly added loging time");
					conn.close();
					System.out.println("Disconnected from database");

				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

}
