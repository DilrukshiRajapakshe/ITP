/** IT17123778– Wickramanayaka D.T.A */
package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Order;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class UpdateOrder {

Connection conn = null;
	
	public void updateOrderr(Order order)
	{
		//Connect database
		conn = (Connection) dbConnect.conn();
		
		try {
		    String query1 = "Update oder set oderNo=?,customerName=?,address=?,telephoneNo=?,items=?,amount=?,deliveryCharges=?,finalAmount=?,quantity=?,billno=? where oderNo=?";
		    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query1);
		    
		    int itemPrice = order.getAmount();
		    int delivery = order.getCharges();
		    int quantity = order.getQuantity();
		    
		    int finalAmount = itemPrice * quantity + delivery;
		    
		    
		    ps.setString(1, order.getOrderNo());
			ps.setString(2, order.getName());
			ps.setString(3, order.getAddress());
			ps.setInt(4, order.getTellNo());
			ps.setString(5, order.getItem());
			ps.setInt(6, order.getAmount());
			ps.setInt(7, order.getCharges());
			ps.setInt(8,finalAmount );
			ps.setInt(9, order.getQuantity());
			ps.setInt(10, order.getBilno());
			ps.setString(11, order.getOrderNo());
			 
			ps.executeUpdate();
			ResultSet rs = ps.executeQuery();
			System.out.println("Successfuly update Order");
			conn.close();
			System.out.println("Disconnected from database");

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
