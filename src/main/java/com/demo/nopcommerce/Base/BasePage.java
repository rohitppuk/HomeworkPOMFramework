package com.demo.nopcommerce.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {
    WebDriver driver;
    Properties regProperty;
    Properties logProperty;
    FileInputStream fileInput;

    // 1. Driver Setup and Initialization
    public WebDriver driverInitialise(String browserName)
    {
        if(browserName.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else if(browserName.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else{
            System.out.println("Not Available Driver,Select from Chrome, Firefox and Microsoft Edge");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        return driver;
    }


    // 2. Configuration of Register Page properties
    public Properties configRegisterProperties()
    {
        regProperty = new Properties();
        try {
            fileInput = new FileInputStream("C:\\Users\\rohitPatel\\PageObjectModelFramework\\src\\test\\" +
                                            "resources\\TestData\\Register.properties");
             regProperty.load(fileInput);

        } catch (FileNotFoundException e) {
            System.out.println("Unable To Load Register Property File....."); // get message in case property file not found
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Unable to Load Register Property File.....");  // get message in case poperty file cannot load
            e.printStackTrace();
        }
        return regProperty;
    }

    //3. CONFIGURE LOGIN PROPERTIES
    public Properties configLoginProperties() {
        logProperty = new Properties();
        try {
            fileInput = new FileInputStream("C:\\Users\\rohitPatel\\PageObjectModelFramework\\" +
                    "src\\test\\resources\\TestData\\Login.properties");
            logProperty.load(fileInput);
        } catch (FileNotFoundException e) {
            System.out.println("Unable To Find Login Property File....");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Unable To Load Login Property File....");
            e.printStackTrace();
        }

    return logProperty;
    }

}
