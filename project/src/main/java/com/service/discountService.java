/** IT17159036– Attanayake A.M.O.M */
package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.disc;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.util.dbConnect;

public class discountService {

	

	Connection con = null;
	ResultSet res ;
	
	public void discountSch (disc d) throws ClassNotFoundException, SQLException{
		con = (Connection) dbConnect.conn();
		
		String se = d.getbid();
		
		//ArrayList<String> a1 = null;
		//ArrayList<ArrayList<String>> bill_list = new ArrayList<ArrayList<String>>();
		
		String query = "select * from disc where bid like '%"+se+"%' ";
		
		Statement st = (Statement) con.createStatement();
		this.res = st.executeQuery(query);
	}
	
	public String printTable() throws SQLException{
		
			String table = "";
		
		table += "<table border = 1>";
	        table += "<tr>";
    		table += "<th>";
    			table += "Bill ID";
    		table += "<th>";
        
    		table += "<th>";
				table += "Discount";
			table += "<th>";
			
    		table += "<td>";
				table += "Delete";
			table += "<td>";

   		table += "<tr>"; 
			
				while(res.next()) {
					
					disc d = new disc();
					//a1 = new ArrayList<String>();
					
					
		            d.setbid(res.getString(1));
		            d.setdis(res.getString(2));
		            
		            //bill_list.add(a1);

		            table += "<tr>";
		            		table += "<td>";
		            			table += d.getbid();
		            		table += "<td>";
				        
		            		table += "<td>";
	            				table += d.getdis();
	            			table += "<td>";
			        
	        
        					table += "<td>";
    							table += "<a href =delete?bid="+d.getbid()+">Delete</a>";
    						table += "<td>";
			        table += "<tr>"; 
				}
				
				
				con.close();
				System.out.println("Disconnected from database");
				
				table += "</table>";
	 		
				return table;//bill_list;
	}


}
