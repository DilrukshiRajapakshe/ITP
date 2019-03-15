/** IT16234062– Rajapakshe D.D.S */
package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.DamageClass;
import com.util.dbConnect;

public class DamageInsertService {
Connection conn = null;
	
	public void DamgeInsert(DamageClass d) throws SQLException{
		conn = (Connection)dbConnect.conn();
		String query = "Insert into stockdamageitem(Id,name,supplierID,description,purchaseprice,amount,type,cost) values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
		
		ps.setLong(1,d.getId());
		ps.setString(2, d.getName());
		ps.setString(3, d.getSupplierID());
		ps.setString(4, d.getDescription());
		ps.setDouble(5, d.getPurchaseprice());
		ps.setInt(6, d.getAmount());
		ps.setString(7, d.getType());
		ps.setDouble(8, d.getCost());
		ps.executeUpdate();
		System.out.println("Successfuly added Stock Table");
		conn.close();
		System.out.println("Disconnected from database table in Stock Table");

	}
}
