package com.ceallo.pages;

import com.ceallo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (id="user")
    public WebElement username;

    @FindBy (id="password")
    public WebElement password;

    @FindBy (id="submit-form")
    public WebElement loginBtn;

}
