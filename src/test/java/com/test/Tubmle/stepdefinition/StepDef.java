package com.test.Tubmle.stepdefinition;

import com.test.Tubmle.pages.HomePageForTumble;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class StepDef {

    WebDriver driver = DriverHelper.getDriver();

    HomePageForTumble homePageForTumble = new HomePageForTumble(driver);
    @Given("User navigates to the Tumble")
    public void user_navigates_to_the_tumble() {
       driver.get(ConfigReader.readProperty("tumble"));
    }
    @When("User Logins for login")
    public void user_logins_for_login() {
            homePageForTumble.loginButton();
    }
    @When("User clicks login")
    public void user_clicks_login() throws InterruptedException {
       homePageForTumble.clickContinueWithEmail();
    }
    @Then("User validates ErrorMessage")
    public void user_validates_error_message() {
      homePageForTumble.enterEmailAndValidateMesssage("asdsads");
    }

}
