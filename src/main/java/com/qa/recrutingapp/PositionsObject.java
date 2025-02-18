package com.qa.recrutingapp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PositionsObject{
	
private WebDriver driver;
String message;

	

	

// Page locators for Postion Object Page //
	private By  WebApp = By.xpath("//div[@class='slds-icon-waffle']");
	private By  AppName = By.xpath("//p[text()='Recruiting']");
	private By  PositionsObject = By.xpath("//*[@data-target-selection-name='sfdc:TabDefinition.Position__c']");
	private By  newButton = By.xpath("//a[@title='New']");
	private By  positionTitle = By.xpath("(//*[text()='Position Title'])[2]//following-sibling::div/input");
	private By  saveButton = By.xpath("//*[@apiname='SaveEdit']");
	private By  resultMessage = By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']");
	private By  selectRecord = By.xpath("//a[@title='test02']");
	private By  editButton = By.xpath("//*[@title='Edit']");
	private By  resultEditMessage = By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']");
	private By saveButton1 = By.xpath("//*[@apiname='SaveEdit']");
	private By result1 = By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']");
	private By result2 = By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']");

	// Constructor for Postion Object Page //
	public PositionsObject(WebDriver driver) {
		this.driver = driver;
	}
		
		
		/*
		@FindBy(xpath="//div[@class='uiInput uiInputCheckbox uiInput--default uiInput--checkbox']/input")
		WebElement activateCheckbox;
		
		@FindBy(xpath="//div[@data-aura-class='forcePageBlockSectionRow'][4]/div/div/div/div/div")
		WebElement typePicklist;
		
		@FindBy(xpath="//a[text()='Partners']")
		WebElement typePicklistValue;
		
		@FindBy(xpath="//div[@data-aura-class='forcePageBlockSectionRow'][5]/div/div/div/div/div")
		WebElement statusPicklist;
		
		@FindBy(xpath="//div[@class='slds-form slds-form_stacked slds-is-editing']/div[6]/div/div/div/div/div")
		WebElement startDate;
		
		@FindBy(xpath="//td[@class='uiDayInMonthCell']/span[text()='20']")
		WebElement startDateSelection;
		
		@FindBy(xpath="//div[@class='slds-form slds-form_stacked slds-is-editing']/div[6]/div/div/div/div/div")
		WebElement endDate;
		
		@FindBy(xpath="//td[@class='uiDayInMonthCell']/span[text()='21']")
		WebElement endDateSelection;
		
		@FindBy(xpath="//div[@class='slds-form slds-form_stacked slds-is-editing']/div[8]/div/div/div/div/input")
		WebElement expectedRevenue;
		

		
		
		@FindBy(xpath="//a[@title='SalesforceOne']")
		WebElement selectRecord;
		
		@FindBy(xpath="//div[@class='slds-grid primaryFieldRow']/div[2]/ul/li[4]")
		WebElement actionButton;
		
		@FindBy(xpath="(//button[text()='Edit'])[2]")
		WebElement editButton; */
		
		

				
		public void navigateToRecrutingApp() {
			System.out.println("** Navigation To Recruting App Started **");
			//waitForElementToApprear(By.xpath("//div[@class='slds-icon-waffle']"));
			driver.findElement(WebApp).click();
			driver.findElement(AppName).click();
			driver.findElement(PositionsObject).click();
			System.out.println("** Navigation To Recruting App is successful **");
			
		}
		
		
		public String newPositionCreation(String PositionName) {
			System.out.println("** New Postion Creation Started **");
			driver.findElement(newButton).click();
			driver.findElement(positionTitle).sendKeys(PositionName);
			//waitForElementToApprear(saveButton1);
			driver.findElement(saveButton).click();
			//waitForElementToApprear(result1);
			message = driver.findElement(resultMessage).getText();
			System.out.println("------"+message+"----------");
			return message;
		}
		
		
		public String editPositionRecord() {
			driver.findElement(selectRecord).click();
			//actionButton.click();
			driver.findElement(editButton).click();
			//typePicklist.click();
			//typePicklistValue.click();
			//waitForElementToApprear(saveButton1);
			driver.findElement(saveButton).click();
			//waitForElementToApprear(result2);
			message = driver.findElement(resultEditMessage).getText();
			System.out.println("---"+message+"-----");
			return message;
			
		}

}
