package com.cg.banking.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BankingStepDefinition {
	private WebDriver driver;
	
	@Given("^User is on Banking Home Page$")
	public void user_is_on_Banking_Home_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:4432/");
	}

	@When("^User clicks on 'LogIn'$")
	public void user_clicks_on_LogIn() throws Throwable {
		By by=By.id("login");
		WebElement searchTxt=driver.findElement(by);
		searchTxt.click();
	}

	@Then("^Link should display with 'Log In'$")
	public void link_should_display_with_Log_In() throws Throwable {
		String actualTitle=driver.getTitle();
	    String expectedTitle="LoginPage";
	    Assert.assertEquals(expectedTitle, actualTitle);
	    driver.close();
	}

	@When("^User clicks on 'New USer\\? Sign Up'$")
	public void user_clicks_on_New_USer_Sign_Up() throws Throwable {
		By by=By.id("registration");
		WebElement searchTxt=driver.findElement(by);
		searchTxt.click();
	}

	@Then("^Link should display with 'Sign Up'$")
	public void link_should_display_with_Sign_Up() throws Throwable {
		String actualTitle=driver.getTitle();
	    String expectedTitle="Insert title here";
	    Assert.assertEquals(expectedTitle, actualTitle);
	    driver.close();
	}



}
