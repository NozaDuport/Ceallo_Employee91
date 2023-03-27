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

    @And("User clicks on {string} link")
    public void userClicksOnLink(String avatar) {
        basePage.avatar.click();
    }

    @And("User navigates to profile settings page")
    public void userNavigatesToProfileSettingsPage() {
        basePage.settingsLink.click();
    }


    @When("User navigates to Full Name inputbox")
    public void user_navigates_to_full_name_inputbox() {
        BrowserUtils.waitForPageToLoad(60);
        profileSettingsPage.fullNameInputBox.clear();
    }

    @And("Enters new {string} and {string}")
    public void entersNewAnd(String username, String arg1) {
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
        BrowserUtils.waitForPageToLoad(60);
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
    @When("User is on the profile settings page")
    public void userIsOnTheProfileSettingsPage() {
        BrowserUtils.waitForPageToLoad(60);
    }
    @Then("User can see following titles:")
    public void user_can_see_following_titles(io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedList = dataTable.asList(String.class);
        List<String> listTitle = BrowserUtils.getElementsText(profileSettingsPage.title);
        System.out.println(expectedList);
        System.out.println(listTitle);

        String namePara = expectedList.get(0);
        String nameTitle = listTitle.get(3);
        System.out.println(namePara + " / " + nameTitle);
        Assert.assertEquals(nameTitle, namePara);

        String emailPara = expectedList.get(1);
        String emailTitle = listTitle.get(4);
        System.out.println(emailPara + " / " + emailTitle);
        Assert.assertEquals(emailTitle, emailPara);

        String phonePara = expectedList.get(2);
        String phoneTitle = listTitle.get(5);
        System.out.println(phonePara + " / " + phoneTitle);
        Assert.assertEquals(phoneTitle, phonePara);
    }

}