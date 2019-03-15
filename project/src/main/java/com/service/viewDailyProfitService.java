/** IT17089296
 * Hapuarachchi H.D.H.U */
package com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.view;
import com.mysql.jdbc.Statement;
import com.util.dbConnect;

public class viewDailyProfitService {

Connection conn = null;
	
	public ArrayList dailyProfitService(view View) throws ClassNotFoundException, SQLException {
		//connect database
		
		conn = (Connection) dbConnect.conn();
		
			String v = View.getView();
			
			ArrayList array = null;
			
			ArrayList list = new ArrayList();
			
			String q3 = "select * From incometab where CAST(Date as DATE) = CURDATE() union all select 'Total :',null,null,null,sum(profit) from incometab where CAST(Date as DATE) = CURDATE()";
			
			Statement s = (Statement) conn.createStatement();
			ResultSet rt = s.executeQuery(q3);
			
			
			while(rt.next()){
				array = new ArrayList();
				
				array.add(rt.getString(1));
				array.add(rt.getString(2));
				array.add(rt.getString(3));
				array.add(rt.getString(4));
				array.add(rt.getString(5));
				
			
				list.add(array);
				
			}
			
			conn.close();
			System.out.println("Disconnected from database");
			
			return list;
		
	}
}
