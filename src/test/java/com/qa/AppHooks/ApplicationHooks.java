package com.qa.AppHooks;

import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	Dimension d;

	/**
	 * Method to get properties file
	 */
	
	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.init_prop();
		System.out.println("Configuration file is successfully read");

	}
	
	/**
	 * Method to launch the browser 
	 */

	@Before(order = 1)
	public void launchBrowser() {
		String browser = prop.getProperty("browser");
		System.out.println("Browser name is " + browser);
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browser);

	}

	
	/**
	 * Method to close the browser
	 */
	
	@After(order = 0)
	public void quitBrowser() {
		//driver.close();
	}

	/**
	 * Method to take screenshot on failure of test cases
	 * @param scenario
	 */
	
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}

}
