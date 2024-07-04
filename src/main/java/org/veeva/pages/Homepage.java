package org.veeva.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Homepage {

    private WebDriver driver;
    WebDriverWait wait ;
    Select select;

    //constructor
    public Homepage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Locators
    private By searchBar = By.id("twotabsearchtextbox");
    private By srchbtn =  By.id("nav-search-submit-button");
    private By categoryDropdown = By.xpath("//select[@id=\"searchDropdownBox\"]");



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

    //select category
    public void selectCategory(String category) {
        select= new Select(driver.findElement(categoryDropdown));
        select.selectByVisibleText(category);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(categoryDropdown));
        //driver.findElement(categoryDropdown).click();
        //WebElement categoryOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[text()='" + category + "']")));
        //categoryOption.click();
    }





}
