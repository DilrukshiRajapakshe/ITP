package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.empSearch;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.util.dbConnect;

public class supSerchSeivice {
	
Connection conn = null;
	
	public ArrayList searchemployee(empSearch search) throws ClassNotFoundException, SQLException 
	{
		//Connect database
		conn = (Connection) dbConnect.conn();
		
		String se = search.getSearch();
		
		ArrayList al=null;
		ArrayList search_list =new ArrayList();
		String query = "select id,name,occupation,address,contact from employee where name like '%"+se+"%' ";
		
		Statement st = (Statement) conn.createStatement();
		ResultSet  rs = st.executeQuery(query);
		
			while (rs.next()) {
            al = new ArrayList();
       

            al.add(rs.getString("id"));
            al.add(rs.getString("name"));
            al.add(rs.getString("occupation"));
            al.add(rs.getString("address"));
            al.add(rs.getString("contact"));
            

            search_list.add(al);
			}
			
		conn.close();
		System.out.println("Disconnected from database");
		
		return search_list;
		
		
	}

}

