package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    final String BASE_URL = "https://log.finalsurge.com/";
    WebDriverWait wait;
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
}
    //public void waitForPageLoaded() {
        //new ExpectedCondition<Boolean>() {
           // public Boolean apply(WebDriver driver) {
                //return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            //}
        //};
    //}
//}


