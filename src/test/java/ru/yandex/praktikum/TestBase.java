package ru.yandex.praktikum;

import com.google.gson.Gson;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.api.UserClient;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver webDriver;
    protected final RegistationPage registationPage = new RegistationPage();
    protected final LoginPage enterPage = new LoginPage();
    protected final UserClient userClient = new UserClient();
    protected final ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    protected final PersonalAccountPage personalAccountPage = new ru.yandex.praktikum.PersonalAccountPage();
    protected final MainPage mainPage = new MainPage();
    protected final Gson gson = new Gson();

    public static void setUpChrome() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void setUpYandex() {
        System.setProperty("webdriver.chrome.driver", "/Users/artembragin/Documents/yandexdriver");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void setUpBrowser(String browserName) {
        if (browserName == "chrome") {
            setUpChrome();
        } else if (browserName == "yandex") {
            setUpYandex();
        }
    }

    @Before
    public void setUpBrowser() {
        setUpBrowser("yandex");
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}