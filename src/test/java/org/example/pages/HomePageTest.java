package org.example.pages;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;

public class HomePageTest extends BeforeTest {
    @Test
    @DisplayName("Check create correct user")
    @Description("Проверка успешного создания пользователя")
    public void checkCreateCorrectUser() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnPersonalAreaLink();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnRegistrationLink();
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        registrationPage.clickOnRegistrationButton();
        registrationPage.registrationUser(getUser().getName(), getUser().getEmail(), getUser().getPassword());
        Assert.assertTrue(getDriver().findElement(loginPage.getLogo()).isDisplayed());
    }

    @Test
    @DisplayName("Check create user with invalid password")
    @Description("Проверка создания пользователя с неверным паролем")
    public void checkCreateUserWithInvalidPassword() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnPersonalAreaLink();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnRegistrationLink();
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        registrationPage.registrationUser(getUser().getName(), getUser().getEmail(), getIncorrectPassword());
        Assert.assertTrue(getDriver().findElement(registrationPage.getIncorrectPassword()).isDisplayed());
    }
}