package com.epam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YahooLoginPage {

    private final WebDriver driver;

    public YahooLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public YahooLoginPage open() {
        driver.navigate().to("https://www.yahoo.com/");
        return this;
    }

    public YahooLoginPage checkHover() {
        WebElement element = driver.findElement(By.className("consent-form"));

        if (element != null) {
            driver.findElement(By.name("agree")).click();
        }
        return this;
    }

    public YahooLoginPage clickByClassName(String className) {
        driver.findElement(By.className(className)).click();
        return this;
    }

    public YahooLoginPage clickById(String id) {
        driver.findElement(By.id(id)).click();
        return this;
    }

    public YahooLoginPage inputDataById(String id, String data) {
        driver.findElement(By.id(id)).sendKeys(data);
        return this;
    }

    public YahooLoginPage waitElementVisibleById(String id) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        return this;
    }

    public YahooLoginPage waitElementVisibleByClassName(String className) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
        return this;
    }

    public WebElement getElementById(String id) {
        return driver.findElement(By.id(id));
    }

    public WebElement getElementByClassName(String className) {
        return driver.findElement(By.className(className));
    }

    public YahooLoginPage moveToElement(String id) {
        Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(By.id(id));

        actions.moveToElement(menu).perform();
        return this;
    }
}
