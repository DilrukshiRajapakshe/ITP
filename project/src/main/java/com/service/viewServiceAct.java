//IT17024914
package com.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.text.*; //added on 22/09/2018

import com.model.activity;
import com.model.viewAct;
import com.mysql.jdbc.Statement;
import com.util.dbConnect;

public class viewServiceAct {
Connection conn = null;
	
	public ArrayList displayService(boolean boolAll,boolean boolToday,String FromDate,String ToDate,String UserID, String Activity) throws ClassNotFoundException, SQLException {
		//connect database
		
		conn = (Connection) dbConnect.conn();
		
			//String v = View.getView();
			
			//Data Filtering query  ------------------------------------------------------------------------
			StringBuffer q1 = new StringBuffer();
			if (boolAll)
				{
					q1.append("");
				}else if(boolToday)
				{
				Date toDay=new Date(0);
					Object date = null;
					q1.append(" WHERE (date BETWEEN '" + String.format("%tF", date ) + " 00:00:00' AND '" + String.format("%tF", date ) + " 23:59:59')");
				}else if (FromDate!="" && ToDate!="" )
				{
					q1.append(" WHERE (date BETWEEN '" + FromDate + " 00:00:00' AND '" + ToDate + " 23:59:59')");
				}

				
				boolean q1Empty=false;
			if (UserID!="" || Activity!="")
					{
						if (q1.append("") != null )
						{
							q1Empty=true;
							q1.append(" WHERE");
						}
						//Adding UserID to where clause
						if ( q1Empty==false && UserID!="")
							{
								q1.append(" AND");
							}
							
						if (UserID!="")
							{
								q1.append(" uname='" + UserID + "'");
							}
						//End Adding UserID to where clause
						
						//Adding Activity to where clause
						if ( (q1Empty==false && Activity!="") || (q1Empty==true && UserID!="" ))
							{
								q1.append(" AND");
							}
							
						if (UserID!="")
							{
								q1.append(" activityType='" + Activity + "'");
							}
						//End Adding Activity to where clause
					}
			
			//End of Data Filtering query ------------------------------------------------------------------------
					
			ArrayList arry = null;
			ArrayList view_list = new ArrayList();
			String q2 = "select * From activity" + q1.toString();
			
			Statement s = (Statement) conn.createStatement();
			ResultSet r = s.executeQuery(q2);
			
			while(r.next()){
				arry = new ArrayList();
				
				arry.add(r.getString(1));
				arry.add(r.getString(2));
				arry.add(r.getString(3));
				arry.add(r.getString(4));
				
			
				view_list.add(arry);
			}
			
			
			
			conn.close();
			System.out.println("Disconnected from database");
			
			return view_list;
		
	}

	public ArrayList displayService(viewAct vv) {
		// TODO Auto-generated method stub
		return null;
	}
}
