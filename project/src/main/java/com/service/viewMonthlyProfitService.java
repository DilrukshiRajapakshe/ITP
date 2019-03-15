/** IT17089296
 * Hapuarachchi H.D.H.U */
package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.profitController;
import com.model.monthlyProfitReport;
import com.model.view;
import com.mysql.jdbc.Statement;
import com.util.dbConnect;

public class viewMonthlyProfitService {
	
	Connection conn = null;
	public ArrayList monthlyProfitService(view View) throws ClassNotFoundException, SQLException {
		//connect database
		
	
		conn = (Connection) dbConnect.conn();
		
			//String v = View.getView();
			//HttpServletRequest request;
			//HttpServletResponse response;
			//ArrayList array = null;
			
			//ArrayList list = new ArrayList();
			
			monthlyProfitReport mp = new monthlyProfitReport();
			
			
			
			ArrayList list = null;
			
			newDateService mds = new newDateService();
			list = mds.addDateService(mp);
			
			/*while(rt.next()){
				array = new ArrayList();
				
				array.add(rt.getString(1));
				array.add(rt.getString(2));
				array.add(rt.getString(3));
				array.add(rt.getString(4));
				array.add(rt.getString(5));
				
			
				list.add(array);
				
			}*/
			//System.out.println(list);
			conn.close();
			System.out.println("Disconnected from database");
			
			return list;
		
	}
}
