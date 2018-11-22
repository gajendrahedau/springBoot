package com.cg.banking.pagebeans;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WithdrawPage {

	@FindBy(how=How.ID,id="amount")
	private WebElement amount;
	
	@FindBy(how=How.ID,id="pinNumber")
	private WebElement pinNumber;
	
	@FindBy(how=How.ID,id="submit")
	private WebElement submit;
	
/*	@FindBy(how=How.ID,id="back")
	private WebElement button;*/

	public WithdrawPage() {
		super();
	}

	public String getAmount() {
		return amount.getAttribute("value");
	}

	public void setAmount(String amount) {
		this.amount.sendKeys(amount);
	}

	public String getPinNumber() {
		return pinNumber.getAttribute("value");
	}

	public void setPinNumber(String pinNumber) {
		this.pinNumber.sendKeys(pinNumber);
	}
	
	public void submitSignIn() {
		submit.submit();
	}
	public void clickSignIn() {
	submit.click();
	}
	
	
	
	
	
}
