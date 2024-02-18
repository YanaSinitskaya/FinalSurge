package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class WorkoutTest extends BaseTest {
    @Test(description = "Add a running workout with correct data", retryAnalyzer = Retry.class)
    public void addRunWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("run");
        workoutPage.dateWorkout("2/24/2024");
        workoutPage.timeWorkout("14:00");
        workoutPage.nameWorkout("Run");
        workoutPage.descriptionWorkout("Running in Loshitsa Park");
        workoutPage.distanceWorkout("3000");
        workoutPage.durationWorkout("01:19:06");
        workoutPage.howIFelt("good");
        workoutPage.perceivedEffort("8 (Hard)");
        workoutPage.hrWorkout("100", "120", "140");
        workoutPage.kCalWorkout("300");
        workoutPage.saveWorkout();
        driver.get("https://log.finalsurge.com/Calendar.cshtml");
        driver.navigate().refresh();
        assertTrue(workoutPage.getWorkout(), "Workout 'Run' is added");
    }

    @Test(description = "Add a bike workout with correct data", retryAnalyzer = Retry.class)
    public void bikeWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("bike");
        workoutPage.dateWorkout("2/24/2024");
        workoutPage.timeWorkout("16:00");
        workoutPage.nameWorkout("bike");
        workoutPage.descriptionWorkout("");
        workoutPage.distanceWorkout("5000");
        workoutPage.durationWorkout("00:10:00");
        workoutPage.elevationWorkout("400", "500");
        workoutPage.howIFelt("Poor");
        workoutPage.perceivedEffort("6 (Moderate)");
        workoutPage.powWorkout("140", "240");
        workoutPage.cadWorkout("160", "190");
        workoutPage.hrWorkout("110", "120", "150");
        workoutPage.kCalWorkout("600");
        workoutPage.saveWorkout();
        driver.get("https://log.finalsurge.com/Calendar.cshtml");
        driver.navigate().refresh();
        assertTrue(workoutPage.getWorkout(), "Workout 'Bike' is added");
    }

    @Test(description = "Add a swimming workout with correct data", retryAnalyzer = Retry.class)
    public void addSwimWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("swim");
        workoutPage.dateWorkout("2/26/2024");
        workoutPage.timeWorkout("16:00");
        workoutPage.nameWorkout("Swim");
        workoutPage.descriptionWorkout("Swimming pool");
        workoutPage.distanceWorkout("5000");
        workoutPage.durationWorkout("10:00");
        workoutPage.howIFelt("Great");
        workoutPage.perceivedEffort("9 (Very Hard)");
        workoutPage.kCalWorkout("200");
        workoutPage.saveWorkout();
        driver.get("https://log.finalsurge.com/Calendar.cshtml");
        driver.navigate().refresh();
        assertTrue(workoutPage.getWorkout(), "Workout 'Swim' is added");
    }

    @Test(description = "Add a cross training workout with correct data", retryAnalyzer = Retry.class)
    public void addCrossTrainingWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("cross-trai");
        workoutPage.dateWorkout("2/19/2024");
        workoutPage.timeWorkout("12:00");
        workoutPage.nameWorkout("Cross");
        workoutPage.descriptionWorkout("Cross in the park");
        workoutPage.distanceForCrossTrainingWorkout("3500");
        workoutPage.durationNoIntWorkout("00:20:00");
        workoutPage.howIFelt("Terrible");
        workoutPage.perceivedEffort("10 (Max Effort)");
        workoutPage.hrWorkout("100", "120", "140");
        workoutPage.kCalWorkout("500");
        workoutPage.saveWorkout();
        driver.get("https://log.finalsurge.com/Calendar.cshtml");
        driver.navigate().refresh();
        assertTrue(workoutPage.getWorkout(), "Workout 'Cross Training' is added");
    }

    @Test(description = "Add a walking workout with correct data", retryAnalyzer = Retry.class)
    public void addWalkWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("walk");
        workoutPage.dateWorkout("2/25/2024");
        workoutPage.timeWorkout("16:00");
        workoutPage.nameWorkout("walk");
        workoutPage.descriptionWorkout("Walk in the park");
        workoutPage.distanceWorkout("10000");
        workoutPage.durationWorkout("00:20:00");
        workoutPage.elevationWorkout("400", "500");
        workoutPage.howIFelt("Poor");
        workoutPage.perceivedEffort("1 (Very Light)");
        workoutPage.powWorkout("140", "240");
        workoutPage.cadWorkout("160", "190");
        workoutPage.hrWorkout("110", "120", "150");
        workoutPage.kCalWorkout("600");
        workoutPage.saveWorkout();
        driver.get("https://log.finalsurge.com/Calendar.cshtml");
        driver.navigate().refresh();
        assertTrue(workoutPage.getWorkout(), "Workout 'Walk' is added");
    }

    @Test(description = "Add a rest day with correct data", retryAnalyzer = Retry.class)
    public void addRestDayWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("rest");
        workoutPage.dateWorkout("2/28/2024");
        workoutPage.nameWorkout("Rest");
        workoutPage.descriptionWorkout("Resting at home");
        workoutPage.saveWorkout();
        driver.get("https://log.finalsurge.com/Calendar.cshtml");
        driver.navigate().refresh();
        assertTrue(workoutPage.getWorkout(), "Workout 'Rest Day' is added");
    }

    @Test(description = "Add a strength training workout with correct data", retryAnalyzer = Retry.class)
    public void addStrengthTrainingWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("strength-t");
        workoutPage.dateWorkout("2/28/2024");
        workoutPage.timeWorkout("17:30");
        workoutPage.nameWorkout("Strength Training");
        workoutPage.descriptionWorkout("Strength Training in the yoga class");
        workoutPage.durationNoIntWorkout("01:00:00");
        workoutPage.howIFelt("Great");
        workoutPage.perceivedEffort("6 (Moderate)");
        workoutPage.saveWorkout();
        driver.get("https://log.finalsurge.com/Calendar.cshtml");
        driver.navigate().refresh();
        assertTrue(workoutPage.getWorkout(), "Workout 'Strength Training' is added");
    }

    @Test(description = "Add a recovery with correct data", retryAnalyzer = Retry.class)
    public void addRecoveryWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("recovery");
        workoutPage.dateWorkout("2/28/2024");
        workoutPage.timeWorkout("16:30");
        workoutPage.nameWorkout("Recovery");
        workoutPage.descriptionWorkout("Recovery");
        workoutPage.saveWorkout();
        driver.get("https://log.finalsurge.com/Calendar.cshtml");
        driver.navigate().refresh();
        assertTrue(workoutPage.getWorkout(), "Workout 'Recovery' is added");
    }

    @Test(description = "Add a other workout with correct data", retryAnalyzer = Retry.class)
    public void addOtherWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("other");
        workoutPage.dateWorkout("2/23/2024");
        workoutPage.timeWorkout("20:00");
        workoutPage.nameWorkout("Stretching");
        workoutPage.descriptionWorkout("Stretching");
        workoutPage.saveWorkout();
        driver.get("https://log.finalsurge.com/Calendar.cshtml");
        driver.navigate().refresh();
        assertTrue(workoutPage.getWorkout(), "Workout 'Other' is added");
    }
}