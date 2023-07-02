package org.example.API;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class    UserPage {
    @Step("Создание пользователя")
    public Response createUser(User user) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post("/api/auth/register");
    }
    @Step("Авторизация пользователя")
    public Response loginUser(LoginUser loginUser) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(loginUser)
                .when()
                .post("/api/auth/login");
    }
    @Step("Удаление пользователя")
    public Response deleteUser (String accessToken) {
        return given()
                .header("Content-type", "application/json")
                .header("Authorization", accessToken)
                .when()
                .delete("/api/auth/user");
    }
    @Step("Выход из системы")
    public Response logoutUser (String accessToken) {
        return given()
                .header("Content-type", "application/json")
                .header("Authorization", accessToken)
                .when()
                .post("/api/auth/logout");
    }
}
