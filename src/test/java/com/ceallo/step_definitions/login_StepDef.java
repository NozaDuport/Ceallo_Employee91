package com.ceallo.step_definitions;

import com.ceallo.pages.LoginPage;
import com.ceallo.utilities.ConfigurationReader;
import com.ceallo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class login_StepDef {

    LoginPage loginPage = new LoginPage();
    @Given("User on the login page")
    public void user_on_the_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("ceallo_url"));
    }
    @When("User enters correct username and password")
    public void user_enters_correct_username_and_password() {

        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
    }
    @Then("Ceallo dashboard should be displayed")
    public void ceallo_dashboard_should_be_displayed() {
        loginPage.loginBtn.click();
    }
}
