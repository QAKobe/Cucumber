package com.test.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class OrderPage {

    public OrderPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='ConfirmAddressID']")
    WebElement selectOffice;

    @FindBy(xpath = "//label[@class='custom-control-label']")
    WebElement groupOrderBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement nextButton;

    @FindBy(xpath = "//textarea[@id='InviteNote']")
    WebElement textArea;

    @FindBy(xpath = "//textarea[@id='InviteList']")
    WebElement textAreaList;

    @FindBy(xpath = "//select[@id='ConfirmAddressID']")
    WebElement location;

    @FindBy(xpath = "//div[@id='addressPreview']")
    WebElement address;

    @FindBy(xpath = "//button[@id='createGroupOrder']")
    WebElement createGroupOrderButton;

    @FindBy(tagName = "h1")
    WebElement header;

    @FindBy(xpath = "//label[.='Total Participants:']//following-sibling::div")
    WebElement totalParticipant;

    public void clickButtons(){
        //BrowserUtils.selectBy(selectOffice, "Office", "value");
        groupOrderBox.click();
        nextButton.click();
    }

    public void sendInvitees(String invitees){
        textArea.sendKeys(invitees);
    }

    public void sendInviteesList(String email1, String email2){
        textAreaList.sendKeys(email1 +", " +email2);
    }

    public void locationAndAddress(String location, String address){
        BrowserUtils.selectBy(this.location, location, "text");
        Assert.assertTrue(BrowserUtils.getText(this.address).contains(address));
    }

    public void clickGroupOrderButton(){
        createGroupOrderButton.click();
    }

    public String validateHeader() throws InterruptedException {
        Thread.sleep(3000);
        return BrowserUtils.getText(header);
    }

    public int validateParticipant(){
        return Integer.parseInt(BrowserUtils.getText(totalParticipant));
    }



}
