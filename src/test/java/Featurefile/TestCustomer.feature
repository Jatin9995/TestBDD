Feature: Customer Details like adding and finding details by name and email id

Background: Steps common for all scenarios
    Given User launched chrome browser
    When user open the URL as "https://admin-demo.nopcommerce.com"
    And Enter Email id as "admin@yourstore.com" and password as "admin"
    And Click on Login button
    Then Use see the home page having page title "Dashboard / nopCommerce administration"
    When User click on Customer Menu
    And click on Customer Menu Item

  @regression
  Scenario: Add New customer
    
    And click on Add new Customer option
    Then User can view the add new ustomer page
    When User enter customer info
    And Click on save button
    Then user can view message "The new customer has been added successfully."
     And User close the browser	

  @regression
  Scenario: Search customer by Email

    And enter customer email id
    When use clicked on search button
    Then use found email in the search table
    And User close the browser
    
    @regression
     Scenario: Search customer by name
   
    And User enter First name
    And User enter Last name
    When use clicked on search button
   Then User should found Name in the search table
    And User close the browser

  
  
  
  
  
  
  
