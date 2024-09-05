package com.junes.fitness.fitnesshelper.mappers;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {All_Food_Mapper.class})
public interface IngredientMapper {

}
