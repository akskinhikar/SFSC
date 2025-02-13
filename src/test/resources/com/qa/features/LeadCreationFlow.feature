Feature: Creating Lead Creation and Update Flow

  Background: 
    Given I have landed on salesforce page
    

  @NewLeadCreation
  Scenario Outline: Creating a new Lead
    When User logs in by using username <username> and password <password>
    When user navigates to marketing crm app
    #When user navigates to <objectName> Object
    #When user clicks on <buttonName> button
    #When user provide information regarding first name <FirstName> last name <LastName> company <Company> lead source <LeadSource> mobile <Mobile>
    #Then user verify the tost message <message> during new lead creation

    #    And user provids Campaign Name <CampaignName> and Expected Revenue <ExpRevenue> and submits order
    #   Then user verify the message <message> is correct
    #   And user logs out of salesforce
    Examples: 
      | username                     | password        | objectName | buttonName | FirstName | LastName | Company | LeadSource | Mobile     | message                           |
      | akskinhikar@deloitte.sandbox | Shriram@Jan2025 | Leads      | New        | Akshay    | Kinhik   | ABCDE   | Web        | 1234567890 | Lead "Akshay Kinhik" was created. |