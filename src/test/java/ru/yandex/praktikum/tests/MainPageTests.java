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
        mainPage.fillingsButtonCLick(webDriver);
        mainPage.bunButtonCLick(webDriver);
        String bunHeaderText = mainPage.bunButtonGetText(webDriver);

        assertEquals("Что-то пошло не так", bunHeaderText, mainPage.choosedHeaderGetText(webDriver));
    }

    @Test
    @DisplayName("Соусы")
    @Description("Переход к разделу Соусы")
    public void saucesHeaderChooseTest() {
        mainPage.saucesButtonCLick(webDriver);
        String sauceHeaderText = mainPage.saucesButtonGetText(webDriver);

        assertEquals("Что-то пошло не так", sauceHeaderText, mainPage.choosedHeaderGetText(webDriver));
    }

    @Test
    @DisplayName("Начинки")
    @Description("Переход к разделу Начинки")
    public void fillingsHeaderChooseTest() {
        mainPage.fillingsButtonCLick(webDriver);
        String fillingsHeaderText = mainPage.fillingsButtonGetText(webDriver);

        assertEquals("Что-то пошло не так", fillingsHeaderText, mainPage.choosedHeaderGetText(webDriver));
    }
}