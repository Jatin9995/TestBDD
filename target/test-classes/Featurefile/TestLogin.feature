Feature: Lohin to nopcommerce.com website
  I want to login to the nopcommerce.com website

 @Sanity
  Scenario: Login to the nopcommerse website with valid credentials
  
  Given User launched chrome browser
    When user open the URL as "https://admin-demo.nopcommerce.com"
    And Enter Email id as "admin@yourstore.com" and password as "admin"
    And Click on Login button
    Then Use see the home page having page title "Dashboard / nopCommerce administration"
    When Use click on logout button
    Then Page title should be "Your store. Login"
    And User close the browser
    
   @regression
   Scenario Outline:  Login to the nopcommerse website with valid credentials using DDT
   
   Given User launched chrome browser
    When user open the URL as "https://admin-demo.nopcommerce.com"
    And Enter Email id as "<email>" and password as "<password>"
    And Click on Login button
    Then Use see the home page having page title "Dashboard / nopCommerce administration"
    When Use click on logout button
    Then Page title should be "Your store. Login"
    And User close the browser
    
   

    Examples: 
      |email  |password|
      |admin@yourstore.com |admin|
      |test@yourstore.com|admin|
