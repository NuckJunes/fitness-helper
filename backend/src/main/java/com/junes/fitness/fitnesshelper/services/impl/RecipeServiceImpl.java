package com.junes.fitness.fitnesshelper.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.junes.fitness.fitnesshelper.dtos.RecipeResponseDTO;
import com.junes.fitness.fitnesshelper.mappers.RecipeMapper;
import com.junes.fitness.fitnesshelper.repositories.RecipeRepository;
import com.junes.fitness.fitnesshelper.services.RecipeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {
	
	private final RecipeRepository recipeRepository;
	private final RecipeMapper recipeMapper;
	
	@Override
	public List<RecipeResponseDTO> GetAllRecipes(long profileID) {
		return recipeMapper.EntitiesToDTOs(recipeRepository.findAllByProfileId(profileID));
	}

}
