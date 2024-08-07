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
    When user typing search item "lap" in search bar
    Then I should see search suggestions with "lap"


  Scenario: search results pagination
    Given user search for "mobile"
    And  user click search button
    When User navigate to second page of results
    Then user should see second page of results

  Scenario: Search with filter criteria
    Given user search for "laptop"
    And user click search button
    And user should see search results for "laptop"
    When user apply the brand filter "Dell"
    Then user should see search results filtered by brand "Dell"

  Scenario: Search with categories
    When User select the category "Electronics"
    And user search for "laptop"
    And user click search button
    Then User should see search results for "laptop" in the "Electronics" category

