package com.qa.stepdefenation;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import AbsctractComponents.Reusable;
import LandingPage.LandingPage;
import MarketingApp.CampaignObject;
import RecrutingApp.PositionsObject;
import SalesApp.AccountsObject;
import SalesApp.CasesObject;
import SalesApp.LeadObject;
import SalesApp.OpportunityObject;
import Utils.BaseTest;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImplementation extends BaseTest {
	public LandingPage landingPage;
	public CampaignObject co;
	public PositionsObject po;
	public Reusable reuse;
	public String Message;
	public String msgeonnewleadcreation;
	public String PositionCreationMessage;
	public String EditPositionCreationMessage;
	public LeadObject lo;
	public OpportunityObject oo;
	public AccountsObject ao;
	public CasesObject ca;
	static Logger logs = LogManager.getLogger("StepDefinitionImplementation.java");
	public String msgeoncasecreation;
	
	
//	@Given("I have landed on salesforce page")
//	public void I_have_landed_on_salesforce_page() {
//		try {
//			landingPage = launchApplication();
//			logs.info("Landed on SF Application");
//		} catch (Exception e) {
//			logs.info("Something went wrong with SF application launch");
//			e.printStackTrace();
//		}
//	}
	

	@Given("^User Login in salesforce using username (.+) and password (.+)$")
	public void User_Login_in_salesforce_using_username_and_password(String username, String password) {
		try {
		landingPage.loginApplication(username, password);
		logs.info("Logging in the SF application is successful");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@When("user navigates to Marketing App")
	public void user_navigates_to_Marketing_App() {
		try {
			co = new CampaignObject(driver);
			co.navigateToMarketingApp();
			logs.info("User has navigated successfully to Marketing App");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@And("^user provids Campaign Name (.+) and Expected Revenue (.+) and submits order$")
	public void user_provids_Campaign_Name_and_Expected_Revenue_and_submits_order(String CampaignName,
			String ExpRevenue) {
		try {
			Message = co.newCampaignCreation(CampaignName, ExpRevenue);
			logs.info("Order has been successfully submitted");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^user verify the message (.+) is correct$")
	public void user_verify_the_message_is_correct(String message) {
		//String textcheck = "Campaign \""+input.get("CampaignName")+"\" was created.";
		
		try {
			logs.info("Actual Message === "+Message);
			logs.info("Expected Message === "+message);
			Assert.assertTrue(Message.equalsIgnoreCase(message), "Matched");
			logs.info("Actual Message is equal to expected message");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@And("user logs out of salesforce")
	public void user_logs_out_of_salesforce() {
		try {
			reuse = new Reusable(driver);
			reuse.logoutApplication();
			logs.info("User has successfully logged out");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@When("user navigates to Recruting App")
	public void user_navigates_to_Recruting_App() {
		try {
			po = new PositionsObject(driver);
			po.navigateToRecrutingApp();
			logs.info("User navigates to Recruting App");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@And("^user provids Position Name (.+) and clicks on saves button$")
	public void user_provids_position_name_and_clicks_on_saves_button(String positionname) {
		try {			
			PositionCreationMessage = po.newPositionCreation(positionname);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@Then ("^user verify the position creation message (.+) is correct$")
	public void user_verify_the_position_creation_message_is_correct (String message) {
		try {
			logs.info("Actual Message === "+PositionCreationMessage);
			logs.info("Expected Message === "+message);
			Assert.assertTrue(PositionCreationMessage.equalsIgnoreCase(message), "Matched");
			logs.info("Actual Position Creation Message is equal to expected message");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@And ("user selects position record")
	public void user_selects_position_record () {
		try {
			EditPositionCreationMessage = po.editPositionRecord();
		}catch (Exception e) {
		
		e.printStackTrace();
		
		}
	}
	
	
	@Then ("^user verify the edit position message (.+) is correct$")
	public void user_verify_the_edit_position_message_is_correct (String message) {
		try {
			logs.info("Actual Message === "+EditPositionCreationMessage);
			logs.info("Expected Message === "+message);
			Assert.assertTrue(EditPositionCreationMessage.equalsIgnoreCase(message), "Matched");
			logs.info("Position has been edited successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	// Lead to Opportunity 
	
	
	@When("^user navigates to desired (.+) App$")
	public void user_navigates_to_desired_App(String appname) {
		try {
			lo = new LeadObject(driver);
			lo.navigateToDesiredApp(appname);
			logs.info("User Navigated to "+appname+ " app");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@When("^user navigates to (.+) Object$")
	public void user_navigates_to_Object(String objectName) {
		try {
			lo.navigateToDesiredObject(objectName);
			logs.info("User Navigates to "+objectName+ "Object");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@When("^user clicks on (.+) button$")
	public void user_clicks_on_button(String buttonName) {
		try {
			lo.clicksonDesiredbutton(buttonName);
			logs.info("User Clicks on "+buttonName+" button");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
}
	
	
    @When("^user provide information regarding first name (.+) last name (.+) company (.+) lead source (.+) mobile (.+)$")
    public void user_provide_information_regarding_first_name_last_name_company_lead_source_mobile
    (String firstName, String lastName, String company, String leadSource, String mobileNo) {
    	try {
    		msgeonnewleadcreation=lo.provideLeadInformationDetails(firstName, lastName, company, leadSource, mobileNo);
    		logs.info("User provides required information");
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
	@Then("^user verify the tost message (.+) during new lead creation$")
	public void user_verify_the_tost_message_during_new_lead_creation(String message) {
		try {
			logs.info("Actual Message === "+msgeonnewleadcreation);
			logs.info("Expected Message === "+message);
			Assert.assertTrue(msgeonnewleadcreation.equalsIgnoreCase(message), "Matched");
			logs.info("New Lead Created Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@When("^user clicks on already existing lead with name (.+)$")
	public void user_clicks_on_already_existing_lead_with_name(String leadName) {
		try {
			lo.editLeadRecord(leadName);
			logs.info("User has successfully clicked on "+leadName);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	@Then("^user clicks on convert button and should get correct message (.+)$")
	public void user_clicks_on_convert_button_and_should_get_correct_message(String message){
		try {
			Message = lo.clickOnConvertButton();
			logs.info("Actual Message === "+Message);
			logs.info("Expected Message === "+message);
			Assert.assertTrue(Message.equalsIgnoreCase(message), "Matched");
			logs.info("Lead Has been converted to opportunity successfully");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Then("^user click on opportunity link to navigate to Opportunity page$")
	public void user_click_on_opportunity_link_to_navigate_to_Opportunity_page() {
		try{
			oo = new OpportunityObject(driver);
			lo.clickOnOpportunityLink();
			logs.info("User navigated to opporunity page successfully");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Then("^user adds product and select pricebook (.+) to the opportunity$")
	public void user_adds_product_to_the_opportunity(String pricebookName) {
		oo.addProductOnOpportunityObject(pricebookName);
		logs.info(pricebookName+" have been added to opporunity");
	}
	
	@Then("^user selects product (.+) name$")
	public void user_selects_product_name(String productName) {
		oo.clickOnAddProductLink();
		oo.selectProductsOnOpportunityObject(productName);
		logs.info(productName+" product has been added to opportunity");

	}
	
	@Then("^user provides the quantity (.+) of products to be added$")
	public void user_provides_the_quantity_of_products_to_be_added(String quantity) {
		oo.moveToNextSteps(quantity);
	}
	
	
	@Then("^user selects (.+) stage to close the opportunity$")
	public void user_selects_closed_stage_to_close_the_opportunity(String ClosedStage) {
		oo.selectClosedStage(ClosedStage);
	}
	
	
	@When("^user provide information for account creation with AccountName (.+) Rating (.+) Phone (.+) AnnualRevenue (.+) Billing Street (.+) Billing City (.+) Billing Province (.+) Billing Country (.+) Billing Zipcode (.+)$")
	public void user_provide_information_for_account_creation_with_account_name_akshay_ki_rating_hot_phone_annual_revenue_billing_street_rue_scott_billing_city_montreal_billing_province_qc_billing_country_ca_billing_zipcode_h4m1t2 (String accountName,	String rating, String phone, String annualRevenue, String billingStreet, String billingCity, String billingProvince, String billingCountry, String billingZipcode) {
		ao = new AccountsObject(driver);
		ao.provideAccountInformationDetails(accountName, rating, phone, annualRevenue, billingStreet, billingCity, billingProvince, billingCountry, billingZipcode);
		//ao.createNewContact(billingCity, billingProvince, accountName, billingCountry, billingZipcode);

	}
	
	
	@And("^user provides contact details like saluation (.+) first name (.+) last name (.+) dateofbirth (.+) email (.+)$")
	public void user_provides_contact_details_like_saluation_saluation_first_name_firstname_last_name_lastname_dateofbirth_dob_email_email(String salua, String firName, String lasName, String dob, String email ) {
	      ao.createNewContact(salua, firName, lasName, dob, email);
	}
	
	
	//**** Case Creation *****
	
	@When("^user provides information case origin (.+) contact name (.+) account name (.+) for creating a case$")
	public void user_provides_information_caseorigin_contactname_accountname_for_creating_a_case(String caseOrigin, String contactName, String accountName) {
		ca = new CasesObject(driver);
		ca.fillCaseCreationDetails(caseOrigin, contactName, accountName);		
		
	}
	
	@When("^user provides Subject (.+) and Description (.+)$")
	public void When_user_provides_Subject_Description (String subject, String description) {
		ca.provideSubjectAndDescription(subject, description);
	}
	
	@When("^user successfully creates the case with message (.+)$")
	public void user_successfully_creates_the_case_with_msg(String mesg) throws InterruptedException {
		msgeoncasecreation = ca.savesTheCase();
		Assert.assertTrue(msgeoncasecreation.contains(mesg), "Matched");
	}


	
	
	@AfterStep
	public void takeScreenshotsAfterEveryStep(Scenario scenario) {
		//logs.info("Present in Hook Class");
		//if(scenario.isFailed())	{
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src,"image/png" , scenario.getName());
			
		//}
	}
	
	
	

}
