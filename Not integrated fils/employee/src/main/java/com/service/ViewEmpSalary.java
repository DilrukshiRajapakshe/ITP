package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.ViewClass;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.util.dbConnect;

public class ViewEmpSalary {
	
	Connection conn = null;
	public ArrayList viewsalartDisplay(ViewClass view)throws ClassNotFoundException, SQLException {
		//Connect database
				conn = (Connection) dbConnect.conn();
		String query1 = "SELECT attendance.eid,attendance.ename,employee.occupation,employee.salary FROM employee INNER JOIN attendance ON employee.id = attendance.eid";
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
            al.add(rs.getInt(4));

            listView.add(al);
			}
			
		conn.close();
		System.out.println("Disconnected from database");
		
		return listView;
		
	}

}
