package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.employee;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class removedelete{

Connection conn = null;
	
	public void deleteremoveSupplierService(employee emp)
	{
		//Connect database
		conn = (Connection) dbConnect.conn();
		
		try {
		    String query1 = "delete from removeemployee where id=?";
		    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query1);
		    
		    
		    ps.setInt(1, emp.getId());
		
			 
			ps.executeUpdate();
			System.out.println("Successfuly delete remove employee");
			conn.close();
			System.out.println("Disconnected from database");

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
