/** IT17089296
 * Hapuarachchi H.D.H.U */
package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//import com.model.StockItem;
import com.model.cashier;
import com.util.dbConnect;

public class refferIncomeService {

Connection conn = null;
	
	public void refferIncome(cashier Bill) throws SQLException{
		
		
		conn = (Connection) dbConnect.conn();
		
			
			String q5 = "insert into incometab(Date,ItemNo,itemName,qty,profit) select dailySales.Date,dailySales.ItemNo,stockitem.name,dailySales.qty,(dailySales.income-stockitem.purchaseprice * dailySales.qty) from dailySales,stockitem where not exists(select * from incometab where dailySales.Date = incometab.Date) and stockitem.Id = dailySales.ItemNo";
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(q5, 0);
			
			ps.executeUpdate();
			System.out.println("Succefully added to the table!!");
			
			
			conn.close();
			System.out.println("Disconnected from database");
		
	}
}
