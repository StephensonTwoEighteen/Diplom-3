package ru.yandex.praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static ru.yandex.praktikum.links.Links.PROFILE_PAGE;

public class PersonalAccountPage {

    private By constructorButton = By.xpath(".//*[contains (text(), 'Конструктор')]");
    private By mainLogo = By.xpath(".//*[@class='AppHeader_header__logo__2D0X2']");
    private By exitButton = By.xpath(".//button[contains (text(), 'Выход')]");


    @Step("Открыть личный кабинет")
    public static void openProfile(org.openqa.selenium.WebDriver webDriver) {
        webDriver.get(PROFILE_PAGE);
    }

    @Step("Клик на кнопку конструктора")
    public void constructorButtonClick(WebDriver webDriver) {
        webDriver.findElement(constructorButton).click();
    }

    @Step("Клик на лого")
    public void mainLogoClick(WebDriver webDriver) {
        webDriver.findElement(mainLogo).click();
    }

    @Step("Клик на Выход")
    public void exitButtonClick(WebDriver webDriver) {
        webDriver.findElement(exitButton).click();
    }

    @Step("Отображение кнопки Выход")
    public boolean exitButtonDisplayed(WebDriver webDriver) {
        return webDriver.findElement(exitButton).isDisplayed();
    }
}
