package com.test.amazon.pages;


import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.security.Key;
import java.util.List;

public class HomePage {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement searchBar;

    @FindBy(xpath = "//span[contains(text(),'results for')]")
    WebElement foundResultsNumber;

    @FindBy(tagName = "h2")
    List<WebElement> allHeaders;

    public void findSeiko(String name){
        searchBar.sendKeys(name, Keys.ENTER);
    }
    public void validateResult(){
        Assert.assertTrue(BrowserUtils.getText(foundResultsNumber).toLowerCase().contains("60,000"));
    }

    public void validateHeaders(String words){
      for (WebElement header : allHeaders){
          if (!BrowserUtils.getText(header).equals("")){
              Assert.assertTrue(BrowserUtils.getText(header).toLowerCase().contains(words));
          }
      }

    }
}
