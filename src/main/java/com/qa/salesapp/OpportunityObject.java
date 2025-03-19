package com.qa.salesapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class OpportunityObject{

	private WebDriver driver;
	private String message;
	private String AppName;
	private String messageonnewleadcreation;
	private String messageonleadconverstion;
	private String prodName;
	private Select stage;

	public OpportunityObject(WebDriver driver) {
		this.driver = driver;
	}

	private String paraEnd = "']";

	private String oo_productDropdown = "(//div[@data-aura-class='forceDeferredDropDownAction'])[2]";
	// String oo_productDropdown2 = "//a[@title='Show 2 more actions']";
	private String oo_productDropdown2 = "(//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled'])[2]";
	private String oo_clickonAddProductsLink = "//a[@title='Add Products']";
	private String oo_clickonChoosePriceBook = "//a[@title='Choose Price Book']";
	private String oo_choosepricebook = "//span[text()='Price Book']/parent::span/following-sibling::div/div/div/div/a";
	private String oo_selectpricebookbyname = "//a[@title='";
	private String oo_savePriceBook = "(//span[text()='Save'])[2]";
	private String oo_SearchProduct = "//input[@placeholder='Search Products...']";
	private String oo_ProductNameCheckBox01 = "//*[text()='";
	private String oo_ProductNameCheckBox02 = "']/parent::span/parent::th/preceding-sibling::td[1]/span/div";
	private String oo_addProduct_NextButton = "//span[text()='Next']";
	private String oo_saveButton = "//button[@title='Save']/span";
	private String oo_Quantity_01 = "//a[text()='";
	private String oo_Quantity_02 = "']/parent::span/parent::th/following-sibling::td[1]";
	private String oo_InputQuantity = "//input[@class='slds-grow input uiInputSmartNumber']";
	private String oo_selectmentionedproduct = "//span[@title='";
	private String oo_selectmentionedproduct02 = " in Products']";
	//String oo_closedStage_Button = "//a[@title='Closed']/parent::li";
	//String oo_closedStage_Button = "//a[@title='Closed']/span[2]";
	private String oo_closedStage_Button = "//*[text()='Closed']";
	private String oo_SelectClosedStage = "//span[text()='Select Closed Stage']/parent::button";
	private String oo_selectListOfClosedStage = "//select[@class='stepAction required-field select']";
	private String oo_saveClosedStage = "(//span[@class=' label bBody' and text()='Save'])[2]";
	private String oo_EditSelectedProducts = "//*[text()='Edit Selected Products']";


	public void addProductOnOpportunityObject(String pricebookname) {
		try {
			//waitForElementToApprearUsingXpath(oo_productDropdown);
			driver.findElement(By.xpath(oo_productDropdown)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(oo_clickonChoosePriceBook)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(oo_choosepricebook)).click();
			//waitForElementToApprearUsingXpath(oo_selectpricebookbyname + pricebookname + paraEnd);

			driver.findElement(By.xpath(oo_selectpricebookbyname + pricebookname + paraEnd)).click();
			driver.findElement(By.xpath(oo_savePriceBook)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnAddProductLink() {
		try {
			Thread.sleep(3000);
			// waitForElementToApprearUsingXpath(oo_productDropdown2);
			driver.findElement(By.xpath(oo_productDropdown2)).click();
			driver.findElement(By.xpath(oo_clickonAddProductsLink)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectProductsOnOpportunityObject(String productName) {
		try {
			prodName = productName;
			driver.findElement(By.xpath(oo_SearchProduct)).sendKeys(productName);
			Thread.sleep(5000);
			driver.findElement(By.xpath(oo_SearchProduct)).sendKeys(Keys.ENTER);
			// driver.findElement(By.xpath(oo_selectmentionedproduct+productName+oo_selectmentionedproduct02)).click();
			// waitForElementToApprearUsingXpath(oo_ProductNameCheckBox01+productName+oo_ProductNameCheckBox02);
			Thread.sleep(5000);
			driver.findElement(By.xpath(oo_ProductNameCheckBox01 + productName + oo_ProductNameCheckBox02)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void moveToNextSteps(String quantity) {
		try {
			//waitForElementToApprearUsingXpath(oo_addProduct_NextButton);
			driver.findElement(By.xpath(oo_addProduct_NextButton)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(oo_Quantity_01 + prodName + oo_Quantity_02)).click();
			driver.findElement(By.xpath(oo_InputQuantity)).sendKeys(quantity);
			driver.findElement(By.xpath(oo_EditSelectedProducts)).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(oo_saveButton)).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void selectClosedStage(String closedStage) {
		try {
			Thread.sleep(5000);
			//waitForElementToApprearUsingXpath(oo_closedStage_Button);
			driver.findElement(By.xpath(oo_closedStage_Button)).click();
			
			driver.findElement(By.xpath(oo_SelectClosedStage)).click();
			stage = new Select(driver.findElement(By.xpath(oo_selectListOfClosedStage)));
			stage.selectByVisibleText(closedStage);
			driver.findElement(By.xpath(oo_saveClosedStage)).click();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 
	 * public String newCampaignCreation(String CampaignName, String ExpRevenue) {
	 * System.out.println("** New Campaign Creation Started **"); newButton.click();
	 * campaignName.sendKeys(CampaignName); activateCheckbox.click();
	 * typePicklist.click(); typePicklistValue.click(); startDate.click();
	 * startDateSelection.click(); endDate.click(); endDateSelection.click();
	 * expectedRevenue.sendKeys(ExpRevenue); waitForElementToApprear(saveButton1);
	 * saveButton.click(); waitForElementToApprear(result1); message =
	 * resultMessage.getText(); return message; }
	 * 
	 * 
	 * public String editCampaignRecord() { selectRecord.click();
	 * actionButton.click(); editButton.click(); typePicklist.click();
	 * typePicklistValue.click(); waitForElementToApprear(saveButton1);
	 * saveButton.click(); waitForElementToApprear(result1); message =
	 * resultMessage.getText(); return message;
	 * 
	 * }
	 */

}
