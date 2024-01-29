package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest {

    @Test(description = "Вход в аккаунт")
        public void login() {
        loginPage.open();
        loginPage.login("yanasyhar@gmail.com", "Kz2-3B8-utt-kts");
        assertTrue(loginPage.successfulLogin());

    }
}
