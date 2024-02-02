package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DropDown {
    WebDriver driver;
    String label;

    public DropDown(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {
        if (option != null) {
            driver.findElement(By.xpath(String.format("//*[text()='%s']//ancestor::div[contains(@class,'formSep')]//select", label))).click();
            driver.findElement(By.xpath(String.format("//*[text()='%s']//ancestor::div[contains(@class,'formSep')]//*[text()='%s']", label, option))).click();
        }
    }
}




