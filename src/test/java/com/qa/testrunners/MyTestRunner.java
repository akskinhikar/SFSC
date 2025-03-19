package com.qa.testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/com/qa/features/LeadCreationFlow.feature"},
		glue = {"com.qa.stepdefenation","com.qa.AppHooks"},
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		}
		)

public class MyTestRunner extends AbstractTestNGCucumberTests {

}



