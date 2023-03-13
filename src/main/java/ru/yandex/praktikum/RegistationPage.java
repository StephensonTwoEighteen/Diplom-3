package ru.yandex.praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.api.User;

import java.util.concurrent.TimeUnit;

import static ru.yandex.praktikum.links.Links.REGISTERATION_PAGE;

;

public class RegistationPage {
    protected static By firstNameField = By.xpath(".//fieldset[1]//input");
    protected static By emailField = By.xpath(".//fieldset[2]//input");
    protected static By passwordField = By.xpath(".//fieldset[3]//input");

    protected static By registrationButton = By.xpath(".//button[contains (text(), \"Зарегистрироваться\")]");
    public static By successRegistered = By.xpath(".//*[contains (text(), \"Вход\")]");
    public static By notCorrectPassword = By.xpath(".//*[contains (text(), \"Некорректный пароль\")]");
    public static String successRegisteredExpected = "Вход";
    public static By loginRegistrationPageButton = By.className("Auth_link__1fOlj");

    private String notEnoughPasswordSymbols = "fH7D0";

    @Step("Открытие страницы регистрации")
    public static void openRegistration(WebDriver webDriver) {
        webDriver.get(REGISTERATION_PAGE);
    }

    @Step("Заполнение полей страницы регистрации")
    public static void fillRegistrationPageFields(WebDriver webDriver, User user) {
        webDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        webDriver.findElement(firstNameField).sendKeys(user.getName());
        webDriver.findElement(emailField).sendKeys(user.getEmail());
        webDriver.findElement(passwordField).sendKeys(user.getPassword());
        webDriver.findElement(registrationButton).click();
    }

    @Step("Заполнение полей страницы регистрации невалидными данными")
    public static void fillRegistrationPageFieldsNegative(WebDriver webDriver, User user) {
        webDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        webDriver.findElement(firstNameField).sendKeys(user.getName());
        webDriver.findElement(emailField).sendKeys(user.getEmail());
        webDriver.findElement(passwordField).sendKeys(user.getPassword());
        webDriver.findElement(registrationButton).click();
    }
}
