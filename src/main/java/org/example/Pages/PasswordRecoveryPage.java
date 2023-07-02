package org.example.Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    private WebDriver driver;
    private final By enterLink = By.xpath("//*[@id=\"root\"]/div/main/div/div/p/a");
    public PasswordRecoveryPage (WebDriver driver) {
        this.driver = driver;
    }
    // метод кликнуть на ссылку "Вспомнили пароль?"
    @Step("Клик на ссылку Вспомнили пароль?")
    public void clickOnEnterLinkOnForgotPasswordPage() {
        driver.findElement(enterLink).click();
    }

}
