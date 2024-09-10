package com.junes.fitness.fitnesshelper.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junes.fitness.fitnesshelper.dtos.WorkoutRequestDTO;
import com.junes.fitness.fitnesshelper.dtos.WorkoutResponseDTO;
import com.junes.fitness.fitnesshelper.services.WorkoutService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workout")
public class WorkoutController {

	private final WorkoutService workoutService;
	
	@GetMapping("/{profileID}")
	public List<WorkoutResponseDTO> getAllWorkouts(@PathVariable long profileID) {
		return workoutService.getAllWorkouts(profileID);
	}
	
	@PostMapping("/{profileID}")
	public WorkoutResponseDTO createWorkout(@PathVariable long profileID, @RequestBody WorkoutRequestDTO workoutRequestDTO) {
		return workoutService.createWorkout(profileID, workoutRequestDTO);
	}
	
	@PatchMapping("/{workoutID}")
	public WorkoutResponseDTO updateWorkout(@PathVariable long workoutID, @RequestBody WorkoutRequestDTO workoutRequestDTO) {
		return workoutService.updateWorkout(workoutID, workoutRequestDTO);
	}
	
}
