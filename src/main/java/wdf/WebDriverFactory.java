package wdf;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class WebDriverFactory {

    public static WebDriver getBs() {
        WebDriver webDriver;

        String browserName = System.getProperty("browserName");

        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            case "yandexBrowser":
                System.setProperty("webdriver.http.factory", "jdk-http-client");
                ChromeDriverService service = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File("C:\\Users\\kopachinskiy_ke\\WebDriver\\bin\\chromedriver.exe"))
                        .build();
                ChromeOptions options = new ChromeOptions()
                        .setBinary("C:\\Users\\kopachinskiy_ke\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
                webDriver = new ChromeDriver(service, options);
                break;
            default:
                throw new RuntimeException("Browser is not detected");
        }
        return webDriver;
    }
}