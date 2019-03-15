/** IT17159036– Attanayake A.M.O.M */
package com.service;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.util.dbConnect;
import com.model.BillSearch;


public class searchServiceBill {

	Connection con = null;
	ResultSet res ;
	
	public void searchbill (BillSearch sch) throws ClassNotFoundException, SQLException
	{
		con = (Connection) dbConnect.conn();
		
		String se = sch.getSch();
		
		//ArrayList<String> a1 = null;
		//ArrayList<ArrayList<String>> bill_list = new ArrayList<ArrayList<String>>();
		
		String query = "select * from bill where bid like '%"+se+"%' ";
		
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
				table += "Item cord";
			table += "<th>";
    
			table += "<th>";
				table += "Price";
			table += "<th>";

			table += "<th>";
				table +="Quantity";
			table += "<th>";

			table += "<th>";
				table += "Net Price";
			table += "<th>";
		table += "<tr>"; 
			
				while(res.next()) {
					
					//a1 = new ArrayList<String>();
					BillSearch sch = new BillSearch();
					
		            sch.setbid(res.getString(1));
		            sch.seticode(res.getString(2));
		            sch.setprice(res.getString(3));
		            sch.setqty(res.getString(4));
		            sch.setnetp(res.getString(5));
		            
		            //bill_list.add(a1);

		            table += "<tr>";
		            		table += "<td>";
		            			table += sch.getbid();
		            		table += "<td>";
				        
		            		table += "<td>";
	            				table += sch.geticode();
	            			table += "<td>";
			        
	            			table += "<td>";
	            				table += sch.getprice();
            				table += "<td>";
		        
		    				table += "<td>";
        						table += sch.getqty();
        					table += "<td>";
	        
        					table += "<td>";
    							table += sch.getnetp();
    						table += "<td>";
    				        
        					table += "<td>";
    							table += "<a href =delete?icode="+sch.geticode()+">Delete</a>";
    						table += "<td>";
			        table += "<tr>"; 
				}
				
				
				con.close();
				System.out.println("Disconnected from database");
				
				table += "</table>";
	 		
				return table;//bill_list;
		
	}
}

	/*public void printTable() {
		// TODO Auto-generated method stub
		
	}
}*/
