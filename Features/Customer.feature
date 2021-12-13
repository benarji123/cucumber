Feature: customer
 Background:  for Below steps common for all scenarios
    Given User Lanch Chrome Browser
     When User Open URL as "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
     And User enters Email as "admin@yourstore.com" and Password as "admin"
     And click on Login
@regression
Scenario: Add a new Customer
     Then user can view Dashboad
     When user click on customer menu
     And click on customer menu item
     And click on Add new Button
     Then user can see customer creation page
     When user enter customer info
     And click save button
     Then user should see "The new customer has been added successfully."
     And close the browser
@regression  
Scenario: Search customer by Eamilid
     When user click on customer menu
     And click on customer menu item
     And Enter customer email
     When user click search button
     Then user should found email in search table
     And close the browser
Scenario: Search customer by firstname and lastname
     When user click on customer menu
     And click on customer menu item
     And Enter customer firstname and lastname
     When user click search button
     Then user should found lastname and firstname in search table
     And close the browser