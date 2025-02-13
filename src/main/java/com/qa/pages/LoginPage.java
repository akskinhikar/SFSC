package com.qa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {
	
	private WebDriver driver;

    //By Locator
	private By username = By.id("username");
	private By password = By.id("password");
	private By btnLogin = By.id("Login");


    // Constructor of Page class

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Actions or Methods

    public void enterUserName(String uname) {
        driver.findElement(username).sendKeys(uname);
    }
    
    public void enterPassword(String passw) {
        driver.findElement(password).sendKeys(passw);
    }
    
    public void clickOnLogin() {
        driver.findElement(btnLogin).click();
    }


    public HomePage doLogin(String uname, String passw){
        driver.findElement(username).sendKeys(uname);
        driver.findElement(password).sendKeys(passw);
        driver.findElement(btnLogin).click();
        return new HomePage(driver);
    }

}
