package com.service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.model.supplier;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class SupplierService {
	
	Connection conn = null;
	
	public void addSupplierService(supplier supplier)
	{
		//Connect database
		conn = (Connection) dbConnect.conn();
		
		try {
			String query1 = "insert into supplier(id,email,address,joindate,name,contact,item) values(?,?,?,?,?,?,?)";
		    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query1);
		    
		    int s = supplier.getId();
			
			ps.setInt(1, supplier.getId());
			ps.setString(2, supplier.getEmail());
			ps.setString(3, supplier.getAddress());
			ps.setString(4, supplier.getJoinDate());
			ps.setString(5, supplier.getName());
			ps.setInt(6, supplier.getContact());
			ps.setString(7, supplier.getItem());
			
			ps.executeUpdate();
			ResultSet rs = ps.executeQuery();
			System.out.println("Successfuly added supplier");
			conn.close();
			System.out.println("Disconnected from database");

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public String ConvertDate(java.util.Date date){
//		
//		
//		   
//		  
//		 String formatedDate ="";
//	    try {
//	    	DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy");
//			date = (Date)formatter.parse(date.toString());
//			 Calendar cal = Calendar.getInstance();
//			   
//			    cal.setTime(date);
//			    
//			    formatedDate=cal.get(Calendar.YEAR)+"-"+(cal.get(Calendar.MONTH) + 1)+"-"+cal.get(Calendar.DATE);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	   
//	    
//	    return formatedDate;
//
//	   
//	  }
//	
//	public void updateSupplierService(supplier supplier)
//	{
//		//Connect database
//		conn = (Connection) dbConnect.conn();
//		
//		try {
//			String sql="update supplier set email='"+supplier.getEmail()+"',address='"+supplier.getAddress()+"',joindate='"+supplier.getJoinDate()+"',name='"+supplier.getName()+"' ,contact='"+supplier.getContact()+"', item;='"+supplier.getItem()+"' where id="+supplier.getId()+"";
//		    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
//		    
////		    String s = supplier.getId();
////			
////			ps.setString(1, supplier.getId());
////			ps.setString(2, supplier.getEmail());
////			ps.setString(3, supplier.getAddress());
////			ps.setDate(4, (Date) supplier.getJoinDate());
////			ps.setDate(5, (Date) supplier.getRemoveDate());
////			ps.setString(6, supplier.getRemoveReason());
////			ps.setString(7, supplier.getName());
////			ps.setInt(8, supplier.getContact());
////			ps.setString(9, supplier.getItem());
//			
//			ps.executeUpdate();
//			ResultSet rs = ps.executeQuery();
//			System.out.println("Successfuly update supplier");
//			conn.close();
//			System.out.println("Disconnected from database");
//
//		}catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	
////	public void deletedetailsSupplierService(supplier supplier)
////	{
////		//Connect database
////		conn = (Connection) dbConnect.conn();
////		
////		try {
////			String sql="update supplier set removedate='"+supplier.getRemoveDate()+"',romovereasone='"+supplier.getRemoveReason()+"'  where id="+supplier.getId()+"";
////		    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
////		    
//////		    String s = supplier.getId();
//////			
//////			ps.setString(1, supplier.getId());
//////			ps.setString(2, supplier.getEmail());
//////			ps.setString(3, supplier.getAddress());
//////			ps.setDate(4, (Date) supplier.getJoinDate());
//////			ps.setDate(5, (Date) supplier.getRemoveDate());
//////			ps.setString(6, supplier.getRemoveReason());
//////			ps.setString(7, supplier.getName());
//////			ps.setInt(8, supplier.getContact());
//////			ps.setString(9, supplier.getItem());
////			
////			ps.executeUpdate();
////			ResultSet rs = ps.executeQuery();
////			System.out.println("Successfuly add delete details supplier");
////			conn.close();
////			System.out.println("Disconnected from database");
////
////		}catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////	}
//	
//	public void delete(int id) {
//		
//		//Connect database
//				conn = (Connection) dbConnect.conn();
//				
//	try {
//		String sql="delete from supplier where ID="+id+"";
//		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
//		
//		ps.executeUpdate();
//		ResultSet rs = ps.executeQuery();
//		System.out.println("Successfuly delete supplier");
//		conn.close();
//		System.out.println("Disconnected from database");
//
//	}catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} 
//		
//	}
//	
////public List<supplier> getAllsupplier() {
////		
////		
////		return template.query("select * from student",new ResultSetExtractor<List<supplier>>(){  
////		    
////		     public List<supplier> extractData(ResultSet rs) throws SQLException,  
////		            DataAccessException {  
////		      
////		        List<supplier> list=new ArrayList<supplier>();  
////		        while(rs.next()){  
////		        Student e=new Student();  
////		        e.setId(rs.getInt(1));  
////		        e.setFirstName(rs.getString(2));  
////		        e.setLastName(rs.getString(3));  
////		        e.setSex(rs.getString(4));
////		        e.setDob(rs.getDate(5));
////		        e.setEmail(rs.getString(6));
////		        e.setSection(rs.getString(7));  
////		        e.setCountry(rs.getString(8));  
////		        e.setFirstAttempt(rs.getBoolean(9));
////		        e.setSubjects(convertDelimitedStringToList(rs.getString(10)));
////		        
////		        list.add(e);  
////		        }  
////		        return list;  
////		        }  
////		    });  
////		  
////		
////		  }

}
