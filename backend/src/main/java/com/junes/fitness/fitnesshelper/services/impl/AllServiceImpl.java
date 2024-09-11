package com.junes.fitness.fitnesshelper.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.junes.fitness.fitnesshelper.dtos.All_Exercise_DTO;
import com.junes.fitness.fitnesshelper.dtos.All_Food_DTO;
import com.junes.fitness.fitnesshelper.mappers.All_Exercise_Mapper;
import com.junes.fitness.fitnesshelper.mappers.All_Food_Mapper;
import com.junes.fitness.fitnesshelper.repositories.All_ExerciseRepository;
import com.junes.fitness.fitnesshelper.repositories.All_FoodRepository;
import com.junes.fitness.fitnesshelper.services.AllService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AllServiceImpl implements AllService {

	private final All_Exercise_Mapper all_exercise_mapper;
	private final All_Food_Mapper all_food_mapper;
	private final All_FoodRepository all_foodRepository;
	private final All_ExerciseRepository all_exerciseRepository;
	
	public List<All_Exercise_DTO> getAllExercises() {
		return all_exercise_mapper.EntitiesToDTOs(all_exerciseRepository.findAll());
	}
	
	public List<All_Food_DTO> getAllFood() {
		return all_food_mapper.EntitiesToDTOs(all_foodRepository.findAll());
	}
	
	
}
