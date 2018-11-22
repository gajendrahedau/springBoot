package com.cg.banking.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.banking.pagebeans.LoginPage;
import com.cg.banking.pagebeans.SignUpPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LogInStepDefinition {
	
	private WebDriver driver;
	private LoginPage loginPage;

	@Given("^User is on Banking Login Page$")
	public void user_is_on_Banking_Login_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:4432/login");
		loginPage=PageFactory.initElements(driver,LoginPage.class);
	}

	@When("^User submit valid details$")
	public void user_submit_valid_details() throws Throwable {
		loginPage.setAccountNo("1");
		loginPage.setPinNumber ("1234");
		loginPage.submitSignIn();
	}

	@Then("^User is able to login$")
	public void user_is_able_to_login() throws Throwable {
		String actualTitle=driver.getTitle();
	    String expectedTitle="Login Success";
	    Assert.assertEquals(expectedTitle, actualTitle);
	    driver.close();
	}
	
	@When("^User submit invalid details$")
	public void user_submit_invalid_details() throws Throwable {
		loginPage.setAccountNo("167");
		loginPage.setPinNumber ("1234789");
		loginPage.clickSignIn();
	}

	@Then("^Display error to user$")
	public void display_error_to_user() throws Throwable {
		String actualTitle=driver.getTitle();
	    String expectedTitle="LoginPage";
	    Assert.assertEquals(expectedTitle, actualTitle);
	    driver.close();
	}



	
}
