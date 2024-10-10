@tagone
Feature: This is to verify the feature is working as expected 

  @tag1
  Scenario: Login In the application with email and clicking the ok button
    Given I am entering the email id
    Then I select the country "Australia" from the dropdown "text"
    And I enter the manatory field
    And I click on Refresh button
    Then Verify the valid links