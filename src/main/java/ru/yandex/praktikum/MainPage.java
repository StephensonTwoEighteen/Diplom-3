package ru.yandex.praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static ru.yandex.praktikum.links.Links.MAIN_PAGE;

public class MainPage {
    WebDriver webDriver;
    private By loginMainPageButton = By.xpath(".//*[.='Войти в аккаунт']");
    private By orderCreateButton = By.xpath(".//*[.='Оформить заказ']");
    private By personalAccountButton = By.xpath(".//*[contains (text(), \"Личный Кабинет\")]");
    private By bunButton = By.xpath(".//div/span[text()='Булки']");
    private By saucesButton = By.xpath(".//div/span[text()='Соусы']");
    private By fillingsButton = By.xpath(".//div/span[text()='Начинки']");
    private By choosedHeader = By.className("tab_tab_type_current__2BEPc");

    public MainPage() {
        webDriver = webDriver;
    }

    @Step("Открытие страницы регистрации")
    public static void openMain(WebDriver webDriver) {
        webDriver.get(MAIN_PAGE);
    }

    @Step("Клик на кнопку логина")
    public void loginMainPageButtonCLick(WebDriver webDriver) {
        webDriver.findElement(loginMainPageButton).click();
    }

    @Step("Отображение кнопки заказа")
    public boolean orderCreateButtonDisplayed(WebDriver webDriver) {
        return webDriver.findElement(orderCreateButton).isDisplayed();
    }

    @Step("Клик на кнопку личного кабинета")
    public void personalAccountButtonCLick(WebDriver webDriver) {
        webDriver.findElement(personalAccountButton).click();
    }

    @Step("Клик на кнопку Булки")
    public void bunButtonCLick(WebDriver webDriver) {
        webDriver.findElement(bunButton).click();
    }

    @Step("Получение текста кнопки Булки>")
    public String bunButtonGetText(org.openqa.selenium.WebDriver webDriver) {
        return webDriver.findElement(bunButton).getText();
    }

    @Step("Клик на кнопку Соусы")
    public void saucesButtonCLick(WebDriver webDriver) {
        webDriver.findElement(saucesButton).click();
    }

    @Step("Получение текста кнопки Соусы")
    public String saucesButtonGetText(WebDriver webDriver) {
        return webDriver.findElement(saucesButton).getText();
    }

    @Step("Клик на кнопку Начинки")
    public void fillingsButtonCLick(WebDriver webDriver) {
        webDriver.findElement(fillingsButton).click();
    }

    @Step("Получение текста кнопки Начинки")
    public String fillingsButtonGetText(WebDriver webDriver) {
        return webDriver.findElement(fillingsButton).getText();
    }

    @Step("Получение текста активной кнопки")
    public String choosedHeaderGetText(WebDriver webDriver) {
        return webDriver.findElement(choosedHeader).getText();
    }
}