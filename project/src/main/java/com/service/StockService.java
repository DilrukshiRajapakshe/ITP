/** IT16234062– Rajapakshe D.D.S */
package com.service;
import java.sql.*;

import com.model.StockItem;
import com.util.dbConnect; 
public class StockService {
	Connection conn = null;
	
	public void stockAndDamgeInsert(StockItem stock) throws SQLException{
		conn = (Connection)dbConnect.conn();
		String query = "Insert into stockitem(name,supplierID,description,purchaseprice,sellprice,amount,type) values(?,?,?,?,?,?,?)";
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
		
		ps.setString(1, stock.getName());
		ps.setString(2, stock.getSupplierID());
		ps.setString(3, stock.getDescription());
		ps.setDouble(4, stock.getPurchaseprice());
		ps.setDouble(5, stock.getSellprice());
		ps.setInt(6, stock.getAmount());
		ps.setString(7, stock.getType());
		
		ps.executeUpdate();
		System.out.println("Successfuly added Stock Table");
		conn.close();
		System.out.println("Disconnected from database table in Stock Table");

	}
}
