/** IT17123778– Wickramanayaka D.T.A */
package com.service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.model.Order;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class InsertOrder {
	
	Connection conn = null;
	
	public void InsertOrderr(Order order)
	{
		//Connect database
		conn = (Connection) dbConnect.conn();
		
		try {
			String query1 = "insert into oder(oderNo,customerName,address,telephoneNo,items,amount,deliveryCharges,finalAmount,quantity,deliveryStatus,billno) values(?,?,?,?,?,?,?,?,?,'Pending','000')";
		    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query1);
		    
		    String s = order.getOrderNo();
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
			ps.setInt(8, finalAmount);
			ps.setInt(9, order.getQuantity());
			
			
			
			
			ps.executeUpdate();
			ResultSet rs = ps.executeQuery();
			System.out.println("Successfuly added order");
			conn.close();
			System.out.println("Disconnected from database");

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}
