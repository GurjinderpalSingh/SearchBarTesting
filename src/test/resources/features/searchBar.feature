Feature: Searchbar functionality on e-commerce site
  test the functionality of search bar using different input scenarios


  Background:
    Given User is on Amazon homepage

  Scenario: Valid search term in the searchBar
    Given user search for "laptop"
    When  user click search button
    Then user should see search results for "laptop"

  Scenario: user click search btn without putting any text in the searchbar
    Given user does not put any term in search Bar
    When  user click search button
    Then user should redirected to home page

  Scenario:  invalid search term in the search bar
    Given User search with invalid input "9877565kbmnhfcdxhzgjrcnhkj" in search bar
    When user click search button
    Then User should be showed no results found message

  Scenario: User is showed suggestion when typing item in search bar
    When user typing search item "laptop" in search bar
    Then I should see search suggestions


  Scenario: search results pagination
