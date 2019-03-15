/** IT16234062– Rajapakshe D.D.S */
package com.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class DamageClass {
	 	private  long Id;
		private String name;
		private String supplierID;
		private String description;
		private double purchaseprice;
		private int amount;
		private String type;
		private double cost;
		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "today",nullable = false)
		private Date today;
		public Date getToday() {
			return today;
		}
		public void setToday(Date today) {
			this.today = today;
		}
		public double getCost() {
			return cost;
		}
		public void setCost(double cost) {
			this.cost = cost;
		}
		public long getId() {
			return Id;
		}
		public void setId(long id) {
			Id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSupplierID() {
			return supplierID;
		}
		public void setSupplierID(String supplierID) {
			this.supplierID = supplierID;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public double getPurchaseprice() {
			return purchaseprice;
		}
		public void setPurchaseprice(double purchaseprice) {
			this.purchaseprice = purchaseprice;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
	
		
}
