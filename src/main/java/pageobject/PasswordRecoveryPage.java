package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasswordRecoveryPage {

    //Кнопка "Войти"
    private static final By ENTER_BUTTON = By.xpath(".//a[text()='Войти']");
    WebDriver webDriver;

    public PasswordRecoveryPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public PasswordRecoveryPage enterButtonClick() {
        WebElement enterButton = webDriver.findElement(ENTER_BUTTON);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", enterButton);
        enterButton.click();
        return this;
    }
}
