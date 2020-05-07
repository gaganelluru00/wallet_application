package com.wallet.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TransactionDetails")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="User_Id")
	private long userId;
	@Column(name="Transaction_Id")
	private String transId;
	@Column(name="Transaction_Time")
	private String transTime;
	@Column(name="Transaction_Type")
	private String tType;
	
	private String recId;
	@Column(name="Sender_AccNumber")
	private String sendId;
	@Column(name="Transaction_Amount")
	private double transAmount;
	@Column(name="Updated_Balance")
	private double updatedBalance;
	
	
	//@ManyToOne(optional=false)
	//@JoinColumn(name="userId", insertable=false, updatable=false)
    //private User user;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getTransId() {
		return transId;
	}
	public void setTransId(String transId) {
		this.transId = transId;
	}
	public String getTransTime() {
		return transTime;
	}
	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}
	public String gettType() {
		return tType;
	}
	public void settType(String tType) {
		this.tType = tType;
	}
	public String getRecId() {
		return recId;
	}
	public void setRecId(String recId) {
		this.recId = recId;
	}
	public String getSendId() {
		return sendId;
	}
	public void setSendId(String sendId) {
		this.sendId = sendId;
	}
	public double getTransAmount() {
		return transAmount;
	}
	public void setTransAmount(double transAmount) {
		this.transAmount = transAmount;
	}
	public double getUpdatedBalance() {
		return updatedBalance;
	}
	public void setUpdatedBalance(double updatedBalance) {
		this.updatedBalance = updatedBalance;
	}
	public Transaction(long userId, String transId, String transTime, String tType, String recId, String sendId,
			double transAmount, double updatedBalance) {
		super();
		this.userId = userId;
		this.transId = transId;
		this.transTime = transTime;
		this.tType = tType;
		this.recId = recId;
		this.sendId = sendId;
		this.transAmount = transAmount;
		this.updatedBalance = updatedBalance;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Transaction [userId=" + userId + ", transId=" + transId + ", transTime=" + transTime + ", tType="
				+ tType + ", recId=" + recId + ", sendId=" + sendId + ", transAmount=" + transAmount
				+ ", updatedBalance=" + updatedBalance + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((recId == null) ? 0 : recId.hashCode());
		result = prime * result + ((sendId == null) ? 0 : sendId.hashCode());
		result = prime * result + ((tType == null) ? 0 : tType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(transAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((transId == null) ? 0 : transId.hashCode());
		result = prime * result + ((transTime == null) ? 0 : transTime.hashCode());
		temp = Double.doubleToLongBits(updatedBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (userId ^ (userId >>> 32));
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
		Transaction other = (Transaction) obj;
		if (recId == null) {
			if (other.recId != null)
				return false;
		} else if (!recId.equals(other.recId))
			return false;
		if (sendId == null) {
			if (other.sendId != null)
				return false;
		} else if (!sendId.equals(other.sendId))
			return false;
		if (tType == null) {
			if (other.tType != null)
				return false;
		} else if (!tType.equals(other.tType))
			return false;
		if (Double.doubleToLongBits(transAmount) != Double.doubleToLongBits(other.transAmount))
			return false;
		if (transId == null) {
			if (other.transId != null)
				return false;
		} else if (!transId.equals(other.transId))
			return false;
		if (transTime == null) {
			if (other.transTime != null)
				return false;
		} else if (!transTime.equals(other.transTime))
			return false;
		if (Double.doubleToLongBits(updatedBalance) != Double.doubleToLongBits(other.updatedBalance))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	

}
