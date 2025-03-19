package com.qa.marketingapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CampaignObject {

    private WebDriver driver;
    String message;
    String AppName;


    //Page Locators for Campaign Object //
    private By WebApp = By.xpath("//div[@class='slds-icon-waffle']");
    private By MarketingApp = By.xpath("//p[text()='Marketing']");
    private By CampaignObject = By.xpath("//*[@data-id='Campaign']");
    private By newButton = By.xpath("//a[@title='New']");
    private By campaignName = By.xpath("//div[@class='uiInput uiInputText uiInput--default uiInput--input']/input");
    private By activateCheckbox = By.xpath("//div[@class='uiInput uiInputCheckbox uiInput--default uiInput--checkbox']/input");
    private By typePicklist = By.xpath("//div[@data-aura-class='forcePageBlockSectionRow'][4]/div/div/div/div/div");
    private By typePicklistValue = By.xpath("//a[text()='Partners']");
    private By statusPicklist = By.xpath("//div[@data-aura-class='forcePageBlockSectionRow'][5]/div/div/div/div/div");
    private By startDate = By.xpath("//div[@class='slds-form slds-form_stacked slds-is-editing']/div[6]/div/div/div/div/div");
    private By startDateSelection = By.xpath("//td[@class='uiDayInMonthCell']/span[text()='27']");
    private By endDate = By.xpath("(//div[@class='form-element']/input)[2]");
    private By endDateSelection = By.xpath("//td[@class='uiDayInMonthCell']/span[text()='30']");
    private By expectedRevenue = By.xpath("//div[@class='slds-form slds-form_stacked slds-is-editing']/div[8]/div/div/div/div/input");
    private By saveButton = By.xpath("//button[@title='Save']/span[text()='Save']");
    private By resultMessage = By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']");
    private By selectRecord = By.xpath("//a[@title='SalesforceOne']");
    private By actionButton = By.xpath("//div[@class='slds-grid primaryFieldRow']/div[2]/ul/li[4]");
    private By editButton = By.xpath("//a[@title='Edit']");
    private By saveButton1 = By.xpath("//button[@title='Save']/span[text()='Save']");
    private By result1 = By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']");

    //Constructor for Campaign Object Page //
    public CampaignObject(WebDriver driver) {
        this.driver = driver;
    }

    // Actions or Methods related to Campain Object //
    public void navigateToMarketingApp() {
        driver.findElement(WebApp).click();
        driver.findElement(MarketingApp).click();
        driver.findElement(CampaignObject).click();

    }

    public String newCampaignCreation(String CampaignName, String ExpRevenue) {
        System.out.println("** New Campaign Creation Started **");
        driver.findElement(newButton).click();
        driver.findElement(campaignName).sendKeys(CampaignName);
        driver.findElement(activateCheckbox).click();
        driver.findElement(typePicklist).click();
        driver.findElement(typePicklistValue).click();
        driver.findElement(startDate).click();
        driver.findElement(startDateSelection).click();
        driver.findElement(endDate).click();
        driver.findElement(endDateSelection).click();
        driver.findElement(expectedRevenue).sendKeys(ExpRevenue);
        //waitForElementToApprear(saveButton1);
        driver.findElement(saveButton).click();
        //waitForElementToApprear(result1);
        message = driver.findElement(resultMessage).getText();
        return message;
    }


    public String editCampaignRecord() {
        driver.findElement(selectRecord).click();
        driver.findElement(actionButton).click();
        driver.findElement(editButton).click();
        driver.findElement(typePicklist).click();
        driver.findElement(typePicklistValue).click();
        //waitForElementToApprear(saveButton1);
        driver.findElement(saveButton).click();
        //waitForElementToApprear(result1);
        message = driver.findElement(resultMessage).getText();
        return message;

    }

}
