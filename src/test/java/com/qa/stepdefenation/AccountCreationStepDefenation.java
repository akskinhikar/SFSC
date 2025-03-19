package com.qa.stepdefenation;

import com.qa.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class AccountCreationStepDefenation {
    private HomePage homePage;


    @When("^user navigates to desired sales App$")
    public void user_navigates_to_desired_sales_App() {
        try {
            homePage.clickAppLauncher();
            homePage.clickMarketingCRMClass();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @When("^user navigates to Accounts Object$")
    public void user_navigates_to_Accounts_Object() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @When("^user clicks on New button for Account Creation$")
    public void user_clicks_on_New_button_for_Account_Creation() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @When("^user provide information for account creation with AccountName (.+) Rating (.+) Phone (.+) AnnualRevenue (.+) Billing Street (.+) Billing City (.+) Billing Province (.+) Billing Country (.+) Billing Zipcode (.+)$")
    public void user_provide_information_for_account_creation_with_account_name_akshay_ki_rating_hot_phone_annual_revenue_billing_street_rue_scott_billing_city_montreal_billing_province_qc_billing_country_ca_billing_zipcode_h4m1t2 (String accountName,	String rating, String phone, String annualRevenue, String billingStreet, String billingCity, String billingProvince, String billingCountry, String billingZipcode) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^user provides contact details like saluation (.+) first name (.+) last name (.+) dateofbirth (.+) email (.+)$")
    public void user_provides_contact_details_like_saluation_saluation_first_name_firstname_last_name_lastname_dateofbirth_dob_email_email(String salua, String firName, String lasName, String dob, String email ) {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
