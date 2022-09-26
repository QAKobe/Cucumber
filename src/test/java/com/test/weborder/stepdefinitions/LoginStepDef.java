package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class LoginStepDef {

    WebDriver driver = DriverHelper.getDriver();
    LoginPage loginPage = new LoginPage(driver);


//    @Given("User navigates to the {string}")
//    public void user_navigates_to_the(String website) {
//        driver.get(website);
//    }
    @When("User provides valid username {string} and {string}")
    public void user_provides_valid_username_and(String email, String password) {
        loginPage.login(email, password);
    }
    @Then("User validates the title {string} from homepage")
    public void user_validates_the_title_from_homepage(String title) {
        Assert.assertEquals(title, driver.getTitle().trim());
        //driver.quit();
    }

    @Then("User validates the message {string} from login page")
    public void user_validates_the_message_from_login_page(String errorMessage) {
        Assert.assertEquals(errorMessage, loginPage.errorMessage().trim());
    }
}
