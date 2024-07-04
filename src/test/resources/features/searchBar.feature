Feature: Searchbar functionality on e-commerce site
  test the functionality of search bar using different input scenarios


  Background:
    Given User is on Amazon homepage

  Scenario: Valid search term in the searchBar
    Given user search for "laptop"
    When  user click search button
    Then user should see search results for "laptop"
