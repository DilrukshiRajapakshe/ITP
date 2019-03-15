/** IT17089296
 * Hapuarachchi H.D.H.U */
package com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.View;

import com.model.add;
import com.model.delete;
import com.model.view;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.util.dbConnect;

public class deleteServiceHarini {


Connection conn = null;
	
	public ArrayList removeService(add nAdd) throws ClassNotFoundException, SQLException {
		//connect database
		
		conn = (Connection) dbConnect.conn();
		


		
		try {
		    String query3 = "delete from monthly_cost where Id=?";
		    PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query3);
		    
		    
		    pst.setLong(1, nAdd.getId());
		
			 
			pst.executeUpdate();
			ResultSet rst = pst.executeQuery();
			System.out.println("Successfuly delete row");
			conn.close();
			System.out.println("Disconnected from database");

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		view View = new view();
		String v = View.getView();
		ArrayList arry = null;
		ArrayList view_list = new ArrayList();
		String q2 = "select * From monthly_cost";
		
		Statement s = (Statement) conn.createStatement();
		ResultSet rt = s.executeQuery(q2);
		
		while(rt.next()){
			arry = new ArrayList();
			
			arry.add(rt.getString(1));
			arry.add(rt.getString(2));
			arry.add(rt.getString(3));
			arry.add(rt.getString(4));
		
			view_list.add(arry);
		}
		
		
		
		conn.close();
		System.out.println("Disconnected from database");
		
		return view_list;
		
	}
		
	
}

		
	


