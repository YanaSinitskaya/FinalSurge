package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButton {
    public static final String INPUT_LOCATOR = "%s";
    WebDriver driver;
    String label;

    public RadioButton(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String value) {
        if (value != null) {
            driver.findElement(By.xpath(String.format("//*[text()='%s']//ancestor::div//*[text()='%s']", label, value))).click();
        }
    }
}
