package com.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    // By Locators

    private By btnappLauncher = By.xpath("//div[@class='slds-icon-waffle']");
    private By maketingCRMClassic = By.xpath("//a[@data-label='Marketing CRM Classic']//p[text()='Marketing CRM Classic']");

    // Constructor of Page class

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Page Action or Methods

    public void clickAppLauncher(){
        driver.findElement(btnappLauncher).click();
    }

    public MarketingApp clickMarketingCRMClass(){
        driver.findElement(maketingCRMClassic).click();
        return (new MarketingApp(driver));
    }

}
