package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.util.dbConnect;

public class getOrderDeatailsForDashboard {

	
Connection conn = null;
	
	public ArrayList getOrderDeatails() throws ClassNotFoundException, SQLException 
	{
		//Connect database
		conn = (Connection) dbConnect.conn();
		
		ArrayList al=null;
		ArrayList search_list =new ArrayList();
		String query = "select * from oder where deliveryStatus like '%Pending%'";
		
		Statement st = (Statement) conn.createStatement();
		ResultSet  rs = st.executeQuery(query);
		
			while (rs.next()) {
            al = new ArrayList();

            al.add(rs.getString("oderNo"));
            al.add(rs.getString("customerName"));
            al.add(rs.getString("address"));
            al.add(rs.getString("telephoneNo"));
            al.add(rs.getString("deliveryStatus"));
            search_list.add(al);
			}
			
		conn.close();
		System.out.println("Disconnected from database");
		
		return search_list;
		
	}
}
