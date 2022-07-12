package com.demo.nopcommerce.test;

import com.demo.nopcommerce.Base.BasePage;
import com.demo.nopcommerce.Pages.LoginPage;
import com.demo.nopcommerce.Pages.RegisterPage;
import com.demo.nopcommerce.Utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sun.print.BackgroundServiceLookup;

import javax.rmi.CORBA.Util;
import java.util.Properties;

public class LoginPageTest {
WebDriver driver;
LoginPage loginPage;
BasePage basePage;
Properties logProperty;
@BeforeClass
    public void launchBrowser()
    {
        basePage = new BasePage();
        logProperty = basePage.configLoginProperties();
        String webEngine = logProperty.getProperty("browser");
        driver = basePage.driverInitialise(webEngine);
        driver.get(logProperty.getProperty("url"));
        loginPage = new LoginPage(driver);
    }
@Test(priority = 1)
    public void verifyLogInPageTitle()
    {
        Assert.assertEquals(loginPage.getLogInPageTitle(),"nopCommerce demo store. Login","LogIn Page Not Loaded.....");
    }
   @Test(priority = 2)
    public void runLogin()
    {

        loginPage.logIn(logProperty.getProperty("email"),logProperty.getProperty("password"));
    }
@AfterClass
    public void teardown()
{
    driver.quit();
}


}
