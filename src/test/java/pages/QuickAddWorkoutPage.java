package pages;

import dto.QuickAddWorkout;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Checkbox;
import wrappers.DropDown;
import wrappers.Input;
import wrappers.TextArea;

@Log4j2
public class QuickAddWorkoutPage extends BasePage {
    public QuickAddWorkoutPage(WebDriver driver) {
        super(driver);
    }

    public final static By SAVE_BUTTON = By.id("saveButton");
    final By WORKOUT_DATE = By.id("WorkoutDate");

    @Step("Fill in all fields in Quick Add Workout")
    public QuickAddWorkoutPage fillFields(QuickAddWorkout quickAddWorkout) {
        log.info("Data filling on the 'Quick Add Workout' page");
        driver.findElement(WORKOUT_DATE).clear();
        new Input(driver, "Date").write(quickAddWorkout.getWorkoutDate());
        new Input(driver, "Time of Day").write(quickAddWorkout.getTimeOfDay());
        new DropDown(driver, "Activity Type").select(quickAddWorkout.getActivityType());
        new Input(driver, "Workout Name").write(quickAddWorkout.getWorkoutName());
        new TextArea(driver, "Workout Description").write(quickAddWorkout.getWorkoutDescription());
        new Input(driver, "Distance").write(quickAddWorkout.getDistanceNumber());
        new DropDown(driver, "Distance").select(quickAddWorkout.getDistanceType());
        new Input(driver, "Duration").write(quickAddWorkout.getDuration());
        new DropDown(driver, "Pace").select(quickAddWorkout.getPaceType());
        driver.findElement(By.id("Pace")).clear();
        new Input(driver, "Pace").write(quickAddWorkout.getPaceNumber());
        new DropDown(driver, "How I Felt").select(quickAddWorkout.getHowFeel());
        new DropDown(driver, "Perceived Effort").select(quickAddWorkout.getPerEffort());
        new TextArea(driver, "Post Workout Notes/Results").write(quickAddWorkout.getPostWorkoutNotesResults());
        new Checkbox(driver, "Show Planned Distance/Duration").select(quickAddWorkout.isShowPlannedDistanceDuration());
        new Input(driver, "Planned Distance").write(quickAddWorkout.getPDistance());
        new DropDown(driver, "Planned Distance").select(quickAddWorkout.getPDistanceType());
        new Input(driver, "Planned Duration").write(quickAddWorkout.getPDuration());
        new Checkbox(driver, "Mark as Race").select(quickAddWorkout.isMarkAsRace());
        new Input(driver, "Age Group Place").write(quickAddWorkout.getAgeGroupPlace());
        new Input(driver, "Overall Place").write(quickAddWorkout.getOverallPlace());
        new Checkbox(driver, "Save to Library").select(quickAddWorkout.isSaveToLibrary());
        return this;
    }

    @Step("Add Workout")
    public void save() {
        log.info("User is saved 'Workout'");
        driver.findElement(SAVE_BUTTON).click();
    }
}