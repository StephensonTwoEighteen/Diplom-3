package ru.yandex.praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.api.User;

import java.util.concurrent.TimeUnit;

import static ru.yandex.praktikum.links.Links.REGISTERATION_PAGE;

public class RegistationPage {
    public By successRegistered = By.xpath(".//*[contains (text(), \"Вход\")]");
    public By notCorrectPassword = By.xpath(".//*[contains (text(), \"Некорректный пароль\")]");
    public String successRegisteredExpected = "Вход";
    public By loginRegistrationPageButton = By.className("Auth_link__1fOlj");
    private By firstNameField = By.xpath(".//fieldset[1]//input");
    private By emailField = By.xpath(".//fieldset[2]//input");
    private By passwordField = By.xpath(".//fieldset[3]//input");
    private By registrationButton = By.xpath(".//button[contains (text(), \"Зарегистрироваться\")]");

    @Step("Открытие страницы регистрации")
    public static void openRegistration(WebDriver webDriver) {
        webDriver.get(REGISTERATION_PAGE);
    }

    @Step("Заполнение полей страницы регистрации")
    public void fillRegistrationPageFields(WebDriver webDriver, User user) {
        webDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        webDriver.findElement(firstNameField).sendKeys(user.getName());
        webDriver.findElement(emailField).sendKeys(user.getEmail());
        webDriver.findElement(passwordField).sendKeys(user.getPassword());
        webDriver.findElement(registrationButton).click();
    }

    @Step("Заполнение полей страницы регистрации невалидными данными")
    public void fillRegistrationPageFieldsNegative(WebDriver webDriver, User user) {
        webDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        webDriver.findElement(firstNameField).sendKeys(user.getName());
        webDriver.findElement(emailField).sendKeys(user.getEmail());
        webDriver.findElement(passwordField).sendKeys(user.getPassword());
        webDriver.findElement(registrationButton).click();
    }
}