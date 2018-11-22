package com.cg.banking.beans;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long accountNo;
	private int pinNumber;
	private String accountType;
	private String status;
	
	private float accountBalance;
	
	@OneToMany(mappedBy="account")
	private List<Transaction>transactions;
	public Account() {
		super();
	}
	
	
	
	
	public Account(long accountNo, int pinNumber) {
		super();
		this.accountNo = accountNo;
		this.pinNumber = pinNumber;
	}




	public Account(String accountType, float accountBalance,int pinNumber) {
		super();
		this.pinNumber = pinNumber;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}



	public Account(String accountType, float accountBalance) {
		super();
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}

	

	
	public Account(long accountNo, int pinNumber, String accountType, String status, float accountBalance,
			List<Transaction> transactions) {
		super();
		this.accountNo = accountNo;
		this.pinNumber = pinNumber;
		this.accountType = accountType;
		this.status = status;
		this.accountBalance = accountBalance;
		this.transactions = transactions;
	}

	public Account(int pinNumber, String accountType, String status,
			float accountBalance, long accountNo) {
		super();
		this.pinNumber = pinNumber;
		this.accountType = accountType;
		this.status = status;
		this.accountBalance = accountBalance;
		this.accountNo = accountNo;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public int getPinNumber() {
		return pinNumber;
	}
	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", pinNumber=" + pinNumber + ", accountType=" + accountType
				+ ", status=" + status + ", accountBalance=" + accountBalance + "]";
	}

	
	

}
