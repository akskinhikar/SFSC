package com.qa.salesapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsObject {
	
private WebDriver driver;
String message;
String AppName;
String msgonnewacctcreation;

	


	private final By AccountName = By.xpath("(//*[text()='Account Name'])[2]/following-sibling::div/input");
	private By Rating=By.xpath("//label[text()='Rating']/../div/lightning-base-combobox/div/div/div/button");
	private By Phone=By.xpath("//label[text()='Phone']/../div/input");
	private By AnnualRevenue=By.xpath("//label[text()='Annual Revenue']/../div/input");
	private By BillingProvince=By.xpath("//label[contains(text(),'Billing State')]/../div/input");
	private By BillingStreet=By.xpath("By.xpath(//label[text()='Billing Street']/../div/textarea");
	private By BillingZipcode=By.xpath("//label[contains(text(),'Billing Zip')]/../div/input");
	private By BillingCountry=By.xpath("//label[text()='Billing Country']/../div/input");
	private By SavButton = By.xpath("//button[@name='SaveEdit']");
	private By contact_new= By.xpath("//span[contains(@title,'Contacts')]/../../../../../following-sibling::div[2]/div");
	private By BillingCity=By.xpath("//label[text()='Billing City']/../div/input");
	private By Salutation = By.xpath("//label[text()='Salutation']/../div");
	private By firstName = By.xpath("//label[text()='First Name']/../div/input");
	private By lastName = By.xpath("//label[text()='Last Name']/../div/input");
	private By Mobile = By.xpath("//label[text()='Mobile']/../div/input");
	private By Birthdate = By.xpath("//label[text()='Birthdate']/../div/input");
	private By Email = By.xpath("//label[text()='Email']/../div/input");
	private By saveEditButton = By.xpath("//button[@name='SaveEdit']");

	String elementName1="//span[text()='";
	String elementName="//*[text()='";
	String paraEnd = "']";


	public AccountsObject(WebDriver driver) {
		this.driver = driver;

	}
	
	
	public void provideAccountInformationDetails(
			String accountName,	String rating, String phone, String annualRevenue,
			String billingStreet, String billingCity, String billingProvince, String billingCountry, String billingZipcode) {
		
		driver.findElement(AccountName).sendKeys(accountName);
		driver.findElement(Rating).click();
		driver.findElement(By.xpath(elementName+rating+paraEnd)).click();
		driver.findElement(Phone).sendKeys(phone);
		driver.findElement(AnnualRevenue).sendKeys(annualRevenue);
		driver.findElement(BillingStreet).sendKeys(billingStreet);
		driver.findElement(BillingProvince).sendKeys(billingProvince);
		driver.findElement(BillingCity).sendKeys(billingCity);
		driver.findElement(BillingZipcode).sendKeys(billingZipcode);
		driver.findElement(BillingCountry).sendKeys(billingCountry);
		driver.findElement(SavButton).click();
		
	}
	

	public void createNewContact(String saluation, String firstname, String lastname, String dob, String email) {
			//waitForElementToApprearUsingXpath(contact_new);
			driver.findElement(contact_new).click();
			driver.findElement(Salutation).click();
			driver.findElement(By.xpath(elementName1+saluation+paraEnd)).click();
			driver.findElement(firstName).sendKeys(firstname);
			driver.findElement(lastName).sendKeys(lastname);
			driver.findElement(Birthdate).sendKeys(dob);
			driver.findElement(Email).sendKeys(email);
			driver.findElement(saveEditButton).click();
		}
	
	/*
	
	public void navigateToDesiredObject(String objectName) {
		//waitForElementToApprearUsingXpath(desiredObject+objectName+paraEnd);
		driver.findElement(By.xpath(desiredObject01+objectName+desiredObject02)).click();
		
	}
	
	public void clicksonDesiredbutton(String buttonName) {
		driver.findElement(By.xpath(desiredButton01+buttonName+desiredObject02)).click();
		
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
