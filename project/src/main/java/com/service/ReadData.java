/** IT17123778– Wickramanayaka D.T.A */
package com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.model.Order;
import com.util.dbConnect;

public class ReadData {
	
	Connection conn = null;
	public ArrayList OrderRead(Order r)throws ClassNotFoundException, SQLException {
		//Connect database
				conn = (Connection) dbConnect.conn();
		String query1=null;
		String  no = r.getOrderNo();
		
		query1 = "SELECT oderNo,customerName,address,telephoneNo,items,quantity,billno,amount,deliveryCharges,finalAmount FROM oder where oderNo ="+no+"";
		
		ArrayList al = null;
		ArrayList listView = new ArrayList();
		
		Statement sta = (Statement) conn.createStatement();
		ResultSet  rs = sta.executeQuery(query1);
		
			while (rs.next()) {
            al = new ArrayList();

            al.add(rs.getString(1));
            al.add(rs.getString(2));
            al.add(rs.getString(3));
            al.add(rs.getInt(4));
            al.add(rs.getString(5));
            al.add(rs.getInt(6));
            al.add(rs.getInt(7));
            al.add(rs.getInt(8));
            al.add(rs.getString(9));
            al.add(rs.getInt(10));
           


            listView.add(al);
			}
			
		conn.close();
		System.out.println("Disconnected from database");
		
		return listView;
		
	}

}
