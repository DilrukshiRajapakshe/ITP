/** IT17119122
 * Liyanage I.M */
package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.util.dbConnect;

public class getEmployeeService {
	
	
	
Connection conn = null;
	
	public ArrayList searchEmployee() throws ClassNotFoundException, SQLException 
	{
		//Connect database
		conn = (Connection) dbConnect.conn();
		
		ArrayList al=null;
		ArrayList search_list =new ArrayList();
		String query = "select * from employee";
		
		Statement st = (Statement) conn.createStatement();
		ResultSet  rs = st.executeQuery(query);
		
			while (rs.next()) {
            al = new ArrayList();

            al.add(rs.getString("id"));
            al.add(rs.getString("name"));
          
            search_list.add(al);
			}
			
		conn.close();
		System.out.println("Disconnected from database");
		
		return search_list;
		
	}
	
	
	public ArrayList searchEmployeeNames() throws ClassNotFoundException, SQLException 
	{
		//Connect database
		conn = (Connection) dbConnect.conn();
		
		ArrayList al=null;
		ArrayList search_list =new ArrayList();
		String query = "select * from employee";
		
		Statement st = (Statement) conn.createStatement();
		ResultSet  rs = st.executeQuery(query);
		
			while (rs.next()) {
            al = new ArrayList();

            al.add(rs.getString("ename"));
          
            search_list.add(al);
			}
			
		conn.close();
		System.out.println("Disconnected from database");
		
		return search_list;
		
	}
}
