package org.veeva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResults {
    private WebDriver driver;
    WebDriverWait wait ;


    //constructor
    public SearchResults(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // By Locators
    private By searchresults = By.xpath("//div[@class=\"s-main-slot s-result-list s-search-results sg-row\"]/div");
    private By noresultfound = By.xpath("//div[starts-with(@data-cel-widget,'MAIN-MESSAGING')]//span[contains(text(),'No results for')]");
    private By searchSuggestion = By.xpath("//div[@class=\"s-suggestion-container\"]/div[@role=\"button\"]");
    private By page2btn = By.xpath("//a[normalize-space()='2']");


    //Methods

    // method to return search results as list
    public List<WebElement> getSearchResults(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchresults));
        return driver.findElements(searchresults);
    }

    //method to check if search results contain searched text
    public boolean resultsContainsSearchText(String text){
        List<WebElement> results = getSearchResults();
        for(WebElement e : results){
            if(e.getText().toLowerCase().contains(text.toLowerCase())){
                return true;
            }
        }
        return false;
    }

    //method to heck no results found
    public WebElement noResultFound(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(noresultfound));
        return driver.findElement(noresultfound);
    }

    public List<WebElement> getSearchSuggestions()
    {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchSuggestion));
        return driver.findElements(searchSuggestion);
    }

    public boolean checkSuggestionDisplayed(String string){
        List <WebElement> suggestions = getSearchSuggestions();
        return suggestions.get(0).getText().contains(string);
     }


    public void goToSecondPageOFResults(){

        wait.until(ExpectedConditions.elementToBeClickable(page2btn));
        driver .findElement(page2btn).click();
    }

    public boolean isPage2(){
       return driver.getCurrentUrl().contains("page=2");

    }

    public void selectFilter(String brand){
        By brandFilterCheckbox = By.xpath("//span[text()='" + brand + "']/preceding-sibling::div");
        WebElement brandFilterElement = wait.until(ExpectedConditions.elementToBeClickable(brandFilterCheckbox));
        brandFilterElement.click();
    }

    public boolean ResultsContainBrand(String brand) {
        List<WebElement> searchResults = getSearchResults();
        for (WebElement result : searchResults) {
            if (result.getText().toLowerCase().contains(brand.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

   public boolean isSearchResultsOfCategory(String category){
        String url = driver.getCurrentUrl().toLowerCase();
        System.out.println(url);
        return url.contains(category.toLowerCase());
   }
}
