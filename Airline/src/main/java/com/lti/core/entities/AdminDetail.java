package com.lti.core.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ADMIN_DETAILS")
@SequenceGenerator(name = "seqDetails", sequenceName = "ADMIN_DETAILS_SEQUENCE", allocationSize = 1, initialValue = 500)
public class AdminDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqDetails")
	private int adminId;
	
	private String username;
	private String password;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AdminDetail() {
		super();
	}
	
	
	
}
