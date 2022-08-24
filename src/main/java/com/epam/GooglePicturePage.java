package com.epam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GooglePicturePage {

    private final WebDriver driver;

    public GooglePicturePage(WebDriver driver) {
        this.driver = driver;
    }

    public GooglePicturePage open() {
        driver.navigate().to("https://www.google.com/");
        return this;
    }

    public GooglePicturePage waitElementVisibleByLinkText(String linkText) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(linkText)));
        return this;
    }

    public GooglePicturePage waitElementVisibleByXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return this;
    }

    public GooglePicturePage acceptToClick(String id) {
        WebElement l2AGLb = driver.findElement(By.id(id));
        if (l2AGLb != null) {
            l2AGLb.click();
        }
        return this;
    }

    public GooglePicturePage inputDataByXpath(String xpath, String value) {
        driver.findElement(By.xpath(xpath)).sendKeys(value);
        return this;
    }

    public GooglePicturePage clickByXpath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
        return this;
    }

    public List<WebElement> getElementsByTagName(String tagName) {
        return driver.findElements(By.tagName(tagName));
    }

}
