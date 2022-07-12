package com.demo.nopcommerce.Pages;


import com.demo.nopcommerce.Utilities.Constants;
import com.demo.nopcommerce.Utilities.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class RegisterPage
{
    WebDriver driver;
    Properties property;
    Utils utils;
    //Belows are webelements objects on Register page
    By registerLink = By.className("ico-register");
    By genderType = By.id("gender-male");
    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By day = By.xpath("//select[@name='DateOfBirthDay']");
    By month = By.xpath("//select[@name='DateOfBirthMonth']");
    By year = By.xpath("//select[@name='DateOfBirthYear']");

    By email = By.id("Email");
    By password = By.id("Password");
    By confirmPassword = By.id("ConfirmPassword");
    By registerButton = By.id("register-button");

    //Creating a constructor of Register Page
    public RegisterPage(WebDriver driver)
    {
        this.driver = driver;
        utils = new Utils(driver);
    }

    public String getRegisterPageTitle()
    {
        return utils.waiteToGetPageTitle(Constants.Register_Page_Title,5);

    }
    public void registerUserDetails(String fname,String lname,String Date, String Month,
                                    String Year,String Email,String pwd,String cpwd) throws InterruptedException
    {
        utils.doClick(registerLink);
        utils.doClick(genderType);
        Thread.sleep(2000);
        utils.doSendData(firstName,fname);
        utils.doSendData(lastName,lname);
        utils.doSelectItem(day,month,year,Date,Month,Year);
        utils.doSendData(email,Email);
        utils.doSendData(password,pwd);
        utils.doSendData(confirmPassword,cpwd);
        utils.doClick(registerButton);
    }


}
