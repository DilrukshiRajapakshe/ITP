/** IT17119122
 * Liyanage I.M */
package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.dailyAttendance;
import com.model.search4;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class getDailyAttendance {

	Connection conn = null;
	
public ArrayList getDailyAttendances(dailyAttendance obj) throws SQLException {
		
		conn = (Connection) dbConnect.conn();
		
		ArrayList al=null;
		ArrayList search_list =new ArrayList();
		
		String year = obj.getYear();
		String day = obj.getDay();
		String month = obj.getMonth();
		
		
		String query1 = "select * from attendance where year like '%"+year+"%' and month like '%"+month+"%' and day like '%"+day+"%'";
			

		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query1);
		
		ResultSet  rs = ps.executeQuery(query1);
		while (rs.next()) {
			
            al = new ArrayList();

            al.add(rs.getString("ename"));
            al.add(rs.getString("intime"));
            al.add(rs.getString("outtime"));
            
            System.out.println(rs.getString(4));
            search_list.add(al);
            
		}
		
		conn.close();
		System.out.println("Disconnected from database");
		
		return search_list;
	}
}
