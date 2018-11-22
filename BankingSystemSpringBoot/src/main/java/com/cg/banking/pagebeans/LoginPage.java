package com.cg.banking.pagebeans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	@FindBy(how=How.ID,id="accountNo")
	private WebElement accountNo;
	
	@FindBy(how=How.ID,id="pinNumber")
	private WebElement pinNumber;
	
	@FindBy(how=How.ID,id="submit")
	private WebElement button;

	public LoginPage() {
		super();
	}

	public String getAccountNo() {
		return accountNo.getAttribute("value");
	}

	public void setAccountNo(String accountNo) {
		this.accountNo.sendKeys(accountNo);
	}

	public String getPinNumber() {
		return pinNumber.getAttribute("value");
	}

	public void setPinNumber(String pinNumber) {
		this.pinNumber.sendKeys(pinNumber);
	}
	
	public void submitSignIn() {
		button.submit();
	}
	public void clickSignIn() {
		button.click();
	}
}
