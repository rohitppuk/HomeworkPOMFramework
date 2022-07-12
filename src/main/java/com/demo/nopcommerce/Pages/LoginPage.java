package com.demo.nopcommerce.Pages;

import com.demo.nopcommerce.Utilities.Constants;
import com.demo.nopcommerce.Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginPage {
    WebDriver driver;
    Utils utils;
    By loginLink = By.cssSelector("a[href=\"/login?returnUrl=%2F\"]");
    By email = By.id("Email");
    By password = By.id("Password");
    By LogInButton =By.cssSelector("button[type='submit'][class='button-1 login-button']");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
        utils = new Utils(driver);
    }
    public String getLogInPageTitle()
    {
        utils.doClick(loginLink);
        return utils.waiteToGetPageTitle(Constants.Login_Page_Title,5);
    }
    public void logIn(String Email,String pwd)
    {

        utils.doSendData(email,Email);
        utils.doSendData(password,pwd);
        utils.doClick(LogInButton);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
