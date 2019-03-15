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
	public class employee implements Serializable {
		private static final long serialVersionUID = 1L;

		@Email @NotEmpty
		private String email;
		
		@NotEmpty
		private String address;
		
		@NotEmpty
		private String nic;

		//@DateTimeFormat(pattern="yyyy-MM-dd")
	    @NotNull
		private String date;
		
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
		
		@NotEmpty
		private String occupation;
		
		@NotEmpty
		private String gender;
		
		@NotEmpty
		private String nationality;
		
		@NotEmpty
		private int salary;
		
		@NotEmpty
		private String radte;
		
		@NotEmpty
		private String rreason;
		
		private String Year;
		private String Month;
		private int Allowans;
		private int Bonus;
		private int Loan;
		private int FMSalary;
		
		
		
		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getYear() {
			return Year;
		}

		public void setYear(String year) {
			Year = year;
		}

		public String getMonth() {
			return Month;
		}

		public void setMonth(String month) {
			Month = month;
		}

		public int getAllowans() {
			return Allowans;
		}

		public void setAllowans(int allowans) {
			Allowans = allowans;
		}

		public int getBonus() {
			return Bonus;
		}

		public void setBonus(int bonus) {
			Bonus = bonus;
		}

		public int getLoan() {
			return Loan;
		}

		public void setLoan(int loan) {
			Loan = loan;
		}

		public int getFMSalary() {
			return FMSalary;
		}

		public void setFMSalary(int fMSalary) {
			FMSalary = fMSalary;
		}

		public String getRadte() {
			return radte;
		}

		public void setRadte(String radte) {
			this.radte = radte;
		}

		public String getRreason() {
			return rreason;
		}

		public void setRreason(String rreason) {
			this.rreason = rreason;
		}

		@NotEmpty
		private String bdate;

		public String getBdate() {
			return bdate;
		}

		public void setBdate(String bdate) {
			this.bdate = bdate;
		}

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getNic() {
			return nic;
		}

		public void setNic(String nic) {
			this.nic = nic;
		}

		public String getJoindate() {
			return date;
		}

		public void setJoindate(String date) {
			this.date = date;
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

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getContact() {
			return contact;
		}

		public void setContact(int contact) {
			this.contact = contact;
		}

		public String getOccupation() {
			return occupation;
		}

		public void setOccupation(String occupation) {
			this.occupation = occupation;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getNationality() {
			return nationality;
		}

		public void setNationality(String nationality) {
			this.nationality = nationality;
		}

	


}
