package com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.model.employee;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class CalculateEmpSalary {
	
	Connection conn = null;
	public void insertSalary(employee e)throws ClassNotFoundException, SQLException {
		//Connect database
				conn = (Connection) dbConnect.conn();
		String query1=null;
		int  id = e.getId();
		String month =  e.getMonth();
		String year = e.getYear();	
		
		query1 = "SELECT COUNT(*) AS rowcount FROM attendance WHERE (eid = "+id+" AND year = "+year+" AND month = "+month+")";
	
		
		Statement sta = (Statement) conn.createStatement();
		ResultSet  rs = sta.executeQuery(query1);
		
		rs.next();
		int count = rs.getInt("rowcount");
		rs.close();
		
		String query2=null;
		
		query2 = "insert into employeesalary(id,name,occupation,salary,year,month,allowance,bonus,loan,workingDays,monthsalary) values(?,?,?,?,?,?,?,?,?,?,?)";
	    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query2);
	    
	    int s = e.getId();
	    int salary = e.getSalary();
	    int allowans = e.getAllowans();
	    int bonus = e.getBonus();
	    int loan = e.getLoan();
	    
	    int MSalary = salary * count + allowans + bonus - loan ;
	    
	    ps.setInt(1, e.getId());
	    ps.setString(2, e.getName());
	    ps.setString(3, e.getOccupation());
	    ps.setInt(4, e.getSalary());
	    ps.setString(5, e.getYear());
	    ps.setString(6, e.getMonth());
	    ps.setInt(7, e.getAllowans());
	    ps.setInt(8, e.getBonus());
	    ps.setInt(9, e.getLoan());
	    ps.setInt(10, count);
	    ps.setInt(11, MSalary);
		
		
		ps.executeUpdate();
//		ResultSet rs = ps.executeQuery();
		System.out.println("Successfuly added employee monthly salary");
		
			
		conn.close();
		System.out.println("Disconnected from database");
		
		
	}


}
