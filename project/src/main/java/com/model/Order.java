/** IT17123778– Wickramanayaka D.T.A */
package com.model;

import java.io.Serializable;

import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	public String orderNo;
	public String Name;
	public String address;
	public int TellNo;
	public String item;
	public int amount;
	public int charges;
	public int Famount;
	public String status;
	public int quantity;
	public int bilno;
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String OrderNo) {
		this.orderNo = OrderNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTellNo() {
		return TellNo;
	}
	public void setTellNo(int tellNo) {
		TellNo = tellNo;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getCharges() {
		return charges;
	}
	public void setCharges(int charges) {
		this.charges = charges;
	}
	public int getFamount() {
		return Famount;
	}
	public void setFamount(int famount) {
		Famount = famount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getBilno() {
		return bilno;
	}
	public void setBilno(int bilno) {
		this.bilno = bilno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
