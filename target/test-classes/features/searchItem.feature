Feature: GreenCart Search experience
  
  @OffersPage
  Scenario Outline: Item search experience
    Given User is in the Greencart Landing Page 
    When User searches with the item short name <Name> in Landing Page
    And Extracts the actual product name from Landing Page
    And User moves to Offers Page
    Then User searches with the same item short name <Name> in Offers Page
    And Check whether same items are being displayed in the Offers Page

Examples:
	|Name|
	|Tom |
	