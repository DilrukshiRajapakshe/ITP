/** IT17119122
 * Liyanage I.M */
package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.user;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.util.dbConnect;

public class chackPriviladgeService {
	
	Connection conn = null;
	
	public String chackPriviladge(user user)
	{
		//Connect database
		conn = (Connection) dbConnect.conn();
		String value=null;
		
	
	try {
		String query = "select * from user where uname=? and password=?";
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
		
		ps.setString(1, user.getUname());
		ps.setString(2, user.getPassword());
		
		System.out.println( user.getUname());
		System.out.println( user.getPassword());
		
		ResultSet rs = ps.executeQuery();
		
			while (rs.next()) 
				value = rs.getString("type");
		
		//conn.close();
		System.out.println("Disconnected from database");
		System.out.println(value);
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return value;
	}
}
