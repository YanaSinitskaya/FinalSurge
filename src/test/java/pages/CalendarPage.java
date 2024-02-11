package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CalendarPage extends BasePage {
    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    final String CALENDAR_URL = BASE_URL + "Calendar.cshtml";
    final By QUICK_WORKOUT_BUTTON = By.id("QuickAddToggle");

    @Step("Open calendar page")
    public void open() {
        driver.get(CALENDAR_URL);
    }

    @Step("Add Quick Workout with toggle")
    public void addQuickWorkoutWithButton() {
        driver.findElement(QUICK_WORKOUT_BUTTON).click();
    }

    @Step("Checking visibility of Workout element on Calendar")
    public boolean QuickWorkOutIsDisplayed(String day, String month, String year) {
        return driver.findElement(By.cssSelector(String.format("div.fc-day-content[data-day='%s'][data-month='%s'][data-year='%s']", day, month, year))).isDisplayed();
    }

    @Step("Delete Workout from Calendar")
    public void deleteWorkoutFromCalendar(String date) {
        driver.findElement(By.cssSelector(String.format("div.dropdown.calendarworkout.drag-workout-source.drag-workout-reorder-target.ui-draggable.ui-droppable[data-date='%s']", date))).click();
        driver.findElement(By.cssSelector(".quick-delete")).click();
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".calheader")));
    }

}
