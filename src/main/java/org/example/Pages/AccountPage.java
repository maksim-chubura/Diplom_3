package org.example.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private WebDriver driver;
    private final By nameField = By.xpath(".//input[@value='Maksim']");
    public AccountPage (WebDriver driver) {
        this.driver = driver;
    }
    @Step("Вернуть заголовок Имя")
    public By getNameField() {
        return nameField;
    }
}
