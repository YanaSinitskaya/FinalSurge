package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class WorkoutPage extends BasePage {
    public WorkoutPage(WebDriver driver) {
        super(driver);
    }

    final String WORKOUT_URL = "WorkoutAdd.cshtml";
    final By WORKOUT_DATE = By.id("WorkoutDate");
    final By WORKOUT_TIME = By.id("WorkoutTime");
    final By WORKOUT_NAME = By.id("Name");
    final By WORKOUT_DESCR = By.id("Desc");
    final By WORKOUT_DIST = By.id("Distance");
    final By DIST_TYPE = By.id("DistType");
    final By DIST_NO_INT = By.id("DistTypeNoInt");
    final By DURATION = By.id("Duration");
    final By DURATION_NO_INT = By.id("DurationNoInt");
    final By T_INTERVALS = By.id("tIntervals");
    final By SET_REPS1 = By.id("SetReps1");
    final By SET_DIST1 = By.id("SetDist1");
    final By SET_TIME1 = By.id("SetTime1");
    final By MIN_HR = By.id("MinHR");
    final By AV_HR = By.id("AvgHR");
    final By MAX_HR = By.id("MaxHR");
    final By K_CAL = By.id("kCal");
    final By POW_AVG = By.id("PowAvg");
    final By POW_MAX = By.id("PowMax");
    final By CAD_AVG = By.id("CadAvg");
    final By CAD_MAX = By.id("CadMax");
    final By E_GAIN = By.id("EGain");
    final By E_LOSS = By.id("ELoss");
    final By PER_EFFORT = By.id("PerEffort");
    final By SAVE_BUTTON = By.id("saveButton");
    final By DROPDOWN_TOGGEL = By.cssSelector(".dropdown-toggle");

    public void open() {
        driver.get(BASE_URL + WORKOUT_URL);
    }

    @Step("Open tabs")
    public void tabOpen(String tab) {
        driver.findElement(By.xpath(String.format("//a[@data-code='%s']", tab))).click();
    }

    @Step("Fill workout date: Date - '{date}'")
    public void dateWorkout(String date) {
        log.info("Workout date is entered");
        driver.findElement(WORKOUT_DATE).clear();
        driver.findElement(WORKOUT_DATE).sendKeys(date);
    }

    @Step("Fill workout time: Time - '{time}'")
    public void timeWorkout(String time) {
        log.info("Workout time is entered");
        driver.findElement(WORKOUT_TIME).sendKeys(time);
    }

    @Step("Fill workout name: Name - '{name}'")
    public void nameWorkout(String name) {
        log.info("Workout name is entered");
        driver.findElement(WORKOUT_NAME).sendKeys(name);
    }

    @Step("Fill workout description: Description - '{description}'")
    public void descriptionWorkout(String description) {
        log.info("Workout description is entered");
        driver.findElement(WORKOUT_DESCR).sendKeys(description);
    }

    @Step("Fill workout distance: Distance - '{distance}'")
    public void distanceWorkout(String distance) {
        log.info("Workout distance is entered");
        driver.findElement(WORKOUT_DIST).sendKeys(distance);
        Select select = new Select(driver.findElement(DIST_TYPE));
        select.selectByVisibleText("m");
    }

    @Step("Fill workout distance: Distance - '{distance}'")
    public void distanceForCrossTrainingWorkout(String distance) {
        log.info("Workout distance for Cross Training is entered");
        driver.findElement(DIST_NO_INT).sendKeys(distance);
        Select select = new Select(driver.findElement(DIST_NO_INT));
        select.selectByVisibleText("m");
    }

    @Step("Fill workout duration: Duration - '{duration}'")
    public void durationWorkout(String duration) {
        log.info("Workout duration is entered");
        driver.findElement(DURATION).sendKeys(duration);
    }

    @Step("Fill workout duration: Duration - '{duration}'")
    public void durationNoIntWorkout(String duration) {
        log.info("Workout duration without int is entered");
        driver.findElement(DURATION_NO_INT).sendKeys(duration);
    }

    @Step("Сhoose an advanced workout")
    public void advancedWorkout() {
        log.info("Workout advance is entered");
        driver.findElement(T_INTERVALS).click();
    }

    @Step("Fill workout reps: Reps - '{reps}'")
    public void repsOfSetWorkout(String reps) {
        log.info("Workout reps is entered");
        driver.findElement(SET_REPS1).sendKeys(reps);
    }

    @Step("Fill workout distance: Distance - '{distance}'")
    public void distanceOfSetWorkout(String distance) {
        log.info("Workout distance of set is entered");
        driver.findElement(SET_DIST1).sendKeys(distance);
    }

    @Step("Fill workout duration: Duration - '{duration}'")
    public void durationOfSetWorkout(String duration) {
        log.info("Workout duration of set is entered");
        driver.findElement(SET_TIME1).sendKeys(duration);
    }

    @Step("Fill HR inputs: MinHR - '{minHR}', AvgHR - '{avgHR}', MaxHR - '{maxHR}'")
    public void hrWorkout(String minHR, String avgHR, String maxHR) {
        log.info("Hr inputs data were entered '{}', '{}', '{}'", minHR, avgHR, maxHR);
        driver.findElement(MIN_HR).sendKeys(minHR);
        driver.findElement(AV_HR).sendKeys(avgHR);
        driver.findElement(MAX_HR).sendKeys(maxHR);
    }

    @Step("Fill kCal input: KCal - '{kCal}'")
    public void kCalWorkout(String kCal) {
        log.info("Workout calories is entered");
        driver.findElement(K_CAL).sendKeys(kCal);
    }

    @Step("Fill pow: PowAvg - '{kCal}', PowMax - '{powMax}'")
    public void powWorkout(String powAvg, String powMax) {
        log.info("Workout pow is entered '{}', '{}'", powAvg, powMax);
        driver.findElement(POW_AVG).sendKeys(powAvg);
        driver.findElement(POW_MAX).sendKeys(powMax);
    }

    @Step("Fill cad: CadAvg - '{cadAvg}', CadMax - '{cadMax}'")
    public void cadWorkout(String cadAvg, String cadMax) {
        log.info("Workout cad is entered '{}', '{}'", cadAvg, cadMax);
        driver.findElement(CAD_AVG).sendKeys(cadAvg);
        driver.findElement(CAD_MAX).sendKeys(cadMax);
    }

    @Step("Fill Elevation: Elevation Gain - '{EGain}', Elevation Loss - '{ELoss}'")
    public void elevationWorkout(String elevationGain, String elevationLoss) {
        log.info("Workout elevation is entered '{}', '{}'", elevationGain, elevationLoss );
        driver.findElement(E_GAIN).sendKeys(elevationGain);
        driver.findElement(E_LOSS).sendKeys(elevationLoss);
    }

    @Step("The sign of Feels")
    public void howIFelt(String feel) {
        log.info("How I Felt is entered");
        driver.findElement(By.name("howfeel")).click();
    }

    @Step("The sign of Perceived Effort")
    public void perceivedEffort(String effort) {
        log.info("Perceived Effort is entered");
        Select select = new Select(driver.findElement(PER_EFFORT));
        select.selectByVisibleText(effort);
    }

    @Step("Save button")
    public void saveWorkout() {
        log.info("User is saved 'Workout'");
        driver.findElement(SAVE_BUTTON).click();
    }

    @Step("Search for a workout")
    public boolean getWorkout() {
        log.info("Workout is displayed on 'Calendar' page");
        return driver.findElement(DROPDOWN_TOGGEL).isDisplayed();
    }
}