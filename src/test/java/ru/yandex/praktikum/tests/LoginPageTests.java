package ru.yandex.praktikum.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.TestBase;
import ru.yandex.praktikum.api.User;

import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.ForgotPasswordPage.loginForgotPasswordPageButton;
import static ru.yandex.praktikum.ForgotPasswordPage.openForgotPassword;
import static ru.yandex.praktikum.MainPage.*;
import static ru.yandex.praktikum.RegistationPage.*;

public class LoginPageTests extends TestBase {
    User userCorrectData = new User("test-user-Vasya@yandex.ru", "hJ87Ju", "Vasya");

    @Before
    public void setUp() {
        registationPage.openRegistration(webDriver);
        registationPage.fillRegistrationPageFields(webDriver, userCorrectData);
    }

    @After
    public void deleteUser() {
        ValidatableResponse responseLogin = userClient.loginUser(userCorrectData);
        String loginBody = responseLogin.extract().body().asPrettyString();
        User newUser = gson.fromJson(loginBody, User.class);
        if (newUser.getAccessToken() != null) {
            userClient.deleteUser(newUser.getAccessToken());
        }
    }

    @Test
    @DisplayName("Логин юзера через кнопку 'Войти в аккаунт'")
    @Description("Логин по кнопке войти в аккаунт на главной")
    public void loginWithEnterToAccountButtonTest() {
        openMain(webDriver);
        webDriver.findElement(loginMainPageButton).click();
        enterPage.fieldsLoginPageFilling(webDriver, userCorrectData);

        assertTrue("Что-то пошло не так", webDriver.findElement(orderCreateButton).isDisplayed());
    }

    @Test
    @DisplayName("Логин юзера через личный кабинет")
    @Description("Логин через Личный кабинет на главной")
    public void loginWithPersonalAccountOnMainPageTest() {
        openMain(webDriver);
        webDriver.findElement(personalAccountButton).click();
        enterPage.fieldsLoginPageFilling(webDriver, userCorrectData);

        assertTrue("Что-то пошло не так", webDriver.findElement(orderCreateButton).isDisplayed());
    }

    @Test
    @DisplayName("Логин юзера через форму регистрации")
    @Description("Логин по кнопке войти в аккаунт через форму регистрации")
    public void loginWithEnterButtonOnRegistrationFormTest() {
        openRegistration(webDriver);
        webDriver.findElement(registationPage.loginRegistrationPageButton).click();
        enterPage.fieldsLoginPageFilling(webDriver, userCorrectData);

        assertTrue("Что-то пошло не так", webDriver.findElement(orderCreateButton).isDisplayed());
    }

    @Test
    @DisplayName("Логин юзера через форму восстановления пароля")
    @Description("Логин по кнопке войти в аккаунт через форму восстановления пароля")
    public void loginWithEnterButtonOnForgotFormTest() {
        openForgotPassword(webDriver);
        webDriver.findElement(loginForgotPasswordPageButton).click();
        enterPage.fieldsLoginPageFilling(webDriver, userCorrectData);

        assertTrue("Что-то пошло не так", webDriver.findElement(orderCreateButton).isDisplayed());
    }
}