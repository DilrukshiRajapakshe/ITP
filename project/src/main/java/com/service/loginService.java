/** IT17119122
 * Liyanage I.M */
package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.user;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class loginService {
	
Connection conn = null;
	
	public boolean loginUserService(user user) throws SQLException
	{
		
	
		//Connect database
		conn = (Connection) dbConnect.conn();
		
		try {
		    String query1 = "select * from user where uname=? and password=?";
		    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query1);
		    
			ps.setString(1, user.getUname());
			ps.setString(2, user.getPassword());
			 
			//ps.executeUpdate();  no need that command it will error in consol
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) 
		           return true;
		     else 
		           return false;
			//conn.close();
			//System.out.println("Disconnected from database");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		
	}

}
