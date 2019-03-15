/** IT17119122
 * Liyanage I.M */
package com.service;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.model.search4;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class search4Service {
	
Connection conn = null;
	
	public ArrayList searchAttendance(search4 search) throws SQLException {
		
		conn = (Connection) dbConnect.conn();
		
		ArrayList al=null;
		ArrayList search_list =new ArrayList();
		
		String year = search.getYear();
		String day = search.getDay();
		String month = search.getMonth();
		
		
		String query1 = "select * from attendance where year like '%"+year+"%' and month like '%"+month+"%' and day like '%"+day+"%'";
			

		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query1);
		
		ResultSet  rs = ps.executeQuery(query1);
		while (rs.next()) {
			
            al = new ArrayList();

            al.add(rs.getString(1));
            al.add(rs.getString(2));
            al.add(rs.getString(3));
            al.add(rs.getString(4));
            al.add(rs.getString(5));
            al.add(rs.getString(6));
            al.add(rs.getString(7));
            al.add(rs.getString(8));
            
            System.out.println(rs.getString(4));
            search_list.add(al);
            
		}
		conn.close();
		System.out.println("Disconnected from database");
		
		return search_list;
	}

}
