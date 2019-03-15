/** IT17106320– Hasara U.G.S */
package com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.employee;
import com.util.dbConnect;

public class ReadDelete {
	
	Connection conn = null;
	public ArrayList EmployeeReadDelete(employee e)throws ClassNotFoundException, SQLException {
		//Connect database
				conn = (Connection) dbConnect.conn();
		String query1=null;
		int  id = e.getId();
		
		query1 = "SELECT id,name,email,contact,occupation,Salary FROM employee where Id ="+id+"";
		
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
            al.add(rs.getString(5));
            al.add(rs.getInt(6));


            listView.add(al);
			}
			
		conn.close();
		System.out.println("Disconnected from database");
		
		return listView;
		
	}

}
