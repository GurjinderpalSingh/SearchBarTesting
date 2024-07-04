package org.veeva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResults {
    private WebDriver driver;

    //constructor
    public SearchResults(WebDriver driver){
        this.driver = driver;
    }

    // By Locators
    private By searchresults = By.xpath("//div[@class=\"s-main-slot s-result-list s-search-results sg-row\"]/div");
    private By noresultfound = By.xpath("//div[@data-cel-widget='MAIN-MESSAGING-1']//span[contains(text(),'No results for')]");
    private By searchSuggestion = By.xpath("//div[@class=\"s-suggestion-container\"]/div[@role=\"button\"]");
    //Methods

    // method to return search results as list
    public List<WebElement> getSearchResults(){
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
        return driver.findElement(noresultfound);
    }

    public List<WebElement> getSearchSuggestions()
    {
        return driver.findElements(searchSuggestion);
    }

    public boolean checkSuggestionDisplayed(String string){
        List <WebElement> suggestions = getSearchSuggestions();
        return suggestions.get(0).getText().contains(string);
     }


}
