package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public static final By USER = By.id("login_name");
    public static final By PASSWORD = By.id("login_password");
    final String LOGIN_URL = BASE_URL+ "login.cshtml";
    final By ERROR = By.xpath("//label[@class='error']");
    final By INVALID_LOGIN_ERROR = By.cssSelector(".alert");
    final By MAIN_PAGE = By.id("dpMonth");

    @Step("Open login page")
    public void open() {
        driver.get(LOGIN_URL);
    }

    @Step("Login by user {user} using password {password}")
    public void login(String user, String password) {
        driver.findElement(USER).sendKeys(user);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(PASSWORD).submit();
    }

    @Step("Successful login")
    public boolean successfulLogin() {
        return driver.findElement(MAIN_PAGE).isDisplayed();
    }

    @Step("Get text of error message ")
    public String errorMessage() {
        return driver.findElement(ERROR).getText();
    }

    @Step("Get text of error invalid Login ")
    public String invalidLogin() {
        return driver.findElement(INVALID_LOGIN_ERROR).getText();
    }
}





