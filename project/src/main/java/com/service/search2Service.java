/** IT17119122
 * Liyanage I.M */
package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.search1;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.util.dbConnect;

public class search2Service {

	Connection conn = null;
	
	public ArrayList searchUser(search1 search) throws SQLException {
		
		conn = (Connection) dbConnect.conn();		
		
		System.out.println("11111");
		
		ArrayList al=null;
		
		String se = search.getSearch();
		
		String query1 = "select * from user where id like '%"+se+"%'";
			

		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query1);
		
		ResultSet  rs = ps.executeQuery(query1);
		while (rs.next()) {
			
            al = new ArrayList();

            al.add(rs.getString(1));
            al.add(rs.getString(2));
            al.add(rs.getString(3));
            al.add(rs.getString(4));
            al.add(rs.getString(5));
            System.out.println(rs.getString(5));
            
		}
		
		conn.close();
		System.out.println("Disconnected from database");
		
		return al;
	}
}
