/** IT17122092
 * Sandarenu M.D.K */
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
