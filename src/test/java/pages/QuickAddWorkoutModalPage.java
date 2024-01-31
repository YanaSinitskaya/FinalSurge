package pages;

import dto.QuickAddWorkout;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.DropDown;
import wrappers.Input;
import wrappers.TextArea;

public class QuickAddWorkoutModalPage extends BasePage {
    public final static By SAVE_BUTTON = By.id("saveButton");

    public QuickAddWorkoutModalPage(WebDriver driver) {
        super(driver);
    }

    @Step("Filling in all fields in Quick Add Workout")
    public QuickAddWorkoutModalPage fillingInAllFields (QuickAddWorkout quickAddWorkout) {
        driver.findElement(By.id("WorkoutDate")).clear();
        new Input(driver, "WorkoutDate").write(quickAddWorkout.getWorkoutDate());
        new Input(driver, "WorkoutTime").write(quickAddWorkout.getTimeOfDay());
        new DropDown(driver, "Activity Type").select(quickAddWorkout.getActivityType());
        new Input(driver, "Workout Name").write(quickAddWorkout.getWorkoutName());
        new TextArea(driver, "Workout Description").write(quickAddWorkout.getWorkoutDescription());
        new Input(driver, "Distance").write(quickAddWorkout.getDistanceNumber());
        new DropDown(driver, "Distance").select(quickAddWorkout.getDistanceType());
        new Input(driver, "Duration").write(quickAddWorkout.getDuration());
        new Input(driver, "Pace").write(quickAddWorkout.getPaceNumber());
        new DropDown(driver, "Distance").select(quickAddWorkout.getPaceType());
        new DropDown(driver, "HowFeel").select(quickAddWorkout.getHowFeel());
        new DropDown(driver, "PerEffort").select(quickAddWorkout.getPerEffort());
        new TextArea(driver, "Post Workout Notes/Results").write(quickAddWorkout.getPostWorkoutNotesResults());
        return this;
    }

    public void save() {
        driver.findElement(SAVE_BUTTON).click();
    }
}
