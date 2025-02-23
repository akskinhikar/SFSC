package com.qa.salesapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LeadObject{
	
private WebDriver driver;
private String message;
private String AppName;
private String messageonnewleadcreation;
private String messageonleadconverstion;
	
	public LeadObject(WebDriver driver) {
		this.driver = driver;
	}
	
	//WebElement MarketingApp = driver.findElement(By.xpath("//p[text()='"+AppName+"']"));
	//Common xPaths:
	private String paraEnd = "']";

	private String webApp = "//div[@class='slds-icon-waffle']";
	private String desiredApp = "//p[text()='";
	private String desiredObject01 = "//a[@title='";
	private String desiredObject02 = "']/parent::*";
	private String desiredButton01 = "//div[@title='";
	private String desiredButton02 = "']/parent::a/parent::li";
	private String firstname = "//input[@name='firstName']";
	private String lastname = "//input[@name='lastName']";
	private String companyname = "//input[@name='Company']";
	private String leadSource = "//label[text()='Lead Source']/parent::div/div[1]";
	private String leadSourcename = "//span[@title='";
	private String mobilephone = "//input[@name='MobilePhone']";
	private String saveButton = "//button[@name='SaveEdit']";
	private String msg = "//span[@class='toastMessage slds-text-heading--small forceActionsText']";
	private String selectRecord = "//*[text()='";
	private String dropdownbutton= "//ul[@class='slds-button-group-list']/li[4]/lightning-button-menu/button";
	private String editButton = "//span[text()='Edit']";
	private String convertButton = "//span[text()='Convert']";
	private String convertButton2 = "//button[text()='Convert']";
	private String leadConvertedSuccessfulMsg = "//div[@class='title']/h2";
	private String opportunityLink = "(//div[@class='containerConvertedItem'])[3]/div[2]/div[2]/a";
	
	
	
	
	public void navigateToDesiredApp(String appName) {
			driver.findElement(By.xpath(webApp)).click();
			//waitForElementToApprearUsingXpath(desiredApp+appName+paraEnd);
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
		//scrollTheScreenToViewDesiredElementUsingXpath(leadSource);
		driver.findElement(By.xpath(leadSource)).click();
		driver.findElement(By.xpath(leadSourcename+leadSourceName+paraEnd)).click();
		driver.findElement(By.xpath(saveButton)).click();
		//waitForElementToApprearUsingXpath(msg);
		messageonnewleadcreation = driver.findElement(By.xpath(msg)).getText();
		System.out.println(messageonnewleadcreation);
		return messageonnewleadcreation;
	}
	
	public void editLeadRecord(String leadname) {
		//waitForElementToApprearUsingXpath(selectRecord+leadname+paraEnd);
		driver.findElement(By.xpath(selectRecord+leadname+paraEnd)).click();
		driver.findElement(By.xpath(dropdownbutton)).click();
		//waitForElementToApprearUsingXpath(editButton);
		driver.findElement(By.xpath(editButton)).click();

	}
	
	public String clickOnConvertButton() throws InterruptedException {
		driver.findElement(By.xpath(dropdownbutton)).click();
		//waitForElementToApprearUsingXpath(convertButton);
		driver.findElement(By.xpath(convertButton)).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(convertButton2)).click();
		//waitForElementToApprearUsingXpath(leadConvertedSuccessfulMsg);
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
