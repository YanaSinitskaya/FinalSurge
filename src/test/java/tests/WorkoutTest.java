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
        workoutPage.dateWorkout("1/31/2024");
        workoutPage.timeWorkout("10:00");
        workoutPage.nameWorkout("Run");
        workoutPage.descriptionWorkout("Running in Loshitsa Park");
        workoutPage.distanceWorkout("2000");
        workoutPage.durationWorkout("01:34:03");
        workoutPage.howIFelt("Great");
        workoutPage.perceivedEffort("6 (Moderate)");
        workoutPage.hrWorkout("100", "110", "150");
        workoutPage.kCalWorkout("260");
        workoutPage.saveWorkout();
        assertTrue(workoutPage.getWorkout(), "Workout added");
    }

    @Test(description = "Add a bike workout with correct data", retryAnalyzer = Retry.class)
    public void bikeWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("Bike");
        workoutPage.dateWorkout("2/22/2024");
        workoutPage.timeWorkout("16:00");
        workoutPage.nameWorkout("Bike");
        workoutPage.descriptionWorkout("");
        workoutPage.distanceWorkout("5000");
        workoutPage.durationWorkout("00:10:00");
        workoutPage.elevationWorkout("400", "500");
        workoutPage.howIFelt("Poor");
        workoutPage.perceivedEffort("3 (Very Light)");
        workoutPage.powWorkout("140", "240");
        workoutPage.cadWorkout("160", "190");
        workoutPage.hrWorkout("110", "120", "150");
        workoutPage.kCalWorkout("600");
        workoutPage.saveWorkout();
        assertTrue(workoutPage.getWorkout(), "Workout added");
    }

    @Test(description = "Add a swimming workout with correct data", retryAnalyzer = Retry.class)
    public void addSwimWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("Swim");
        workoutPage.dateWorkout("2/5/2024");
        workoutPage.timeWorkout("16:00");
        workoutPage.nameWorkout("Swim");
        workoutPage.descriptionWorkout("Swimming pool");
        workoutPage.advancedWorkout();
        workoutPage.repsOfSetWorkout("5");
        workoutPage.durationOfSetWorkout("20:00");
        workoutPage.distanceWorkout("1000");
        workoutPage.durationWorkout("40:00");
        workoutPage.howIFelt("Great");
        workoutPage.perceivedEffort("9 (Very Hard)");
        workoutPage.kCalWorkout("200");
        workoutPage.saveWorkout();
        assertTrue(workoutPage.getWorkout(), "Workout added");
    }

    @Test(description = "Add a cross training workout with correct data", retryAnalyzer = Retry.class)
    public void addCrossTrainingWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("cross-trai");
        workoutPage.dateWorkout("2/12/2024");
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
        assertTrue(workoutPage.getWorkout(), "Workout added");
    }

    @Test(description = "Add a walking workout with correct data", retryAnalyzer = Retry.class)
    public void addWalkWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("Walk");
        workoutPage.dateWorkout("2/22/2024");
        workoutPage.timeWorkout("16:00");
        workoutPage.nameWorkout("Walk");
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
        assertTrue(workoutPage.getWorkout(), "Workout added");
    }

    @Test(description = "Add a rest day with correct data", retryAnalyzer = Retry.class)
    public void addRestDayWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("Rest");
        workoutPage.dateWorkout("2/2/2024");
        workoutPage.nameWorkout("Rest");
        workoutPage.descriptionWorkout("Resting at home");
        workoutPage.saveWorkout();
        assertTrue(workoutPage.getWorkout(), "Workout added");
    }

    @Test(description = "Add a strength training workout with correct data", retryAnalyzer = Retry.class)
    public void addStrengthTrainingWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("strength-t");
        workoutPage.dateWorkout("5/12/2024");
        workoutPage.timeWorkout("17:30");
        workoutPage.nameWorkout("Strength Training");
        workoutPage.descriptionWorkout("Strength Training in the yoga class");
        workoutPage.durationNoIntWorkout("01:00:00");
        workoutPage.howIFelt("Great");
        workoutPage.perceivedEffort("6 (Moderate)");
        workoutPage.saveWorkout();
        assertTrue(workoutPage.getWorkout(), "Workout added");
    }

    @Test(description = "Add a recovery with correct data", retryAnalyzer = Retry.class)
    public void addRecoveryWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("Recovery");
        workoutPage.dateWorkout("2/13/2024");
        workoutPage.timeWorkout("16:30");
        workoutPage.nameWorkout("Recovery");
        workoutPage.descriptionWorkout("Recovery");
        workoutPage.saveWorkout();
        assertTrue(workoutPage.getWorkout(), "Workout added");
    }

    @Test(description = "Add a other workout with correct data", retryAnalyzer = Retry.class)
    public void addOtherWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("Other");
        workoutPage.dateWorkout("2/16/2024");
        workoutPage.timeWorkout("20:00");
        workoutPage.nameWorkout("Stretching");
        workoutPage.descriptionWorkout("Stretching");
        workoutPage.saveWorkout();
        assertTrue(workoutPage.getWorkout(), "Workout added");
    }

    @Test(description = "Add a transition workout with correct data", retryAnalyzer = Retry.class)
    public void transitionWorkout() {
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        workoutPage.open();
        workoutPage.tabOpen("Transition");
        workoutPage.dateWorkout("2/22/2024");
        workoutPage.timeWorkout("16:00");
        workoutPage.nameWorkout("Transition");
        workoutPage.descriptionWorkout("");
        workoutPage.distanceWorkout("1000");
        workoutPage.durationWorkout("00:10:00");
        workoutPage.elevationWorkout("400", "500");
        workoutPage.howIFelt("Poor");
        workoutPage.perceivedEffort("1 (Very Light)");
        workoutPage.powWorkout("140", "240");
        workoutPage.cadWorkout("160", "190");
        workoutPage.hrWorkout("110", "120", "150");
        workoutPage.kCalWorkout("300");
        workoutPage.saveWorkout();
        assertTrue(workoutPage.getWorkout(), "Workout added");
    }
}

