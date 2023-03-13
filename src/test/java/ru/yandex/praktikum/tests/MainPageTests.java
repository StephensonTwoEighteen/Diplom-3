package ru.yandex.praktikum.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.praktikum.MainPage;
import ru.yandex.praktikum.TestBase;

import static org.junit.Assert.assertEquals;
import static ru.yandex.praktikum.MainPage.*;

public class MainPageTests extends TestBase {

    @Before
    @DisplayName("Открытие главной страницы")
    public void openMain() {
        MainPage.openMain(webDriver);
    }

    @Test
    @DisplayName("Булки")
    @Description("Переход к разделу Булки")
    public void bunHeaderChooseTest() {
        webDriver.findElement(fillingsButton).click();
        webDriver.findElement(bunButton).click();

        String bunHeaderText = webDriver.findElement(bunButton).getText();

        assertEquals("Что-то пошло не так", bunHeaderText, webDriver.findElement(choosedHeader).getText());
    }

    @Test
    @DisplayName("Соусы")
    @Description("Переход к разделу Соусы")
    public void saucesHeaderChooseTest() {
        webDriver.findElement(saucesButton).click();

        String sauceHeaderText = webDriver.findElement(saucesButton).getText();

        assertEquals("Что-то пошло не так", sauceHeaderText, webDriver.findElement(choosedHeader).getText());
    }

    @Test
    @DisplayName("Начинки")
    @Description("Переход к разделу Начинки")
    public void fillingsHeaderChooseTest() {
        webDriver.findElement(fillingsButton).click();

        String fillingsHeaderText = webDriver.findElement(fillingsButton).getText();

        assertEquals("Что-то пошло не так", fillingsHeaderText, webDriver.findElement(choosedHeader).getText());
    }
}
