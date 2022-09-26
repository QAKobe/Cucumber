package com.test.amazon.stepdefinitions;

import com.test.amazon.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class SearchStepDef {

    WebDriver driver = DriverHelper.getDriver();
    HomePage homePage = new HomePage(driver);


    @Given("User navigates to the Amazon")
    public void user_navigates_to_the_amazon() {
       driver.get(ConfigReader.readProperty("amazonUrl"));
    }
    @When("User searches for Seiko")
    public void user_searches_for_seiko() {
        homePage.findSeiko("iphone 13 case");
    }
    @Then("User validates the number is fifty thousands result")
    public void user_validates_the_number_is_fifty_thousands_result() {
        homePage.validateResult();
    }

    @And("User validates all headers contains Seiko")
    public void User_validates_all_headers_contains_Seiko(){
        homePage.validateHeaders("iphone");
    }
}
