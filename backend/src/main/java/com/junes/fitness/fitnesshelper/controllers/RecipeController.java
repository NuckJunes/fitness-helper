package com.junes.fitness.fitnesshelper.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junes.fitness.fitnesshelper.dtos.RecipeRequestDTO;
import com.junes.fitness.fitnesshelper.dtos.RecipeResponseDTO;
import com.junes.fitness.fitnesshelper.services.RecipeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recipe")
public class RecipeController {

	private final RecipeService recipeService;
	
	@GetMapping("/{profileID}")
	public List<RecipeResponseDTO> GetAllRecipes(@PathVariable long profileID) {
		return recipeService.GetAllRecipes(profileID);
	}
	
	@PostMapping("/{profileID}")
	public RecipeResponseDTO CreateNewRecipe(@PathVariable long profileID, @RequestBody RecipeRequestDTO recipeRequestDTO) {
		return recipeService.CreateNewRecipe(profileID, recipeRequestDTO);
	}
	
	@PatchMapping("{recipeID}")
	public RecipeResponseDTO UpdateRecipe(@PathVariable long recipeID, @RequestBody RecipeRequestDTO recipeRequestDTO) {
		return recipeService.UpdateRecipe(recipeID, recipeRequestDTO);
	}
	
	@DeleteMapping("{recipeID}")
	public RecipeResponseDTO DeleteRecipe(@PathVariable long recipeID) {
		return recipeService.DeleteRecipe(recipeID);
	}
}
