/** IT17106320– Hasara U.G.S */
package com.service;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.model.employee;
import com.util.dbConnect;


public class ReadDataEmp {
	
		Connection conn = null;
		public ArrayList employeeRead(employee emp)throws ClassNotFoundException, SQLException {
			//Connect database
			conn = (Connection) dbConnect.conn();
			String query1=null;
			int  id = emp.getId();
			
			query1 = "SELECT id,name,nic,occupation,salary,bdate,gender,contact,email,address,nationality,jdate FROM employee where Id ="+id+"";
			
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
	            al.add(rs.getInt(5));
	            al.add(rs.getString(6));
	            al.add(rs.getString(7));
	            al.add(rs.getInt(8));
	            al.add(rs.getString(9));
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
