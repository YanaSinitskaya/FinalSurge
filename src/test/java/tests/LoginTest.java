package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(description = "Successful login", retryAnalyzer = Retry.class)
        public void login() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        assertTrue(loginPage.successfulLogin(),"Not logged in" );
    }

    @Test(description = "Input empty email in Login", retryAnalyzer = Retry.class)
    public void emptyEmail() {
        loginPage.open();
        loginPage.login("", "Kz2-3B8-utt-kts");
        Assert.assertEquals(loginPage.errorMessage(),"Please enter your e-mail address.", "Enter email");
    }

    @Test(description = "Input wrong password in Login", retryAnalyzer = Retry.class)
    public void invalidLogin() {
        loginPage.open();
        loginPage.login("yanasyhar@gmail.com", "12345");
        Assert.assertEquals(loginPage.invalidLogin(),"Invalid login credentials. Please try again.", "Check for login creds");
    }
}