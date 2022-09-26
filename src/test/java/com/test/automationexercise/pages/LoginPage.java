package com.test.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[.='New User Signup!']")
    WebElement header;

    @FindBy(xpath = "//input[@name='name']")
    WebElement nameField;

    @FindBy(xpath = "//input[@name='email' and @data-qa='signup-email']") // remember this one
    WebElement emailField;

    @FindBy(xpath = "//button[.='Signup']")
    WebElement clickSignUp;

    public boolean validateHeader(){
        return header.isDisplayed();
    }

    public void enterNameAndEmail(String name, String email){
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        clickSignUp.click();
    }



}
