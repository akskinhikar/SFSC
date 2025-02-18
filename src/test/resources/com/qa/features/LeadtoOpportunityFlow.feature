Feature: Creating End to End flow for Lead To Opportunity Flow

  Background: 
    Given I have landed on salesforce page

  @NewLeadCreation
  Scenario Outline: Creating a new Lead
    Given User Login in salesforce using username <username> and password <password>
    When user navigates to desired <AppName> App
    When user navigates to <objectName> Object
    When user clicks on <buttonName> button
    When user provide information regarding first name <FirstName> last name <LastName> company <Company> lead source <LeadSource> mobile <Mobile>
    Then user verify the tost message <message> during new lead creation

    #    And user provids Campaign Name <CampaignName> and Expected Revenue <ExpRevenue> and submits order
    #   Then user verify the message <message> is correct
    #   And user logs out of salesforce
    Examples: 
      | username                     | password        | AppName | objectName | buttonName | FirstName | LastName | Company | LeadSource | Mobile     | message                          |
      | akskinhikar@deloitte.sandbox | Shriram@Jan2024 | Sales   | Leads      | New        | Akshay    | Kinhi    | ABCD    | Web        | 1234567890 | Lead "Akshay Kinhi" was created. |

  @EditExistingLead
  Scenario Outline: Editing exiting Lead information
    Given User Login in salesforce using username <username> and password <password>
    When user navigates to desired <AppName> App
    When user navigates to <objectName> Object
    When user clicks on already existing lead with name <LeadName>

    #    And user provids Campaign Name <CampaignName> and Expected Revenue <ExpRevenue> and submits order
    #   Then user verify the message <message> is correct
    #   And user logs out of salesforce
    Examples: 
      | username                     | password        | AppName | objectName | LeadName     |
      | akskinhikar@deloitte.sandbox | Shriram@Jan2024 | Sales   | Leads      | Akshay Kinhi |

  @LeadToOpportunityFlow
  Scenario Outline: Creating a New Lead and converting it to opportunity
    Given User Login in salesforce using username <username> and password <password>
    When user navigates to desired <AppName> App
    When user navigates to <objectName> Object
    When user clicks on <buttonName> button
    When user provide information regarding first name <FirstName> last name <LastName> company <Company> lead source <LeadSource> mobile <Mobile>
    Then user verify the tost message <message> during new lead creation
    Then user clicks on convert button and should get correct message <leadconversionmessage>
    Then user click on opportunity link to navigate to Opportunity page
    Then user adds product and select pricebook <pricebookName> to the opportunity
    Then user selects product <productname> name
    Then user provides the quantity <quantity> of products to be added
    Then user selects <stage> stage to close the opportunity

    Examples: 
      | username                     | password        | AppName | objectName | buttonName | FirstName | LastName | Company | LeadSource | Mobile     | message                           | leadconversionmessage        | pricebookName | productname           | quantity | stage      |
      | akskinhikar@deloitte.sandbox | Shriram@Jan2024 | Sales   | Leads      | New        | Akshayb   | Kinhi    | ABCD    | Web        | 1234567890 | Lead "Akshayb Kinhi" was created. | Your lead has been converted | Standard      | GenWatt Diesel 1000kW |        5 | Closed Won |
