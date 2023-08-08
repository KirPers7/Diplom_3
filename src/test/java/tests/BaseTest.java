package tests;

import clients.UserClient;
import data.UserGenerator;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.MainPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pojo.User;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver webDriver;
    protected final UserGenerator userGenerator = new UserGenerator();
    protected final UserClient userClient = new UserClient();
    User user = userGenerator.randomUser();
    protected String accessToken;
    protected String refreshToken;
    protected final String email = user.getEmail();
    protected final String password = user.getPassword();

    protected final String incorrectPassword = RandomStringUtils.randomAlphabetic(5);

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();

//        ChromeOptions options = new ChromeOptions();
//        options.setBinary("C:\\Users\\kopachinskiy_ke\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\");
//        webDriver = new ChromeDriver(options);

        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(webDriver);
        mainPage.open();
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}
