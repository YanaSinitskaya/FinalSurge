package tests;

import dto.QuickAddWorkout;
import org.testng.annotations.Test;

public class CalendarTest extends BaseTest {

    @Test(description = "Add new Quick Workout Description on Calendar")
    public void add() {
        QuickAddWorkout newQuickWorkout = QuickAddWorkout.builder()
                .workoutDate("2/1/2024")
                .timeOfDay("4:44")
                .activityType("Run")
                .workoutName("RunTest")
                .workoutDescription("Testing this workout")
                .distanceNumber("7")
                .distanceType("mi")
                .duration("00:20:33")
                .paceNumber("04:11")
                .paceType("min/mi")
                .howFeel("Good")
                .perEffort("2 (Light)")
                .postWorkoutNotesResults("Super")

                .showPlannedDistanceDuration("")
                .pDistance("21")
                .pDistanceType("mi")
                .pDuration("0:19:33")

                .markAsRace("")
                .ageGroupPlace("4")
                .overallPlace("1")

                .saveToLibrary("")
                .build();
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        calendarPage.open();
        calendarPage.addQuickWorkoutWithButton();
        quickAddWorkoutModalPage.fillingInAllFields(newQuickWorkout);
        quickAddWorkoutModalPage.save();

    }
}
