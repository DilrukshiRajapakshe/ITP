//IT17024914
package com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.View;

import com.model.activity;
import com.model.deleteAct;
import com.model.viewAct;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.util.dbConnect;

public class deleteServiceAct {


Connection conn = null;
	
	public ArrayList removeService(activity nAct) throws ClassNotFoundException, SQLException {
		//connect database
		
		conn = (Connection) dbConnect.conn();
		


		
		try {
		    String query3 = "delete from activity where Id=?";
		    PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query3);
		    
		    
		    //pst.setLong(1, nAct.getId());
		
			 
			pst.executeUpdate();
			ResultSet rst = pst.executeQuery();
			System.out.println("Successfuly delete row");
			conn.close();
			System.out.println("Disconnected from database");

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		viewAct View = new viewAct();
		String v = View.getView();
		ArrayList arry = null;
		ArrayList view_list = new ArrayList();
		String q2 = "select * From activity";
		
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