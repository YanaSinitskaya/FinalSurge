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
    final By WORKOUTDATE = By.id("WorkoutDate");
    final By WORKOUTTIME = By.id("WorkoutTime");
    final By WORKOUTNAME = By.id("Name");
    final By WORKOUTDESCR = By.id("Desc");
    final By WORKOUTDIST = By.id("Distance");
    final By DISTTYPE = By.id("DistType");
    final By DISTNOINT = By.id("DistTypeNoInt");
    final By DURATION = By.id("Duration");
    final By DURATIONNOINT = By.id("DurationNoInt");
    final By TINTERVALS = By.id("tIntervals");
    final By SETREPS1 = By.id("SetReps1");
    final By SETDIST1 = By.id("SetDist1");
    final By SETTIME1 = By.id("SetTime1");
    final By MINHR = By.id("MinHR");
    final By AVHR = By.id("AvgHR");
    final By MAXHR = By.id("MaxHR");
    final By KCAL = By.id("kCal");
    final By POWAVG = By.id("PowAvg");
    final By POWMAX = By.id("PowMax");
    final By CADAVG = By.id("CadAvg");
    final By CADMAX = By.id("CadMax");
    final By EGAIN = By.id("EGain");
    final By ELOSS = By.id("ELoss");
    final By PEREFFORT = By.id("PerEffort");
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
        driver.findElement(WORKOUTDATE).clear();
        driver.findElement(WORKOUTDATE).sendKeys(date);
    }

    @Step("Fill workout time: Time - '{time}'")
    public void timeWorkout(String time) {
        log.info("Workout time is entered");
        driver.findElement(WORKOUTTIME).sendKeys(time);
    }

    @Step("Fill workout name: Name - '{name}'")
    public void nameWorkout(String name) {
        log.info("Workout name is entered");
        driver.findElement(WORKOUTNAME).sendKeys(name);
    }

    @Step("Fill workout description: Description - '{description}'")
    public void descriptionWorkout(String description) {
        log.info("Workout description is entered");
        driver.findElement(WORKOUTDESCR).sendKeys(description);
    }

    @Step("Fill workout distance: Distance - '{distance}'")
    public void distanceWorkout(String distance) {
        log.info("Workout distance is entered");
        driver.findElement(WORKOUTDIST).sendKeys(distance);
        Select select = new Select(driver.findElement(DISTTYPE));
        select.selectByVisibleText("m");
    }

    @Step("Fill workout distance: Distance - '{distance}'")
    public void distanceForCrossTrainingWorkout(String distance) {
        log.info("Workout distance for Cross Training is entered");
        driver.findElement(DISTNOINT).sendKeys(distance);
        Select select = new Select(driver.findElement(DISTNOINT));
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
        driver.findElement(DURATIONNOINT).sendKeys(duration);
    }

    @Step("Сhoose an advanced workout")
    public void advancedWorkout() {
        log.info("Workout advance is entered");
        driver.findElement(TINTERVALS).click();
    }

    @Step("Fill workout reps: Reps - '{reps}'")
    public void repsOfSetWorkout(String reps) {
        log.info("Workout reps is entered");
        driver.findElement(SETREPS1).sendKeys(reps);
    }

    @Step("Fill workout distance: Distance - '{distance}'")
    public void distanceOfSetWorkout(String distance) {
        log.info("Workout distance of set is entered");
        driver.findElement(SETDIST1).sendKeys(distance);
    }

    @Step("Fill workout duration: Duration - '{duration}'")
    public void durationOfSetWorkout(String duration) {
        log.info("Workout duration of set is entered");
        driver.findElement(SETTIME1).sendKeys(duration);
    }

    @Step("Fill HR inputs: MinHR - '{minHR}', AvgHR - '{avgHR}', MaxHR - '{maxHR}'")
    public void hrWorkout(String minHR, String avgHR, String maxHR) {
        log.info("Hr inputs data were entered '{}', '{}', '{}'", minHR, avgHR, maxHR);
        driver.findElement(MINHR).sendKeys(minHR);
        driver.findElement(AVHR).sendKeys(avgHR);
        driver.findElement(MAXHR).sendKeys(maxHR);
    }

    @Step("Fill kCal input: KCal - '{kCal}'")
    public void kCalWorkout(String kCal) {
        log.info("Workout calories is entered");
        driver.findElement(KCAL).sendKeys(kCal);
    }

    @Step("Fill pow: PowAvg - '{kCal}', PowMax - '{powMax}'")
    public void powWorkout(String powAvg, String powMax) {
        log.info("Workout pow is entered '{}', '{}'", powAvg, powMax);
        driver.findElement(POWAVG).sendKeys(powAvg);
        driver.findElement(POWMAX).sendKeys(powMax);
    }

    @Step("Fill cad: CadAvg - '{cadAvg}', CadMax - '{cadMax}'")
    public void cadWorkout(String cadAvg, String cadMax) {
        log.info("Workout cad is entered '{}', '{}'", cadAvg, cadMax);
        driver.findElement(CADAVG).sendKeys(cadAvg);
        driver.findElement(CADMAX).sendKeys(cadMax);
    }

    @Step("Fill Elevation: Elevation Gain - '{EGain}', Elevation Loss - '{ELoss}'")
    public void elevationWorkout(String elevationGain, String elevationLoss) {
        log.info("Workout elevation is entered '{}', '{}'", elevationGain, elevationLoss );
        driver.findElement(EGAIN).sendKeys(elevationGain);
        driver.findElement(ELOSS).sendKeys(elevationLoss);
    }

    @Step("The sign of Feels")
    public void howIFelt(String feel) {
        log.info("How I Felt is entered");
        driver.findElement(By.name("howfeel")).click();
    }

    @Step("The sign of Perceived Effort")
    public void perceivedEffort(String effort) {
        log.info("Perceived Effort is entered");
        Select select = new Select(driver.findElement(PEREFFORT));
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