package com.qa.stepdefenation;

import com.qa.factory.DriverFactory;
import com.qa.pages.HomePage;
import com.qa.pages.LeadsPage;
import com.qa.pages.LoginPage;
import com.qa.pages.MarketingApp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LeadCreationFlowStepDefenation {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private HomePage homePage;
    private MarketingApp marketingApp;
    private LeadsPage leadsPage;
    static Logger logs = LogManager.getLogger("LeadCreationFlowStepDefenation.java");
    
    @When("^User logs in by using username (.+) and password (.+)$")
    public void User_logs_in_by_using_username_and_password(String uname, String pwd) {

        homePage = loginPage.doLogin(uname,pwd);
        logs.info("Login Was Successful and landed on Home Page");
    }


    @When("^user navigates to marketing crm app$")
    public void user_navigates_to_marketing_crm_app() {
        try {
            homePage.clickAppLauncher();
            marketingApp = homePage.clickMarketingCRMClass();
            logs.info("Navigated to Marketing App Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("^user navigates to Leads Object$")
    public void user_navigates_to_Leads_Object() {
        try {
            leadsPage = marketingApp.clickOnLeadsObject();
            logs.info("Navigated to Leads Page Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @When("^user clicks on New button for Lead Creation$")
    public void user_clicks_on_New_button_for_Lead_Creation() {
        try {
            leadsPage.click_on_new_leads_creation_button();
            logs.info("Clicked on New Button for Lead Creation");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @When("^user provide information regarding first name (.+) last name (.+) company (.+) lead source (.+) mobile (.+)$")
    public void user_provide_information_regarding_first_name_last_name_company_lead_source_mobile
            (String firstName, String lastName, String company, String leadSource, String mobileNo) {
        try {
            leadsPage.new_neads_ceation_infomation(firstName, lastName, company);
            logs.info("New Lead Created Successfully");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^user verify the tost message (.+) during new lead creation$")
    public void user_verify_the_tost_message_during_new_lead_creation(String message) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
