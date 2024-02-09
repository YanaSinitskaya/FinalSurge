package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

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
    //final By DROPDOWN_TOGGEL = By.className("dropdown-toggle");
    final By DROPDOWN_TOGGEL = By.cssSelector(".dropdown-toggle");

    public void open() {
        driver.get(BASE_URL + WORKOUT_URL);
    }

    @Step("Open tabs")
    public void tabOpen(String tab) {
        //driver.findElement(By.cssSelector("[data-code=" + tab + "]")).click();
        driver.findElement(By.xpath(String.format("//a[@data-code='%s']", tab))).click();
    }

    @Step("Fill workout date: Date - '{date}'")
    public void dateWorkout(String date) {
        driver.findElement(WORKOUTDATE).clear();
        driver.findElement(WORKOUTDATE).sendKeys(date);
    }

    @Step("Fill workout time: Time - '{time}'")
    public void timeWorkout(String time) {
        driver.findElement(WORKOUTTIME).sendKeys(time);
    }

    @Step("Fill workout name: Name - '{name}'")
    public void nameWorkout(String name) {
        driver.findElement(WORKOUTNAME).sendKeys(name);
    }

    @Step("Fill workout description: Description - '{description}'")
    public void descriptionWorkout(String description) {
        driver.findElement(WORKOUTDESCR).sendKeys(description);
    }

    @Step("Fill workout distance: Distance - '{distance}'")
    public void distanceWorkout(String distance) {
        driver.findElement(WORKOUTDIST).sendKeys(distance);
        Select select = new Select(driver.findElement(DISTTYPE));
        select.selectByVisibleText("m");
    }

    @Step("Fill workout distance: Distance - '{distance}'")
    public void distanceForCrossTrainingWorkout(String distance) {
        driver.findElement(DISTNOINT).sendKeys(distance);
        Select select = new Select(driver.findElement(DISTNOINT));
        select.selectByVisibleText("m");
    }

    @Step("Fill workout duration: Duration - '{duration}'")
    public void durationWorkout(String duration) {
        driver.findElement(DURATION).sendKeys(duration);
    }

    @Step("Fill workout duration: Duration - '{duration}'")
    public void durationNoIntWorkout(String duration) {
        driver.findElement(DURATIONNOINT).sendKeys(duration);
    }

    @Step("Сhoose an advanced workout")
    public void advancedWorkout() {
        driver.findElement(TINTERVALS).click();
    }

    @Step("Fill workout reps: Reps - '{reps}'")
    public void repsOfSetWorkout(String reps) {
        driver.findElement(SETREPS1).sendKeys(reps);
    }

    @Step("Fill workout distance: Distance - '{distance}'")
    public void distanceOfSetWorkout(String distance) {
        driver.findElement(SETDIST1).sendKeys(distance);
    }

    @Step("Fill workout duration: Duration - '{duration}'")
    public void durationOfSetWorkout(String duration) {
        driver.findElement(SETTIME1).sendKeys(duration);
    }

    @Step("Fill HR inputs: MinHR - '{minHR}', AvgHR - '{avgHR}', MaxHR - '{maxHR}'")
    public void hrWorkout(String minHR, String avgHR, String maxHR) {
        driver.findElement(MINHR).sendKeys(minHR);
        driver.findElement(AVHR).sendKeys(avgHR);
        driver.findElement(MAXHR).sendKeys(maxHR);
    }

    @Step("Fill kCal input: KCal - '{kCal}'")
    public void kCalWorkout(String kCal) {
        driver.findElement(KCAL).sendKeys(kCal);
    }

    @Step("Fill pow: PowAvg - '{kCal}', PowMax - '{powMax}'")
    public void powWorkout(String powAvg, String powMax) {
        driver.findElement(POWAVG).sendKeys(powAvg);
        driver.findElement(POWMAX).sendKeys(powMax);
    }

    @Step("Fill cad: CadAvg - '{cadAvg}', CadMax - '{cadMax}'")
    public void cadWorkout(String cadAvg, String cadMax) {
        driver.findElement(CADAVG).sendKeys(cadAvg);
        driver.findElement(CADMAX).sendKeys(cadMax);
    }

    @Step("Fill Elevation: Elevation Gain - '{EGain}', Elevation Loss - '{ELoss}'")
    public void elevationWorkout(String elevationGain, String elevationLoss) {
        driver.findElement(EGAIN).sendKeys(elevationGain);
        driver.findElement(ELOSS).sendKeys(elevationLoss);
    }

    @Step("The sign of Feels")
    public void howIFelt(String feel) {
        //driver.findElement(By.id("hf_" + feel)).click();
        driver.findElement(By.name("howfeel")).click();
    }

    @Step("The sign of Perceived Effort")
    public void perceivedEffort(String effort) {
        Select select = new Select(driver.findElement(PEREFFORT));
        select.selectByVisibleText(effort);
    }

    @Step("Save button")
    public void saveWorkout() {
        driver.findElement(SAVE_BUTTON).click();
    }

    @Step("Search for a workout")
    public boolean getWorkout() {
        return driver.findElement(DROPDOWN_TOGGEL).isDisplayed();
    }
}


