/** IT16234062– Rajapakshe D.D.S */
package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.DamageClass;
import com.model.ReturnItem;
import com.model.StockItem;
import com.util.dbConnect;

public class UpdateService {
Connection conn = null;
	
	public void stockAndDamgeUpdate(StockItem stock) throws SQLException{
		conn = (Connection)dbConnect.conn();
		String type = stock.getType();
		
			String query1 = "Update stockitem set Id=?, name=?, supplierID=?, description=?, purchaseprice=?, sellprice=?, amount=?, type=? where Id=?";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query1);
			
			ps.setLong(1, stock.getId());
			ps.setString(2, stock.getName());
			ps.setString(3, stock.getSupplierID());
			ps.setString(4, stock.getDescription());
			ps.setDouble(5, stock.getPurchaseprice());
			ps.setDouble(6, stock.getSellprice());
			ps.setInt(7, stock.getAmount());
			ps.setString(8, stock.getType());
			ps.setLong(9, stock.getId());
			ps.executeUpdate();
			System.out.println("Successfuly Update Stock Table");
			conn.close();
			System.out.println("Disconnected from database table in Stock Table");
		
	}
	public void DamgeUpdate(DamageClass stock) throws SQLException{
		conn = (Connection)dbConnect.conn();
		String type = stock.getType();
			String query1 = "Update stockdamageitem set Id=?, name=?, supplierID=?, description=?, purchaseprice=?, amount=?, type=?, cost=? where Id=?";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query1);
			
			ps.setLong(1, stock.getId());
			ps.setString(2, stock.getName());
			ps.setString(3, stock.getSupplierID());
			ps.setString(4, stock.getDescription());
			ps.setDouble(5, stock.getPurchaseprice());
			ps.setInt(6, stock.getAmount());
			ps.setString(7, stock.getType());
			ps.setDouble(8, stock.getCost());
			ps.setLong(9, stock.getId());
			ps.executeUpdate();
			System.out.println("Successfuly Update Stock Table");
			conn.close();
			System.out.println("Disconnected from database table in Stock Table");
	}
	
	public void rentANDreturnUpdate(ReturnItem r) throws SQLException{
		conn = (Connection)dbConnect.conn();
		String type = r.getType();
		
			String query1 = "Update returnitem set  name=?, Id=?, supplierID=?, cuName=?, telNo=?, sellprice=?, amount =?, date=?, today=?, type=? where Id=?";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query1);
			
			ps.setString(1, r.getName());
			ps.setLong(2, r.getId());
			ps.setString(3, r.getSupplierID());
			ps.setString(4, r.getCuName());
			ps.setInt(5, r.getTelNo());
			ps.setDouble(6, r.getSellprice());
			ps.setInt(7, r.getAmount());
			ps.setString(8, r.getDate());
			ps.setString(9, r.getToday());
			ps.setString(10, r.getType());
			ps.setLong(11, r.getId());
			ps.executeUpdate();
			ps.executeUpdate();
			System.out.println("Successfuly Update Stock Table");
			conn.close();
			System.out.println("Disconnected from database table in Stock Table");
		
	}
}
