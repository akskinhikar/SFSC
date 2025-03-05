package com.qa.stepdefenation;

import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPageStepDefenation {
	public static Logger log = LogManager.getLogger(LoginPageStepDefenation.class);
	@Given("^I have landed on salesforce page$")
	public void i_have_landed_on_salesforce_page() {
		try {
			DriverFactory.getDriver().get("https://deloittesandbox-4b-dev-ed.develop.my.salesforce.com/");
			log.info("Driver Initiated successfully with provided URL");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
