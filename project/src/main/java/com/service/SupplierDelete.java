/** IT17122092
 * Sandarenu M.D.K */
package com.service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.supplier;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class SupplierDelete{

Connection conn = null;
	
	public void deleteSupplierService(supplier supplier)
	{
		//Connect database
		conn = (Connection) dbConnect.conn();
		
		try {
			

			String query1 = "insert into removesupplier(id,rReasone,rdate,name,address,contact,email,items,joindate) values(?,?,?,?,?,?,?,?,?)";
		    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query1);
		    
		    int s = supplier.getId();
		    System.out.println(supplier.getId()+" "+supplier.getRemoveReason());
			
			ps.setInt(1, supplier.getId());
			ps.setString(2, supplier.getRemoveReason());
			ps.setString(3, supplier.getRemoveDate());
			ps.setString(4, supplier.getName());
			ps.setString(5, supplier.getAddress());
			ps.setInt(6, supplier.getContact());
			ps.setString(7, supplier.getEmail());
			ps.setString(8, supplier.getItem());
			ps.setString(9, supplier.getJoinDate());
			
			ps.executeUpdate();
//			ResultSet rs = ps.executeQuery();
			System.out.println("Successfuly added supplier");

		
		    String query2 = "delete from supplier where id=?";
		    PreparedStatement ps2 = (PreparedStatement) conn.prepareStatement(query2);
		    
		    
		    ps2.setInt(1, supplier.getId());
		
			 
			ps2.executeUpdate();
//			ResultSet rs2 = ps.executeQuery();
			System.out.println("Successfuly delete supplier");
			conn.close();
			System.out.println("Disconnected from database");

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
