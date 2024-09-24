package com.junes.fitness.fitnesshelper.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.junes.fitness.fitnesshelper.dtos.RecipeRequestDTO;
import com.junes.fitness.fitnesshelper.dtos.RecipeResponseDTO;
import com.junes.fitness.fitnesshelper.entities.All_Food;
import com.junes.fitness.fitnesshelper.entities.Ingredient;
import com.junes.fitness.fitnesshelper.entities.Recipe;
import com.junes.fitness.fitnesshelper.mappers.RecipeMapper;
import com.junes.fitness.fitnesshelper.repositories.All_FoodRepository;
import com.junes.fitness.fitnesshelper.repositories.IngredientRepository;
import com.junes.fitness.fitnesshelper.repositories.ProfileRepository;
import com.junes.fitness.fitnesshelper.repositories.RecipeRepository;
import com.junes.fitness.fitnesshelper.services.RecipeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {
	
	private final RecipeRepository recipeRepository;
	private final RecipeMapper recipeMapper;
	private final ProfileRepository profileRepository;
	private final IngredientRepository ingredientRepository;
	private final All_FoodRepository all_FoodRepository;
	
	@Override
	public List<RecipeResponseDTO> GetAllRecipes(long profileID) {
		return recipeMapper.EntitiesToDTOs(recipeRepository.findAllByProfileId(profileID));
	}

	@Override
	public RecipeResponseDTO CreateNewRecipe(long profileID, RecipeRequestDTO recipeRequestDTO) {
		Recipe recipeToCreate = recipeMapper.DTOToEntity(recipeRequestDTO);
		recipeToCreate.setProfile(profileRepository.getById(profileID));
		//add ingredients
		for(Ingredient i : recipeToCreate.getIngredients()) {
			i.setRecipe(recipeToCreate);
			All_Food tmp = all_FoodRepository.findByName(i.getAll_Food().getName());
			List<Ingredient> tmpFood = tmp.getIngredients();
			tmpFood.add(i);
			tmp.setIngredients(tmpFood);
			i.setAll_Food(tmp);
		}
		recipeRepository.saveAndFlush(recipeToCreate);
		ingredientRepository.saveAllAndFlush(recipeToCreate.getIngredients());
		return recipeMapper.EntityToDTO(recipeToCreate);
	}
}
