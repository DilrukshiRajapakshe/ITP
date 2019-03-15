/** IT17122092
 * Sandarenu M.D.K */
package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.ViewClass;
import com.mysql.jdbc.Connection;
import com.util.dbConnect;

public class ViewServiceSup {

	Connection conn = null;
	public ArrayList supplierViewDisplay(ViewClass view)throws ClassNotFoundException, SQLException {
		//Connect database
				conn = (Connection) dbConnect.conn();
		String query1 = "SELECT id,name,joindate,email,address,contact,item FROM supplier";
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
            al.add(rs.getString(4));
            al.add(rs.getString(5));
            al.add(rs.getInt(6));
            al.add(rs.getString(7));


            listView.add(al);
			}
			
		conn.close();
		System.out.println("Disconnected from database");
		
		return listView;
		
	}
}
