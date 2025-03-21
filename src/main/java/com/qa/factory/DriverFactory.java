package com.qa.factory;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	public static Logger log = LogManager.getLogger(DriverFactory.class);
	/**
	 * This method is used to initialize the threadlocal driver on the basis of given browser value
	 * @param browser
	 * @return
	 */
	public WebDriver init_driver(String browser) {
		log.info("Selected browser is " + browser);

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());

		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			tlDriver.set(new EdgeDriver());
		} else if (browser.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			tlDriver.set(new SafariDriver());
		} else {
			log.info("Please provide correct browser value");
		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		return getDriver();
	
	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
