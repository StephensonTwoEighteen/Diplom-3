package ru.yandex.praktikum;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static ru.yandex.praktikum.links.Links.PROFILE_PAGE;

public class PersonalAccountPage {

    public static By constructorButton = By.xpath(".//*[contains (text(), 'Конструктор')]");
    public static By mainLogo = By.xpath(".//*[@class='AppHeader_header__logo__2D0X2']");
    public static By exitButton = By.xpath(".//button[contains (text(), 'Выход')]");


    @Step("Открыть личный кабинет")
    public static void openProfile(org.openqa.selenium.WebDriver webDriver) {
        webDriver.get(PROFILE_PAGE);
    }


}
