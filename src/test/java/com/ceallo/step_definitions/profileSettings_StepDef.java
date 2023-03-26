package com.ceallo.step_definitions;

import com.ceallo.pages.BasePage;
import com.ceallo.pages.ProfileSettingsPage;
import com.ceallo.utilities.BrowserUtils;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class profileSettings_StepDef {

    BasePage basePage = new BasePage();
    ProfileSettingsPage profileSettingsPage = new ProfileSettingsPage();

    @When("User clicks on {string} link")
    public void userClicksOnLink(String avatar) {
        basePage.avatar.click();
    }

    @And("User navigates to profile settings page")
    public void userNavigatesToProfileSettingsPage() {
        basePage.settingsLink.click();
    }

    @Then("User can see Full name title")
    public void userCanSeeFullNameTitle() {
        String nameTitle = profileSettingsPage.fullName.getText();
        System.out.println(nameTitle);
        Assert.assertEquals(nameTitle, "Full name");
    }

    @And("User can see Email title")
    public void userCanSeeEmailTitle() {
        String emailTitle = profileSettingsPage.email.getText();
        System.out.println(emailTitle);
        Assert.assertEquals(emailTitle, "Email");
    }

    @And("User can see Phone number title")
    public void userCanSeePhoneNumberTitle() {
        String phoneTitle = profileSettingsPage.phoneNumber.getText();
        System.out.println(phoneTitle);
        Assert.assertEquals(phoneTitle, "Phone number");
    }

    @When("User navigates to Full Name inputbox")
    public void user_navigates_to_full_name_inputbox() {
        profileSettingsPage.fullNameInputBox.clear();
    }

    @And("Enters new {string} and {string}")
    public void entersNewAnd(String arg0, String arg1) {
        BrowserUtils.waitForPageToLoad(60);
        Faker faker = new Faker();
        profileSettingsPage.fullNameInputBox.sendKeys(faker.name().fullName());
    }

    @Then("Info should update to new {string} and {string}")
    public void info_should_update_to_new_and(String string, String string2) {
        String fullNameValue = profileSettingsPage.fullNameInputBox.getAttribute("value");
        System.out.println("Updated full name is: " + fullNameValue);
    }

    @When("User clicks on privacy link")
    public void userClicksOnPrivacyLink() {
        profileSettingsPage.phoneForm.get(3).click();
    }

    @Then("User can select private mode")
    public void userCanSelectPrivateMode() {
        List<WebElement> privacy = profileSettingsPage.phoneForm.get(3).findElements(By.xpath("//li[@tabindex='0']"));
        privacy.get(0).click();
    }

    @When("User checks time under Locale dropdown")
    public void userChecksTimeUnderLocaleDropdown() {
        profileSettingsPage.localDate.isDisplayed();
        profileSettingsPage.localTime.isDisplayed();
    }
    @Then("current local time is displayed correctly")
    public void currentLocalTimeIsDisplayedCorrectly() {
        BrowserUtils.waitForPageToLoad(60);
        String displayedTime = profileSettingsPage.localTime.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.US);
        LocalTime time = LocalTime.now();
        String current = formatter.format(time);
        System.out.println(displayedTime);
        System.out.println(current);
        Assert.assertEquals(displayedTime, current);

    }


}
