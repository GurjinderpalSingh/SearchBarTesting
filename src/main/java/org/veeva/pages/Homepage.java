package org.veeva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Homepage {

    private WebDriver driver;

    //Locators
    private By searchBar = By.id("twotabsearchtextbox");
    private By srchbtn =  By.id("nav-search-submit-button");

    //constructor
    public Homepage(WebDriver driver){
        this.driver = driver;
    }

    //methods

    //method to add text to search box
    public void addSearchtext(String text){
        driver.findElement(searchBar).sendKeys(text);
    }


    // method to click search button
    public void clickSearchBtn(){
        driver.findElement(srchbtn).click();
    }




}
