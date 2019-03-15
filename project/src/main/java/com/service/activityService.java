//IT17024914
package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.activity;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class activityService {
	
	Connection conn = null;
	
	public void actService(activity activity)
	{
		//Connect database
		conn = (Connection) dbConnect.conn();
		
		try {
		    String query = "insert into activity(index1,date,userid,activity type) values(?,?,?)";
		    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
		    
		    ps.setInt(1, activity.getIndex());
		    ps.setString(2, activity.getDate());
			ps.setString(3, activity.getUname());
			ps.setString(4, activity.getActivityType());
			
			
			ps.executeUpdate();
			ResultSet rs = ps.executeQuery();
			System.out.println("Successfuly added record");
			conn.close();
			System.out.println("Disconnected from database");

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}