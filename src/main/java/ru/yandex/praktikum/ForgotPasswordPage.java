package ru.yandex.praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static ru.yandex.praktikum.links.Links.FORGOT_PASSWORD_PAGE;

public class ForgotPasswordPage {
    public static By loginForgotPasswordPageButton = By.className("Auth_link__1fOlj");

    @Step("Открытие страницы регистрации")
    public static void openForgotPassword(WebDriver webDriver) {
        webDriver.get(FORGOT_PASSWORD_PAGE);
    }
}
