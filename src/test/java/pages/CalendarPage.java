package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalendarPage extends BasePage {
    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    final String CALENDAR_URL = BASE_URL + "Calendar.cshtml";

    @Step("Open calendar page")
    public void open() {
        driver.get(CALENDAR_URL);
    }

    /* ПОСМОТРЕТЬ ЛОКАТОР!!
    @Step("Add activity OnCalendar")
    public void addActivityOnCalendar() {
        driver.findElement(By.cssSelector(".calendar-add dropdown")).click();
    } */

    public void addQuickWorkoutWithButton() {
        driver.findElement(By.id("QuickAddToggle")).click();
    }

}
