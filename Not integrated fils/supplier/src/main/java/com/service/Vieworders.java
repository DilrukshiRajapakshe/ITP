package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.ViewClass;
import com.model.supplier;
import com.mysql.jdbc.Connection;
import com.util.dbConnect;

public class Vieworders {
	
	Connection conn = null;
	public ArrayList SupplierOrdertView(supplier s)throws ClassNotFoundException, SQLException {
		//Connect database
				conn = (Connection) dbConnect.conn();
		String query1=null;
		int  id = s.getId();
		
		query1 = "SELECT * FROM supplierorders where id ="+id+"";
		
		ArrayList al = null;
		ArrayList listView = new ArrayList();
		
		Statement sta = (Statement) conn.createStatement();
		ResultSet  rs = sta.executeQuery(query1);
		
			while (rs.next()) {
            al = new ArrayList();

            al.add(rs.getString(1));
            al.add(rs.getInt(2));
            al.add(rs.getString(3));
            al.add(rs.getString(4));
            al.add(rs.getString(5));
            al.add(rs.getString(6));
            al.add(rs.getInt(7));
            al.add(rs.getInt(8));
            al.add(rs.getDouble(9));
            al.add(rs.getDouble(10));
            al.add(rs.getDouble(11));

            listView.add(al);
			}
			
		conn.close();
		System.out.println("Disconnected from database");
		
		return listView;
		
	}


}
