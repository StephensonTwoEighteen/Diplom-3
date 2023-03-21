package ru.yandex.praktikum.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import ru.yandex.praktikum.TestBase;
import ru.yandex.praktikum.api.User;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
        openRegistration(webDriver);
        registationPage.fillRegistrationPageFields(webDriver, userCorrectData);

        assertTrue("\"Вероятно юзер уже существует\"", registationPage.successRegistration(webDriver));
    }

    @Test
    @DisplayName("Регистрация пользователя с некорректными данными")
    @Description("Попытка регистрации с паролем меньше 6 символов")
    public void userRegistrationWithIncorrectDataTest() {
        openRegistration(webDriver);
        registationPage.fillRegistrationPageFieldsNegative(webDriver, userIncorrectData);

        assertTrue("Что-то пошло не так", registationPage.notCorrectPasswordDispayed(webDriver));
    }
}