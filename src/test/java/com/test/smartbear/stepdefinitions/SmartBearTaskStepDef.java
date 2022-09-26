package com.test.smartbear.stepdefinitions;

import com.test.smartbear.pages.OrderPageTask;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class SmartBearTaskStepDef {

    WebDriver driver = DriverHelper.getDriver();

    OrderPageTask orderPageTask = new OrderPageTask(driver);

    @When("User enters username and password and clicks loging button")
    public void user_enters_username_and_password_and_clicks_loging_button() {
        orderPageTask.login(ConfigReader.readProperty("username"), ConfigReader.readProperty("password"));
    }

    @Then("User clicks order button")
    public void user_clicks_order_button() {
        orderPageTask.orderButton();
        Assert.assertTrue(driver.getTitle().contains("Web Order"));
    }

    @Then("User chooses {string} and provides quantity as {string}")
    public void user_chooses_and_provides_quantity_as(String screen, String quantity) throws InterruptedException {
        orderPageTask.choosesScreenSaverAndQuantity(screen, quantity);
    }

    @Then("User provides his or her {string} and {string}")
    public void user_provides_his_or_her_and(String name, String lastname) {
        orderPageTask.userNameAndLastName(name);
    }

    @Then("User provides {string} and {string}")
    public void user_provides_and(String street, String city) {
        orderPageTask.streetAndCity(street, city);

    }

    @Then("User provides {string} and {string} and fills it")
    public void user_provides_and_and_fills_it(String il, String zip) {
        orderPageTask.stateAndZipcode(il, zip);
    }

    @Then("User checks visa")
    public void user_checks_visa() {
        orderPageTask.checkVisa();
    }

    @Then("User provides {string} and {string} and clicks proceed button")
    public void user_provides_and_and_clicks_proceed_button(String cc, String ex) {
        orderPageTask.cardNumberAndEx(cc, ex);
    }

    @Then("User validates {string} at the end")
    public void user_validates_at_the_end(String text) {
        orderPageTask.validateText(text);
    }


    // using DATA TABLE
    @Then("User chooses and provides quantity as")
    public void user_chooses_and_provides_quantity_as(DataTable dataTable) throws InterruptedException {
        Map<String, String> productInformation = dataTable.asMap();
        orderPageTask.choosesScreenSaverAndQuantity(productInformation.get("productName"), productInformation.get("Quantity"));
    }

    @Then("User provides his and info")
    public void user_provides_his_and_info(DataTable dataTable) {
        Map<String, String> names = dataTable.asMap();
        orderPageTask.userNameAndLastName(names.get("customerName"));
    }

    @Then("User provides  and")
    public void user_provides_and(DataTable dataTable) {
        Map<String, String> address = dataTable.asMap();
        orderPageTask.streetAndCity(address.get("street"), address.get("city"));

    }

    @Then("User provides  and  and fills it")
    public void user_provides_and_and_fills_it(DataTable dataTable) {
        Map<String, String> stateZip = dataTable.asMap();
        orderPageTask.stateAndZipcode(stateZip.get("state"), stateZip.get("zipcode"));
    }

    @Then("User provides  and  and clicks proceed button")
    public void user_provides_and_and_clicks_proceed_button(DataTable dataTable) {
        Map<String, String> ccEx = dataTable.asMap();
        orderPageTask.cardNumberAndEx(ccEx.get("cardNumber"), ccEx.get("expDate"));
    }

    @Then("User validates at the end")
    public void user_validates_at_the_end(DataTable dataTable) {
        List<String>message = dataTable.asList();
        orderPageTask.validateText(message.get(0));
    }


}
