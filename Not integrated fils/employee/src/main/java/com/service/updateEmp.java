package com.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.employee;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.util.dbConnect;

public class updateEmp {

Connection conn = null;
	
	public void updateEmployeeService(employee employee)
	{
		//Connect database
		conn = (Connection) dbConnect.conn();
		
		try {
		    String query1 = "update employee set id=?, name=?,nic=?,occupation=?,salary=?,bdate=?,gender=?,contact=?,email=?,address=?,nationality=?,jdate=? where id=?";
		    PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query1);
		    
		    
		    
		    ps.setInt(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getNic());
			ps.setString(4, employee.getOccupation());
			ps.setInt(5, employee.getSalary());
			ps.setString(6, employee.getBdate());
			ps.setString(7, employee.getGender());
			ps.setInt(8, employee.getContact());
			ps.setString(9, employee.getEmail());
			ps.setString(10, employee.getAddress());
			ps.setString(11, employee.getNationality());
			ps.setString(12, employee.getJoindate());
			ps.setInt(13, employee.getId());
			 
			ps.executeUpdate();
			ResultSet rs = ps.executeQuery();
			System.out.println("Successfuly updare Employee");
			conn.close();
			System.out.println("Disconnected from database");

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
