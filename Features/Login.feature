Feature: Login 

  @sanity @regression
  Scenario: Successful Login with Valid Credentials
     Given User Lanch Chrome Browser
     When User Open URL as "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
     And User enters Email as "admin@yourstore.com" and Password as "admin"
     And click on Login
     Then  Page title should be "Dashboard / nopCommerce administration"
     When click on logout link
     Then Page title should be "Your store. Login"
     And close the browser
    
  Scenario Outline: Data Driven login
     Given User Lanch Chrome Browser
     When User Open URL as "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
     And User enters Email as "<email>" and Password as "<password>"
     And click on Login
     Then  Page title should be "Dashboard / nopCommerce administration"
     When click on logout link
     Then Page title should be "Your store. Login"
     And close the browser
     Examples:
     |email| password|
     |admin@yourstore.com|admin|
     |admin@yourstore.com|admin123|
     