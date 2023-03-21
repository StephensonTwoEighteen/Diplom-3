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

public class PersonalAccountPageTests extends TestBase {

    User userCorrectData = new User("test-user-Vasya@yandex.ru", "hJ87Ju", "Vasya");

    @Before
    public void setUp() {
        ru.yandex.praktikum.RegistationPage.openRegistration(webDriver);
        registationPage.fillRegistrationPageFields(webDriver, userCorrectData);
        openLogin(webDriver);
        enterPage.fieldsLoginPageFilling(webDriver, userCorrectData);
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
        mainPage.personalAccountButtonCLick(webDriver);

        assertTrue("Что-то пошло не так", personalAccountPage.exitButtonDisplayed(webDriver));
    }

    @Test
    @DisplayName("Переход по клику на конструктор")
    @Description("Проверка перехода на главную из ЛК по клику на кнопку конструктора")
    public void constructorButtonPressTest() {
        mainPage.personalAccountButtonCLick(webDriver);
        personalAccountPage.constructorButtonClick(webDriver);

        assertTrue("Что-то пошло не так", mainPage.orderCreateButtonDisplayed(webDriver));
    }

    @Test
    @DisplayName("Переход по клику на лого")
    @Description("Проверка перехода на главную из ЛК по клику на лого")
    public void logoButtonPressTest() {
        mainPage.personalAccountButtonCLick(webDriver);
        personalAccountPage.mainLogoClick(webDriver);

        assertTrue("Что-то пошло не так", mainPage.orderCreateButtonDisplayed(webDriver));
    }

    @Test
    @DisplayName("Переход на главную по клику на 'Выйти'")
    @Description("Проверка перехода на страницу логина из ЛК по клику на кнопку Выйти")
    public void exitButtonPressTest() {
        mainPage.personalAccountButtonCLick(webDriver);
        personalAccountPage.exitButtonClick(webDriver);

        assertTrue("Что-то пошло не так", enterPage.loginButtonClick(webDriver));
    }
}