package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class FullAddWorkout {
    String workoutDate;
    String timeOfDay;
    String workoutName;
    String workoutDescription;
    String distanceNumber;
    String distanceType;
    String duration;
    String paceNumber;
    String paceType;
    String howIFelt;
    String perceivedEffort;
    String minHR;
    String avgHR;
    String maxHR;
    String caloriesBurned;
    String reps;
    boolean showPlannedDistanceDuration;
    boolean markAsRace;
}