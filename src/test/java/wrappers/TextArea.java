package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextArea {
    WebDriver driver;
    String label;

    public TextArea(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        if (text != null) {
            driver.findElement(By.xpath(String.format("//label[contains(text(),'%s')]/ancestor::div/textarea", label))).sendKeys(text);
        }
    }
}