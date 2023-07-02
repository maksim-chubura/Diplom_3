package org.example.Pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.API.LoginUser;
import org.example.API.User;
import org.example.API.UserPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.example.Browsers.BrowserSetup.browserDriverSetUp;

public class BeforeTest {
    private final String email = "chubura.max@yandex.ru";
    private final String password = "938409";
    private final String name = "Maksim";
    private final String incorrectPassword = "9876";
    private WebDriver driver;
    private final User user = new User(email, password, name);
    private final UserPage userPage = new UserPage();
    private final LoginUser loginUser = new LoginUser(email, password);
    private final LoginUser incorrectLoginUser = new LoginUser(email, incorrectPassword);

    public void setDriver() {
        driver = browserDriverSetUp();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://stellarburgers.nomoreparties.site/");
    }
    @Before
    public void setUp() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
        setDriver();
    }
    @After
    public void tearDown() {
        Response response = getUserPage().loginUser(getLoginUser());
        if (response.jsonPath().get("success").equals(true)) {
            getUserPage().logoutUser(response.jsonPath().get("accessToken"));
            getUserPage().deleteUser(response.jsonPath().get("accessToken"));
        }
        response = getUserPage().loginUser(getIncorrectLoginUser());
        if (response.jsonPath().get("success").equals(true)) {
            getUserPage().logoutUser(response.jsonPath().get("accessToken"));
            getUserPage().deleteUser(response.jsonPath().get("accessToken"));
        }
        driver.quit();
    }
    public WebDriver getDriver() {
        return driver;
    }
    public UserPage getUserPage() {
        return userPage;
    }
    public User getUser() {
        return user;
    }
    public LoginUser getLoginUser() {
        return loginUser;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public LoginUser getIncorrectLoginUser() {
        return incorrectLoginUser;
    }
    public String getIncorrectPassword() {
        return incorrectPassword;
    }
}
