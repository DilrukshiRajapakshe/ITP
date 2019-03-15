/** IT17089296
 * Hapuarachchi H.D.H.U */
package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import com.model.add;
import com.model.monthlyProfitReport;
import com.mysql.jdbc.Statement;
import com.util.dbConnect;

public class newDateService {

Connection conn = null;
	
	public ArrayList addDateService(monthlyProfitReport mpr) throws SQLException{
		
		
		conn = (Connection) dbConnect.conn();
		
			//String q1 = "Insert into monthly_cost(cost_type,amount) values(?,?)";
			//PreparedStatement ps = (PreparedStatement) conn.prepareStatement(q1, 0);
			 
			//ps.setString(1,Add.getcost_type());
			//ps.setDouble(2,Add.getamount());
			
			//ps.executeUpdate();
			//System.out.println("Succefully added to the table!!");
		ArrayList array = null;
		ArrayList arr = null;
		//ArrayList arr1 = null;
		
		ArrayList list = new ArrayList();
		
		
		String d1 = mpr.getStartDate();
		String d2 = mpr.getEndDate();
			System.out.println("ssss");
			System.out.println(d1);
			System.out.println("ssss");
			System.out.println(d2);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
			LocalDate date1 = LocalDate.parse(d1, formatter);
			LocalDate date2 = LocalDate.parse(d2, formatter);
			int year1 = date1.getYear(); 
			int day1 = date1.getDayOfMonth();
			Month month1 = date1.getMonth(); 
			int monthAsInt1 = month1.getValue();
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			System.out.print(year1); System.out.print(monthAsInt1); System.out.print(day1);
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			int year2 = date2.getYear(); 
			int day2 = date2.getDayOfMonth();
			Month month2 = date2.getMonth(); 
			int monthAsInt2 = month2.getValue();
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			System.out.print(year2); System.out.print(monthAsInt2); System.out.print(day2);
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
			
			String q3 = "select CAST(Date as DATE),sum(profit) From incometab where (EXTRACT(YEAR FROM Date) BETWEEN "+year1+" and "+year2+") AND (EXTRACT(MONTH FROM Date) BETWEEN "+monthAsInt1+" and "+monthAsInt2+") AND (EXTRACT(DAY FROM Date) BETWEEN "+day1+" and "+day2+") GROUP BY CAST(Date as DATE) UNION ALL select 'Total Income :',sum(profit) from incometab where (EXTRACT(YEAR FROM Date) BETWEEN "+year1+" and "+year2+") AND (EXTRACT(MONTH FROM Date) BETWEEN "+monthAsInt1+" and "+monthAsInt2+") AND (EXTRACT(DAY FROM Date) BETWEEN "+day1+" and "+day2+") union all select 'Additonal Cost :',sum(amount) from monthly_cost where (EXTRACT(YEAR FROM noteDate) BETWEEN "+year1+" and "+year2+") AND (EXTRACT(MONTH FROM noteDate) BETWEEN "+monthAsInt1+" and "+monthAsInt2+") AND (EXTRACT(DAY FROM noteDate) BETWEEN "+day1+" and "+day2+") union all select 'Employee Salary : ',sum(monthsalary) from employeesalary GROUP BY(year BETWEEN "+year1+" and "+year2+") AND (month BETWEEN "+monthAsInt1+" and "+monthAsInt2+") union all select 'Damage Cost : ',sum(cost) from stockdamageitem where (EXTRACT(YEAR FROM dDate) BETWEEN "+year1+" and "+year2+") AND (EXTRACT(MONTH FROM dDate) BETWEEN "+monthAsInt1+" and "+monthAsInt2+") AND (EXTRACT(DAY FROM dDate) BETWEEN "+day1+" and "+day2+")";
			System.out.println("susi");
			String tot="select 'Total Profit :',(select sum(profit) from incometab where (EXTRACT(YEAR FROM Date) BETWEEN "+year1+" and "+year2+") AND (EXTRACT(MONTH FROM Date) BETWEEN "+monthAsInt1+" and "+monthAsInt2+") AND (EXTRACT(DAY FROM Date) BETWEEN "+day1+" and "+day2+"))-((select sum(amount) from monthly_cost where (EXTRACT(YEAR FROM noteDate) BETWEEN "+year1+" and "+year2+") AND (EXTRACT(MONTH FROM noteDate) BETWEEN "+monthAsInt1+" and "+monthAsInt2+") AND (EXTRACT(DAY FROM noteDate) BETWEEN "+day1+" and "+day2+"))+(select sum(monthsalary) from employeesalary GROUP BY(year BETWEEN "+year1+" and "+year2+") AND (month BETWEEN "+monthAsInt1+" and "+monthAsInt2+"))+(select sum(cost) from stockdamageitem where (EXTRACT(YEAR FROM dDate) BETWEEN "+year1+" and "+year2+") AND (EXTRACT(MONTH FROM dDate) BETWEEN "+monthAsInt1+" and "+monthAsInt2+") AND (EXTRACT(DAY FROM dDate) BETWEEN "+day1+" and "+day2+")))";
			
			
			//String qa = "select 'Total Profit : ',sum(profit) from incometab where (EXTRACT(YEAR FROM Date) BETWEEN "+year1+" and "+year2+") AND (EXTRACT(MONTH FROM Date) BETWEEN "+monthAsInt1+" and "+monthAsInt2+") AND (EXTRACT(DAY FROM Date) BETWEEN "+day1+" and "+day2+")-sum(amount) from monthly_cost where (EXTRACT(YEAR FROM noteDate) BETWEEN "+year1+" and "+year2+") AND (EXTRACT(MONTH FROM noteDate) BETWEEN "+monthAsInt1+" and "+monthAsInt2+") AND (EXTRACT(DAY FROM noteDate) BETWEEN "+day1+" and "+day2+")+sum(salary) from emp_tab where (EXTRACT(YEAR FROM Date) BETWEEN "+year1+" and "+year2+") AND (EXTRACT(MONTH FROM Date) BETWEEN "+monthAsInt1+" and "+monthAsInt2+") AND (EXTRACT(DAY FROM Date) BETWEEN "+day1+" and "+day2+")+sum(cost) from stockdamageitem where (EXTRACT(YEAR FROM dDate) BETWEEN "+year1+" and "+year2+") AND (EXTRACT(MONTH FROM dDate) BETWEEN "+monthAsInt1+" and "+monthAsInt2+") AND (EXTRACT(DAY FROM dDate) BETWEEN "+day1+" and "+day2+")";
			
			//String qa1 = "select 'Total Profit : ',sum(incometab.profit)-(sum(monthly_cost.amount)+sum(emp_tab.salary)+sum(stockdamageitem.cost)) from incometab,monthly_cost,emp_tab,stockdamageitem where ((EXTRACT(YEAR FROM incometab.Date) BETWEEN "+year1+" and "+year2+") AND (EXTRACT(MONTH FROM incometab.Date) BETWEEN "+monthAsInt1+" and "+monthAsInt2+") AND (EXTRACT(DAY FROM incometab.Date) BETWEEN "+day1+" and "+day2+")) AND ((EXTRACT(YEAR FROM monthly_cost.noteDate) BETWEEN "+year1+" and "+year2+") AND (EXTRACT(MONTH FROM monthly_cost.noteDate) BETWEEN "+monthAsInt1+" and "+monthAsInt2+") AND (EXTRACT(DAY FROM monthly_cost.noteDate) BETWEEN "+day1+" and "+day2+")) AND ((EXTRACT(YEAR FROM stockdamageitem.dDate) BETWEEN "+year1+" and "+year2+") AND (EXTRACT(MONTH FROM stockdamageitem.dDate) BETWEEN "+monthAsInt1+" and "+monthAsInt2+") AND (EXTRACT(DAY FROM stockdamageitem.dDate) BETWEEN "+day1+" and "+day2+")) AND ((EXTRACT(YEAR FROM emp_tab.Date) BETWEEN "+year1+" and "+year2+") AND (EXTRACT(MONTH FROM emp_tab.Date) BETWEEN "+monthAsInt1+" and "+monthAsInt2+") AND (EXTRACT(DAY FROM emp_tab.Date) BETWEEN "+day1+" and "+day2+"))";
			
			
			System.out.println(q3);
			Statement s = (Statement) conn.createStatement();
			Statement st = (Statement) conn.createStatement();
			// st1 = (Statement) conn.createStatement();
			ResultSet rt = s.executeQuery(q3);
			ResultSet r = st.executeQuery(tot);
			//ResultSet rt1 = st1.executeQuery(qa1);
			while(rt.next()){
				array = new ArrayList();
				
				array.add(rt.getString(1));
				array.add(rt.getString(2));
				//array.add(rt.getString(3));
				//array.add(rt.getString(4));
				//array.add(rt.getString(5));
				
				list.add(array);
				
			}
			while(r.next()){
				arr = new ArrayList();
				
				arr.add(r.getString(1));
				arr.add(r.getString(2));
				
				list.add(arr);
				
			}
			/*while(rt1.next()){
				arr1 = new ArrayList();
				
				array.add(rt1.getString(1));
				array.add(rt1.getString(2));
				//array.add(rt.getString(3));
				//array.add(rt.getString(4));
				//array.add(rt.getString(5));
				
				list.add(arr1);
				
			}*/
			conn.close();
			System.out.println("Disconnected from database");
			return list;
	}
}
