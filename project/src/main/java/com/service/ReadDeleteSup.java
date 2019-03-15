/** IT17122092
 * Sandarenu M.D.K */
package com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.supplier;
import com.util.dbConnect;

public class ReadDeleteSup {
	
	Connection conn = null;
	public ArrayList SupplierReadDelete(supplier s)throws ClassNotFoundException, SQLException {
		//Connect database
				conn = (Connection) dbConnect.conn();
		String query1=null;
		int  id = s.getId();
		
		query1 = "SELECT id,name,email,contact,item FROM supplier where Id ="+id+"";
		
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


            listView.add(al);
			}
			
		conn.close();
		System.out.println("Disconnected from database");
		
		return listView;
	}
}
