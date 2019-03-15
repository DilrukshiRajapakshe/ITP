/** IT17106320– Hasara U.G.S */
package com.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import com.model.ViewClass;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.util.dbConnect;

public class DeleteView {
	
		Connection conn = null;
		public ArrayList viewDeleteDisplay(ViewClass view)throws ClassNotFoundException, SQLException {
			//Connect database
					conn = (Connection) dbConnect.conn();
			String query1 = "SELECT id,name,occupation,salary,email,contact,rdate,rreason FROM removeemployee";
			String st = view.getSt();
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
	            al.add(rs.getString(7));
	            al.add(rs.getString(8));

	            listView.add(al);
				}
				
			conn.close();
			System.out.println("Disconnected from database");
			
			return listView;
			
		}
	}



