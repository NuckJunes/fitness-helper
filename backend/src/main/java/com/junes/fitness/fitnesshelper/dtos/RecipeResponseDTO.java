package com.junes.fitness.fitnesshelper.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeResponseDTO {

	private long id;
	
	private String name;
	
	private String course;
	
	private List<IngredientResponseDTO> ingredients;
	
	private List<String> instructions;
	
	private String imageURL;
}