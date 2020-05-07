package com.wallet.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name="AccountDetails")
public class User {
	
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private long userId;
	


	@Column(name="Email_Id")
	private String email;
	@Column(name="Mobile_Number")
	private String mobile;
	@Min(value=0)
	@Column(name="Account_Balance")
	private double accountBalance;
	


	@Column(name="Account_Generation_Time")
	private String time;
	@Column(name="Account_Type")
	private String accountType;
	@Column(name="accountNumber")
	private String accountNumber;
	@Column(name="Username")
	private String username;
	@Column(name="Password")
	private String password;
	
	@OneToMany(targetEntity=Transaction.class, fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	private List<Transaction> transactions=new ArrayList<Transaction>();
	
	


	public static long accNum=1;
	
	
	
	
	
	

	public User(long userId, String email, String mobile, @Min(0) double accountBalance, String time,
			String accountType, String accountNumber, String username, String password) {
		super();
		this.userId = userId;
		this.email = email;
		this.mobile = mobile;
		this.accountBalance = accountBalance;
		this.time = time;
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.username = username;
		this.password = password;
		
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public double getAccountBalance() {
		return accountBalance;
	}


	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}


	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	



	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
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


	


	


	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", mobile=" + mobile + ", accountBalance=" + accountBalance
				+ ", time=" + time + ", accountType=" + accountType + ", accountNumber=" + accountNumber + ", username="
				+ username + ", password=" + password + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(accountBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (userId ^ (userId >>> 32));
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (Double.doubleToLongBits(accountBalance) != Double.doubleToLongBits(other.accountBalance))
			return false;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (userId != other.userId)
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	

}
