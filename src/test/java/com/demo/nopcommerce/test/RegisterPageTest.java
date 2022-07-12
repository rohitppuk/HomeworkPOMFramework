package com.demo.nopcommerce.test;

import com.demo.nopcommerce.Base.BasePage;
import com.demo.nopcommerce.Pages.RegisterPage;
import com.demo.nopcommerce.Utilities.Utils;
import javafx.scene.layout.Priority;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Properties;

public class RegisterPageTest {
WebDriver driver;
BasePage basePage;
Properties regProperty;
RegisterPage registerPage;
Integer integer;


@BeforeClass
public void launchBrowser()
{
    basePage = new BasePage();
    regProperty = basePage.configRegisterProperties();
    String webEngine = regProperty.getProperty("browser");
    driver = basePage.driverInitialise(webEngine);
    driver.get(regProperty.getProperty("url"));
    registerPage = new RegisterPage(driver);
}
    @Test(priority = 1)
    public void runRegistration() throws InterruptedException {

        registerPage.registerUserDetails(
                regProperty.getProperty("FirstName"),
                regProperty.getProperty("LastName"),
                regProperty.getProperty("DateOfBirthDay"),
                regProperty.getProperty("DateOfBirthMonth"),
                regProperty.getProperty("DateOfBirthYear"),
                regProperty.getProperty("Email"),
                regProperty.getProperty("Password"),
                regProperty.getProperty("ConfirmPassword")
        );
        Thread.sleep(2000);

    }

@Test(priority = 2)

public void verifyRegisterPageTitle()
{
   Assert.assertEquals(registerPage.getRegisterPageTitle(),"nopCommerce demo store. Register","RegisterPage Not Loaded.....");

}

   @AfterClass
    public void tearDown()
    {
        driver.quit();
    }


}
