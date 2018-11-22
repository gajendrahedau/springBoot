package com.cg.banking.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.banking.pagebeans.SignUpPage;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignUpStepDefinition {
	private WebDriver driver;
	private SignUpPage signUpPage;

	@Given("^User is on Banking Signup Page$")
	public void user_is_on_Banking_Signup_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:4432/registration");
		signUpPage=PageFactory.initElements(driver,SignUpPage.class);
	}

	@When("^User submits valid details$")
	public void user_submits_valid_details() throws Throwable {
		signUpPage.setAccountType("savings");
		signUpPage.setPinNumber("1234");
		signUpPage.setAccountBalance("5000");
		signUpPage.submitSignIn();
	}

	@Then("^Register the user$")
	public void register_the_user() throws Throwable {
		String actualTitle=driver.getTitle();
	    String expectedTitle="Welcome Page";
	    Assert.assertEquals(expectedTitle, actualTitle);
	    driver.close();
	}

	@Given("^User is on Banking SignUp Page$")
	public void user_is_on_Banking_SignUp_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:4432/registration");
		signUpPage=PageFactory.initElements(driver,SignUpPage.class); 
	}

	@When("^User submits invalid details$")
	public void user_submits_invalid_details() throws Throwable {
		signUpPage.setAccountType("");
		signUpPage.setPinNumber ("1234");
		signUpPage.setAccountBalance("5000");
		signUpPage.clickSignIn();
	}

	@Then("^Ask to fill correct details$")
	public void ask_to_fill_correct_details() throws Throwable {
		String actualTitle=driver.getTitle();
	    String expectedTitle="Welcome Page";
	    Assert.assertEquals(expectedTitle, actualTitle);
	    driver.close();
	}


}
