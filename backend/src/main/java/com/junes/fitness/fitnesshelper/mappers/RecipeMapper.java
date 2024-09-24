package com.junes.fitness.fitnesshelper.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.junes.fitness.fitnesshelper.dtos.RecipeRequestDTO;
import com.junes.fitness.fitnesshelper.dtos.RecipeResponseDTO;
import com.junes.fitness.fitnesshelper.entities.Recipe;

@Mapper(componentModel = "spring", uses = {IngredientMapper.class})
public interface RecipeMapper {

	List<RecipeResponseDTO> EntitiesToDTOs(List<Recipe> allByProfileId);

	Recipe DTOToEntity(RecipeRequestDTO recipeRequestDTO);

	RecipeResponseDTO EntityToDTO(Recipe saveAndFlush);

}
