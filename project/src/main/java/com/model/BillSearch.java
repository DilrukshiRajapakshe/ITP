/** IT17159036– Attanayake A.M.O.M */
package com.model;

public class BillSearch {

	private String search;
	private String bid;
	private String icode;
	private String price;
	private String qty;
	private String netp;
	
	public String getSch() {
		return search;
		
	}
	
	public void setSch(String search) {
		
		this.search = search;
	}
	
	public void setbid(String bid) {
		
		this.bid = bid;
	}
	
	public void seticode(String icode) {
		
		this.icode = icode;
	}

	public void setprice(String price) {
		
		this.price = price;
	}

	public void setqty(String qty) {
		
		this.qty = qty;
	}

	public void setnetp(String netp) {
		
		this.netp = netp;
	}
	
	public String getbid() {
	
		return bid ;
		
	}
	
	public String geticode() {
		
		return icode ;
		
	}
	
	public String getprice() {
		
		return price;
		
	}
	
	public String getqty() {
		
		return qty;
		
	}
	
	public String getnetp() {
		
		return netp;
		
	}

}

