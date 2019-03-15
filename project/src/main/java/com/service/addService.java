/** IT17089296
 * Hapuarachchi H.D.H.U */
package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.model.add;

import com.util.dbConnect;

public class addService {
	Connection conn = null;
	
	public void addCostService(add Add) throws SQLException{
		
		
		conn = (Connection) dbConnect.conn();
		
			String q1 = "Insert into monthly_cost(cost_type,amount) values(?,?)";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(q1, 0);
			 
			ps.setString(1,Add.getcost_type());
			ps.setDouble(2,Add.getamount());
			
			ps.executeUpdate();
			System.out.println("Succefully added to the table!!");
			
			
			conn.close();
			System.out.println("Disconnected from database");
		
	}
}
