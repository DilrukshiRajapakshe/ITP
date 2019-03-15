/** IT17159036– Attanayake A.M.O.M */
/*package com.service;
import java.sql.*;


//import java.lang.Math;
import com.model.cashier;
import com.util.dbConnect;

public class cashierService {

	Connection conn = null;
	PreparedStatement pst = null;
	
	public void addcashierService(cashier cash) {
		
		//float Total;
		
		conn = (Connection) dbConnect.conn();
		
		try {
			
			 pst = conn.prepareStatement("INSERT INTO bill(date,bid,Icode,price,qty,netprice) VALUES (?,?,?,?,?)");
			 pst.setString(1,cash.getBillID());
			 pst.setString(2,cash.getIcode());
			 pst.setString(3,cash.getPrice()); 
			 pst.setString(4,cash.getQty());
			 pst.setString(5, cash.getNetPrice());
			 
			 pst.executeUpdate();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
*/

package com.service;
import java.sql.*;


//import java.lang.Math;
import com.model.cashier;
import com.util.dbConnect;

public class cashierService {

	Connection conn = null;
	PreparedStatement pst = null;
	
	public void addcashierService(cashier cash) {
		
		//float Total;
		
		conn = (Connection) dbConnect.conn();
		
		try {
			
			 pst = conn.prepareStatement("INSERT INTO bill(bid,icode,price,qty,NetPrice) VALUES (?,?,?,?,?)");
			 pst.setString(1,cash.getBillID());
			 pst.setString(2,cash.getIcode());
			 pst.setString(3,cash.getPrice()); 
			 pst.setString(4,cash.getQty());
			 pst.setString(5, cash.getNetPrice());
			 
			 pst.executeUpdate();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			pst = conn.prepareStatement("INSERT INTO disc(bid,disc)VALUES(?,?)");
			pst.setString(1,cash.getBillID());
			pst.setString(2,cash.getDisc());
			
			pst.executeUpdate();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
