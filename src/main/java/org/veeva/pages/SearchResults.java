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
            if(!e.getText().contains(text)){
                return false;
            }
        }
        return true;
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


}
