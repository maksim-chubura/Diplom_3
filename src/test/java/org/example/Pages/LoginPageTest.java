package org.example.Pages;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginPageTest extends BeforeTest {
    @Before
    public void registrationUser() {
        getUserPage().createUser(getUser());
    }

    @Test
    @DisplayName("Login by clicking the Login button on the main page")
    @Description("Вход по кнопке Войти в аккаунт на главной")
    public void loginClickLoginButtonOnMainPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnEnterAcountButton();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getUser().getEmail(), getUser().getPassword());
        homePage.clickOnPersonalAreaLink();
        AccountPage accountPage = new AccountPage(getDriver());
        Assert.assertTrue(getDriver().findElement(accountPage.getNameField()).isDisplayed());
    }

    @Test
    @DisplayName("Login by clicking the Personal Area button")
    @Description("Вход по кнопке Личный кабинет")
    public void loginClickPersonalAreaButton() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnPersonalAreaLink();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getUser().getEmail(), getUser().getPassword());
        homePage.clickOnPersonalAreaLink();
        AccountPage accountPage = new AccountPage(getDriver());
        Assert.assertTrue(getDriver().findElement(accountPage.getNameField()).isDisplayed());
    }

    @Test
    @DisplayName("Login on click enter button on registration page")
    @Description("Вход при нажатии кнопки Ввод на странице регистрации")
    public void loginOnClickEnterButtonOnRegistrationPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnPersonalAreaLink();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnRegistrationLink();
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        registrationPage.clickSignInButton();
        loginPage.login(getUser().getEmail(), getUser().getPassword());
        homePage.clickOnPersonalAreaLink();
        AccountPage accountPage = new AccountPage(getDriver());
        Assert.assertTrue(getDriver().findElement(accountPage.getNameField()).isDisplayed());
    }

    @Test
    @DisplayName("Login on forgot password page")
    @Description("Вход через кнопку на странице восстановления пароля")
    public void loginOnForgotPasswordPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnPersonalAreaLink();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.clickOnRestorePasswordLink();
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(getDriver());
        passwordRecoveryPage.clickOnEnterLinkOnForgotPasswordPage();
        loginPage.login(getUser().getEmail(), getUser().getPassword());
        homePage.clickOnPersonalAreaLink();
        AccountPage accountPage = new AccountPage(getDriver());
        Assert.assertTrue(getDriver().findElement(accountPage.getNameField()).isDisplayed());
    }

    @Test
    @DisplayName("Logout from Personal Area")
    @Description("Выход из Личного кабинета")
    public void logoutFromPersonalArea() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnPersonalAreaLink();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getUser().getEmail(), getUser().getPassword());
        homePage.clickOnPersonalAreaLink();
        loginPage.clickLogoutButton();
        Assert.assertTrue(getDriver().findElement(loginPage.getLogo()).isDisplayed());
    }
}