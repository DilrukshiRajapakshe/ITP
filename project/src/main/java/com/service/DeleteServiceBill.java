/** IT17159036– Attanayake A.M.O.M */
package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.BillSearch;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class DeleteServiceBill {

	Connection conn = null;
	
	public void deleteItem(BillSearch item) {
		
		conn = (Connection)dbConnect.conn();
		
		try {
			
			String query = "delete from bill where icode=?";
			PreparedStatement ps = (PreparedStatement)conn.prepareStatement(query);
			
			ps.executeUpdate();
			ResultSet rs = ps.executeQuery();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
