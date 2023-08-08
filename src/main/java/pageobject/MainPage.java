package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    //Кнопка "Войти в аккаунт"
    private static final By AUTHORIZATION_BUTTON = By.xpath(".//button[text()='Войти в аккаунт']");
    //Кнопка "Оформить заказ"
    private static final By CHECKOUT_BUTTON = By.xpath(".//button[text()='Оформить заказ']");
    //Кнопка "Личный Кабинет"
    private static final By PERSONAL_ACCOUNT_BUTTON = By.xpath(".//p[text()='Личный Кабинет']");
    //Кнопка "Соусы"
    private static final By SAUCES_BUTTON = By.xpath(".//span[text()='Соусы']");
    //Кнопка "Начинки"
    private static final By FILLINGS_BUTTON = By.xpath(".//span[text()='Начинки']");
    //Кнопка "Булки"
    private static final By BUNS_BUTTON = By.xpath(".//span[text()='Булки']");
    //Раздел "Соусы"
    private static final By SAUCES_SECTION = By.xpath(".//h2[text()='Соусы']");
    //Раздел "Начинки"
    private static final By FILLINGS_SECTION = By.xpath(".//h2[text()='Начинки']");
    //Раздел "Булки"
    private static final By BUNS_SECTION = By.xpath(".//h2[text()='Булки']");

    WebDriver webDriver;

    public MainPage(WebDriver driver) {
        this.webDriver = driver;
    }

    public void open() {
        webDriver.get(PAGE_URL);
        webDriver.manage().window().maximize();
    }

    public MainPage personalAccountButtonClick() {
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions.elementToBeClickable(PERSONAL_ACCOUNT_BUTTON)).click();
        return this;
    }

    public MainPage signInButtonClick() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.elementToBeClickable(AUTHORIZATION_BUTTON)).click();
        return this;
    }

    public MainPage checkoutButtonAvailable() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.elementToBeClickable(CHECKOUT_BUTTON));
        return this;
    }

    public MainPage saucesClick() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.elementToBeClickable(SAUCES_BUTTON)).click();
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(SAUCES_SECTION));
        return this;
    }

    public MainPage fillingsClick() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.elementToBeClickable(FILLINGS_BUTTON)).click();
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(FILLINGS_SECTION));
        return this;
    }

    public MainPage bunsClick() {
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.elementToBeClickable(BUNS_BUTTON)).click();
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(BUNS_SECTION));
        return this;
    }
}
