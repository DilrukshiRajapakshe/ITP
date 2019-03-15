/** IT17122092
 * Sandarenu M.D.K */
package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.supSearch;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.util.dbConnect;

public class SupplierSearchService {
	
Connection conn = null;
	
	public ArrayList searchsupplier(supSearch search) throws ClassNotFoundException, SQLException 
	{
		//Connect database
		conn = (Connection) dbConnect.conn();
		
		String se = search.getSearch();
		
		ArrayList al=null;
		ArrayList search_list =new ArrayList();
		String query = "select id,name,address,email,contact from supplier where name like '%"+se+"%' ";
		
		Statement st = (Statement) conn.createStatement();
		ResultSet  rs = st.executeQuery(query);
		
			while (rs.next()) {
            al = new ArrayList();

            al.add(rs.getInt("id"));
            al.add(rs.getString("name"));
            al.add(rs.getString("address"));
            al.add(rs.getString("mail"));
            al.add(rs.getInt("contact"));

            search_list.add(al);
			}
			
		conn.close();
		System.out.println("Disconnected from database");
		
		return search_list;
		
		
	}

}

