/** IT16234062– Rajapakshe D.D.S */
package com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.model.SearchClass;
import com.model.ViewClass;
import com.util.dbConnect;

public class SearchService {
	Connection conn = null;
	public ArrayList stockSearchDisplay(SearchClass search)throws ClassNotFoundException, SQLException {
		conn = (Connection)dbConnect.conn();
		ArrayList al = null;
		ArrayList listView = new ArrayList();
		String  name = search.getName();
		String type = search.getType();
		System.out.println("Hi");
		System.out.println(name);
		System.out.println(type);
		String query1=null;
		if(type.equals("Stock-item")){
			query1 = "SELECT * FROM stockitem where name like '%"+name+"%' ";
			
			Statement sta = (Statement) conn.createStatement();
			ResultSet  rs = sta.executeQuery(query1);
			
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
				System.out.println(listView);
		}
		else if(type.equals("Damage-item")){
			query1 = "SELECT * FROM stockdamageitem where name like '%"+name+"%' ";
			
			Statement sta = (Statement) conn.createStatement();
			ResultSet  rs = sta.executeQuery(query1);
			
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
				System.out.println(listView);
		}
		
		else if(type.equals("Return-item")  ){
			query1 = "SELECT * FROM returnitem where type='Return-item' and name like '%"+name+"%' ";
			
			Statement sta = (Statement) conn.createStatement();
			ResultSet  rs = sta.executeQuery(query1);
			
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
				System.out.println(listView);
		}
		else if( type.equals("Reparing-item")){
			query1 = "SELECT * FROM returnitem where type='Reparing-item' and name like '%"+name+"%' ";
			
			Statement sta = (Statement) conn.createStatement();
			ResultSet  rs = sta.executeQuery(query1);
			
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
				System.out.println(listView);
		}
		else if( type.equals("NonReparing-item") ){
			query1 = "SELECT * FROM returnitem where type='NonReparing-item' and name like '%"+name+"%' ";
			
			Statement sta = (Statement) conn.createStatement();
			ResultSet  rs = sta.executeQuery(query1);
			
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
				System.out.println(listView);
		}
		
			
		conn.close();
		System.out.println("Disconnected from database");
		
		return listView;
		
	}
}
