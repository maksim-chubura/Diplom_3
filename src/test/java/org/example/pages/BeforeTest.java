package org.example.pages;

import io.restassured.response.Response;
import org.example.resources.LoginUser;
import org.example.resources.User;
import org.example.steps.UserPage;
import org.example.resources.UserGenerator;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static org.example.api.PathApi.BASE_URI;
import static org.example.browsers.BrowserSetup.browserDriverSetUp;

public class BeforeTest {
    private final String incorrectPassword = "9876";
    private WebDriver driver;
    private User user = new User();
    private final UserPage userPage = new UserPage();
    private final LoginUser loginUser = new LoginUser(user.getEmail(), user.getPassword());
    private final LoginUser incorrectLoginUser = new LoginUser(user.getEmail(), incorrectPassword);

    public void setDriver() {
        driver = browserDriverSetUp();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(BASE_URI);
    }

    @Before
    public void setUp() {
        user = UserGenerator.random();
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

    public LoginUser getIncorrectLoginUser() {
        return incorrectLoginUser;
    }

    public String getIncorrectPassword() {
        return incorrectPassword;
    }
}
