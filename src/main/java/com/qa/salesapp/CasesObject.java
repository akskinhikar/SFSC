package com.qa.salesapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import AbsctractComponents.Reusable;

public class CasesObject extends Reusable{
	
	public CasesObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	
	WebDriver driver;
	String messageoncasecreation;
	String AppName;
	
	
	String webApp = "//div[@class='slds-icon-waffle']";
	String desiredApp = "//p[text()='";
	String paraEnd = "']";
	String desiredObject01 = "//a[@title='";
	String desiredObject02 = "']/parent::*";
	String contactName = "//input[contains(@placeholder,'Search Contacts')]";
	String accountName = "//input[contains(@placeholder,'Search Accounts')]";
	String desiredButton01 = "//div[@title='";
	String desiredButton02 = "']/parent::a/parent::li";
	String saveButton_newCase = "//button[@name='SaveEdit']";
	String caseSubject = "//input[@name='Subject']";
	String caseDescription = "//*[@field-label='Description']//textarea";
	String selectContactName01 = "//*[text()='Contact Name']/..//span[text()='";
	String selectAccountName01 = "//*[text()='Account Name']/..//span[text()='";
	String caseOrigin = "//button[contains(@aria-label,'Case Origin')]";
	String caseOriginOption = "//*[text()='";
	String msg = "//span[@class='toastMessage slds-text-heading--small forceActionsText']";
	
	
	/*
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
		driver.findElement(By.xpath(desiredButton01+buttonName+desiredObject02)).click();		
	} */
	
	
	public void fillCaseCreationDetails(String caseorigin, String contactname, String accountname) {
		driver.findElement(By.xpath(caseOrigin)).click();
		driver.findElement(By.xpath(caseOriginOption+caseorigin+paraEnd)).click();
		
		
		driver.findElement(By.xpath(contactName)).click();
		driver.findElement(By.xpath(selectContactName01+contactname+paraEnd)).click();
		
		driver.findElement(By.xpath(accountName)).click();
		driver.findElement(By.xpath(selectAccountName01+accountname+paraEnd)).click();
	}
	
	public void provideSubjectAndDescription(String subj, String desc) {
		driver.findElement(By.xpath(caseSubject)).sendKeys(subj);
		driver.findElement(By.xpath(caseDescription)).sendKeys(desc);
	}
	
	public String savesTheCase() throws InterruptedException {
		driver.findElement(By.xpath(saveButton_newCase)).click();
		//waitForElementToApprearUsingXpath(saveButton_newCase);
		Thread.sleep(3000);
		messageoncasecreation =  driver.findElement(By.xpath(msg)).getText();
		System.out.println(messageoncasecreation);
		return messageoncasecreation;
		
	}


}
