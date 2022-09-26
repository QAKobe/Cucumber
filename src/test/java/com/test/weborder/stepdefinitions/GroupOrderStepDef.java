package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.OrderPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class GroupOrderStepDef {

    WebDriver driver = DriverHelper.getDriver();
    OrderPage orderPage = new OrderPage(driver);

    @When("User click Group Order Box and Next Button")
    public void user_click_group_order_box_and_next_button() {
        orderPage.clickButtons();
    }

    @When("User sends the word {string}")
    public void user_sends_the_word(String invitees) {
        orderPage.sendInvitees(invitees);
    }

    @When("User sends e-mail addresses which are {string} and {string} to Invite List")
    public void user_sends_e_mail_addresses_which_are_and_to_invite_list(String email1, String email2) {
        orderPage.sendInviteesList(email1, email2);
    }

    @When("User chooses the delivery address {string} and validate the address {string}")
    public void user_chooses_the_delivery_address_and_validate_the_address(String location, String address) {
        orderPage.locationAndAddress(location, address);
    }

    @When("User clicks create group order button")
    public void user_clicks_create_group_order_button() {
        orderPage.clickGroupOrderButton();
    }

    @Then("User validates the header of page which is {string}")
    public void user_validates_the_header_of_page_which_is(String expectedHeader) throws InterruptedException {
        Assert.assertEquals(expectedHeader, orderPage.validateHeader());
    }

    @Then("User validates total participant is {int}")
    public void user_validates_total_participant_is(int expectedParticipant) {
        Assert.assertEquals(expectedParticipant, orderPage.validateParticipant());
    }


}
