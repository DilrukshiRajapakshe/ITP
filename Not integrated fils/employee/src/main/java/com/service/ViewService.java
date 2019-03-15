package com.service;
import java.sql.*;
import java.util.ArrayList;

import com.model.ViewClass;
import com.mysql.jdbc.Connection;
import com.util.dbConnect;


public class ViewService {
	Connection conn = null;
	public ArrayList employeeViewDisplay(ViewClass view)throws ClassNotFoundException, SQLException {
		//Connect database
				conn = (Connection) dbConnect.conn();
		String query1 = "SELECT id,name,nic,gender,bdate,nationality,occupation,salary,contact,email,address,jdate FROM employee";
		String st = view.getSt();
		ArrayList al = null;
		ArrayList listView = new ArrayList();
		
		Statement sta = (Statement) conn.createStatement();
		ResultSet  rs = sta.executeQuery(query1);
		
			while (rs.next()) {
            al = new ArrayList();

            al.add(rs.getInt(1));
            al.add(rs.getString(2));
            al.add(rs.getString(3));
            al.add(rs.getString(4));
            al.add(rs.getString(5));
            al.add(rs.getString(6));
            al.add(rs.getString(7));
            al.add(rs.getInt(8));
            al.add(rs.getInt(9));
            al.add(rs.getString(10));
            al.add(rs.getString(11));
            al.add(rs.getString(12));


            listView.add(al);
			}
			
		conn.close();
		System.out.println("Disconnected from database");
		
		return listView;
		
	}
}
