package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

@Log4j2
public class CalendarPage extends BasePage {
    public CalendarPage(WebDriver driver) {
        super(driver);
    }
    final static Date TODAY_DATE = new Date();
    final String CALENDAR_URL = BASE_URL + "Calendar.cshtml";
    final By QUICK_WORKOUT_BUTTON = By.id("QuickAddToggle");
    final By DELETE_BUTTON_DROPDOWN = By.xpath("//div[@class='dropdown calendarworkout drag-workout-source drag-workout-reorder-target ui-draggable ui-droppable open']" +
            "//a[contains(@class,'quick-delete') and text()='Delete']");

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
    public boolean quickWorkOutIsDisplayed(String day, String month, String year, String training) {
        log.info("Quick Workout '{}' is displayed on the Calendar page on '{}', '{}', '{}'", training, day, month, year);
            int size = driver.findElements(By.xpath(String.format("//div[@class='fc-day-content' and @data-day='%s' and @data-month='%s' and @data-year='%s']" +
                    "//following-sibling::div[contains(@class, 'fc-event-activity-title') and text()='%s']", day, month, year, training))).size();
            if (size > 0) {
                return true;
            } else {
                return false;
            }
    }


    @Step("Delete Workout from Calendar")
    public void deleteWorkoutFromCalendar(String day, String month, String year, String training) {
        log.info("Workout '{}' is deleted from the Calendar on date '{}', '{}', '{}'", training, day, month, year);
        driver.findElement(By.xpath(String.format("//div[@class='fc-day-content' and @data-day='%s' and @data-month='%s' and @data-year='%s']" +
                "//following-sibling::div[contains(@class, 'fc-event-activity-title') and text()='%s']", day, month, year, training))).click();
        driver.findElement(DELETE_BUTTON_DROPDOWN).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('.btn.btn-primary',':before').click();");
    }

    @Step("Set date")
    public static String getTodayDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");
        return sdf.format(TODAY_DATE);
    }

    @Step("Get value of today date")
    public static String getValueByType(int typeOfDate) {
        int valueToAdd = 0;
        if (typeOfDate == Calendar.MONTH) {
            valueToAdd += 1;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(TODAY_DATE);
        return  String.valueOf(calendar.get(typeOfDate) + valueToAdd);
    }

    public void waitUntilTrainingDisappear (String day, String month, String year, String training) {
        int seconds = 3;
        Duration durationInSeconds = Duration.ofSeconds(seconds);
        WebDriverWait wait = new WebDriverWait(driver, durationInSeconds);
        wait.until(ExpectedConditions.invisibilityOfElementLocated
                (By.xpath(String.format("//div[@class='fc-day-content' and @data-day='%s' and @data-month='%s' and @data-year='%s']" +
                        "//following-sibling::div[contains(@class, 'fc-event-activity-title') and text()='%s']", day, month, year, training))));
    }
}