package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculatorPage extends BasePage {
    public static final By ERROR_MESSAGE = By.cssSelector(".alert-error");
    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open calculator")
    public void open() {
        driver.get(BASE_URL + "Calendar.cshtml");
        driver.findElement(By.xpath("//i[@class = 'icsw16-calculator']")).click();
        driver.switchTo().frame("OtherCalciFrame");
    }

    @Step("Choose Pace Calculator")
    public void paceCalc() {
        driver.findElement(By.xpath("//a[contains(text(),'Pace Calculator')]")).click();
    }

    @Step("Fill Distance")
    public void distance(String distance) {
        driver.findElement(By.id("RunDist")).sendKeys(distance);
    }

    @Step("Fill Time")
    public void time(String hours, String minutes, String seconds) {
        driver.findElement(By.id("TimeHH")).sendKeys(hours);
        driver.findElement(By.id("TimeMM")).sendKeys(minutes);
        driver.findElement(By.id("TimeSS")).sendKeys(seconds);
    }

    @Step("Fill distance")
    public void saveButton() {
        driver.findElement(By.id("saveButtonSettings")).click();
    }

    @Step("Search for a pace")
    public boolean getPace() {
        return driver.findElement(By.xpath("//*[@class='w-box-header']//*[text()='Pace Chart']")).isDisplayed();
    }

    @Step("Search for a pace")
    public boolean getCaloricNeeds() {
        return driver.findElement(By.xpath("//*[@class='w-box-header']//*[text()='Daily Caloric Needs Calculator']")).isDisplayed();
    }

    @Step("Fill Weight")
    public void weight(String weight) {
        driver.findElement(By.id("Weight")).sendKeys(weight);
        driver.findElement(By.id("optionsRadios4")).click();
    }

    @Step("Fill Height")
    public void height(String height) {
        driver.findElement(By.id("HeightInchCent")).sendKeys(height);
        driver.findElement(By.cssSelector("[value=m]")).click();
    }

    @Step("Fill Age")
    public void age(String age) {
        driver.findElement(By.id("Age")).sendKeys(age);
    }

    @Step("Сhoose female gender")
    public void femaleGender() {
        driver.findElement(By.id("optionsRadios6")).click();
    }

    @Step("Сhoose male gender")
    public void maleGender() {
        driver.findElement(By.id("optionsRadios5")).click();
    }

    @Step("Fill run distance")
    public void runDistance(String distance) {
        driver.findElement(By.id("RunDist")).sendKeys(distance);
        driver.findElement(By.id("optionsRadios8")).click();
    }
    @Step("Error message from caloric needs calculator")
    public String getError() {
        return driver.findElement(ERROR_MESSAGE).getAttribute("innerText");
    }
}