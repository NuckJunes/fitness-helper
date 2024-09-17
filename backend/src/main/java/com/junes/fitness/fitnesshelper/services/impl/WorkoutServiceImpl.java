package com.junes.fitness.fitnesshelper.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.junes.fitness.fitnesshelper.dtos.WorkoutRequestDTO;
import com.junes.fitness.fitnesshelper.dtos.WorkoutResponseDTO;
import com.junes.fitness.fitnesshelper.entities.All_Exercise;
import com.junes.fitness.fitnesshelper.entities.Exercise;
import com.junes.fitness.fitnesshelper.entities.Profile;
import com.junes.fitness.fitnesshelper.entities.Workout;
import com.junes.fitness.fitnesshelper.mappers.WorkoutMapper;
import com.junes.fitness.fitnesshelper.repositories.All_ExerciseRepository;
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
	private final All_ExerciseRepository all_exerciseRepository;
	
	@Override
	public List<WorkoutResponseDTO> getAllWorkouts(long profileID) {
		return workoutMapper.entitiesToDTOs(workoutRepository.findAllByProfileId(profileID));
	}

	@Override
	public WorkoutResponseDTO createWorkout(long profileID, WorkoutRequestDTO workoutRequestDTO) {
		Workout workoutToCreate = workoutMapper.DTOToEntity(workoutRequestDTO);
		
		Profile profileToModify = profileRepository.getById(profileID);
		if(profileToModify.isDeleted()) {
			//throw error here
		}
		List<Workout> tmp_workouts = profileToModify.getWorkouts();
		tmp_workouts.add(workoutToCreate);
		
		workoutToCreate.setProfile(profileToModify);
		
		for(Exercise e : workoutToCreate.getExercises()) {		
			All_Exercise tmp = all_exerciseRepository.findByName(e.getExercise().getName());
			List<Exercise> tmpExercises = tmp.getExercises();
			tmpExercises.add(e);
			tmp.setExercises(tmpExercises);
			
			e.setWorkout(workoutToCreate);
			e.setExercise(tmp);
			e.setId(null);
		}
		workoutRepository.saveAndFlush(workoutToCreate);
		exerciseRepository.saveAllAndFlush(workoutToCreate.getExercises());
		profileRepository.saveAndFlush(profileToModify);
		return workoutMapper.EntityToDTO(workoutToCreate);
	}

	@Override
	public WorkoutResponseDTO updateWorkout(long workoutID, WorkoutRequestDTO workoutRequestDTO) {
		Long profileID = workoutRepository.getById(workoutID).getId();
		deleteWorkout(workoutID);
		return createWorkout(profileID, workoutRequestDTO);
	}

	@Override
	public WorkoutResponseDTO deleteWorkout(long workoutID) {
		Workout workoutToDelete = workoutRepository.getById(workoutID);
		List<Exercise> exercisesToDelete = workoutToDelete.getExercises();
		for(Exercise e : exercisesToDelete) {
			All_Exercise tmp = all_exerciseRepository.findByName(e.getExercise().getName());
			List<Exercise> tmpExercises = tmp.getExercises();
			tmpExercises.remove(e);
			tmp.setExercises(tmpExercises);
			all_exerciseRepository.saveAndFlush(tmp);
			
			e.setWorkout(null);
			e.setExercise(null);
			
			exerciseRepository.deleteById(e.getId());
		}
		
		workoutRepository.deleteById(workoutID);
		return workoutMapper.EntityToDTO(workoutToDelete);
	}

}
