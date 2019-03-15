package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.supplier;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class InsertOrder {
Connection conn = null;
	
	public void addSupplierOder(supplier supplier)
	{
		//Connect database
		conn = (Connection) dbConnect.conn();
		
		try {
			String query1 = "insert into supplierorders(orderid,id,name,item,orderdate,warranty,itempirce,quantity,discount,fullcost,finalitemcost) values(?,?,?,?,?,?,?,?,?,?,?)";
		    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query1);
		    
		    String s = supplier.getOrderId();
		    System.out.println(supplier.getOrderId()+" "+supplier.getRemoveReason());
		    
		    int price = supplier.getPrice();
		    int quantity = supplier.getQuantity();
		    double discount = supplier.getDiscount();
		    
		    double fullamount;
		    double itemFullAmount;
		    double discountAmount;
		    double amount;
		    
		    amount = price * quantity ;
		    discountAmount = amount * discount/100;
		    fullamount = amount - discountAmount;
		    itemFullAmount = fullamount / quantity;
		    
		    ps.setString(1, supplier.getOrderId());
			ps.setInt(2, supplier.getId());
			ps.setString(3, supplier.getName());
			ps.setString(4, supplier.getItem());
			ps.setString(5, supplier.getOrderDate());
			ps.setString(6, supplier.getWarranty());
			ps.setInt(7, supplier.getPrice());
			ps.setInt(8, supplier.getQuantity());
			ps.setDouble(9, supplier.getDiscount());
			ps.setDouble(10, fullamount);
			ps.setDouble(11,itemFullAmount );
			
			
			ps.executeUpdate();
			//ResultSet rs = ps.executeQuery();
			System.out.println("Successfuly added supplier Oder");
			conn.close();
			System.out.println("Disconnected from database");

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}
}
