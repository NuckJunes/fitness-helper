package com.junes.fitness.fitnesshelper.services;

import java.util.List;

import com.junes.fitness.fitnesshelper.dtos.WorkoutRequestDTO;
import com.junes.fitness.fitnesshelper.dtos.WorkoutResponseDTO;

public interface WorkoutService {

	List<WorkoutResponseDTO> getAllWorkouts(long profileID);

	WorkoutResponseDTO createWorkout(long profileID, WorkoutRequestDTO workoutRequestDTO);

}
