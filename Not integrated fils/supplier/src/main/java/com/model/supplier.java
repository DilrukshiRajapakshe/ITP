package com.model;

	import java.io.Serializable;
	import javax.persistence.*;
	import javax.validation.constraints.NotNull;
	import javax.validation.constraints.Past;
	import javax.validation.constraints.Size;

	import org.hibernate.validator.constraints.Email;
	import org.hibernate.validator.constraints.NotEmpty;
	import org.springframework.format.annotation.DateTimeFormat;

	import java.util.ArrayList;
	import java.util.Date;
	import java.util.List;


	/**
	 * The persistent class for the student database table.
	 * 
	 */
	//@Entity
	//@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
	public class supplier implements Serializable {
		private static final long serialVersionUID = 1L;

		@Email @NotEmpty
		private String email;
		
		@NotEmpty
		private String address;
		
		@NotEmpty
		private String item;

		@DateTimeFormat(pattern="yyyy-MM-dd")
	    @NotNull
		private String joindate;
		
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private String removedate;
		
		private String romovereasone;

		@NotEmpty
		@Size(min=3, max=30)
		private String name;

		@Id
		@NotEmpty
		private int id;

		@Size(min=10, max=10)
		@NotEmpty
		private int contact;
		
		private String orderId;
		private String OrderDate;
		private String warranty;
		private int price;
		private int quantity;
		
		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		private double discount;
		private double fullItemPrice;
		private double itemPrice;

	
		public String getJoindate() {
			return joindate;
		}

		public void setJoindate(String joindate) {
			this.joindate = joindate;
		}

		public String getRemovedate() {
			return removedate;
		}

		public void setRemovedate(String removedate) {
			this.removedate = removedate;
		}

		public String getRomovereasone() {
			return romovereasone;
		}

		public void setRomovereasone(String romovereasone) {
			this.romovereasone = romovereasone;
		}

		public String getOrderId() {
			return orderId;
		}

		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}

		public String getOrderDate() {
			return OrderDate;
		}

		public void setOrderDate(String orderDate) {
			OrderDate = orderDate;
		}

		public String getWarranty() {
			return warranty;
		}

		public void setWarranty(String warranty2) {
			this.warranty = warranty2;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public double getDiscount() {
			return discount;
		}

		public void setDiscount(double discount) {
			this.discount = discount;
		}

		public double getFullItemPrice() {
			return fullItemPrice;
		}

		public void setFullItemPrice(double fullItemPrice) {
			this.fullItemPrice = fullItemPrice;
		}

		public double getItemPrice() {
			return itemPrice;
		}

		public void setItemPrice(double itemPrice) {
			this.itemPrice = itemPrice;
		}

		public String getEmail() {
			return this.email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getRemoveReason() {
			return this.romovereasone;
		}

		public void setRemoveReason(String romovereasone) {
			this.romovereasone = romovereasone;
		}

		public String getJoinDate() {
			return this.joindate;
		}

		public void setJoinDate(String date) {
			this.joindate = date;
		}
		
		public String getRemoveDate() {
			return this.removedate;
		}

		public void setRemoveDate(String removedate) {
			this.removedate = removedate;
		}
		
		public String getAddress() {
			return this.address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
		
		public String getItem() {
			return this.item;
		}

		public void setItem(String item) {
			this.item = item;
		}

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getId() {
			return this.id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getContact() {
			return this.contact;
		}

		public void setContact(int contactt) {
			this.contact = contactt;
		}

}
