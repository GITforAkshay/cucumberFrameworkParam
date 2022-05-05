Feature: Checkout experience
  
  @Checkout
  Scenario Outline: Items added to cart for checkout
    Given User is in the Greencart Landing Page 
    When User searches with the item short name <Name> in Landing Page
    And Extracts the actual product name from Landing Page
    And Added "3" items of the selected product into the cart
    Then User proceeds to checkout and validate the <Name> items in Checkout Page
    And Verify user has ability to enter promo code and place the order

Examples:
	|Name|
	|Tom |
	|Beet|
	|Cap |
	
