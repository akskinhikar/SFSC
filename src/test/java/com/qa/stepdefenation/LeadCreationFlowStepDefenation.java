package com.qa.stepdefenation;

import com.qa.factory.DriverFactory;
import com.qa.pages.HomePage;
import com.qa.pages.LeadsPage;
import com.qa.pages.LoginPage;
import com.qa.pages.MarketingApp;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeadCreationFlowStepDefenation {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private HomePage homePage;
    private MarketingApp marketingApp;
    private LeadsPage leadsPage;
    @When("^User logs in by using username (.+) and password (.+)$")
    public void User_logs_in_by_using_username_and_password(String uname, String pwd) {

        homePage = loginPage.doLogin(uname,pwd);
    }


    @When("^user navigates to marketing crm app$")
    public void user_navigates_to_marketing_crm_app() {
        try {
            homePage.clickAppLauncher();
            marketingApp = homePage.clickMarketingCRMClass();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("^user navigates to Leads Object$")
    public void user_navigates_to_Leads_Object() {
        try {
            leadsPage = marketingApp.clickOnLeadsObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @When("^user clicks on New button for Lead Creation$")
    public void user_clicks_on_New_button_for_Lead_Creation() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @When("^user provide information regarding first name (.+) last name (.+) company (.+) lead source (.+) mobile (.+)$")
    public void user_provide_information_regarding_first_name_last_name_company_lead_source_mobile
            (String firstName, String lastName, String company, String leadSource, String mobileNo) {
        try {

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
