package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    final String LOGIN_URL = BASE_URL + "login.cshtml";
    private final By EMAIL = By.id("login_name");
    private final By PASSWORD = By.id("login_password");
    private final By LOGIN_BUTTON = By.cssSelector("//div[@class='submit_sect']//button[@class='btn btn-beoro-1' and contains(text(),'Login')]");
    private final By CALENDAR = By.cssSelector(".fc-header-center");

    public void open() {
        driver.get(LOGIN_URL);
    }

    public void login(String email, String password) {
        driver.findElement(EMAIL).sendKeys(email);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(CALENDAR));
    }

    public boolean successfulLogin() {
        return driver.findElement(CALENDAR).isDisplayed();
    }
}
