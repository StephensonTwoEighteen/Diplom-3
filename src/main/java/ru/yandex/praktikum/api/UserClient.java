package ru.yandex.praktikum.api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserClient extends StellarClient {
    public final String LOGIN_USER = "/api/auth/login";
    public final String TOUCH_USER = "/api/auth/user";

    @Step("Логин юзера")
    public ValidatableResponse loginUser(User user) {
        return given().spec(baseSpec())
                .body(user)
                .when()
                .post(LOGIN_USER)
                .then();
    }

    @Step("Удаление юзера")
    public ValidatableResponse deleteUser(String accessToken) {
        return given().spec(baseSpec())
                .header("Authorization", accessToken)
                .when()
                .delete(TOUCH_USER)
                .then();
    }
}
