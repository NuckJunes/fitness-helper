package com.junes.fitness.fitnesshelper.services;

import java.util.List;

import com.junes.fitness.fitnesshelper.dtos.RecipeRequestDTO;
import com.junes.fitness.fitnesshelper.dtos.RecipeResponseDTO;

public interface RecipeService {

	List<RecipeResponseDTO> GetAllRecipes(long profileID);

	RecipeResponseDTO CreateNewRecipe(long profileID, RecipeRequestDTO recipeRequestDTO);

	RecipeResponseDTO UpdateRecipe(long recipeID, RecipeRequestDTO recipeRequestDTO);

	RecipeResponseDTO DeleteRecipe(long recipeID);

}
