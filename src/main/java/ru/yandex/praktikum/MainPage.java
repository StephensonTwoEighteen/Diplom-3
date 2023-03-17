package ru.yandex.praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static ru.yandex.praktikum.links.Links.MAIN_PAGE;

public class MainPage {
    public static WebDriver webDriver;
    public static By loginMainPageButton = By.xpath(".//*[.='Войти в аккаунт']");
    public static By orderCreateButton = By.xpath(".//*[.='Оформить заказ']");
    public static By personalAccountButton = By.xpath(".//*[contains (text(), \"Личный Кабинет\")]");
    public static By bunButton = By.xpath(".//div/span[text()='Булки']");
    public static By saucesButton = By.xpath(".//div/span[text()='Соусы']");
    public static By fillingsButton = By.xpath(".//div/span[text()='Начинки']");
    public static By choosedHeader = By.className("tab_tab_type_current__2BEPc");
    public MainPage() {
        webDriver = webDriver;
    }

    @Step("Открытие страницы регистрации")
    public static void openMain(WebDriver webDriver) {
        webDriver.get(MAIN_PAGE);
    }
}