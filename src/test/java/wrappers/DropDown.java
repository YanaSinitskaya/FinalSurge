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
            driver.findElement(By.xpath(String.format("//label[contains(text(), '%s')]/..//select", label))).click();
            driver.findElement(By.xpath(String.format("//*[contains(@class,'formSep')]/descendant::option[contains(text(),'%s')]", option))).click();
        }
    }
}
    /* WebElement element =
    driver.findElement(By.xpath(String.format("//*[text()='%s']//ancestor::lightning-combobox//button", label)));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                    element.click();
    driver.findElement(By.xpath(String.format("//*[text()='%s']//ancestor::lightning-combobox//*[text()='%s']", label, option))).click(); */





