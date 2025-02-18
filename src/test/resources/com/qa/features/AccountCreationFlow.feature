Feature: Flow for Account Creation

  Background: 
    Given I have landed on salesforce page

 @AccountCreationFlow
  Scenario Outline: Creating a New Account
    Given User Login in salesforce using username <username> and password <password>
    When user navigates to desired <AppName> App
    When user navigates to <objectName> Object
    When user clicks on <buttonName> button
    When user provide information for account creation with AccountName <accountName> Rating <rating> Phone <phone> AnnualRevenue <annualRevenue> Billing Street <billingStreet> Billing City <billingCity> Billing Province <billingProvince> Billing Country <billingCountry> Billing Zipcode <billingZipcode>
    And user provides contact details like saluation <saluation> first name <firstname> last name <lastname> dateofbirth <dob> email <email>

    Examples: 
      | username                     | password        | AppName | objectName | buttonName | accountName | rating | phone     | annualRevenue | billingStreet | billingCity | billingProvince | billingCountry | billingZipcode | saluation | firstname | lastname | dob        | email        |
      | akskinhikar@deloitte.sandbox | Shriram@Jan2024 | Sales   | Accounts   | New        | AkshayKin22 | Hot    | 123456781 |         11001 | Rue Scott     | Montreal    | QC              | CA             | H4M1T2         | Mr.       | Aksay     | Kinhik   | 2000-01-20 | ajs@gmai.com |
