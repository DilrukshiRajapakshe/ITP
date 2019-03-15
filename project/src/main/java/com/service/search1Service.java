/** IT17119122
 * Liyanage I.M */
package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.search1;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.util.dbConnect;

public class search1Service {
	
Connection conn = null;
	
	public ArrayList searchUser(search1 search) throws ClassNotFoundException, SQLException 
	{
		//Connect database
		conn = (Connection) dbConnect.conn();
		
		String se = search.getSearch();
		
		ArrayList al=null;
		ArrayList search_list =new ArrayList();
		String query = "select * from user where id like '%"+se+"%' or uname like '%"+se+"%'";
		
		Statement st = (Statement) conn.createStatement();
		ResultSet  rs = st.executeQuery(query);
		
			while (rs.next()) {
            al = new ArrayList();

            al.add(rs.getString(1)); 
            al.add(rs.getString(2)); 
            al.add(rs.getString(3)); 
            al.add(rs.getString(4)); 
            al.add(rs.getString(5)); 

            search_list.add(al);
			}
			
		conn.close();
		System.out.println("Disconnected from database");
		
		return search_list;
		
		
	}

}

