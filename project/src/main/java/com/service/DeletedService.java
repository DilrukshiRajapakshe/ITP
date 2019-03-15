/** IT16234062– Rajapakshe D.D.S */
package com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.DamageClass;
import com.model.ReturnItem;
import com.model.StockItem;
import com.mysql.jdbc.PreparedStatement;

import com.util.dbConnect;

public class DeletedService {
	Connection conn = null;
	
	public ArrayList stockDeleted(StockItem s)throws ClassNotFoundException, SQLException {
		conn = (Connection)dbConnect.conn();
		String type = s.getType();
		ArrayList al = null;
		ArrayList listView = new ArrayList();
		
		if(type.equals("Stock-item")){
			
			String query1=null;
			
			query1 = "DELETE  FROM stockitem where Id =?";
			
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query1);
		    pst.setLong(1, s.getId());
		    
		    pst.executeUpdate();
			
			
			System.out.println("Successfuly delete row");
			
			conn.close();
			System.out.println("Disconnected from database");
			if(type.equals("Stock-item")){
				conn = (Connection)dbConnect.conn();
				String query2 = "SELECT * FROM stockitem where type = 'Stock-item'";
	
				
				Statement sta = (Statement) conn.createStatement();
				ResultSet  rs = sta.executeQuery(query2);
				
					while (rs.next()) {
		            al = new ArrayList();
	
		            al.add(rs.getString(1));
		            al.add(rs.getString(2));
		            al.add(rs.getString(3));
		            al.add(rs.getString(4));
		            al.add(rs.getString(5));
		            al.add(rs.getString(6));
		            al.add(rs.getString(7));
		            al.add(rs.getString(8));
	
	
		            listView.add(al);
					}
					
				conn.close();
				System.out.println("Disconnected from database");
				}
		}
		return listView;
	}
	public ArrayList DamageDeleted(DamageClass s)throws ClassNotFoundException, SQLException {
		conn = (Connection)dbConnect.conn();
		String type = s.getType();
		ArrayList al = null;
		ArrayList listView = new ArrayList();
		if(type.equals("Damage-item")){
			String query1=null;
			
			query1 = "DELETE  FROM stockdamageitem where Id =?";
			
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query1);
		    pst.setLong(1, s.getId());
		    
		    pst.executeUpdate();
			
			
			System.out.println("Successfuly delete row");
			
			conn.close();
			System.out.println("Disconnected from database");
			
			if(type.equals("Damage-item")){
				conn = (Connection)dbConnect.conn();
				String query2 = "SELECT * FROM stockdamageitem where type = 'Damage-item'";
			
				Statement sta = (Statement) conn.createStatement();
				ResultSet  rs = sta.executeQuery(query2);
				
					while (rs.next()) {
			            al = new ArrayList();
		
			            al.add(rs.getString(1));
			            al.add(rs.getString(2));
			            al.add(rs.getString(3));
			            al.add(rs.getString(4));
			            al.add(rs.getString(5));
			            al.add(rs.getString(6));
			            al.add(rs.getString(7));
			            al.add(rs.getString(8));
	
	
		            listView.add(al);
					}
					
				conn.close();
				System.out.println("Disconnected from database");
			}

		}
		return listView;
		
	}
		
	
	public ArrayList RentDeleted(ReturnItem r)throws ClassNotFoundException, SQLException {
			conn = (Connection)dbConnect.conn();
			
			long  id = r.getId();
			String type = r.getType();
			ArrayList al = null;
			ArrayList listView = new ArrayList();
			if(type.equals("Reparing-item")||type.equals("Return-item") || type.equals("NonReparing-item")){
				
				String query1=null;
				query1 = "DELETE  FROM returnitem where Id =?";
				
				PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query1);
			    pst.setLong(1, r.getId());
			    
			    pst.executeUpdate();
				
				System.out.println("Successfuly delete row");
				
				conn.close();
				System.out.println("Disconnected from database");
				if(type.equals("Return-item")){
					conn = (Connection)dbConnect.conn();
					String query2 = "SELECT * FROM returnitem where type = 'Return-item'";
		
					
					Statement sta = (Statement) conn.createStatement();
					ResultSet  rs = sta.executeQuery(query2);
					
						while (rs.next()) {
			            al = new ArrayList();
		
			            al.add(rs.getString(1));
			            al.add(rs.getString(2));
			            al.add(rs.getString(3));
			            al.add(rs.getString(4));
			            al.add(rs.getString(5));
			            al.add(rs.getString(6));
			            al.add(rs.getString(7));
			            al.add(rs.getString(8));
			            al.add(rs.getString(9));
			            al.add(rs.getString(10));
		
			            listView.add(al);
						}
						
					conn.close();
					System.out.println("Disconnected from database");
					}
				else if(type.equals("Reparing-item")){
					conn = (Connection)dbConnect.conn();
					String query2 = "SELECT * FROM returnitem where type = 'Reparing-item'";
		
					
					Statement sta = (Statement) conn.createStatement();
					ResultSet  rs = sta.executeQuery(query2);
					
						while (rs.next()) {
			            al = new ArrayList();
		
			            al.add(rs.getString(1));
			            al.add(rs.getString(2));
			            al.add(rs.getString(3));
			            al.add(rs.getString(4));
			            al.add(rs.getString(5));
			            al.add(rs.getString(6));
			            al.add(rs.getString(7));
			            al.add(rs.getString(8));
			            al.add(rs.getString(9));
			            al.add(rs.getString(10));
		
			            listView.add(al);
						}
						
					conn.close();
					System.out.println("Disconnected from database");
					}
				else if(type.equals("NonReparing-item")){
					conn = (Connection)dbConnect.conn();
					String query2 = "SELECT * FROM returnitem where type = 'NonReparing-item'";
		
					
					Statement sta = (Statement) conn.createStatement();
					ResultSet  rs = sta.executeQuery(query2);
					
						while (rs.next()) {
			            al = new ArrayList();
		
			            al.add(rs.getString(1));
			            al.add(rs.getString(2));
			            al.add(rs.getString(3));
			            al.add(rs.getString(4));
			            al.add(rs.getString(5));
			            al.add(rs.getString(6));
			            al.add(rs.getString(7));
			            al.add(rs.getString(8));
			            al.add(rs.getString(9));
			            al.add(rs.getString(10));
		
			            listView.add(al);
						}
						
					conn.close();
					System.out.println("Disconnected from database");
					}
			}
			return listView;
		}
		public ArrayList NonItemDeleted(StockItem s)throws ClassNotFoundException, SQLException {
			conn = (Connection)dbConnect.conn();
			String type = s.getType();
			int amount = s.getAmount();
			ArrayList al = null;
			ArrayList listView = new ArrayList();
			
			String query1=null;
			query1 = "DELETE  FROM stockitem where Id =?";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(query1);
			pst.setLong(1, s.getId());   
		    pst.executeUpdate();
			System.out.println("Successfuly delete row");
		    conn.close();
		 
				conn = (Connection)dbConnect.conn();
				String query2 = "SELECT * FROM stockitem where type='Stock-item' and amount<=12";
				Statement sta = (Statement) conn.createStatement();
				ResultSet  rs = sta.executeQuery(query2);
				
					while (rs.next()) {
		            al = new ArrayList();
	
		            al.add(rs.getString(1));
		            al.add(rs.getString(2));
		            al.add(rs.getString(3));
		            al.add(rs.getString(4));
		            al.add(rs.getString(5));
		            al.add(rs.getString(6));
		            al.add(rs.getString(7));
		            al.add(rs.getString(8));
	
	
		            listView.add(al);
					}
					
				conn.close();
				System.out.println("Disconnected from database");
			
			return listView;
		}
}
