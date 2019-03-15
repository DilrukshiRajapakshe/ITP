package com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.employee;
import com.util.dbConnect;

public class ReadeSalary {
	
	Connection conn = null;
	public ArrayList SalaryRead(employee e)throws ClassNotFoundException, SQLException {
		//Connect database
				conn = (Connection) dbConnect.conn();
		String query1=null;
		int  id = e.getId();
		
		query1 = "SELECT attendance.eid,attendance.ename,employee.occupation,employee.salary FROM employee INNER JOIN attendance ON employee.id = attendance.eid where employee.id ="+id+"";
		
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
		
	} //where Id ="+id+"


}
