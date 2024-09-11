package com.junes.fitness.fitnesshelper.services.impl;

import org.springframework.stereotype.Service;

import com.junes.fitness.fitnesshelper.mappers.All_Exercise_Mapper;
import com.junes.fitness.fitnesshelper.mappers.All_Food_Mapper;
import com.junes.fitness.fitnesshelper.repositories.All_ExerciseRepository;
import com.junes.fitness.fitnesshelper.repositories.All_FoodRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AllServiceImpl {

	private final All_Exercise_Mapper all_exercise_mapper;
	private final All_Food_Mapper all_food_mapper;
	private final All_FoodRepository all_foodRepository;
	private final All_ExerciseRepository all_exerciseRepository;
	
	
}
