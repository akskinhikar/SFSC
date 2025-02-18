Feature: Creating New Campaingns in Salesforce
  I want to use this template for my feature file

  Background: 
    Given I have landed on salesforce page

  @NewCampaignsCreation
  Scenario Outline: Positive test for creating a new campaigns in salesforce
    Given User Login in salesforce using username <username> and password <password>
    When user navigates to Marketing App
    And user provids Campaign Name <CampaignName> and Expected Revenue <ExpRevenue> and submits order
    Then user verify the message <message> is correct
    And user logs out of salesforce

    Examples: 
      | username                     | password        | CampaignName           | ExpRevenue | message                                        |
      | akskinhikar@deloitte.sandbox | Shriram@Jan2024 | SalesforceJuntwentytwo |     110090 | Campaign "SalesforceJuntwentytwo" was created. |
      #| akskinhikar@deloitte.sandbox | Shriram@Jul2023 | SalesforceJuntwentyhree 	|     100093 | Campaign "SalesforceJuntwentyhree" was created.	|
