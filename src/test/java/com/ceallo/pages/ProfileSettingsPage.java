package com.ceallo.pages;

import com.ceallo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProfileSettingsPage {

    public ProfileSettingsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//label[@for='displayname']")
    public WebElement fullName;
    @FindBy(id = "displayname")
    public WebElement fullNameInputBox;
    @FindBy(xpath = "//label[@for='email']")
    public WebElement email;
    @FindBy(xpath = "//label[@for='phone']")
    public WebElement phoneNumber;
    @FindBy(className = "federation-menu")
    public List<WebElement> phoneForm;
    @FindBy(id = "localeexample-date")
    public WebElement localDate;
    @FindBy(id = "localeexample-time")
    public WebElement localTime;

    @FindBy(xpath = "//label")
    public List<WebElement> title;


}
