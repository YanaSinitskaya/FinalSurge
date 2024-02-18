package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkbox {
    WebDriver driver;
    String label;

    public Checkbox(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(boolean isNeedToSelect) {
        if (isNeedToSelect) {
            driver.findElement(By.xpath(String.format("//*[text()='%s']//ancestor::label[contains(@class,'checkbox inline')]//input", label))).click();
        }
    }
}