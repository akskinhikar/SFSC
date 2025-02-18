package com.qa.salesapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbsctractComponents.Reusable;

public class LeadObject extends Reusable {
	
WebDriver driver;
String message;
String AppName;
String messageonnewleadcreation;
String messageonleadconverstion;
	
	public LeadObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	
	//WebElement MarketingApp = driver.findElement(By.xpath("//p[text()='"+AppName+"']"));
	//Common xPaths:
	String paraEnd = "']";
	
	String webApp = "//div[@class='slds-icon-waffle']";
	String desiredApp = "//p[text()='";
	String desiredObject01 = "//a[@title='";
	String desiredObject02 = "']/parent::*";
	String desiredButton01 = "//div[@title='";
	String desiredButton02 = "']/parent::a/parent::li";
	String firstname = "//input[@name='firstName']";
	String lastname = "//input[@name='lastName']";
	String companyname = "//input[@name='Company']";
	String leadSource = "//label[text()='Lead Source']/parent::div/div[1]";
	String leadSourcename = "//span[@title='";
	String mobilephone = "//input[@name='MobilePhone']";
	String saveButton = "//button[@name='SaveEdit']";
	String msg = "//span[@class='toastMessage slds-text-heading--small forceActionsText']";
	String selectRecord = "//*[text()='";
	String dropdownbutton= "//ul[@class='slds-button-group-list']/li[4]/lightning-button-menu/button";
	String editButton = "//span[text()='Edit']";
	String convertButton = "//span[text()='Convert']";
	String convertButton2 = "//button[text()='Convert']";
	String leadConvertedSuccessfulMsg = "//div[@class='title']/h2";
	String opportunityLink = "(//div[@class='containerConvertedItem'])[3]/div[2]/div[2]/a";
	
	
	
	
	public void navigateToDesiredApp(String appName) {
			driver.findElement(By.xpath(webApp)).click();
			waitForElementToApprearUsingXpath(desiredApp+appName+paraEnd);
			driver.findElement(By.xpath(desiredApp+appName+paraEnd)).click();
		}
	
	public void navigateToDesiredObject(String objectName) {
		//waitForElementToApprearUsingXpath(desiredObject+objectName+paraEnd);
		driver.findElement(By.xpath(desiredObject01+objectName+desiredObject02)).click();
		
	}
	
	public void clicksonDesiredbutton(String buttonName) {
		driver.findElement(By.xpath(desiredButton01+buttonName+desiredButton02)).click();
		
	}
	
	public String provideLeadInformationDetails(String fName, String lName, String companyName, String leadSourceName, String mobileNumber) throws InterruptedException {
		driver.findElement(By.xpath(firstname)).sendKeys(fName);
		driver.findElement(By.xpath(lastname)).sendKeys(lName);
		driver.findElement(By.xpath(companyname)).sendKeys(companyName);
		driver.findElement(By.xpath(mobilephone)).sendKeys(mobileNumber);
		scrollTheScreenToViewDesiredElementUsingXpath(leadSource);
		driver.findElement(By.xpath(leadSource)).click();
		driver.findElement(By.xpath(leadSourcename+leadSourceName+paraEnd)).click();
		driver.findElement(By.xpath(saveButton)).click();
		waitForElementToApprearUsingXpath(msg);
		messageonnewleadcreation = driver.findElement(By.xpath(msg)).getText();
		System.out.println(messageonnewleadcreation);
		return messageonnewleadcreation;
	}
	
	public void editLeadRecord(String leadname) {
		waitForElementToApprearUsingXpath(selectRecord+leadname+paraEnd);	
		driver.findElement(By.xpath(selectRecord+leadname+paraEnd)).click();
		driver.findElement(By.xpath(dropdownbutton)).click();
		waitForElementToApprearUsingXpath(editButton);			
		driver.findElement(By.xpath(editButton)).click();

	}
	
	public String clickOnConvertButton() throws InterruptedException {
		driver.findElement(By.xpath(dropdownbutton)).click();
		waitForElementToApprearUsingXpath(convertButton);			
		driver.findElement(By.xpath(convertButton)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(convertButton2)).click();
		waitForElementToApprearUsingXpath(leadConvertedSuccessfulMsg);
		messageonleadconverstion = driver.findElement(By.xpath(leadConvertedSuccessfulMsg)).getText();
		System.out.println(messageonleadconverstion);
		return messageonleadconverstion;
	}
	
	public void clickOnOpportunityLink() {
		driver.findElement(By.xpath(opportunityLink)).click();
	}
	
	/*
		
		public String newCampaignCreation(String CampaignName, String ExpRevenue) {
			System.out.println("** New Campaign Creation Started **");
			newButton.click();
			campaignName.sendKeys(CampaignName);
			activateCheckbox.click();
			typePicklist.click();
			typePicklistValue.click();
			startDate.click();
			startDateSelection.click();
			endDate.click();
			endDateSelection.click();
			expectedRevenue.sendKeys(ExpRevenue);
			waitForElementToApprear(saveButton1);			
			saveButton.click();
			waitForElementToApprear(result1);
			message = resultMessage.getText();
			return message;
		}
		
		
		public String editCampaignRecord() {
			selectRecord.click();
			actionButton.click();
			editButton.click();
			typePicklist.click();
			typePicklistValue.click();
			waitForElementToApprear(saveButton1);			
			saveButton.click();
			waitForElementToApprear(result1);
			message = resultMessage.getText();			
			return message;
			
		} */

}
