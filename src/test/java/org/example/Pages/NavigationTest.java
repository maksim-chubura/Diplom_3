package org.example.Pages;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NavigationTest extends BeforeTest {
    @Before
    public void registrationUser() {
        getUserPage().createUser(getUser());
    }

    @Test
    @DisplayName("Check transition from personal account to constructor by click on Constructor")
    @Description("Проверка перехода из личного кабинета в конструктор по клику на Конструктор")
    public void checkTransitionFromPersonalAccountToConstructorByClickOnConstructor() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnPersonalAreaLink();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getUser().getEmail(), getUser().getPassword());
        homePage.clickOnPersonalAreaLink();
        homePage.clickOnConstructorLink();
        Assert.assertTrue(getDriver().findElement(homePage.getConstructBurgerHeader()).isDisplayed());
    }

    @Test
    @DisplayName("Check transition from personal account to constructor by click on Stellar Burgers")
    @Description("Проверка перехода из личного кабинета в конструктор по клику на Stellar Burgers")
    public void checkTransitionFromPersonalAccountToConstructorByClickOnStellarBurgers() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnPersonalAreaLink();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(getUser().getEmail(), getUser().getPassword());
        homePage.clickOnPersonalAreaLink();
        homePage.clickOnStellarBurgersLogoLink();
        Assert.assertTrue(getDriver().findElement(homePage.getConstructBurgerHeader()).isDisplayed());
    }


    @Test
    @DisplayName("Check transition to Bins section")
    @Description("Работа перехода на раздел Булки")
    public void checkTransitionToBunsSection() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnSaucesChapter();
        homePage.clickOnBunsChapter();
        Assert.assertEquals("Неверный текст! Должны быть Булки", "Булки", homePage.getTextFromTheChosenElement());
    }

    @Test
    @DisplayName("Check transition to Sauce section")
    @Description("Работа перехода на раздел Соусы")
    public void checkTransitionToSauceSection() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnSaucesChapter();
        Assert.assertEquals("Неверный текст! Должны быть Соусы", "Соусы", homePage.getTextFromTheChosenElement());
    }

    @Test
    @DisplayName("Check transition to Ingredients section")
    @Description("Работа перехода на раздел Начинки")
    public void checkTransitionToIngredientsSection() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnIngredientsChapter();
        Assert.assertEquals("Неверный текст! Должны быть Начинки", "Начинки", homePage.getTextFromTheChosenElement());
    }

}
