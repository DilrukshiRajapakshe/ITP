/** IT17119122
 * Liyanage I.M */
package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

import org.omg.CORBA.portable.ServantObject;

import com.model.logingRecords;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class recordLogOutTime {
	
	
Connection conn = null;

public String Ltime;
public String Date;
	public void logOutRecord()
	{
				
				//Connect database
				conn = (Connection) dbConnect.conn();
				
				logingRecords LR = new logingRecords();
				LR.setOtime();
	
				try {
				    String query2 = "update report set uname=?,ltime=?,otime=?,year=?,month=?,day=? where uname=? and ltime=? and year=? and month=? and day=?";
				    
				    PreparedStatement ps1 = (PreparedStatement) conn.prepareStatement(query2);
				    
				    
				    ps1.setString(1, LR.getUname());
					ps1.setString(2, LR.getLtime());
					ps1.setString(3, LR.getOtime());
					ps1.setString(4, logingRecords.getYear());
					ps1.setString(5, logingRecords.getMonth());
					ps1.setString(6, logingRecords.getDay());
					ps1.setString(7, LR.getUname());
					ps1.setString(8, LR.getLtime());
					ps1.setString(9, logingRecords.getYear());
					ps1.setString(10, logingRecords.getMonth());
					ps1.setString(11, logingRecords.getDay());
					
					System.out.println(LR.getUname());
					System.out.println(LR.getLtime());

					
					ps1.executeUpdate();
					ResultSet rs1 = ps1.executeQuery();
					System.out.println("Successfuly added logout time ");
					conn.close();
					System.out.println("Disconnected from database");

				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

}
