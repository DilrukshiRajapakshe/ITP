package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.cashier;
import com.util.dbConnect;

public class BillpassToSales {

Connection conn = null;
	
	public void billPass(cashier Bill) throws SQLException{
		
	/*	
		conn = (Connection) dbConnect.conn();
		
			
			String q5 = "insert into dailySales(ItemNo,qty,income) select Icode,count(qty),sum(NetPrice) from bill where cast(bid as DATE)=CURDATE() group by Icode";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(q5, 0);
			
			ps.executeUpdate();
			System.out.println("Succefully added to the table!!");
			Bill.getIcode();
			Bill.getQty();
			Bill.getNetPrice();
			
			conn.close();
			System.out.println("Disconnected from database");
		*/
	}

}
