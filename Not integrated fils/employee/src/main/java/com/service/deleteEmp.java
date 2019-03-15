package com.service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.employee;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class deleteEmp{

Connection conn = null;
	
	public void deleteEmployeeService(employee emp)
	{
		//Connect database
		conn = (Connection) dbConnect.conn();
		
		try {
			

			String query1 = "insert into removeemployee(id,name,occupation,salary,email,contact,rdate,rreason) values(?,?,?,?,?,?,?,?)";
		    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query1);
		    
		    int s = emp.getId();
		    System.out.println(emp.getId()+" "+emp.getRreason());
			
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.setString(3, emp.getOccupation());
			ps.setInt(4, emp.getSalary());
			ps.setString(5, emp.getEmail());
			ps.setInt(6, emp.getContact());
			ps.setString(7, emp.getRadte());
			ps.setString(8, emp.getRreason());
			
			ps.executeUpdate();
//			ResultSet rs = ps.executeQuery();
			System.out.println("Successfuly added remove supplier");

		
		    String query2 = "delete from employee where id=?";
		    PreparedStatement ps2 = (PreparedStatement) conn.prepareStatement(query2);
		    
		    
		    ps2.setInt(1, emp.getId());
		
			 
			ps2.executeUpdate();
//			ResultSet rs2 = ps.executeQuery();
			System.out.println("Successfuly delete employee");
			conn.close();
			System.out.println("Disconnected from database");

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
