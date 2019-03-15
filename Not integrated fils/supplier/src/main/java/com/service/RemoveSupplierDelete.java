package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.supplier;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class RemoveSupplierDelete{

Connection conn = null;
	
	public void deleteremoveSupplierService(supplier s)
	{
		//Connect database
		conn = (Connection) dbConnect.conn();
		
		try {
		    String query1 = "delete from removesupplier where id=?";
		    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query1);
		    
		    
		    ps.setInt(1, s.getId());
		
			 
			ps.executeUpdate();
			System.out.println("Successfuly delete remove supplier");
			conn.close();
			System.out.println("Disconnected from database");

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
