package com.junes.fitness.fitnesshelper.services;

import java.util.List;

import com.junes.fitness.fitnesshelper.dtos.RecipeResponseDTO;

public interface RecipeService {

	List<RecipeResponseDTO> GetAllRecipes(long profileID);

}
