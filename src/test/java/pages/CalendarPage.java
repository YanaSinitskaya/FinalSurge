package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class CalendarPage extends BasePage {
    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    final String CALENDAR_URL = BASE_URL + "Calendar.cshtml";
    final By QUICK_WORKOUT_BUTTON = By.id("QuickAddToggle");

    @Step("Open calendar page")
    public void open() {
        log.info("Open 'Calendar' page");
        driver.get(CALENDAR_URL);
    }

    @Step("Add Quick Workout with toggle")
    public void addQuickWorkoutWithButton() {
        log.info("Quick Workout is added with toggle");
        driver.findElement(QUICK_WORKOUT_BUTTON).click();
    }

    @Step("Check that visibility of workout element on Calendar")
    public boolean QuickWorkOutIsDisplayed(String day, String month, String year) {
        log.info("Quick Workout is displayed on the Calendar page: '{}', '{}', '{}'", day, month, year);
        return driver.findElement(By.cssSelector(String.format("div.fc-day-content[data-day='%s'][data-month='%s'][data-year='%s']", day, month, year))).isDisplayed();
    }

    @Step("Delete Workout from Calendar")
    public void deleteWorkoutFromCalendar(String date) {
        log.info("Workout is deleted from the Calendar");
        driver.findElement(By.cssSelector(String.format("div.dropdown.calendarworkout.drag-workout-source.drag-workout-reorder-target.ui-draggable.ui-droppable[data-date='%s']", date))).click();
        driver.findElement(By.cssSelector(".quick-delete")).click();
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".calheader")));
    }
}