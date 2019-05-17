Feature: Test End to End Feature For Smartbear Application

  Scenario: User should be able to login smartbear application successfully
  	Given User navigates to smartbear homepage 
    When User enters username
    And User enters password
    And User clicks on login button
    Then User should land on weborders page
  
  Scenario: User should be able to process WebOrders successfully
   	Given User navigates to Process Order page
   	When User enters Product Information
   	And User enters Address Information
   	And User enters Payment Information
   	And User clicks on Process Button
   	Then Orders should be able to process successfully
   	
  Scenario: User should be able to delete the processed order successfully
  	Given User should be on the weborders page
  	When User selects the current order
  	And User clicks on delete selected
  	Then order should be successfully deleted
  	
   	
   	
