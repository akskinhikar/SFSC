package com.qa.pages;

import com.qa.util.TestUtil;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class LeadsPage {
    private WebDriver driver;
    TestUtil testUtil = null;
    //By Locators
    private By leads_New_Button = By.xpath("//a[@title='New' and @role='button']");
    private By leads_input_First_Name = By.xpath("//input[@placeholder='First Name']");
    private By leads_input_Last_Name = By.xpath("//input[@placeholder='Last Name']");
    private By leads_input_Company = By.xpath("//input[@name='Company']");
    private By leads_drop_Lead_Source = By.xpath("//button[@aria-label='Lead Source']");
    private By leads_Lead_Source_Option_Web = By.xpath("//lightning-base-combobox-item[@data-value='Web']");
    private By leads_Lead_Source_Option_PhoneInq = By.xpath("//lightning-base-combobox-item[@data-value='Phone Inquiry']");
    private By leads_button_New_Leads_Save = By.xpath("//button[@name='SaveEdit' and text()='Save']");

    //constructor
    public LeadsPage(WebDriver driver) {
        this.driver = driver;
    }

    //Page Actions
    public void click_on_new_leads_creation_button(){
        driver.findElement(leads_New_Button).click();
    }

    public void new_neads_ceation_infomation(String first_name, String last_name, String company) throws InterruptedException {

            driver.findElement(leads_input_First_Name).sendKeys(first_name);
            driver.findElement(leads_input_Last_Name).sendKeys(last_name);
            driver.findElement(leads_input_Company).sendKeys(company);
            testUtil = new TestUtil(driver);
            testUtil.scroll_the_screen_to_view_desired_element_using_xpath(leads_drop_Lead_Source);
            driver.findElement(leads_drop_Lead_Source).click();
            driver.findElement(leads_Lead_Source_Option_Web).click();
            driver.findElement(leads_button_New_Leads_Save).click();
    }
}
