package com.cg.banking.pagebeans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignUpPage {

	@FindBy(how=How.ID,id="accountType")
	private WebElement accountType;
	
	@FindBy(how=How.ID,id="pinNumber")
	private WebElement pinNumber;
	
	@FindBy(how=How.ID,id="accountBalance")
	private WebElement accountBalance;
	
	@FindBy(how=How.ID,id="submit")
	private WebElement button;

	public SignUpPage() {
		super();
	}

	public String getAccountType() {
		return accountType.getAttribute("value");
		
	}

	public void setAccountType(String accountType) {
		this.accountType.sendKeys(accountType);
	}

	public String getPinNumber() {
		return pinNumber.getAttribute("value");
	}

	public void setPinNumber(String pinNumber) {
		this.pinNumber.sendKeys(pinNumber);
	}

	public String getAccountBalance() {
		return accountBalance.getAttribute("value");
	}

	public void setAccountBalance(String accountBalance) {
		this.accountBalance.sendKeys(accountBalance);
	}
	
	public void submitSignIn() {
		button.submit();
	}
	public void clickSignIn() {
		button.click();
	}
	
	
}
