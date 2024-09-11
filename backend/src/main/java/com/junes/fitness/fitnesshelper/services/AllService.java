package com.junes.fitness.fitnesshelper.services;

import java.util.List;

import com.junes.fitness.fitnesshelper.dtos.All_Exercise_DTO;
import com.junes.fitness.fitnesshelper.dtos.All_Food_DTO;

public interface AllService {

	List<All_Exercise_DTO> getAllExercises();

	List<All_Food_DTO> getAllFood();

}
