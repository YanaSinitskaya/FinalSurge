package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class QuickAddWorkout {
    String workoutDate;
    String timeOfDay;
    String activityType;
    String workoutName;
    String workoutDescription;
    String distanceNumber;
    String distanceType;
    String duration;
    String paceNumber;
    String paceType;
    String howFeel;
    String perEffort;
    String postWorkoutNotesResults;
    String pDistance;
    String pDistanceType;
    String pDuration;
    String overallPlace;
    String ageGroupPlace;
    boolean showPlannedDistanceDuration;
    boolean markAsRace;
    boolean saveToLibrary;
}
