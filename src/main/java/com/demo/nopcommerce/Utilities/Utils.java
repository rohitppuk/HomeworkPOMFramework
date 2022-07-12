package com.demo.nopcommerce.Utilities;

import com.demo.nopcommerce.Base.BasePage;
import com.demo.nopcommerce.Pages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Properties;

public class Utils {
    WebDriver driver;
    WebElement element;

    public Utils(WebDriver driver)
    {
        this.driver = driver;
    }
    public WebElement getElement(By locator)
    {
       WebElement  element = driver.findElement(locator);
        return element;
    }
    public void doSendData(By locator, String value)
    {
     getElement(locator).sendKeys(value);
    }
    public void doClick(By locator)
    {
     getElement(locator).click();
    }
    public void doSelectItem(By dayLocator,By monthLocator, By yearLocator,String Day,String Month,String Year) throws InterruptedException {
        Select selectDay = new Select(getElement(dayLocator));
        selectDay.selectByValue(Day);
        Thread.sleep(2000);
        Select selectMonth =new Select(getElement(monthLocator));
        selectMonth.selectByVisibleText(Month);
        Thread.sleep(2000);
        Select selectYear = new Select(getElement(yearLocator));
        selectYear.selectByValue(Year);
        Thread.sleep(2000);
    }
    public String waiteToGetPageTitle(String titleValue,int timeOut)
    {
        WebDriverWait waite = new WebDriverWait(driver,timeOut);
        waite.until(ExpectedConditions.titleIs(titleValue));
        return driver.getTitle();

    }
}
