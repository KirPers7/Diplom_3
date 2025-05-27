package tests;

import clients.UserClient;
import data.UserGenerator;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pageobject.MainPage;
import pojo.User;
import wdf.WebDriverFactory;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected final UserGenerator userGenerator = new UserGenerator();
    protected final UserClient userClient = new UserClient();
    protected final String incorrectPassword = RandomStringUtils.randomAlphabetic(5);
    protected String accessToken;
    protected String refreshToken;
    protected WebDriver webDriver;
    protected User user = userGenerator.randomUser();
    protected final String email = user.getEmail();
    protected final String password = user.getPassword();

    @Before
    public void setUp() {
        webDriver = WebDriverFactory.getBs();

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
