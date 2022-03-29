#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Regression
Feature: Navigate to Menu (Product Category) and Select a Product
  This feature will test the Navigation to a Product Category and will Select a product
@Positive
  Scenario: Navigate to Curtain Under Home and Kitchen product Category
    Given I am on the Shopclues homepage and Notification is closed
    When I click on ProductCategory "Home & Kitchen" and Product "Curtains"
    Then All Curtains are displayed on the a new page
    When I click on first product
    Then Curtains product page will be displayed
    And Upon clicking Product added to cart message will appear on clicking Add to cart

 

    
