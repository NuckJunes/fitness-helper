package com.junes.fitness.fitnesshelper.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.junes.fitness.fitnesshelper.dtos.WorkoutRequestDTO;
import com.junes.fitness.fitnesshelper.dtos.WorkoutResponseDTO;
import com.junes.fitness.fitnesshelper.entities.Exercise;
import com.junes.fitness.fitnesshelper.entities.Profile;
import com.junes.fitness.fitnesshelper.entities.Workout;
import com.junes.fitness.fitnesshelper.mappers.WorkoutMapper;
import com.junes.fitness.fitnesshelper.repositories.ExerciseRepository;
import com.junes.fitness.fitnesshelper.repositories.ProfileRepository;
import com.junes.fitness.fitnesshelper.repositories.WorkoutRepository;
import com.junes.fitness.fitnesshelper.services.WorkoutService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkoutServiceImpl implements WorkoutService{
	
	private final WorkoutMapper workoutMapper;
	private final WorkoutRepository workoutRepository;
	private final ProfileRepository profileRepository;
	private final ExerciseRepository exerciseRepository;
	
	@Override
	public List<WorkoutResponseDTO> getAllWorkouts(long profileID) {
		return workoutMapper.entitiesToDTOs(workoutRepository.findAllByProfileId(profileID));
	}

	@Override
	public WorkoutResponseDTO createWorkout(long profileID, WorkoutRequestDTO workoutRequestDTO) {
		Workout workoutToCreate = workoutMapper.DTOToEntity(workoutRequestDTO);
		
		Profile profileToModify = profileRepository.getById(profileID);
		List<Workout> tmp_workouts = profileToModify.getWorkouts();
		tmp_workouts.add(workoutToCreate);
		
		workoutToCreate.setProfile(profileToModify);
		profileRepository.saveAndFlush(profileToModify);
		
		for(Exercise e : workoutToCreate.getExercises()) {
			e.setWorkout(workoutToCreate);
			exerciseRepository.saveAndFlush(e);
		}
		workoutRepository.saveAndFlush(workoutToCreate);
		return workoutMapper.EntityToDTO(workoutToCreate);
	}

}
