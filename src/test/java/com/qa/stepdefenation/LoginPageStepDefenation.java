package com.qa.stepdefenation;

import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;

public class LoginPageStepDefenation {

	@Given("^I have landed on salesforce page$")
	public void i_have_landed_on_salesforce_page() {
		try {
			DriverFactory.getDriver().get("https://deloittesandbox-4b-dev-ed.develop.my.salesforce.com/");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
