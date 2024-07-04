package org.veeva.stepdefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.veeva.pages.Homepage;
import org.veeva.pages.SearchResults;

import javax.accessibility.AccessibleAttributeSequence;
import java.time.Duration;


public class searchBarstepdef {
    WebDriver driver = Hooks.driver;
    Homepage homepage;
    SearchResults searchresults;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("User is on Amazon homepage")
    public void userIsOnAmazonHomepage() {
        driver.get("https://www.amazon.ca/");
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("navbar")));
        homepage = new Homepage(driver);
        searchresults = new SearchResults(driver);
    }

    @Given("user search for {string}")
    public  void user_search_for(String string){
        homepage.addSearchtext(string);
    }

    @When("user click search button")
    public void userClickSearchButton() {
        homepage.clickSearchBtn();
    }

    @Then("user should see search results for {string}")
    public void user_should_see_results_for(String string){
        searchresults.getSearchResults();
        Assert.assertTrue(searchresults.resultsContainsSearchText(string));
    }

    @Given("user does not put any term in search Bar")
    public void userDoesNotPutAnyTermInSearchBar() {
        homepage.addSearchtext("");
    }

    @Then("user should redirected to home page")
    public void userShouldRedirectedToHomePage() {
        Assert.assertEquals(homepage.checkPageUrl(),"https://www.amazon.ca/");
    }

    @Given("User search with invalid input {string} in search bar")
    public void userSearchWithInvalidInputInSearchBar(String string) {
        homepage.addSearchtext(string);
        homepage.clickSearchBtn();
    }

    @Then("User should be showed no results found message")
    public void userShouldBeShowedNoResultsFoundMessage() {
        Assert.assertTrue(searchresults.noResultFound().isDisplayed());
    }

    @When("user typing search item {string} in search bar")
    public void userTypingSearchItemInSearchBar(String string) {
        homepage.addSearchtext(string);
    }

    @Then("I should see search suggestions with {string}")
    public void iShouldSeeSearchSuggestions(String string) {
       Assert.assertTrue(searchresults.checkSuggestionDisplayed(string));

    }

    @When("User navigate to second page of results")
    public void userNavigateToSecondPageOfResults() {
        searchresults.goToSecondPageOFResults();
    }

    @Then("user should see second page of results")
    public void userShouldSeeSecondPageOfResults() {
        Assert.assertTrue(searchresults.isPage2());
    }

    @When("user apply the brand filter {string}")
    public void ApplyTheBrandFilter(String string) {
        searchresults.selectFilter(string);
    }

    @Then("user should see search results filtered by brand {string}")
    public void userShouldSeeSearchResultsFilteredByBrand(String brand) {
        searchresults.getSearchResults();
        Assert.assertTrue(searchresults.ResultsContainBrand(brand));
    }

    @When("User select the category {string}")
    public void userSelectTheCategory(String category) {
        homepage.selectCategory(category);
    }

    @Then("User should see search results for {string} in the {string} category")
    public void userShouldSeeSearchResultsForInTheCategory(String item, String category) {
        searchresults.getSearchResults();
        Assert.assertTrue(searchresults.resultsContainsSearchText(item));
        Assert.assertTrue(searchresults.isSearchResultsOfCategory(category));
    }
}
