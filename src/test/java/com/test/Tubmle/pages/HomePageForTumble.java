package com.test.Tubmle.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageForTumble {

    public HomePageForTumble(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[.='Log in']")
    WebElement loginButton;

    @FindBy(xpath = "//button[.='Continue with email']")
    WebElement loginWithEmail;

    @FindBy(xpath = "//input[@name='email']")
    WebElement enterEmail;

    @FindBy(xpath = "//div[@class='CkEXb']") // CkEXb
    WebElement errorMessage;

    public void loginButton(){
       loginButton.click();
    }
    public void clickContinueWithEmail() throws InterruptedException {
        Thread.sleep(2000);
        loginWithEmail.click();
    }

    public void enterEmailAndValidateMesssage(String email){
        enterEmail.sendKeys(email, Keys.ENTER);
        String actualText = errorMessage.getText();
        String expectedText = "That's not a valid email address. Please try again.";
        if (errorMessage.isDisplayed()){
            Assert.assertEquals(actualText, expectedText);
            System.out.println(actualText);
            System.out.println(expectedText);
        }
    }
}
