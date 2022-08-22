package com.epam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LvSendMailPage {

    public static final String IFRAME_XPATH = "//iframe[@title='Визуальный текстовый редактор, message']";

    private final WebDriver driver;

    public LvSendMailPage(WebDriver driver) {
        this.driver = driver;
    }

    public LvSendMailPage waitByXpath (String xpath){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return this;
    }

    public LvSendMailPage waitById (String id){
        WebDriverWait wait2 = new WebDriverWait(driver, 30);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));

        return this;
    }
    public LvSendMailPage waitByClassName (String className){
        WebDriverWait wait3 = new WebDriverWait(driver, 30);
        wait3.until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));

        return this;
    }

    public LvSendMailPage clickByXpath(String xpath){
        driver.findElement(By.xpath(xpath)).click();
        return this;
    }

    public LvSendMailPage sendKeysById(String id, String data){
        driver.findElement(By.id(id)).sendKeys(data);
        return this;
    }

    public LvSendMailPage sendKeysByXpath(String xpath, String data){
        driver.findElement(By.xpath(xpath)).sendKeys(data);
        return this;
    }

    public LvSendMailPage switchToMessageFrame() {
        WebElement iframe = driver.findElement(By.xpath(IFRAME_XPATH));
        driver.switchTo().frame(iframe);
        return this;
    }

    public LvSendMailPage switchToDefaultFrame() {
        driver.switchTo().defaultContent();
        return this;
    }

    public LvSendMailPage clickByClassName(String className){
        driver.findElement(By.className(className)).click();
        return  this;
    }

    public LvSendMailPage clickById(String id){
        driver.findElement(By.id(id)).click();
        return  this;
    }

}
