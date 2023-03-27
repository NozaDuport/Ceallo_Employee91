package com.ceallo.pages;

import com.ceallo.utilities.BrowserUtils;
import com.ceallo.utilities.ConfigurationReader;
import com.ceallo.utilities.Driver;
import org.junit.Assert;

import java.util.List;

public class tests {
    public static void main(String[] args) {
        LoginPage loginPage = new LoginPage();
        ProfileSettingsPage profileSettingsPage = new ProfileSettingsPage();

      Driver.getDriver ().get("https://qa.ceallo.com/index.php/settings/user");
        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginBtn.click();

        List<String> listTitle = BrowserUtils.getElementsText(profileSettingsPage.title);
        String nameTitle = listTitle.get(3);
        System.out.println(nameTitle);
        Assert.assertEquals(nameTitle, "Full name");

        String emailTitle = listTitle.get(4);
        System.out.println(emailTitle);
        Assert.assertEquals(emailTitle, "Email");

        String phoneTitle = listTitle.get(5);
        System.out.println(phoneTitle);
        Assert.assertEquals(phoneTitle, "Phone number");


       /* WebElement nameTitle = Driver.getDriver().findElement(By.xpath("//label[@for='displayname']"));
        System.out.println(nameTitle.getText());
        List<WebElement> phoneForm = Driver.getDriver().findElements(By.className("federation-menu"));
        System.out.println(phoneForm.size());
        phoneForm.get(3).click();
        System.out.println("phoneForm.get(3).getText() = " + phoneForm.get(3).getText());
        List<WebElement> privacy = phoneForm.get(3).findElements(By.xpath("//li[@tabindex='0']"));
        privacy.get(0).click();*/

       /* String displayedTime = profileSettingsPage.localTime.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.US);
        LocalTime time = LocalTime.now();
        String current = formatter.format(time);
        System.out.println(displayedTime);
        System.out.println(current);
        Assert.assertEquals(displayedTime, current);
*/

        Driver.closeDriver();



    }
}
