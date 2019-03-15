package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.supplier;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class SupplierUpdate {

Connection conn = null;
	
	public void updateSupplierService(supplier supplier)
	{
		//Connect database
		conn = (Connection) dbConnect.conn();
		
		try {
		    String query1 = "Update supplier set id=?,name=?,address=?,email=?,joindate=?,item=?,contact=? where id=?";
		    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query1);
		    
		    
		    ps.setInt(1, supplier.getId());
			ps.setString(2, supplier.getName());
			ps.setString(3, supplier.getAddress());
			ps.setString(4, supplier.getEmail());
			ps.setString(5, supplier.getJoinDate());
			ps.setString(6, supplier.getItem());
			ps.setInt(7, supplier.getContact());
			ps.setInt(8, supplier.getId());
			 
			ps.executeUpdate();
			ResultSet rs = ps.executeQuery();
			System.out.println("Successfuly updare suplier");
			conn.close();
			System.out.println("Disconnected from database");

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
