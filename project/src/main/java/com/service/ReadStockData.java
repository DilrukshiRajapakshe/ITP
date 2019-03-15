package com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.model.DamageClass;
import com.model.ReturnItem;
import com.model.StockItem;
import com.util.dbConnect;

public class ReadStockData {
	Connection conn = null;
	public ArrayList StockRead(StockItem s)throws ClassNotFoundException, SQLException {
		conn = (Connection)dbConnect.conn();
		String query1=null;
		long  id = s.getId();
		String type = s.getType();
		
		query1 = "SELECT * FROM stockitem where Id ="+id+"";
		
		ArrayList al = null;
		ArrayList listView = new ArrayList();
		
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
			
		conn.close();
		System.out.println("Disconnected from database");
		
		return listView;
		
	}
	public ArrayList DamageRead(DamageClass s)throws ClassNotFoundException, SQLException {
		conn = (Connection)dbConnect.conn();
		String query1=null;
		long  id = s.getId();
		String type = s.getType();
		
		query1 = "SELECT * FROM stockdamageitem where Id ="+id+"";
		
		ArrayList al = null;
		ArrayList listView = new ArrayList();
		
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
			
		conn.close();
		System.out.println("Disconnected from database");
		
		return listView;
		
	}
	public ArrayList RetutnRead(ReturnItem r)throws ClassNotFoundException, SQLException {
		conn = (Connection)dbConnect.conn();
		String query1=null;
		long  id = r.getId();
		String type = r.getType();
		System.out.println("rrrrrr");
		System.out.println(type);
		query1 = "SELECT * FROM returnitem where Id ="+id+" and type like '%"+type+"%'";
		
		ArrayList al = null;
		ArrayList listView = new ArrayList();
		
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
			
		conn.close();
		System.out.println("Disconnected from database");
		
		return listView;
		
	}
}
