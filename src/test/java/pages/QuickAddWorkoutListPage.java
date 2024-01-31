package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QuickAddWorkoutListPage extends BasePage {
    public static final By QUICK_ADD = By.id("QuickAddToggle");
    public static final By ERROR_MESSAGE = By.cssSelector(".alert-error");
    public static final By ALERT_MESSAGE = By.className("fc-event-activity-title");

    public QuickAddWorkoutListPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Calendar page")
    public QuickAddWorkoutListPage open() {
        driver.get(BASE_URL + "Calendar.cshtml");
        return this;
    }

    @Step("Click quick add workout on Calendar page")
    public QuickAddWorkoutModalPage clickQuickAddWorkout() {
        driver.findElement(QUICK_ADD).click();
        return new QuickAddWorkoutModalPage(driver);
    }

    @Step("Error message from Quick Workout")
    public String getError() {
        return driver.findElement(ERROR_MESSAGE).getAttribute("innerText");
    }

    @Step("Getting workout on Calendar page")
    public String getMessage(){
        return driver.findElement(ALERT_MESSAGE).getAttribute("innerText");
    }
}
