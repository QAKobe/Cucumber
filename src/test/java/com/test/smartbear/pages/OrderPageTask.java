package com.test.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class OrderPageTask {

    public OrderPageTask(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='ctl00$MainContent$username']")
    WebElement userNameField;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//a[@href='Process.aspx']")
    WebElement orderButton;

    @FindBy(xpath = "//select[@name='ctl00$MainContent$fmwOrder$ddlProduct']")
    WebElement selectScreenSaver;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']")
    WebElement quantity;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_txtName']")
    WebElement customerName;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox2']")
    WebElement streetLine;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox3']")
    WebElement city;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox4']")
    WebElement state;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox5']")
    WebElement zipcode;

    @FindBy(xpath = "//input[@value='Visa']")
    WebElement visa;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")
    WebElement cardNumber;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox1']")
    WebElement expirationDate;

    @FindBy(xpath = "//a[@id='ctl00_MainContent_fmwOrder_InsertButton']")
    WebElement clickProcess;

    @FindBy(xpath = "//strong")
    WebElement textMessage;

    public void login(String username, String password){
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void orderButton(){
        orderButton.click();
    }

    public void choosesScreenSaverAndQuantity(String screen, String quantity) throws InterruptedException {
        Thread.sleep(2000);
        BrowserUtils.selectBy(selectScreenSaver, screen, "value");
        this.quantity.clear();
        Thread.sleep(3000);
        this.quantity.sendKeys(quantity);

    }

    public void userNameAndLastName(String names){
        customerName.sendKeys(names);
    }

    public void streetAndCity(String street, String city){
        this.streetLine.sendKeys(street);
        this.city.sendKeys(city);
    }

    public void stateAndZipcode(String state, String zipcode){
        this.state.sendKeys(state);
        this.zipcode.sendKeys(zipcode);
    }

    public void checkVisa(){
        visa.click();
    }

    public void cardNumberAndEx(String cc, String ex){
        cardNumber.sendKeys(cc);
        expirationDate.sendKeys(ex);
        clickProcess.click();
    }
    public void validateText(String text){
        Assert.assertTrue(BrowserUtils.getText(textMessage).contains(text));
    }


}
