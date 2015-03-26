Feature: Search Bing again for information on Partnet

  @htmlunit
  Scenario: Search bing for Partnet again
    Given I am on Bing's home page
    When I search for Partnet
    Then I will see Partnet's home page in the list of results