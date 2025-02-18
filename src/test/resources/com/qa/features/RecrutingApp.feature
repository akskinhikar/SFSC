Feature: Creating New Position in the Recruting App


  Background: 
    Given I have landed on salesforce page
    
  @NewPositionCreation
  Scenario Outline: Positive test for creating a new poistion in salesforce
    Given User Login in salesforce using username <username> and password <password>
    When user navigates to Recruting App
    And user provids Position Name <PositionName> and clicks on saves button
    Then user verify the position creation message <message> is correct
    And user logs out of salesforce

    Examples: 
      | username                     | password        | PositionName	| message 												|
      | akskinhikar@deloitte.sandbox | Shriram@Jul2023 | test02				| Position "test02" was created. 	|

      
      
  @EditPositionCreation
  Scenario Outline: Positive test for creating a new poistion in salesforce
    Given User Login in salesforce using username <username> and password <password>
    When user navigates to Recruting App
    And user selects position record
    Then user verify the edit position message <message> is correct
    And user logs out of salesforce

    Examples: 
      | username                     | password        | message 												|
      | akskinhikar@deloitte.sandbox | Shriram@Jul2023 | Position "test02" was saved.  	|
	  