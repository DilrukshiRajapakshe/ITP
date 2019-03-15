/** IT17089296
 * Hapuarachchi H.D.H.U */
package com.model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class add {
	  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "noteDate",nullable = false)
	//@DateTimeFormat("dd.MM HH:mm")
	

	private Date noteDate;
	
	  private String cost_type;
		
	  private double amount; 
	
	  public Date getNoteDate(){
		  return noteDate;
	  }
	  public void setNoteDate(Date noteDate){
		  this.noteDate = noteDate;
	  }
	public long getId(){
		 return Id;
	 }
	 public void setId(long Id){
		 this.Id=Id;
	 }
	 
	  public String getcost_type() {
	   return cost_type;
	  }
	  public void setcost_type(String cost_type) {
	   this.cost_type = cost_type;
	  }
	  public double getamount() {
	   return amount;
	  }
	  public void setamount(double amount) {
	   this.amount = amount;
	  }
	  
	  
	
	
	
}
