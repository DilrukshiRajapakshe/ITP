/** IT17119122
 * Liyanage I.M */
package com.util;

import java.sql.*;

public class dbConnect {
	
	public static Connection conn() {
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hd", "root", "");
			System.out.println("Connected to the database..");
			
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
		return conn;
	}
}
