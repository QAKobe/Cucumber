package com.test.etsy.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;

public class MainPage {

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@data-id='search-query']")
    WebElement searchBar;


    public void search(String item){
        searchBar.sendKeys(item, Keys.ENTER);
    }




}
