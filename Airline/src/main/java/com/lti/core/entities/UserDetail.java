package com.lti.core.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="USER_DETAILS")
@SequenceGenerator(name = "seq", sequenceName = "USER_DETAILS_SEQUENCE", allocationSize = 1, initialValue = 100)
public class UserDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private int userId;
	private String title;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	private long mobileNo;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "userDetails", cascade = CascadeType.ALL)
	private List<PassengerDetail> passengerDetails;
	
	@JsonIgnore
	@OneToMany(mappedBy="userdetails",cascade=CascadeType.ALL)
	private List<BankDetail> bankDetails;
	
	public UserDetail() {
		super();
	}
	public UserDetail(int userId, String title, String firstName, String lastName, String email, String password,
			String confirmPassword, int mobileNo) {
		super();
		this.userId = userId;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		
		this.mobileNo = mobileNo;
	}
	public List<PassengerDetail> getPassengerDetails() {
		return passengerDetails;
	}
	public void setPassengerDetails(List<PassengerDetail> passengerDetails) {
		this.passengerDetails = passengerDetails;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", title=" + title + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", password=" + password + " "
				+ ", mobileNo=" + mobileNo + "]";
	}
	
	
	
	
	
	

}
