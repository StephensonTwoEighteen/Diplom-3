package ru.yandex.praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.api.User;

import static ru.yandex.praktikum.links.Links.LOGIN_PAGE;

public class LoginPage {
    public static By userAlreadyExist = By.className("input__error");
    public static By emailField = By.xpath(".//fieldset[1]//input");
    public static By loginButton = By.className("button_button__33qZ0");
    public static By passwordField = By.xpath("//input[@name = 'Пароль']");

    @Step("Открыть страницу логина")
    public static void openLogin(WebDriver webDriver) {
        webDriver.get(LOGIN_PAGE);
    }

    @Step("Заполнение полей формы")
    public static void fieldsLoginPageFilling(WebDriver webDriver, User user) {
        webDriver.manage().timeouts().implicitlyWait(4, java.util.concurrent.TimeUnit.SECONDS);
        webDriver.findElement(emailField).sendKeys(user.getEmail());
        webDriver.findElement(passwordField).sendKeys(user.getPassword());
        webDriver.findElement(loginButton).click();
    }
}
