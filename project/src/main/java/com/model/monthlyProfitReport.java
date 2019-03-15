/** IT17089296
 * Hapuarachchi H.D.H.U */
package com.model;


import java.time.LocalDate;
import java.util.Date;

public class monthlyProfitReport {
	
	private String str;
	private String end;
	
	
	public void setStartDate(String str){
		this.str = str;
		System.out.println("harini");
		System.out.println(str);
	}
	public String getStartDate(){
		System.out.println("hapu");
		System.out.println(str);
		System.out.println("hapu");
		return str;
	}
	public String getEndDate(){
		return end;
	}
	public void setEndDate(String end){
		this.end = end;
	}
}
