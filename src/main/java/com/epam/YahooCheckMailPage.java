package com.epam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YahooCheckMailPage {
    private final WebDriver driver;

    public YahooCheckMailPage(WebDriver driver) {
        this.driver = driver;
    }

    public YahooCheckMailPage clickByXpath(String xpath){
        driver.findElement(By.xpath(xpath)).click();
        return this;
    }

    public YahooCheckMailPage waitByXpath(String xpath){
        WebDriverWait wait6 = new WebDriverWait(driver, 30);
        wait6.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return this;
    }

    public String getTextByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath)).getText();
    }
}
