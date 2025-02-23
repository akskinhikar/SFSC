package com.qa.salesapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CasesObject {
	private  WebDriver driver;


	

	private String messageoncasecreation;
	private String AppName;
	private String webApp = "//div[@class='slds-icon-waffle']";
	private String desiredApp = "//p[text()='";
	private String paraEnd = "']";
	private String desiredObject01 = "//a[@title='";
	private String desiredObject02 = "']/parent::*";
	private String contactName = "//input[contains(@placeholder,'Search Contacts')]";
	private String accountName = "//input[contains(@placeholder,'Search Accounts')]";
	private String desiredButton01 = "//div[@title='";
	private String desiredButton02 = "']/parent::a/parent::li";
	private String saveButton_newCase = "//button[@name='SaveEdit']";
	private String caseSubject = "//input[@name='Subject']";
	private String caseDescription = "//*[@field-label='Description']//textarea";
	private String selectContactName01 = "//*[text()='Contact Name']/..//span[text()='";
	private String selectAccountName01 = "//*[text()='Account Name']/..//span[text()='";
	private String caseOrigin = "//button[contains(@aria-label,'Case Origin')]";
	private String caseOriginOption = "//*[text()='";
	private String msg = "//span[@class='toastMessage slds-text-heading--small forceActionsText']";

	public CasesObject(WebDriver driver) {
		this.driver = driver;
	}


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
