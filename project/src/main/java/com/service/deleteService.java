/** IT17119122
 * Liyanage I.M */
package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.user;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class deleteService {
	
	Connection conn = null;
	
	public void deleteUserService(String uid) {
		
		conn = (Connection) dbConnect.conn();
		
		try {
		    String query1 = "delete from user where id = ?";
		    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query1);
			
		    ps.setString(1, uid);
		    
			ps.executeUpdate();
			ResultSet rs = ps.executeQuery();
			System.out.println("Successfuly delete user");
			conn.close();
			System.out.println("Disconnected from database");

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
