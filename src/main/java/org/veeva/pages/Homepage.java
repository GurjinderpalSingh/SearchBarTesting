package org.veeva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Homepage {

    private WebDriver driver;
    WebDriverWait wait ;

    //constructor
    public Homepage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Locators
    private By searchBar = By.id("twotabsearchtextbox");
    private By srchbtn =  By.id("nav-search-submit-button");



    //methods

    //method to add text to search box
    public void addSearchtext(String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(searchBar));
        driver.findElement(searchBar).sendKeys(text);
    }

    // method to click search button
    public void clickSearchBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(srchbtn));
        driver.findElement(srchbtn).click();
    }

    //method to check it is homepage
    public String checkPageUrl(){
       return driver.getCurrentUrl();
    }




}
