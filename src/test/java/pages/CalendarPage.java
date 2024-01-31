package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalendarPage extends BasePage {
    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    final String CALENDAR_URL = BASE_URL + "Calendar.cshtml";
    final By ADD_WORKOUT_BUTTON = By.id("saveButton");

    @Step("Open calendar page")
    public void open() {
        driver.get(CALENDAR_URL);
    }

    // ПОСМОТРЕТЬ ЛОКАТОР!!
    public void addActivityOnCalendar() {
        driver.findElement(By.cssSelector(".calendar-add dropdown")).click();
    }

    public void saveWorkoutOnCalendar() {
        driver.findElement(ADD_WORKOUT_BUTTON);
    }

}
