Feature: Login Functionality for OpenCart E-Commerce Website

	As a user of OpenCart website
	I want to be able to login in my account
	So that I can access my account related infomration
	
	Background: 
	Given I am on OpenCart Login page
	
	Scenario: Successful login with valid credentials
		Given I have entered a valid username and password
		When I click on the login button
		Then User should be successfully logged in.

		Scenario Outline: Unsuccessful login with an invalid credentials
		Given I have entered a invalid "<username>" and "<password>"
		When I click on the login button
		Then User should not be successfully logged in and user should see error message "<error_message>"
		
		Examples:
					
		  | username  			| password 			| error_message  																 |				
      | baba@gmail.com 	|   atlas@12 		| Warning: No matche for E-Mail and/or Password. |
      | atlas 					|   validpass 	| Warning: No matche for E-Mail and/or Password. |       																				
      | valid@gmail.com | 	abcccd 	    | Warning: No matche for E-Mail and/or Password. |
     
 
 
    Scenario: Navigating to your forgotten password page
		When I click on the "Forgotten Password" link.
		Then I should be redirected to the password reset page.
		
		