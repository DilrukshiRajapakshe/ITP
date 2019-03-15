/** IT16234062– Rajapakshe D.D.S */
package com.service;
import java.sql.*;
import com.util.dbConnect; 
import com.model.ReturnItem;
public class Retutnservice {
Connection conn = null;
	
	public void returnAndReparingInsert(ReturnItem stock) throws SQLException{
		conn = (Connection)dbConnect.conn();
		String query = "Insert into returnitem(name,Id,supplierID,cuName,telNo,sellprice,amount,date,today,type) values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
		
		ps.setString(1, stock.getName());
		ps.setLong(2, stock.getId());
		ps.setString(3, stock.getSupplierID());
		ps.setString(4, stock.getCuName());
		ps.setInt(5, stock.getTelNo());
		ps.setDouble(6, stock.getSellprice());
		ps.setInt(7, stock.getAmount());
		ps.setString(8, stock.getDate());
		ps.setString(9, stock.getToday());
		ps.setString(10, stock.getType());
		
		
		ps.executeUpdate();
		System.out.println("Successfuly added Stock Table");
		conn.close();
		System.out.println("Disconnected from database table in Stock Table");

	}
}
