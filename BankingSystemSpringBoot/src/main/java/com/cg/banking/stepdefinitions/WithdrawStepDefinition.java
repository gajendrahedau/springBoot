package com.cg.banking.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.banking.pagebeans.WithdrawPage;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WithdrawStepDefinition {
	
	private WebDriver driver;
	private WithdrawPage withdrawPage;
	
	@Given("^User is in 'withdraw amount' page$")
	public void user_is_in_withdraw_amount_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:4432/withdrawAmountPage");
		withdrawPage=PageFactory.initElements(driver,WithdrawPage.class);
	}

	@When("^User enters correct details$")
	public void user_enters_correct_details() throws Throwable {
		withdrawPage.setAmount("100");
		withdrawPage.setPinNumber("1234");
		withdrawPage.clickSignIn();
	}

	@Then("^'updated balance' is displayed on the page$")
	public void updated_balance_is_displayed_on_the_page() throws Throwable {
		String actualTitle=driver.getTitle();
	    String expectedTitle="Withdraw Amount";
	    Assert.assertEquals(expectedTitle, actualTitle);
	    driver.close();
	}

	@When("^User enters incorrect details$")
	public void user_enters_incorrect_details() throws Throwable {
		withdrawPage.setAmount("100");
		withdrawPage.setPinNumber("123");
		withdrawPage.submitSignIn();
	}

	@Then("^user asked again to enter the details$")
	public void user_asked_again_to_enter_the_details() throws Throwable {
		String actualTitle=driver.getTitle();
	    String expectedTitle="Withdraw Amount";
	    Assert.assertEquals(expectedTitle, actualTitle);
	    driver.close();  
	}



}
