package com.epam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LvLoginPage {
    private final WebDriver driver;

    public LvLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LvLoginPage open() {
        driver.navigate().to("https://www.inbox.lv/");
        return this;
    }

    public LvLoginPage sendKeysById(String id, String data) {
        driver.findElement(By.id(id)).sendKeys(data);
        return this;
    }

    public LvLoginPage clickById (String id){
        driver.findElement(By.id(id)).click();
        return this;
    }

}
