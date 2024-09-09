package com.junes.fitness.fitnesshelper.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.junes.fitness.fitnesshelper.dtos.WorkoutResponseDTO;
import com.junes.fitness.fitnesshelper.mappers.WorkoutMapper;
import com.junes.fitness.fitnesshelper.repositories.WorkoutRepository;
import com.junes.fitness.fitnesshelper.services.WorkoutService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkoutServiceImpl implements WorkoutService{
	
	private final WorkoutMapper workoutMapper;
	private final WorkoutRepository workoutRepository;
	
	@Override
	public List<WorkoutResponseDTO> getAllWorkouts(long profileID) {
		return workoutMapper.entitiesToDTOs(workoutRepository.findAllByProfileId(profileID));
	}

}
