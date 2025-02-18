Feature: Flow for Managing the Case

  Background: 
    Given I have landed on salesforce page

  @CasesCreationFlow
  Scenario Outline: Creating a New Case
    Given User Login in salesforce using username <username> and password <password>
    When user navigates to desired <AppName> App
    When user navigates to <objectName> Object
    When user clicks on <buttonName> button
    When user provides information case origin <caseOrigin> contact name <contactName> account name <accountName> for creating a case
    When user provides Subject <Subject> and Description <Description>
    When user successfully creates the case with message <message>

    Examples: 
      | username                     | password        | AppName | buttonName | objectName | caseOrigin | contactName | accountName | Subject          | Description      | message      |
      | akskinhikar@deloitte.sandbox | Shriram@Jan2024 | Sales   | New        | Cases      | Phone      | AkshayKin22 | AkshayKin22 | New Case Created | New Case Created | was created. |
