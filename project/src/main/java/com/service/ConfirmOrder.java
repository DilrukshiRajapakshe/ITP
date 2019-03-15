/** IT17123778– Wickramanayaka D.T.A */
package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Order;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class ConfirmOrder {
	
Connection conn = null;
	
	public void confirmOrderr(Order order)
	{
		//Connect database
		conn = (Connection) dbConnect.conn();
		
		try {
			String sql = "Update oder SET deliveryStatus='Confirm' where oderNo=?";
		    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
		    
		    
		    ps.setString(1, order.getOrderNo());
			 
			ps.executeUpdate();
			ResultSet rs = ps.executeQuery();
			System.out.println("Successfuly Confirmed Order");
			conn.close();
			System.out.println("Disconnected from database");

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
