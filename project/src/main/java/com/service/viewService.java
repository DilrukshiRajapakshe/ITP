/** IT17089296
 * Hapuarachchi H.D.H.U */
package com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.model.view;
import com.mysql.jdbc.Statement;
import com.util.dbConnect;

public class viewService {
Connection conn = null;
	
	public ArrayList displayService(view View) throws ClassNotFoundException, SQLException {
		//connect database
		
		conn = (Connection) dbConnect.conn();
		
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
