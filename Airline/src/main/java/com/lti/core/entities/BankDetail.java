package com.lti.core.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BANK_DETAILS")
@SequenceGenerator(name = "seqDetails", sequenceName = "BANK_DETAILS_SEQUENCE", allocationSize = 1, initialValue = 500)
public class BankDetail {

		
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqDetails")
		private int bankId;
		private String bankName;
		private String ifsc;
		private double bankBalance;
		private long accNo;
		
		@ManyToOne
		@JoinColumn(name="userId")
		private UserDetail userdetails;

		public int getBankId() {
			return bankId;
		}

		public void setBankId(int bankId) {
			this.bankId = bankId;
		}

		public String getBankName() {
			return bankName;
		}

		public void setBankName(String bankName) {
			this.bankName = bankName;
		}

		public String getIfsc() {
			return ifsc;
		}

		public void setIfsc(String ifsc) {
			this.ifsc = ifsc;
		}

		public double getBankBalance() {
			return bankBalance;
		}

		public void setBankBalance(double bankBalance) {
			this.bankBalance = bankBalance;
		}

		public long getAccNo() {
			return accNo;
		}

		public void setAccNo(long accNo) {
			this.accNo = accNo;
		}

		public UserDetail getUserdetails() {
			return userdetails;
		}

		public void setUserdetails(UserDetail userdetails) {
			this.userdetails = userdetails;
		}

		public BankDetail(int bankId, String bankName, String ifsc, double bankBalance, long accNo,
				UserDetail userdetails) {
			super();
			this.bankId = bankId;
			this.bankName = bankName;
			this.ifsc = ifsc;
			this.bankBalance = bankBalance;
			this.accNo = accNo;
			this.userdetails = userdetails;
		}

		public BankDetail() {
			super();
		}
		
		
}
