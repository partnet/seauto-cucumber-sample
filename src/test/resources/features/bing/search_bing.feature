Feature: Search Bing for information

  @firefox
  Scenario: Search bing for Partnet
    Given I am on Bing's home page
    When I search for Partnet
    Then I will see Partnet's home page in the list of results