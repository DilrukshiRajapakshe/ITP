package com.model;

//import java.util.Date;
import java.lang.String;

public class cashier {

	//private String date;
	private String billID;
	private String Icode;
	private String price;
	private String qty;
	private String disc;
	private String netprice;
	private String TbillID;
	
	public String getIcode() {
		
		return Icode;
	}
	
	public String getPrice() {
		
		return price;
	}
	
	public String getNetPrice() {
		
	//	netprice = price * qty;
		
		return netprice;
	}
	
	public String getQty() {
		
		return qty;
	}
	
	public String getDisc() {
		
		return disc;
	}	
	
	public String getBillID() {
		
		return billID;
	}
	
	/*public String getDate() {
		
		return date;
	}*/
	
	public void setIcode(String Icode) {
		
		this.Icode = Icode;
		
	}
	
	public void setPrice(String price) {
		
		this.price = price;
		
	}
	public void setNetPrice(String netprice) {
		
		this.netprice = netprice;
		
	}
	public void setQty(String qty) {
		
		this.qty = qty;
		
	}
	
	public void setDisc(String disc) {
		
		this.disc = disc;
		
	}
	
	public void setBillID(String billID) {
		
		this.billID = billID;
	}
	
	public void tempBidSetter(String TbillID) {
		
		this.TbillID = TbillID;
		
	}
	
	public String TemgetBillID() {
		
		return TbillID;
	}
	/*
	public void setDate(String date) {
		
		this.date = date;
	}*/
}
