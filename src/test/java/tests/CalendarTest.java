package tests;

import dto.QuickAddWorkout;
import org.testng.annotations.Test;

public class CalendarTest extends BaseTest {

    @Test(description = "Add new Quick Workout Description on Calendar")
    public void add() {
        QuickAddWorkout newQuickWorkout = QuickAddWorkout.builder()
                .workoutDate("")
                .timeOfDay("")
                .activityType("")
                .workoutName("")
                .workoutDescription("")
                .distanceNumber("")
                .distanceType("")
                .duration("")
                .paceNumber("")
                .paceType("")
                .howFeel("")
                .perEffort("")
                .postWorkoutNotesResults("")
                .build();
        loginPage.open();
        loginPage.login(USER, PASSWORD);
        calendarPage.open();
        calendarPage.addActivityOnCalendar();     // ПОСМОТРЕТЬ ЛОКАТОР!!
        quickAddWorkoutModalPage.fillingInAllFields(newQuickWorkout);
        calendarPage.addActivityOnCalendar();

    }
}
