package com.cg.banking.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"features"},
	glue= {"com.cg.banking.stepdefinitions"}
)

public class TestRunner {

}
