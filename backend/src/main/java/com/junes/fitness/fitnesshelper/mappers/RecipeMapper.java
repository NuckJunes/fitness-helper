package com.junes.fitness.fitnesshelper.mappers;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {IngredientMapper.class})
public interface RecipeMapper {

}
