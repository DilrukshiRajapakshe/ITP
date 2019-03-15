/** IT17123778– Wickramanayaka D.T.A */
package com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.ViewClass;
import com.util.dbConnect;

public class ViewOrders {
	
	Connection conn = null;
	public ArrayList OrderViewDisplay(ViewClass view)throws ClassNotFoundException, SQLException {
		//Connect database
				conn = (Connection) dbConnect.conn();
		String query1 = "SELECT * FROM oder";
		String st = view.getSt();
		ArrayList al = null;
		ArrayList listView = new ArrayList();
		
		Statement sta = (Statement) conn.createStatement();
		ResultSet  rs = sta.executeQuery(query1);
		
			while (rs.next()) {
            al = new ArrayList();

            al.add(rs.getString(1));
            al.add(rs.getString(2));
            al.add(rs.getString(3));
            al.add(rs.getInt(4));
            al.add(rs.getString(5));
            al.add(rs.getInt(6));
            al.add(rs.getInt(7));
            al.add(rs.getInt(8));
            al.add(rs.getString(9));
            al.add(rs.getInt(10));
            al.add(rs.getInt(11));


            listView.add(al);
			}
			
		conn.close();
		System.out.println("Disconnected from database");
		
		return listView;
		
	}

}
