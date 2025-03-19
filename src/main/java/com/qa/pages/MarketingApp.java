package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MarketingApp {

    private WebDriver driver;

    //By locators
    private By mkt_Lead_Object = By.xpath("//one-app-nav-bar-item-root[@data-id='Lead']");
    private String mkt_lead_obj = "//a[@title='Leads']";


    // Constructor of Page class
    public MarketingApp(WebDriver driver) {
        this.driver = driver;
    }

    // Page Actions
    public LeadsPage clickOnLeadsObject(){
        //JavascriptExecutor js = (JavascriptExecutor)driver;
        driver.findElement(mkt_Lead_Object).click();
        return (new LeadsPage(driver));
    }
}
