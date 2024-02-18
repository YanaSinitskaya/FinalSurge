package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
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
        log.info("Open 'Login' page");
        driver.get(LOGIN_URL);
    }

    @Step("Login by user {user} using password {password}")
    public void login(String user, String password) {
        log.info("Log in using credentials: '{}', '{}'", user, password);
        driver.findElement(USER).sendKeys(user);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(PASSWORD).submit();
    }

    @Step("Successful login")
    public boolean successfulLogin() {
        log.info("User is logged success");
        return driver.findElement(MAIN_PAGE).isDisplayed();
    }

    @Step("Get text of error message ")
    public String errorMessage() {
        log.info("Error message is displayed");
        return driver.findElement(ERROR).getText();
    }

    @Step("Get text of error invalid login ")
    public String invalidLogin() {
        log.info("User is entered an invalid login");
        return driver.findElement(INVALID_LOGIN_ERROR).getText();
    }
}