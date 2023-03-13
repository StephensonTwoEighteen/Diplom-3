package ru.yandex.praktikum.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.TestBase;
import ru.yandex.praktikum.api.User;

import static org.junit.Assert.assertTrue;
import static ru.yandex.praktikum.LoginPage.*;
import static ru.yandex.praktikum.MainPage.orderCreateButton;
import static ru.yandex.praktikum.MainPage.personalAccountButton;
import static ru.yandex.praktikum.PersonalAccountPage.*;
import static ru.yandex.praktikum.RegistationPage.fillRegistrationPageFields;

public class PersonalAccountPageTests extends TestBase {

    User userCorrectData = new User("test-user-Vasya@yandex.ru", "hJ87Ju", "Vasya");

    @Before
    public void setUp() {
        registationPage.openRegistration(webDriver);
        fillRegistrationPageFields(webDriver, userCorrectData);
        openLogin(webDriver);
        fieldsLoginPageFilling(webDriver, userCorrectData);
    }

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
    @DisplayName("Открытие личного кабинета")
    @Description("Проверка открытия личного кабинета с главной страницы")
    public void personalAccountOpenByButtonTest() {
        webDriver.findElement(personalAccountButton).click();

        assertTrue("Что-то пошло не так", webDriver.findElement(exitButton).isDisplayed());
    }

    @Test
    @DisplayName("Переход по клику на конструктор")
    @Description("Проверка перехода на главную из ЛК по клику на кнопку конструктора")
    public void constructorButtonPressTest() {
        webDriver.findElement(personalAccountButton).click();
        webDriver.findElement(constructorButton).click();

        assertTrue("Что-то пошло не так", webDriver.findElement(orderCreateButton).isDisplayed());
    }

    @Test
    @DisplayName("Переход по клику на лого")
    @Description("Проверка перехода на главную из ЛК по клику на лого")
    public void logoButtonPressTest() {
        webDriver.findElement(personalAccountButton).click();
        webDriver.findElement(mainLogo).click();

        assertTrue("Что-то пошло не так", webDriver.findElement(orderCreateButton).isDisplayed());
    }

    @Test
    @DisplayName("Переход на главную по клику на 'Выйти'")
    @Description("Проверка перехода на страницу логина из ЛК по клику на кнопку Выйти")
    public void exitButtonPressTest() {
        webDriver.findElement(personalAccountButton).click();
        webDriver.findElement(exitButton).click();

        assertTrue("Что-то пошло не так", webDriver.findElement(loginButton).isDisplayed());
    }
}
