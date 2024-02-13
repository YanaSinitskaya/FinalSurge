package tests;

import dto.QuickAddWorkout;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalendarTest extends BaseTest {

    @Test(description = "Add new Quick Workout Description on Calendar", retryAnalyzer = Retry.class)
    public void addNewQuickWorkout() {
        QuickAddWorkout newQuickWorkout = QuickAddWorkout.builder()
                .workoutDate("2/1/2024")
                .timeOfDay("4:44")
                .activityType("Run")
                .workoutName("RunTest")
                .workoutDescription("Testing this workout")
                .distanceNumber("1")
                .distanceType("mi")
                .duration("01:20:33")
                .paceNumber("03:55")
                .paceType("min/mi")
                .howFeel("Good")
                .perEffort("2 (Light)")
                .postWorkoutNotesResults("Super")

                .showPlannedDistanceDuration(true)
                .pDistance("21")
                .pDistanceType("mi")
                .pDuration("0:19:33")

                .markAsRace(true)
                .ageGroupPlace("4")
                .overallPlace("1")

                .saveToLibrary(true)
                .build();
        loginPage.open();
        loginPage.login("yanasyhar@gmail.com", "Kz2-3B8-utt-kts");
        calendarPage.open();
        calendarPage.addQuickWorkoutWithButton();
        quickAddWorkoutPage.fillingFields(newQuickWorkout);
        quickAddWorkoutPage.save();
        Assert.assertEquals(calendarPage.QuickWorkOutIsDisplayed("1", "2","2024"), true, "The workout isn't created");
    }

    @Test(description = "Remove Quick Workout from Calendar", retryAnalyzer = Retry.class)
    public void deleteWorkoutFromCalendar() {
        QuickAddWorkout newQuickWorkout = QuickAddWorkout.builder()
                .workoutDate("2/4/2024")
                .activityType("Bike")

                .build();
        loginPage.open();
        loginPage.login("yanasyhar@gmail.com", "Kz2-3B8-utt-kts");
        calendarPage.open();
        calendarPage.addQuickWorkoutWithButton();
        quickAddWorkoutPage.fillingFields(newQuickWorkout);
        quickAddWorkoutPage.save();
        calendarPage.deleteWorkoutFromCalendar("2/4/2024");
        Assert.assertEquals(calendarPage.QuickWorkOutIsDisplayed("4", "2","2024"), false, "The workout isn't deleted");
    }
}