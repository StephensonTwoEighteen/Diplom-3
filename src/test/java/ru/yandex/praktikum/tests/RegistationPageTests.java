package ru.yandex.praktikum.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import ru.yandex.praktikum.RegistationPage;
import ru.yandex.praktikum.TestBase;
import ru.yandex.praktikum.api.User;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.LoginPage.*;
import static ru.yandex.praktikum.RegistationPage.*;

public class RegistationPageTests extends TestBase {

    User userCorrectData = new User("test-user-Vasya@yandex.ru", "hJ87Ju", "Vasya");
    User userIncorrectData = new User("test-user-Vasya@yandex.ru", "hJ87", "Vasya");

    @After
    public void deleteUser() {
        io.restassured.response.ValidatableResponse responseLogin = userClient.loginUser(userCorrectData);
        String loginBody = responseLogin.extract().body().asPrettyString();
        User newUser = gson.fromJson(loginBody, User.class);
        if (newUser.getAccessToken() != null) {
            userClient.deleteUser(newUser.getAccessToken());
        }
    }

    @Test
    @DisplayName("Регистрация пользователя с корректными данными")
    @Description("Попытка регистрации с валидными данными")
    public void userRegistrationWithCorrectDataTest() {
        registationPage.openRegistration(webDriver);
        RegistationPage.fillRegistrationPageFields(webDriver, userCorrectData);

        assertTrue("Вероятно юзер уже существует", webDriver.findElements(userAlreadyExist).size() == 0);
        assertThat("\"Вероятно юзер уже существует\"", webDriver.findElement(successRegistered).getText(), equalTo(successRegisteredExpected));
    }

    @Test
    @DisplayName("Регистрация пользователя с некорректными данными")
    @Description("Попытка регистрации с паролем меньше 6 символов")
    public void userRegistrationWithIncorrectDataTest() {
        registationPage.openRegistration(webDriver);
        RegistationPage.fillRegistrationPageFieldsNegative(webDriver, userIncorrectData);

        assertTrue(webDriver.findElement(notCorrectPassword).isDisplayed());
    }
}
