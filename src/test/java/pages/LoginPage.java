package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public static final By USER = By.id("login_name");
    public static final By PASSWORD = By.id("login_password");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void open() {
        driver.get(BASE_URL + "login.cshtml");
    }
    @Step("Login by user {user} using password {password}")
    public void login(String user, String password) {
        driver.findElement(USER).sendKeys(user);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(PASSWORD).submit();
    }
}





