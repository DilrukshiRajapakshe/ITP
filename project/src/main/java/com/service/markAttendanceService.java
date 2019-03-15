/** IT17119122
 * Liyanage I.M */
package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.markAttendance;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class markAttendanceService {

Connection conn = null;
	
	public void markIn(markAttendance obj)
	{
		//Connect database
		conn = (Connection) dbConnect.conn();
		
		try {
		    String query1 = "insert into attendance(eid,ename,intime,outtime,year,month,day,workhours) values(?,?,?,?,?,?,?,?)";
		    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query1);
		    
		    
		    ps.setInt(1, Integer.parseInt(obj.getEid()));
			ps.setString(2, obj.getEname());
			ps.setString(3, obj.getIntime());
			ps.setString(4, "Not leave");
			ps.setString(5, obj.getYear());
			ps.setString(6, obj.getMonth());
			ps.setString(7, obj.getDay());
			ps.setString(8, "0");
			
			ps.executeUpdate();
			ResultSet rs = ps.executeQuery();
			System.out.println("Successfuly added attendance");
			conn.close();
			System.out.println("Disconnected from database");

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 public void markOut(markAttendance obj)
		{
			//Connect database
			conn = (Connection) dbConnect.conn();
			
			try {
			    String query1 = "update attendance set outtime=?,workhours=? where eid=? and ename=? and year=? and month=? and day=?";
			    
			    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query1);
			    
			   
			    ps.setString(1, obj.getOuttime());
			    ps.setString(2, obj.getWorkHours());
				ps.setInt(3, Integer.parseInt(obj.getEid()));
				ps.setString(4, obj.getEname());
				ps.setString(5, obj.getYear());
				ps.setString(6, obj.getMonth());
				ps.setString(7, obj.getDay());
				
				ps.executeUpdate();
				ResultSet rs = ps.executeQuery();
				System.out.println("Successfuly Updated");
				conn.close();
				System.out.println("Disconnected from database");

			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
